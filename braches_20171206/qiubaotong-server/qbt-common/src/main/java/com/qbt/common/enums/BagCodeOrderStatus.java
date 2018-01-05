package com.qbt.common.enums;

/**
 * 包包码使用记录状态
 * @author wuwang
 *
 */
public enum BagCodeOrderStatus {

	unknow(0, "未知"),
	success(1, "成功"),
	fail(2, "失败"),
	;
	
	Integer code;
	String desc;
	
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
	
	private BagCodeOrderStatus(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public static BagCodeOrderStatus getByCode(Integer code){
		if(code != null){
			for(BagCodeOrderStatus s : values()){
				if(s.getCode() == code){
					return s;
				}
			}
		}
		return null;
	}
	
}
