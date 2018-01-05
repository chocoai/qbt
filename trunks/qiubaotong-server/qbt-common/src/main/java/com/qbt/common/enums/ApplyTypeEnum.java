package com.qbt.common.enums;

/**
 *  助理类型
  * @ClassName: ApplyTypeEnum
  * @Description: TODO
  * @author share 2016年8月24日
  * @modify share 2016年8月24日
 */
public enum ApplyTypeEnum {

	partner(8,"合作社类型"),
	;
	Integer code;
	String desc;

	private ApplyTypeEnum(Integer code,String desc) { 
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
