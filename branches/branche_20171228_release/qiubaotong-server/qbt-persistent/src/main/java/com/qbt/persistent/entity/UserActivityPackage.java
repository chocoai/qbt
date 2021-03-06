package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class UserActivityPackage extends BaseEntity {
	int userId;
	int orderDetailId;
	Integer status;//(0 - inactive; 1 - active)
	String operatorId;
	String operatorName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
}
