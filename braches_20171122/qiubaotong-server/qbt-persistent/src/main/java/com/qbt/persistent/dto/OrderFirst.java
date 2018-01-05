package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrderInfo;

public class OrderFirst extends OrderInfo {

	private Date createTime;
	
	private String name;
	
	private String mobile;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

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
}
