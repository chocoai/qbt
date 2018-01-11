package com.qbt.persistent.dto;

import com.qbt.persistent.entity.OrderInfo;

public class OrderCountAmount extends OrderInfo{

	private String name;
	
	private String mobile;
	
	private Integer count;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
