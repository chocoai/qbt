package com.qbt.common.enums;

public enum VipActivateStatusEnum {
	
	No(1,"未激活"),
	Yes(2,"已激活"),
	;
	
	Integer code;
	String desc;

	private VipActivateStatusEnum(Integer code,String desc) { 
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
	
	public static VipActivateStatusEnum getByCode(Integer code){
		if(code != null){
			for(VipActivateStatusEnum v : values()){
				if(v.getCode() == code){
					return v;
				}
			}
		}
		return null;
	}
	
}
