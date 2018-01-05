package com.qbt.web.pojo.orderChangeBook;

import java.util.Date;

import com.qbt.common.result.Paging;

public class OrderChangeBookPageReqVo extends Paging{
	
	private Date startTime;
	
	private Date endTime;
	
	private Integer orderId;
	
	private String mailNo;
	
	private String orderNumber;

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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
