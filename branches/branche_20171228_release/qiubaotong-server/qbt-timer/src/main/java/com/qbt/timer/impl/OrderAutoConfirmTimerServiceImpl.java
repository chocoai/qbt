package com.qbt.timer.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.service.OrderInfoService;
import com.qbt.timer.TimerService;

@Service("orderAutoConfirmTimerService")
public class OrderAutoConfirmTimerServiceImpl extends TimerService{
	
	@Resource
	private OrderInfoService orderInfoService;
	private static final int PASTDAY = 7;
	
	/**
	 * 订单签收7天后自动设置为已确认收包
	 *
	 */
	@Override
	public void process() {
		// TODO Auto-generated method stub
		
		  Calendar calendar = Calendar.getInstance();  
	      calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - PASTDAY); 
	      Date days = calendar.getTime();  
	      String date = DateUtil.formatDate(days);
	      List<OrderInfo> list = orderInfoService.findByAutoConfirm(date);
	      for(OrderInfo orderInfo:list){
	    	  if(orderInfo.getIsConfirmReceive() == false){
	    		  orderInfoService.updateConfirmReceiveById(orderInfo.getId());
	    	  }
	      }
	      
	}
	public static void main(String[] args) {
		  Calendar calendar = Calendar.getInstance();  
	      calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - PASTDAY); 
	      Date days = calendar.getTime();  
	      String date = DateUtil.formatDate(days);
	      System.out.println(date);
	}
}
