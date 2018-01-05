package com.qbt.web.pojo.activityOff;

import com.qbt.common.result.Paging;

public class ActivityOffPageReqVo extends Paging {
	
	//规则名称
	private String name;
	
	//1-首单满减 2-全员满减 3-球场满减 4-地域满减
	private Integer type;
	
	//范围：1-球场 2-地区
	private Integer scope;
	
	//1-正常 2-无效
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getScope() {
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
