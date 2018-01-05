package com.qbt.web.pojo.smsMessage;

import java.util.Date;

public class SmsMessageVo {

	//请求时间
	private Date requestTime;
	//uuid
	private String uuid;
	//状态0-发送中1-成功2-失败
	private Integer requestStatus;
	//接收手机号码
	private String mobiles;
	//消息模板编号
	private String smsTemplateId;
	//消息内容
	private String smsData;
	//返回码 
	private String statusCode;
	//错误信息
	private String statusMsg;
	//sid
	private String messageSid;
	//短信平台时间
	private String dateCreated;
	//请求平台
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
	public Integer getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(Integer requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getMobiles() {
		return mobiles;
	}
	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}
	public String getSmsTemplateId() {
		return smsTemplateId;
	}
	public void setSmsTemplateId(String smsTemplateId) {
		this.smsTemplateId = smsTemplateId;
	}
	public String getSmsData() {
		return smsData;
	}
	public void setSmsData(String smsData) {
		this.smsData = smsData;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public String getMessageSid() {
		return messageSid;
	}
	public void setMessageSid(String messageSid) {
		this.messageSid = messageSid;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	
	
	
}
