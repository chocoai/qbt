package com.qbt.web.pojo.baseTravelAgency;

import com.qbt.common.result.Paging;

public class BaseTravelAgencyPageReqVo extends Paging{

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
