package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrderRefund;

public class BossOrderRefund extends OrderRefund {
	
	private Date startTime;
	
	private Date endTime;
	
	private String orderNumber;

	//订单下单时间
  	private Date orderCreateTime;
  	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
