package com.qbt.persistent.dto;

import com.qbt.persistent.entity.OrderInfo;

public class ReportOrderAmount extends OrderInfo {
	
	//用户名
	private String userName;
	
	//支付号
	private String uuid;
	
	//券面额
	private Double childAmount;
	
	//支付方式：1-微信支付,2-boss购买,97-boss下单免支付,98-合作方下单免支付,99-现金券满额支付
	private Integer payMethod;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Double getChildAmount() {
		return childAmount;
	}

	public void setChildAmount(Double childAmount) {
		this.childAmount = childAmount;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}
	
}
