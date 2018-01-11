package com.qbt.common.enums;

public enum SysConfigEnum {
	
	shunfengReort("1","顺丰报文"),
	billTimeLimit("2","发票期限"),
	billExplain("3","发票说明"),
	insuranceExplain("4","发票说明");
	
	String code;
	String desc;
	
	private SysConfigEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
