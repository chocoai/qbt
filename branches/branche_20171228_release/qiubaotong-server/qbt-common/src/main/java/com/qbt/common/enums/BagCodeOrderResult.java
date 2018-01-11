package com.qbt.common.enums;

/**
 * 包包码使用记录状态
 * @author wuwang
 *
 */
public enum BagCodeOrderResult {

	jd_distinct(1,"寄收信息不一致"),
	bagCode_un_exist(2,"包包码不存在"),
	bagCode_forbidden(3,"包包码禁用"),
	bagCode_un_date(4,"包包码不在有效期"),
	j_un_free(5,"寄件人信息不能随意"),
	un_pay(6,"未支付"),
	paid(7,"已支付");
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
	
	private BagCodeOrderResult(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public static BagCodeOrderResult getByCode(Integer code){
		if(code != null){
			for(BagCodeOrderResult s : values()){
				if(s.getCode() == code){
					return s;
				}
			}
		}
		return null;
	}
	
}
