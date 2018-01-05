package com.qbt.common.enums;

/**
 *  日志类型
  * @ClassName: LogTypeEnum
  * @Description: TODO
  * @author share 2016年8月24日
  * @modify share 2016年8月24日
 */
public enum LogTypeEnum {

	wechat(1,"微信服务"),
	boss(2,"boss服务");
	Integer code;
	String desc;

	private LogTypeEnum(Integer code,String desc) { 
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
