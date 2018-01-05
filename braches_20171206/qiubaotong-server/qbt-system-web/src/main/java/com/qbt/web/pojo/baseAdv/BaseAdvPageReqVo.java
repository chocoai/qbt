package com.qbt.web.pojo.baseAdv;

import com.qbt.common.result.Paging;

public class BaseAdvPageReqVo extends Paging{

	private String name;
	
	private String type;
	
	private String position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
