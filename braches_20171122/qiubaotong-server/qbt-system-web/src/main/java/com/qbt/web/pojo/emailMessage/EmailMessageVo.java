package com.qbt.web.pojo.emailMessage;

import java.util.Date;

public class EmailMessageVo {

	//请求时间
	private Date requestTime;
	//标识Id
	private String uuid;
	//发送状态 0-发送中 1-成功 2-失败
	private Integer requestStatus;
	//发送者地址
	private String fromAddress;
	//发送者名称
	private String fromUserName;
	//接收者列表
	private String recAddress;
	//抄送地址列表
	private String ccAddress;
	//邮件主题
	private String subject;
	//邮件附件
	private String attachments;
	//邮件内容
	private String data;
	//平台
	private String platform;
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getRecAddress() {
		return recAddress;
	}
	public void setRecAddress(String recAddress) {
		this.recAddress = recAddress;
	}
	public String getCcAddress() {
		return ccAddress;
	}
	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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

}
