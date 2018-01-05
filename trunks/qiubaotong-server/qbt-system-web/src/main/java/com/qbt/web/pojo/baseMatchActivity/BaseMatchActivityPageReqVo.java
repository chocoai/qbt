package com.qbt.web.pojo.baseMatchActivity;

import com.qbt.common.result.Paging;

public class BaseMatchActivityPageReqVo extends Paging{

	private String name;

	private String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
