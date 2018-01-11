package com.qbt.common.enums;

public enum OrderOperateTypeEnum {

	/**
	 * 操作者类型：1:客户;2:客服;3:球场工作人员;4:顺丰系统;5:球包通系统;6:微信
	 */
	weixin_user(1,"客户"),
	sys_kf(2,"客服"),
	course_person(3,"球场工作人员"),
	sf_system(4,"顺丰系统"),
	qbt_system(5,"球包通系统"),
	weixin(6,"微信"),
	;
	
	
	Integer code;
	String desc;

	private OrderOperateTypeEnum(Integer code,String desc) { 
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
