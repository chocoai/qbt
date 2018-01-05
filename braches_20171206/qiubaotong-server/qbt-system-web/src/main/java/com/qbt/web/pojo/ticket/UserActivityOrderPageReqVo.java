package com.qbt.web.pojo.ticket;

import com.qbt.common.result.Paging;

public class UserActivityOrderPageReqVo extends Paging{
	int orderId;
	String orderNumber;
	String wechatTransactionNumber;
	int userId;
	Integer type;
	int activityId;
	String activityName;
	String purchaser;
	String purchaserAddress;
	String purchaserNumber;
	Integer status;//(0 - inactive; 1 - active)
	Integer payStatus;
	String proxyUserId;
	String proxyUser;
	Integer operatorId;
	String operatorName;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public String getPurchaserAddress() {
		return purchaserAddress;
	}

	public void setPurchaserAddress(String purchaserAddress) {
		this.purchaserAddress = purchaserAddress;
	}

	public String getPurchaserNumber() {
		return purchaserNumber;
	}

	public void setPurchaserNumber(String purchaserNumber) {
		this.purchaserNumber = purchaserNumber;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getProxyUser() {
		return proxyUser;
	}

	public void setProxyUser(String proxyUser) {
		this.proxyUser = proxyUser;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getWechatTransactionNumber() {
		return wechatTransactionNumber;
	}

	public void setWechatTransactionNumber(String wechatTransactionNumber) {
		this.wechatTransactionNumber = wechatTransactionNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProxyUserId() {
		return proxyUserId;
	}

	public void setProxyUserId(String proxyUserId) {
		this.proxyUserId = proxyUserId;
	}
	
}
