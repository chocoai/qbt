/**
 * Project Name:qbt-support
 * File Name:OrderSfRouteCommonSupportImpl.java
 * Package Name:com.qbt.bussiness.support.impl
 * Date:2017年8月3日上午11:03:50
 *
*/

package com.qbt.bussiness.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.CommonSfRoute;
import com.qbt.bussiness.support.OrderSfRouteCommonSupport;
import com.qbt.bussiness.support.SmsMsgSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.enums.DeliveryStatus;
import com.qbt.common.enums.ExceptionTypeEnum;
import com.qbt.common.enums.LanguagesEnum;
import com.qbt.common.enums.OrderOperateTypeEnum;
import com.qbt.common.util.Checker;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderOperateLog;
import com.qbt.persistent.entity.OrderWaybill;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.WinnerList;
import com.qbt.service.CouponService;
import com.qbt.service.OrderExceptionBookService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderOperateLogService;
import com.qbt.service.OrderWaybillService;
import com.qbt.service.RewardActitvityService;
import com.qbt.service.SaleOrderInfoService;
import com.qbt.service.SfNotifyConfigService;
import com.qbt.service.UserAssistantService;
import com.qbt.service.UserKfService;
import com.qbt.service.UserWeixinService;
import com.qbt.service.WinnerListService;

/**
 * ClassName:OrderSfRouteCommonSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月3日 上午11:03:50
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrderSfRouteCommonSupportImpl implements OrderSfRouteCommonSupport {
	
	@Resource
	private OrderWaybillService orderWaybillService;
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private OrderExceptionBookService orderExceptionBookService;
	
	@Resource
	private OrderOperateLogService orderOperateLogService;
	
	@Resource
	private UserAssistantService userAssistantService;
	
	@Resource
	private UserKfService userKfService;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private SaleOrderInfoService saleOrderInfoService;
	
	@Resource
	private RewardActitvityService rewardService;
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private WinnerListService winnerListService;
	
	@Resource
	private SmsMsgSupport smsMessageSupport;
	
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	@Resource
	private SfNotifyConfigService sfNotifyConfigService;
	
	@Override
	public void orderRoute(String sfId, OrderInfo orderInfo, CommonSfRoute commonSfRoute) {
		/**
		 * 保存物流信息
		 */
		OrderWaybill orderWaybill = new OrderWaybill();
		orderWaybill.setAcceptAddress(commonSfRoute.getAcceptAddress());
		orderWaybill.setAcceptTime(DateUtil.str2Date(commonSfRoute.getAcceptTime(),DateUtil.DATE_TIME_FORMAT_01));
		orderWaybill.setMailNo(commonSfRoute.getMailNo());
		orderWaybill.setOpCode(commonSfRoute.getOpCode());
		orderWaybill.setOrderId(orderInfo.getId());
		orderWaybill.setRemark(commonSfRoute.getRemark());
		orderWaybill.setSfId(sfId);
		orderWaybillService.insert(orderWaybill);
		/**
		 * 	
			5-物流运输中
			6-派送中
			7-已签收
		 */
		String opcode = commonSfRoute.getOpCode();
		
		if(Constants.reciveCodes.contains(opcode)){
			int deliverStatus = orderInfo.getDeliveryStatus();
			if(deliverStatus == DeliveryStatus.wait_sf_recive.getCode()){
				orderInfo.setDeliveryStatus(DeliveryStatus.sf_recived.getCode());
				orderInfoService.updateById(orderInfo);
				orderOperateLog(orderInfo, "快递员已取件");
				// 消息发送
				if(!sfNotifyConfigService.isDisabledNotify(orderInfo.getNumber())) {
					sendMsgByRecive(commonSfRoute, orderInfo);
				}
			}
			
		}else if(Constants.sendingCodes.contains(opcode)){
			orderInfo.setDeliveryStatus(DeliveryStatus.delivery_ing.getCode());
			orderInfoService.updateById(orderInfo);
			orderOperateLog(orderInfo, "快递员派送中");
		}else if(Constants.overCodes.contains(opcode)){
			orderInfo.setDeliveryStatus(DeliveryStatus.signed.getCode());
			orderInfoService.updateById(orderInfo);
			orderOperateLog(orderInfo, "订单已签收");
			if(orderInfo.getIsConfirmReceive()==false){
				// 消息发送
				if(!sfNotifyConfigService.isDisabledNotify(orderInfo.getNumber())) {
					sendMsgBySign(commonSfRoute, orderInfo);	
				}
			}
			/**
			 * 将销售二维码人员的订单至成有效
			 */
			saleOrderInfoService.updateStatus(orderInfo.getId(), 1);
			
			//将与该订单绑定的优惠券设置为有效
			couponService.deblockingCoupon(orderInfo.getOrderId());
			//更新中奖纪录
			WinnerList winnerList = new WinnerList();
			winnerList.setOrderId(orderInfo.getOrderId());
			winnerListService.update(winnerList);
			
			UserCouponActivity uca = couponService.findWinnerInfo(orderInfo.getOrderId());
			if(!sfNotifyConfigService.isDisabledNotify(orderInfo.getNumber())) {
				sendCouponMessage(orderInfo, uca);
			}
		}else{
			int deliverStatus = orderInfo.getDeliveryStatus();
			if(deliverStatus < 5){
				orderInfo.setDeliveryStatus(DeliveryStatus.transport_ing.getCode());
				orderInfoService.updateById(orderInfo);
				orderOperateLog(orderInfo, "订单运输中");
				// 消息发送
				if(!sfNotifyConfigService.isDisabledNotify(orderInfo.getNumber())) {
					sendMsgBytransport(commonSfRoute, orderInfo);	
				}				
			}
			if(Constants.questionCodes.contains(opcode)){
				/**
				 * 登记仪表盘
				 */
				OrderExceptionBook orderExceptionBook = new OrderExceptionBook();
				orderExceptionBook.setOrderId(orderInfo.getId()); 
				orderExceptionBook.setOrderNumber(orderInfo.getNumber());
				orderExceptionBook.setIsDealed(false);
				orderExceptionBook.setOrderStatus(orderInfo.getOrderStatus());
				orderExceptionBook.setDescription("快递运输问题：" + commonSfRoute.getRemark());
				orderExceptionBook.setType(ExceptionTypeEnum.sf_express_return.getCode());
				orderExceptionBookService.insert(orderExceptionBook);
				orderOperateLog(orderInfo, "订单运输中出现异常：" + commonSfRoute.getRemark());
				
				List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
				if(Checker.isNotEmpty(kfList)){
					//微信通知客服
					for(UserWeixin kf : kfList){
						wechatMessageSupport.exceptionBookNotify(orderExceptionBook, kf.getOpenid());
					}
				}
			}
		}
	}
	
	private void sendMsgBySign(CommonSfRoute commonSfRoute, OrderInfo orderInfo) {
		// 1、通知寄包人
//		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
			smsMessageSupport.sendOrderSignJpMsgToJContact(orderInfo);
		}else{
			smsMessageSupport.sendOrderSignMsgToJContact(orderInfo);
		}
		if(!orderInfo.getjMobile().equals(orderInfo.getdMobile())){
			// 2、通知收包人
//			jmobiles = new String[]{orderInfo.getdMobile()};
			if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
				smsMessageSupport.sendOrderSignJpMsgToDContact(orderInfo);
			}else{
				smsMessageSupport.sendOrderSignMsgToDContact(orderInfo);
			}
		}
		/*// 3、球场人员
		// 寄方
		if(orderInfo.getjAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getjAddrId(), orderInfo.getjAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_112399.getCode(), SmsMessageTemplate.createM_112399(orderInfo,deliver.getAcceptTime()));
			} 
			
		}
		// 收方
		if(orderInfo.getdAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getdAddrId(), orderInfo.getdAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_112399.getCode(), SmsMessageTemplate.createM_112399(orderInfo,deliver.getAcceptTime()));
			}
		}*/
		
		/**
		 * 微信发送
		 */
		// 1、下单人微信推送
		wechatMessageSupport.orderSignNotify(orderInfo, commonSfRoute.getAcceptTime());
	}

	
	private void sendMsgByRecive(CommonSfRoute commonSfRoute, OrderInfo orderInfo) {
		// 1、通知寄包人已取件
//		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
//			smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112395.getCode(), SmsMessageTemplate.createM_112395(orderInfo,deliver.getAcceptTime())));
		}else{
			//smsSendService.sendSms(jmobiles, SmsTemplate.M_162520.getCode(), SmsMessageTemplate.createM_162520J(orderInfo,deliver.getAcceptTime()));
		}
		// 2、通知收包人已取件
		if(!orderInfo.getjMobile().equals(orderInfo.getdMobile())){
//			jmobiles = new String[]{orderInfo.getdMobile()};
			if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
//				smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112395.getCode(), SmsMessageTemplate.createM_112395(orderInfo,deliver.getAcceptTime())));
			}else{
				//smsSendService.sendSms(jmobiles, SmsTemplate.M_162520.getCode(), SmsMessageTemplate.createM_162520D(orderInfo,deliver.getAcceptTime()));
			}
		}
		/*// 3、球场人员
		// 寄方
		if(orderInfo.getjAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getjAddrId(), orderInfo.getjAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124157.getCode(), SmsMessageTemplate.createM_124157(orderInfo,deliver.getAcceptTime()));
			} 
		}
		// 收方
		if(orderInfo.getdAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getdAddrId(), orderInfo.getdAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124157.getCode(), SmsMessageTemplate.createM_124157(orderInfo,deliver.getAcceptTime()));
			}
		}*/
		
		/**
		 * 微信发送
		 */
		// 1、下单人微信推送
		wechatMessageSupport.orderReciveNotify(orderInfo, commonSfRoute.getAcceptTime());
	}
	
	

	private void sendMsgBytransport(CommonSfRoute commonSfRoute, OrderInfo orderInfo) {
		// 1、通知寄包人已取件
//		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
//			smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112397.getCode(), SmsMessageTemplate.createM_112397(orderInfo,deliver.getAcceptTime())));
		}else{
			//smsSendService.sendSms(jmobiles, SmsTemplate.M_162523.getCode(), SmsMessageTemplate.createM_162523J(orderInfo,deliver.getAcceptTime()));
		}
		// 2、通知收包人已取件
		if(!orderInfo.getjMobile().equals(orderInfo.getdMobile())){
//			jmobiles = new String[]{orderInfo.getdMobile()};
			if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
//				smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112397.getCode(), SmsMessageTemplate.createM_112397(orderInfo,deliver.getAcceptTime())));
			}else{
				//smsSendService.sendSms(jmobiles, SmsTemplate.M_162523.getCode(), SmsMessageTemplate.createM_162523D(orderInfo,deliver.getAcceptTime()));
			}
		}
		/*// 3、球场人员
		// 寄方
		if(orderInfo.getjAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getjAddrId(), orderInfo.getjAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124153.getCode(), SmsMessageTemplate.createM_124153(orderInfo));
			} 
			
		}
		// 收方
		if(orderInfo.getdAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getdAddrId(), orderInfo.getdAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124153.getCode(), SmsMessageTemplate.createM_124153(orderInfo));
			}
		}*/
		
		/**
		 * 微信发送
		 */
		// 1、下单人微信推送
//		wechatMessageSupport.orderTransportNotify(orderInfo, commonSfRoute.getAcceptTime());
	}

	private void orderOperateLog(OrderInfo orderInfo,String remark){
		OrderOperateLog log = new OrderOperateLog();
		log.setAction("顺丰快递");
		log.setDescription(remark);
		log.setOperatorId(0);
		log.setOperatorName("顺丰系统");
		log.setOperatorType(OrderOperateTypeEnum.qbt_system.getCode());
		log.setOrderId(orderInfo.getId());
		orderOperateLogService.insert(log);
	}
	
	private void sendCouponMessage(OrderInfo orderInfo, UserCouponActivity uca){
		if(Checker.isNotEmpty(uca)) {
			if(!LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
				smsMessageSupport.sendOrderCouponMsg(orderInfo, uca);
			}
		}
	}
	
}
