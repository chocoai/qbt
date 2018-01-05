package com.qbt.web.mq.process.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.qbt.bussiness.support.EmailMsgSupport;
import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.enums.DeliveryStatus;
import com.qbt.common.enums.ExceptionTypeEnum;
import com.qbt.common.enums.OrderOperateTypeEnum;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.enums.SfBpsStatus;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.email.EmailService;
import com.qbt.persistent.entity.BaseBspAreaConfig;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.OrderEmail;
import com.qbt.persistent.entity.OrderEmailInsured;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderOperateLog;
import com.qbt.persistent.entity.UserSfKf;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.BaseBspAreaConfigService;
import com.qbt.service.BaseCourseInfoService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.OrderEmailInsuredService;
import com.qbt.service.OrderEmailService;
import com.qbt.service.OrderExceptionBookService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderOperateLogService;
import com.qbt.service.OrderRouteTaskService;
import com.qbt.service.UserAssistantService;
import com.qbt.service.UserKfService;
import com.qbt.service.UserSfKfService;
import com.qbt.service.UserWeixinService;
import com.qbt.sf.api.bean.RespErr;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseAddedService;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseCargo;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseReq;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseReqBody;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseReqOrder;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseResp;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseRespDeliver;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sms.api.service.SmsSendService;
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
public class OrderProcessServiceImpl extends AbstractProcessService{

	@Resource
	private WechatCommonSupport commonSupport;
	@Resource
	private OrderInfoService orderInfoService;
	@Resource
	private BaseCourseInfoService baseCourseInfoService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	@Resource
	private UserSfKfService userSfKfService;
	@Resource
	private SFExpressApiService sfExpressApiService;
	@Resource
	private SmsSendService smsSendService;
	@Resource
	private WechatApi wechatApi;
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
	private OrderRouteTaskService orderRouteTaskService;
	@Resource
	private EmailService emailService;
	@Resource
	private BaseBspAreaConfigService baseBspAreaConfigService;
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	@Resource
	private EmailMsgSupport emailMsgSupport;
	@Resource
	private OrderEmailService orderEmailService;
	@Resource
	private OrderEmailInsuredService orderEmailInsuredService;
	
	@Override
	public void processMsg(String msg) {
		try {
			Thread.currentThread().setName(ToolsUtil.getUUID());
			LogCvt.info("BSP逆向处理订单ID:"+msg);
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
			if(!StringUtil.isEmpty(orderInfo.getMailNo()) || orderInfo.getBpsStatus().intValue() == SfBpsStatus.sucess.getCode().intValue()){
				LogCvt.error("订单已发给顺丰，无需处理此条消息");
				return;
			}
			// 查询客服值班电话
			int week = Integer.parseInt(DateUtil.getWeekDay());
			int hour = DateUtil.getHour(new Date());
			UserSfKf kfUser = userSfKfService.findDutyKf(week,hour);
			if(kfUser == null){
				/**
				 * 登记仪表盘
				 */
				String desc = "订单支付成功，顺丰下单，无法查找值班客服人员，星期"+week+",小时："+hour;
				OrderExceptionBook orderExceptionBook = saveOrderExceptionBook(orderInfo, desc);
				
				List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
				if(Checker.isNotEmpty(kfList)){
					//微信通知客服
					for(UserWeixin kf : kfList){
						wechatMessageSupport.exceptionBookNotify(orderExceptionBook, kf.getOpenid());
					}
				}
				
				LogCvt.error("订单支付成功，顺丰下单，无法查找值班客服人员，week="+week+",hour="+hour);
				return;
			}
			// 顺丰订单请求信息
			OrderReverseReq orderReq = contactOrderReq(orderInfo, kfUser);
			// 发送至顺丰
			OrderReverseResp resp = null;
			int sendCount = 3;
			for(int i = 0; i <=sendCount; i++){
				OrderReverseReq req = getOrderReverseReq(orderReq, i);
				LogCvt.info("第"+(i+1)+"次下发BSP");
				resp = sfExpressApiService.orderReverseService(req);
				if(resp == null && i != sendCount){
					continue;
				}else if(resp == null && i == sendCount){
					LogCvt.error("订单支付成功，顺丰下单失败，msg:"+ "第"+sendCount+"次下发BSP, 接口无响应");
					orderInfo.setBpsStatus(SfBpsStatus.fail.getCode());
					orderInfoService.updateById(orderInfo);
					
					String desc = "订单支付成功，下发顺丰失败，原因："+"第"+sendCount+"次下发BSP, 接口无响应";
					OrderExceptionBook orderExceptionBook = saveOrderExceptionBook(orderInfo, desc);
					
					List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
					if(Checker.isNotEmpty(kfList)){
						//微信通知客服
						for(UserWeixin kf : kfList){
							wechatMessageSupport.exceptionBookNotify(orderExceptionBook, kf.getOpenid());
						}
					}
					return;
				}
				RespErr err = resp.getError();
				if(err == null || StringUtil.isEmpty(err.getCode())){
					break;
				}
			}
			RespErr err = resp.getError();
			if(err != null && !StringUtil.isEmpty(err.getCode())){
				LogCvt.error("订单支付成功，顺丰下单失败，msg:"+err.getValue());
				orderInfo.setBpsStatus(SfBpsStatus.fail.getCode());
				orderInfoService.updateById(orderInfo);
				
				String desc = "订单支付成功，下发顺丰失败，原因："+err.getValue();
				OrderExceptionBook orderExceptionBook = saveOrderExceptionBook(orderInfo, desc);
				
				List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
				if(Checker.isNotEmpty(kfList)){
					//微信通知客服
					for(UserWeixin kf : kfList){
						wechatMessageSupport.exceptionBookNotify(orderExceptionBook, kf.getOpenid());
					}
				}
				return;
			}
			List<OrderReverseRespDeliver> deliverOrder = resp.getDeliverOrder();
			if(!deliverOrder.isEmpty()){
				OrderReverseRespDeliver respDeliver = deliverOrder.get(0);
				orderInfo.setMailNo(respDeliver.getMailno());
				// 检查运单号
				checkMailNo(orderId, orderInfo, respDeliver);
			}
			orderInfo.setBpsStatus(SfBpsStatus.sucess.getCode());
			orderInfo.setDeliveryStatus(DeliveryStatus.wait_sf_recive.getCode());
			
			
			// 添加到顺丰路由任务表
			
			OrderOperateLog log = new OrderOperateLog();
			log.setAction("发顺丰");
			log.setDescription("订单信息下发至顺丰");
			log.setOperatorId(orderInfo.getUserId());
			log.setOperatorName("球包通系统");
			log.setOperatorType(OrderOperateTypeEnum.qbt_system.getCode());
			log.setOrderId(orderInfo.getId());
			orderOperateLogService.insert(log);
			
			// 发送邮件
			emailMsgSupport.orderPaySuccNotify(orderInfo);
			checkInsuredValue(orderInfo);
			orderInfoService.updateById(orderInfo);
			log = new OrderOperateLog();
			log.setAction("发短信、微信、邮件通知消息");
			log.setDescription("发送短信和微信消息给用户，已发邮件给客服和顺丰人员");
			log.setOperatorId(orderInfo.getUserId());
			log.setOperatorName("球包通系统");
			log.setOperatorType(OrderOperateTypeEnum.qbt_system.getCode());
			log.setOrderId(orderInfo.getId());
			orderOperateLogService.insert(log);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		
	}
	
	private void checkInsuredValue(OrderInfo orderInfo) {
		OrderEmail orderEmail = orderEmailService.findByCode("orderCreate");
		OrderEmailInsured orderEmailInsured = orderEmailInsuredService.findByMinMaxAndOrderEmailId(orderInfo.getInsuredValue(), orderEmail.getId());
		orderInfo.setInsuredChannel(orderEmailInsured.getInsuredChannel());
	}
	
	public OrderReverseReq getOrderReverseReq(OrderReverseReq orderReq,int i){
		OrderReverseReq req = BeanUtil.a2b(orderReq, OrderReverseReq.class);
		switch (i) {
			case 0:
				return orderReq;
			case 1:
				// 替换寄件球场区
				req.getBody().getOrder().setJ_county(req.getBody().getOrder().getJ_city());
				return req;
			case 2:
				// 替换收件球场区
				req.getBody().getOrder().setD_county(req.getBody().getOrder().getD_city());
				return req;
			case 3:
				// 替换寄收件球场区
				req.getBody().getOrder().setJ_county(req.getBody().getOrder().getJ_city());
				req.getBody().getOrder().setD_county(req.getBody().getOrder().getD_city());
				return req;
		}
		return orderReq;
	}

	/**
	 *  检查运单号数据
	  * @Title: checkMailNo
	  * @Description: TODO
	  * @author: share 2016年9月3日
	  * @modify: share 2016年9月3日
	  * @param orderId
	  * @param orderInfo
	  * @param respDeliver
	 */
	private void checkMailNo(int orderId, OrderInfo orderInfo, OrderReverseRespDeliver respDeliver) {
		if(StringUtil.isEmpty(respDeliver.getMailno())){
			String remark = "订单支付成功，顺丰下单成功，但无顺丰运单号，请客服与顺丰确认该地区是否可以到达，filter_result:"+respDeliver.getFilter_result();
			LogCvt.error(remark);
			orderInfo.setBpsStatus(SfBpsStatus.fail.getCode());
			orderInfoService.updateById(orderInfo);
			
			OrderExceptionBook orderExceptionBook = saveOrderExceptionBook(orderInfo, remark);
			
			List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
			if(Checker.isNotEmpty(kfList)){
				//微信通知客服
				for(UserWeixin kf : kfList){
					wechatMessageSupport.exceptionBookNotify(orderExceptionBook, kf.getOpenid());
				}
			}
		}
	}


	private OrderReverseReq contactOrderReq(OrderInfo orderInfo, UserSfKf kfUser) {
		OrderReverseReq orderReq = new OrderReverseReq();
		OrderReverseReqBody body = new OrderReverseReqBody();
		orderReq.setService("OrderReverseService");
		// 寄件方信息
		String[] jtreePaths = orderInfo.getjTreePath().split(",");
		String j_province = jtreePaths[0];
		String j_city = jtreePaths[1]; 
		String j_county = jtreePaths.length ==3?jtreePaths[2]:"";
		
		OrderReverseReqOrder order = new OrderReverseReqOrder();
		order.setOrderid(orderInfo.getNumber());
		order.setJ_contanct(orderInfo.getjContact()+"(球包通)");
		order.setJ_mobile(kfUser.getMobile());
		// bsp地区配置转换
		int jAreaId = orderInfo.getjAreaId();
		order.setJ_province(j_province);
		order.setJ_city(j_city);
		BaseBspAreaConfig jAreaConfig = baseBspAreaConfigService.findBySrcArea(j_city, j_county);
		if(Checker.isEmpty(jAreaConfig)){
			BaseSfArea sfArea = baseSfAreaService.findById(jAreaId);
			sfArea = baseSfAreaService.findById(sfArea.getParentId());
			jAreaConfig = baseBspAreaConfigService.findBySrcArea(sfArea.getFullName(), j_county);
		}
		if(Checker.isNotEmpty(jAreaConfig)){
			order.setJ_county(jAreaConfig.getDestCountry());
		}else{
			order.setJ_county(j_county);
		}
		if(orderInfo.getjAddrType() != 4){
			order.setJ_company(orderInfo.getjAddrName());
		}
		/*// 检查是否为球场寄包
		if(orderInfo.getjAddrType() == 1){
			boolean matchCoursePhone = false;
			BaseCourseInfo course = baseCourseInfoService.findByQyCourseId(orderInfo.getjAddrId());
			if(course != null){
				String mobile = course.getMobile();
				String phone = course.getTelephone();
				if(StringUtil.isMobile(mobile)){
					order.setJ_mobile(mobile);
					matchCoursePhone =true;
				}else if(StringUtil.isMobile(phone)){
					order.setJ_mobile(phone);
					matchCoursePhone =true;
				}
			}
			// 未匹配上球场电话获取球包助理电话
			if(!matchCoursePhone){
				List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getjAddrId(), orderInfo.getjAddrType());
				if(assistantList != null && !assistantList.isEmpty()){
					String phone = assistantList.get(0).getMobile();
					order.setJ_mobile(phone);
				} 
			}
		}*/
		String jAddressName = Checker.isNotEmpty(orderInfo.getjAddrName()) ? "("+orderInfo.getjAddrName()+")" : "";
		order.setJ_address(orderInfo.getjTreePath().replace(",", "")+orderInfo.getjAddress()+jAddressName);
		// 收件方信息
		String[] dtreePaths = orderInfo.getdTreePath().split(",");
		String d_province = dtreePaths[0];
		String d_city = dtreePaths[1];
		String d_county = dtreePaths.length ==3?dtreePaths[2]:"";
		order.setD_contact(orderInfo.getdContact()+"(球包通)");
		order.setD_mobile(kfUser.getMobile());
		// bsp地区配置转换
		int dAreaId = orderInfo.getdAreaId();
		order.setD_province(d_province);
		order.setD_city(d_city);
		BaseBspAreaConfig dAreaConfig = baseBspAreaConfigService.findBySrcArea(d_city, d_county);
		if(Checker.isEmpty(dAreaConfig)){
			BaseSfArea sfArea = baseSfAreaService.findById(dAreaId);
			sfArea = baseSfAreaService.findById(sfArea.getParentId());
			dAreaConfig = baseBspAreaConfigService.findBySrcArea(sfArea.getFullName(), d_county);
		}
		if(Checker.isNotEmpty(dAreaConfig)){
			order.setD_county(dAreaConfig.getDestCountry());
		}else{
			order.setD_county(d_county);
		}
		if(orderInfo.getdAddrType() != 4){
			order.setD_company(orderInfo.getdAddrName());
		}
		/*// 检查是否为球场收包
		if(orderInfo.getdAddrType() == 1){
			boolean matchCoursePhone = false;
			BaseCourseInfo course = baseCourseInfoService.findByQyCourseId(orderInfo.getdAddrId());
			if(course != null){
				String mobile = course.getMobile();
				String phone = course.getTelephone();
				if(StringUtil.isMobile(mobile)){
					order.setD_mobile(mobile);
					matchCoursePhone =true;
				}else if(StringUtil.isMobile(phone)){
					order.setD_mobile(phone);
					matchCoursePhone =true;
				}
			}
			// 未匹配上球场电话获取球包助理电话
			if(!matchCoursePhone){
				List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getdAddrId(), orderInfo.getdAddrType());
				if(assistantList != null && !assistantList.isEmpty()){
					String phone = assistantList.get(0).getMobile();
					order.setD_mobile(phone);
				} 
			}
		}*/
		String dAddressName = Checker.isNotEmpty(orderInfo.getdAddrName()) ? "("+orderInfo.getdAddrName()+")" : "";
		order.setD_address(orderInfo.getdTreePath().replace(",", "")+orderInfo.getdAddress()+dAddressName);
		// other
		order.setPay_method("3");
		order.setExpress_type(orderInfo.getExpressType());
		order.setCargo_total_weight("18.00");
		order.setSendstarttime(DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01));
		order.setRemark("重件高价值物品请三轮车或面包车取包，需包装，取包:"+DateUtil.formatDate(orderInfo.getSendSfUserTime(),"MM-dd HH:mm:ss"));
		
		List<OrderReverseCargo> cargoList = new ArrayList<OrderReverseCargo>();
		OrderReverseCargo cargo = new OrderReverseCargo();
		cargo.setCount("1");
		cargo.setName("球包(需要包装)");
		cargoList.add(cargo);
		// 检查是否为球场寄包
		if(orderInfo.getjAddrType() == 1){
			int hour = DateUtil.getHour(orderInfo.getSendSfUserTime());
			if(hour >=8 && hour <= 10){
				cargo.setName(cargo.getName()+";注:可以早上10点统一取件");
			}else if(hour >10 && hour <= 14){
				cargo.setName(cargo.getName()+";注:可以下午14点统一取件");
			}else if(hour >14 && hour <= 21){
				cargo.setName(cargo.getName()+";注:统一收件跟随网点发出班次");
			}
		}
		order.setCargoList(cargoList);
		List<OrderReverseAddedService> addedServiceList = new ArrayList<OrderReverseAddedService>();
		OrderReverseAddedService orderAddedService = new OrderReverseAddedService();
		orderAddedService.setName("INSURE");
		if(0<orderInfo.getInsuredValue()&&orderInfo.getInsuredValue()<=20){
			orderAddedService.setValue("0");
		}else{
			orderAddedService.setValue(orderInfo.getInsuredValue() == 0 ? "2000" : String.valueOf(Arith.mul(orderInfo.getInsuredValue(),10000)));
		}
		addedServiceList.add(orderAddedService);
		order.setAddedService(addedServiceList);
	    
		body.setOrder(order);
		orderReq.setBody(body);
		return orderReq;
	}
	
	private OrderExceptionBook saveOrderExceptionBook(OrderInfo orderInfo, String desc){
		OrderExceptionBook orderExceptionBook = new OrderExceptionBook();
		orderExceptionBook.setOrderId(orderInfo.getId()); 
		orderExceptionBook.setOrderNumber(orderInfo.getNumber());
		orderExceptionBook.setIsDealed(false);
		orderExceptionBook.setOrderStatus(orderInfo.getOrderStatus());
		orderExceptionBook.setDescription(desc);
		orderExceptionBook.setType(ExceptionTypeEnum.order_fail.getCode());
		orderExceptionBookService.insert(orderExceptionBook);
		return orderExceptionBook;
	}
	
	public static void main(String[] args) {
		System.out.println("aaa\t\t\t\t\t".replaceAll("['\t']+", "fuck"));
	}
	
}
