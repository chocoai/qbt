package com.qbt.web.pojo.vipType;

import com.qbt.common.result.Paging;

public class VipTypePageReqVo extends Paging{
	
	//会员卡名称 
	private String name;
	//1-正常 2-禁用
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
