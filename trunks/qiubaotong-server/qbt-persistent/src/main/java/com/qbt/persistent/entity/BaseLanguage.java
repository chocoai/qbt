package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BaseLanguage extends BaseEntity {
	
	private String name;
	
	private String ename;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
}