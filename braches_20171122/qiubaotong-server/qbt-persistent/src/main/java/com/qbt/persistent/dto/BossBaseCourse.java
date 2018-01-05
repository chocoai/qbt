package com.qbt.persistent.dto;

import com.qbt.persistent.entity.BaseCourse;

public class BossBaseCourse extends BaseCourse {
	
	private String contact;
	
	private String mobile;
	
	//是否有助理
    private Boolean hasAssistant;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getHasAssistant() {
		return hasAssistant;
	}

	public void setHasAssistant(Boolean hasAssistant) {
		this.hasAssistant = hasAssistant;
	}
    
}
