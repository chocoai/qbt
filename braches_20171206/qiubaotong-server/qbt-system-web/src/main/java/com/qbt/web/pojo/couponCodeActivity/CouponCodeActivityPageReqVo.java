package com.qbt.web.pojo.couponCodeActivity;

import com.qbt.common.result.Paging;

public class CouponCodeActivityPageReqVo extends Paging {

	private String name;
	
	 private Integer status;
	 
	 private String code;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	 
}
