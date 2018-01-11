package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class TicketPackageRule extends BaseEntity{
	
	private String ruleName;
	
	private float price;
	
	private int status;
	
	private String description;
	
	private int isStorageService;
	
	private String operator;
	

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsStorageService() {
		return isStorageService;
	}

	public void setIsStorageService(int isStorageService) {
		this.isStorageService = isStorageService;
	}

	
}
