package com.qbt.web.pojo.login;

import java.util.List;

public class LoginRespVo {
	
	//用户id
	private Integer userId;
	
	//手机号
	private String mobile;
	
	//邮箱地址
	private String email;
	
	//是否超级用户
	private Boolean isSuperUser;
	
	//是否激活
	private Boolean isValidated;
	
	//状态：1-正常，2-禁用
	private Integer status;
	
	//token
	private String token;
	
	//用户名
	private String name;
	
	//用户平台id
	private List<Integer> platIdList;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsSuperUser() {
		return isSuperUser;
	}

	public void setIsSuperUser(Boolean isSuperUser) {
		this.isSuperUser = isSuperUser;
	}

	public Boolean getIsValidated() {
		return isValidated;
	}

	public void setIsValidated(Boolean isValidated) {
		this.isValidated = isValidated;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getPlatIdList() {
		return platIdList;
	}

	public void setPlatIdList(List<Integer> platIdList) {
		this.platIdList = platIdList;
	}
	
}
