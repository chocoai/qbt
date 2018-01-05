package com.qbt.common.enums;

public enum SerialTypeEnum {

	ORDER_TYPE("order", "0"), 
	BIG_ORDER_TYPE("bigorder", "1"),
	PAYMENT_TYPE("payment", "2"), 
	REFUND_TYPE("refund", "3"),
	COUPON_TYPE("coupon", "4"),
	VIP_ORDER_TYPE("viporder", "5"),
	TICKET_PACKAGE_PAYMENT_TYPE("ticketPackage", "6"),
	;

	String type;
	String value;

	private SerialTypeEnum(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
