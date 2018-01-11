package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrderChangeBook;

public class BossOrderChangeBook extends OrderChangeBook {
	
	private Date startTime;
	
	private Date endTime;
	
	private String orderNumber;
	
	private String mailNo;

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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}
	
}
