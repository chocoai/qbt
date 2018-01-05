package com.qbt.persistent.dto;

import com.qbt.persistent.entity.UserAssistantApply;

public class UserAssistantApplyWX extends UserAssistantApply {

	private String nickname; 
	    
    private Integer sex;
    
    private String mobile;
    
    private String email;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
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
    
    
	
}
