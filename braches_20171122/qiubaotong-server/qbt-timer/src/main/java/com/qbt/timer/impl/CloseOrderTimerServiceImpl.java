package com.qbt.timer.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.OrderCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.OrderInfoSummary;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.Orders;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrdersService;
import com.qbt.timer.TimerService;

@Service("closeOrderTimerService")
public class CloseOrderTimerServiceImpl extends TimerService {
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private OrdersService ordersService;
	
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	@Resource
	private OrderCommonSupport orderCommonSupport;
	
	@Override
	public void process() {
		int timeOut = 31;
		List<OrderInfo> orderList = orderInfoService.findCloseableOrders(timeOut);
		Set<Integer> superOrderIds = new HashSet<Integer>();
		if(Checker.isNotEmpty(orderList)){
			for(OrderInfo o : orderList){
				o.setOrderStatus(6);//6-订单关闭-系统关单
				orderInfoService.updateById(o);
				LogCvt.info("订单号["+o.getNumber()+"] 已关闭订单");
				//记录大订单号
				if(o.getOrderId() != 0) superOrderIds.add(o.getOrderId());
			}
		}
		//检查是否关闭大订单
		orderCommonSupport.closeBigOrder(new ArrayList<Integer>(superOrderIds));
		// 提前半小时通知客户支付
//		List<OrderInfo> payList = orderInfoService.findNeedPayOrders(timeOut-10);
//		if(Checker.isNotEmpty(payList)){
//			//微信通知
//			for(OrderInfo orderInfo : payList){
//				wechatMessageSupport.waitPayNotify(orderInfo);
//			}
//		}
	}

}
