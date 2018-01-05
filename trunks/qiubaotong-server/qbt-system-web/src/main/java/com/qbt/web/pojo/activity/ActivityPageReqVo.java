package com.qbt.web.pojo.activity;

import com.qbt.common.result.Paging;

public class ActivityPageReqVo extends Paging {
	
	private String name;//活动名称
	
	private String code;//暗码，唯一索引(暗号为4-6位的英文字母和数字组合)
	
	private Integer type = 1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
