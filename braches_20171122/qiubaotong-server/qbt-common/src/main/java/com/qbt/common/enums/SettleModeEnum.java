package com.qbt.common.enums;

public enum SettleModeEnum {
	
	//1-进阶模式，2-订单折扣模式，3-订单固定金额模式
	advanced_mode(1, "进阶模式"),
	per_percent_mode(2, "订单折扣模式"),
	per_rebate_mode(3, "订单固定金额模式"),
	;
	
	private SettleModeEnum(int code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
	private int code;
	
	private String desc;

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	public static SettleModeEnum getByCode(int code){
		for(SettleModeEnum s : values()){
			if (s.getCode() == code) return s;
		}
		return null;
	}
	
}
