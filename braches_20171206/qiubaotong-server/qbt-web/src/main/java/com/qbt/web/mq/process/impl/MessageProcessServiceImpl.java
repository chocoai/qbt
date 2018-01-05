package com.qbt.web.mq.process.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.SmsMsgSupport;
import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.enums.LanguagesEnum;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.CommonService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.UserAssistantService;
import com.qbt.service.UserProxyService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.mq.process.AbstractProcessService;
import com.qbt.wechat.api.WechatApi;

/**
 *  订单支付成功消息处理
  * @ClassName: OrderProcessServiceImpl
  * @Description: TODO
  * @author share 2016年8月29日
  * @modify share 2016年8月29日
 */
@Service
public class MessageProcessServiceImpl extends AbstractProcessService{

	@Resource
	private CommonService commonService;
	@Resource
	private WechatCommonSupport commonSupport;
	@Resource
	private OrderInfoService orderInfoService;
	@Resource
	private WechatApi wechatApi;
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private UserAssistantService userAssistantService;
	@Resource
	private UserProxyService userProxyService;
	@Resource
	private SmsMsgSupport smsMessageSupport;
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	@Override
	public void processMsg(String msg) {
		try {
			Thread.currentThread().setName(ToolsUtil.getUUID());
			LogCvt.info("下单消息异步处理订单ID:"+msg);
			int orderId = Integer.parseInt(msg);
			// 查询订单号
			OrderInfo orderInfo = orderInfoService.findById(orderId);
			if(orderInfo == null){
				LogCvt.error("无效的订单ID，id for>>"+msg);
				return;
			}
			if(orderInfo.getOrderStatus().intValue() != OrderStatus.pay_succ.getCode().intValue()){
				LogCvt.error("订单非支付成功状态>>"+msg);
				return;
			}
			//一单多包发短信
			String key = RedisKeyUtil.fiter_same_order_sms_key(orderInfo.getOrderId(),orderInfo.getMd5());
			long flag = commonService.lock(key, "sms", 15 * 60);
			if(flag == 0){
				LogCvt.info("订单ID，id 短信已聚合发送，无效在发>>"+msg);
				return;
			}
			// 多条订单短信组合通知
			List<OrderInfo> orderInfoList = orderInfoService.findByMd5(orderInfo.getOrderId(),orderInfo.getUserId(), orderInfo.getMd5());
			StringBuilder sb = new StringBuilder();
			for(OrderInfo info : orderInfoList){
				sb.append(info.getNumber()).append(",");
			}
			orderInfo.setNumber(sb.toString().substring(0, sb.toString().length()-1));
			// 短信消息发送
			messageSend(orderInfo);
			// 微信消息发送
			wechatMessageSend(orderInfo);
			
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		
	}
	

	private void wechatMessageSend(OrderInfo orderInfo){
		// 1、下单人微信推送
		wechatMessageSupport.createOrderNotify(orderInfo);
		// 2、客服人员\财务人员 微信推送
		// 2.1财务
		List<UserWeixin> kfList = userWeixinService.findByKfType(1);//1-财务
		if(Checker.isNotEmpty(kfList)){
			//微信通知客服
			for(UserWeixin kf : kfList){
				wechatMessageSupport.createOrderCwNotify(orderInfo, kf.getOpenid());
			}
		}
		// 2.2客服
//		kfList = userWeixinService.findByKfType(0);//1-财务
//		if(Checker.isNotEmpty(kfList)){
//			//微信通知客服
//			for(UserWeixin kf : kfList){
//				wechatMessageSupport.createOrderKfNotify(orderInfo, kf.getOpenid());
//			}
//		}
		if(orderInfo.getProxyUserId() > 0){
			 UserProxy userProxy = userProxyService.findByUserId(orderInfo.getProxyUserId(), orderInfo.getProxySelfUserId());
			 UserWeixin userWeixin = userWeixinService.findById(orderInfo.getProxyUserId());
			 wechatMessageSupport.proxyOrderNotify(orderInfo, userProxy, userWeixin.getOpenid(), "");
		}
		
	}
	
	/**
	 *  短信发送
	  * @Title: messageSend
	  * @Description: TODO
	  * @author: share 2016年8月29日
	  * @modify: share 2016年8月29日
	  * @param orderInfo
	  * @return
	  * @throws Exception
	 */
	private void messageSend(OrderInfo orderInfo) throws Exception {
		// 1、通知寄包人
		if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
			smsMessageSupport.createOrderJpMsgToJContact(orderInfo);
		}else{
			smsMessageSupport.createOrderMsgToJContact(orderInfo);
		}
		
		// 2、通知收包人
		if(!orderInfo.getjMobile().equals(orderInfo.getdMobile())){
			if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
				smsMessageSupport.createOrderJpMsgToDContact(orderInfo);
			}else{
				smsMessageSupport.createOrderMsgToDContact(orderInfo);
			}
		}
	/*	// 3、球场人员
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
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124160.getCode(), SmsMessageTemplate.createM_124160(orderInfo));
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
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124159.getCode(), SmsMessageTemplate.createM_124159(orderInfo));
			}
		}*/
	}

	public static void main(String[] args) {
		System.out.println("aaa\t\t\t\t\t".replaceAll("['\t']+", "fuck"));
	}
	
}
