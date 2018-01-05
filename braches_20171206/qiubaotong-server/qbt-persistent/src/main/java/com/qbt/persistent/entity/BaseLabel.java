package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BaseLabel extends BaseEntity{

	private String name;
	
	private Integer superId;
	
	private Integer sort;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSuperId() {
		return superId;
	}

	public void setSuperId(Integer superId) {
		this.superId = superId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	
	
}
