package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class ActivityRule extends BaseEntity {
	
	//规则名称
	private String name;
	
	//规则描述
	private String memo;
	
	//规则总金额
	private double amount;
	
	//状态 1-正常 2-无效
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
