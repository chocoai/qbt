package com.qbt.web.pojo.rewardActitvity;

import java.util.Date;

public class WinnerListVo {
	private int id;
	private Date createTime;//创建时间
    private Date updateTime;//创建时间
    private Integer orderId;
	private Integer userId;
	private String userInfo;
	private Integer rewardActivityId;
	private String rewardActivityInfo;
	private Integer status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
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
