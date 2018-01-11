package com.qbt.web.pojo.smsMessage;

import com.qbt.common.result.Paging;

public class SmsMessagePageReqVo extends Paging {

	//接收手机号码
	private String mobiles;
	//消息内容
	private String smsData;
	//请求平台
	private String platform;
	
	public String getMobiles() {
		return mobiles;
	}
	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}
	public String getSmsData() {
		return smsData;
	}
	public void setSmsData(String smsData) {
		this.smsData = smsData;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	

}
