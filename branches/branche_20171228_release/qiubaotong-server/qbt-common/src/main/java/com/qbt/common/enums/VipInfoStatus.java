package com.qbt.common.enums;


/**
 * vip会员状态
  * @ClassName: VipInfoStatus
  * @Description: TODO
  * @author chenxiaocong 2016年11月4日
  * @modify chenxiaocong 2016年11月4日
 */
public enum VipInfoStatus {

	normal(1,"正常"),
	disable(2,"禁用");
	
	Integer code;
	String desc;

	private VipInfoStatus(Integer code,String desc) { 
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
