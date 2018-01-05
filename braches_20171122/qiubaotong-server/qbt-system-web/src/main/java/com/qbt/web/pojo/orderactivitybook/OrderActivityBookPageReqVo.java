package com.qbt.web.pojo.orderactivitybook;

import com.qbt.common.result.Paging;

public class OrderActivityBookPageReqVo extends Paging {

	private Integer activityId;
	
	private String activityName;
	
	private int orderId;
	
	private String number;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
	
}
