package com.qbt.web.pojo.sysuser;

import javax.validation.constraints.NotNull;

public class UserPassVo {
	
	@NotNull(message = "密码不能为空")
	private String password;
	
	@NotNull(message = "新密码不能为空")
	private String newPassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
