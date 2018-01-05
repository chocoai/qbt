package com.qbt.common.enums;

public enum PaymentStatus {

	/**
	 * 支付状态 1-预支付 2-支付成功 3-支付失败 4-异常
	 */
	ready(1,"预支付"),
	success(2,"支付成功"),
	fail(3,"支付失败"),
	exception(4,"异常"),
	;
	Integer code;
	String desc;

	private PaymentStatus(Integer code,String desc) { 
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

}
