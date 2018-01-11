package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class OrderActivityBook extends BaseEntity{
	
	//活动id
	private Integer activityId;
	
	//活动名称
	private String activityName;
	
	//订单总金额
	private double totalAmount;
	
	//优惠折扣金额
	private double discount;
	
	//实际支付金额
	private double amount;
	
	//1-首单满减 2-全员满减 3-球场满减 4-地域满减
	private int type;
	
	//1-正常 2-已退款
	private int status;
	
	//订单id
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
