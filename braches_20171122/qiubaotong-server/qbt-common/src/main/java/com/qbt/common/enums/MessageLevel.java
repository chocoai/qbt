package com.qbt.common.enums;

/**
 * 消息级别
  * @ClassName: MessageLevel
  * @Description: TODO
  * @author chenxiaocong 2016年10月28日
  * @modify chenxiaocong 2016年10月28日
 */
public enum MessageLevel {

	M_113079("113079","PAYMENT")
	;
	
//	PAYMENT 支付级别, REMINDER 提醒, VERIFICATION 验证码;
	
	String code;
	String desc;

	private MessageLevel(String code,String desc) { 
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

	public static String getByCode(String code){
		if(code != null){
			for(MessageLevel s : values()){
				if(s.getCode().equals(code)){
					return s.getDesc();
				}
			}
		}
		return null;//走短信服务器默认级别
	}
}
