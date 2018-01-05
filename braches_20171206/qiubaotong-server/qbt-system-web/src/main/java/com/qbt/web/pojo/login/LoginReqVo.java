package com.qbt.web.pojo.login;

import javax.validation.constraints.NotNull;

public class LoginReqVo {
	
	//手机号或邮箱
	@NotNull(message = "手机号不能为空")
	private String mobile;
	
	//登录密码
	@NotNull(message = "密码不能为空")
	private String pwd;


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
