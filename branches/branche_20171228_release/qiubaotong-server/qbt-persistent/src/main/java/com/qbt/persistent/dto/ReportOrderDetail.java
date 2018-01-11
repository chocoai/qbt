package com.qbt.persistent.dto;

import com.qbt.persistent.entity.OrderInfo;

public class ReportOrderDetail extends OrderInfo {
	
	private String userName;
	
	private Integer couponType;//优惠券类型：1:现金券;2:折扣券;3:特价券

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	
}
