package com.qbt.common.enums;

public enum MqTypeEnum {

	order_pay_sucess("order"),
	order_bps_uppdate("modify"),
	order_pay_message("message");
	
	private String type;
	
	private MqTypeEnum(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
