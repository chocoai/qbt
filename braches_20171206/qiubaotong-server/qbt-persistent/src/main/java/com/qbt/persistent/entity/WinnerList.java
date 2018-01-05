package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class WinnerList extends BaseEntity{
	
	private Integer orderId;
	private Integer userId;
	private String userInfo;
	private Integer rewardActivityId;
	private String rewardActivityInfo;
	private Integer status;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getRewardActivityId() {
		return rewardActivityId;
	}
	public void setRewardActivityId(Integer rewardActivityId) {
		this.rewardActivityId = rewardActivityId;
	}
	public String getRewardActivityInfo() {
		return rewardActivityInfo;
	}
	public void setRewardActivityInfo(String rewardActivityInfo) {
		this.rewardActivityInfo = rewardActivityInfo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
	
}
