package com.qbt.common.enums;

public enum AddrTypeEnum {
	
	course(1, "球场"),
	airport(2, "机场"),
	bank(3, "银行"),
	address(4, "个人地址"),
	sfSite(5, "顺丰站点"),
	;
	
	
	private AddrTypeEnum(int type, String desc){
		this.type = type;
		this.desc = desc;
	}
	
	private int type;
	
	private String desc;

	public int getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
	
	public static AddrTypeEnum getByType(int type){
		for(AddrTypeEnum t : values()){
			if(t.getType() == type){
				return t;
			}
		}
		return null;
	}
}
