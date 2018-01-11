package com.geling.msg.entity;

/**
 * @description 
 * @author Fred
 * @time 2013-5-17 下午2:59:50
 */
public enum RequestType {
	//EMAIL  发送邮件
	//SMS    发送短信
	//HTTP	 发送HTTP和HTTPS请求
	//wechat 发送微信通知
	EMAIL(0),SMS(10),HTTP(20),WECHAT(30);
	
	private int value;
	RequestType(int value){
		this.value = value;
	}
	
	public RequestType fromInt(int value){
		switch (value) {
		case 0:
			return EMAIL;
		case 10:
			return SMS;
		case 20:
			return HTTP;
		case 30:
			return WECHAT;
		}
		return null;
	}
	
	public int value(){
		return value;
	}
}
