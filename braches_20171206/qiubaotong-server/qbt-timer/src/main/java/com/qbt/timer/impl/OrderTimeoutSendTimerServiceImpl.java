package com.qbt.timer.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.enums.ExceptionTypeEnum;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderTaskFlow;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.OrderExceptionBookService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderTaskFlowService;
import com.qbt.service.UserWeixinService;
import com.qbt.sms.api.service.SmsSendService;
import com.qbt.timer.TimerService;
import com.qbt.wechat.api.WechatApi;

@Service("orderTimeoutSendTimerService")
public class OrderTimeoutSendTimerServiceImpl extends TimerService {
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private OrderTaskFlowService orderTaskFlowService;
	
	@Resource
	private OrderExceptionBookService orderExceptionBookService;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private SmsSendService smsSendService;
	
	@Resource
	private WechatCommonSupport commonSupport;
	
	@Resource
	private WechatApi wechatApi;
	
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	private static String decription = "已超过预约取包时间2小时,球包未被取走";
	
	@Override
	public void process() {
		/**
		 * 如果超过预约时间两小时，订单状态未变更，
		 * “任务类型”显示：订单状态未变更，
		 * “描述”显示：已超过预约取包时间2小时,球包未被取走，
		 * 同时微信推送信息到客服手机。
		 */
		
		List<OrderInfo> orderList = orderInfoService.findSendableOrders(3);//3-超过预约时间两小时
		if(Checker.isNotEmpty(orderList)){
			List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
			String[] kfMobiles = null;
			if(Checker.isNotEmpty(kfList)){
				kfMobiles = new String[kfList.size()];
				for(int i = 0; i < kfList.size(); i++){
					kfMobiles[i] = kfList.get(i).getMobile();
				}
			}
			
			OrderTaskFlow flow = null;
			OrderExceptionBook book = null;
			for(OrderInfo orderInfo : orderList){
				long after = DateUtils.addHours(orderInfo.getSendSfUserTime(), 2).getTime();
				//超过预约时间两小时
				if(System.currentTimeMillis() > after){
					//登记订单客服跟踪表
					flow = new OrderTaskFlow();
					flow.setOrderId(orderInfo.getId());
					flow.setType(3);//3-超过预约时间两小时
					orderTaskFlowService.insert(flow);
					
					//登记仪表盘
					book = new OrderExceptionBook();
					book.setOrderId(orderInfo.getId());
					book.setOrderNumber(orderInfo.getNumber());
					book.setOrderStatus(orderInfo.getOrderStatus());
					book.setType(ExceptionTypeEnum.on_change_status.getCode());//2:订单状态在一定时间内没有变化
					book.setDescription(decription);
					book.setIsDealed(false);
					orderExceptionBookService.insert(book);
					
					if(Checker.isNotEmpty(kfList)){
						//微信通知客服
						for(UserWeixin kf : kfList){
							wechatMessageSupport.exceptionBookNotify(book, kf.getOpenid());
						}
						
						//短信通知客服
//						smsSendService.sendSms(kfMobiles, SmsTemplate.M_70670.getCode(), new String[]{SmsMessageTimerTemplate.createM_70670(book)});
					}
				}
			}
		}
	}

}
