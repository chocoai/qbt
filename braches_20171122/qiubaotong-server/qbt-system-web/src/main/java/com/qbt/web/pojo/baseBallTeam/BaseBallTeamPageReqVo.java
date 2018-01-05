package com.qbt.web.pojo.baseBallTeam;

import com.qbt.common.result.Paging;

public class BaseBallTeamPageReqVo extends Paging{

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