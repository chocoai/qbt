package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class ActivityRuleConfig extends BaseEntity {
	
	//规则id
	private int ruleId;
	
	//规则金额
	private double amount;
	
	//数量
	private int number;
	
	//限制使用金额
	private double limitAmount;


	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(double limitAmount) {
		this.limitAmount = limitAmount;
	}

}
