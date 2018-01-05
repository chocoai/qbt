package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class SfNotifyConfig extends BaseEntity {
	
    private String orderNumber;

    private Integer operator; // 操作人
    
    private String operatorName;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}