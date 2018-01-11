package com.qbt.web.pojo.sysuser;

import com.qbt.common.result.Paging;

public class AdminUserPageReqVo extends Paging {
	
	private String email;
	
    private String mobile;
    
    private Integer status;
    
    private String name;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
