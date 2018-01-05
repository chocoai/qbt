package com.qbt.web.pojo.emailMessage;

import com.qbt.common.result.Paging;

public class EmailMessagePageReqVo extends Paging{

	private Integer requestStatus;
	//邮件主题(模糊查询)
	private String subject;
	//平台（精准查询）
	private String platform;
	//邮件内容
	private String data;
	//邮箱地址
	private String emailAddress;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Integer getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(Integer requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
