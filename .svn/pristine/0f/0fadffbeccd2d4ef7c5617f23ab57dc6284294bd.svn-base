package com.qbt.timer.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.OrderCommonSupport;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.OrderInfoSummary;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.Orders;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrdersService;
import com.qbt.timer.TimerService;

@Service("closeOrderForOfficialTimerService")
public class CloseOrderForOfficialTimerServiceImpl extends TimerService {
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private OrdersService ordersService;
	
	@Resource
	private OrderCommonSupport orderCommonSupport;
	
	@Override
	public void process() {
		List<OrderInfo> orderList = orderInfoService.findCloseableOrdersForOfficial(15);
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
	}

}
