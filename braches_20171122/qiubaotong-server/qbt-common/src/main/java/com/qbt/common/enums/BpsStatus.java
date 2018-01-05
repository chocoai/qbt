package com.qbt.common.enums;

/**
 * 顺丰BPS状态
 * @author wuwang
 *
 */
public enum BpsStatus {
	
	/**
	 * 顺丰BPS状态
	  1-未发送
	  2-发送成功
	  3-发送失败
	 */
	
	un_send(1,"未发送"),
	su_send(2,"发送成功"),
	fail_send(3,"发送失败");
	Integer code;
	String desc;
	
	private BpsStatus(Integer code, String desc) {
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
	
	public static BpsStatus getByCode(Integer code){
		if(code != null){
			for(BpsStatus s : values()){
				if(s.getCode() == code){
					return s;
				}
			}
		}
		return null;
	}
}
