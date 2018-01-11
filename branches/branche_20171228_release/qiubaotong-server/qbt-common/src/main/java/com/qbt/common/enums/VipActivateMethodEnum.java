package com.qbt.common.enums;

public enum VipActivateMethodEnum {
	
	Wechat(1,"微信"),
	App(2,"APP"),
	PC(3,"官网"),
	KF(4,"客服人工"),
	;
	
	Integer code;
	String desc;

	private VipActivateMethodEnum(Integer code,String desc) { 
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static VipActivateMethodEnum getByCode(Integer code){
		if(code != null){
			for(VipActivateMethodEnum v : values()){
				if(v.getCode() == code){
					return v;
				}
			}
		}
		return null;
	}
	
}
