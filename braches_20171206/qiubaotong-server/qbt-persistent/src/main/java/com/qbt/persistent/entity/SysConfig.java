package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class SysConfig extends BaseEntity{
	
	private int operater;
	private String operaterName;
	private String code;
	private String value;
	private String name;
	public int getOperater() {
		return operater;
	}
	public void setOperater(int operater) {
		this.operater = operater;
	}
	public String getOperaterName() {
		return operaterName;
	}
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
