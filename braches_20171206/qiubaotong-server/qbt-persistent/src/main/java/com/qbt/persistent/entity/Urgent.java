package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class Urgent extends BaseEntity {
	
    private String name;//名称

    private Integer price;// 价格

    private String fromProvince;// 原寄地省
    private String fromCity;// 原寄地市
    
    private String toProvince;// 目的地省
    private String toCity;// 目的地市
    
    private String fromProvinceName;// 原寄地省
    private String fromCityName;// 原寄地市
    
    private String toProvinceName;// 目的地省
    private String toCityName;// 目的地市
    
    private String description;
    
    private Integer operator; // 操作人
    
    private String operatorName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getFromProvince() {
		return fromProvince;
	}

	public void setFromProvince(String fromProvince) {
		this.fromProvince = fromProvince;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToProvince() {
		return toProvince;
	}

	public void setToProvince(String toProvince) {
		this.toProvince = toProvince;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public String getFromProvinceName() {
		return fromProvinceName;
	}

	public void setFromProvinceName(String fromProvinceName) {
		this.fromProvinceName = fromProvinceName;
	}

	public String getFromCityName() {
		return fromCityName;
	}

	public void setFromCityName(String fromCityName) {
		this.fromCityName = fromCityName;
	}

	public String getToProvinceName() {
		return toProvinceName;
	}

	public void setToProvinceName(String toProvinceName) {
		this.toProvinceName = toProvinceName;
	}

	public String getToCityName() {
		return toCityName;
	}

	public void setToCityName(String toCityName) {
		this.toCityName = toCityName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}