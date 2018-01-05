package com.qbt.common.enums;

public enum ExceptionTypeEnum {

	
	/**
	 * 任务类型：
	 * 1:需对订单状态检查;
	 * 2:订单状态在一定时间内没有变化;
	 * 3:下单失败的;
	 * 4:派送失败;
	 * 5:球场端收件异常;
	 * 6:快件已退回/转寄;
	 */
	check_status(1,"需对订单状态检查"),
	on_change_status(2,"订单状态在一定时间内没有变化"),
	order_fail(3,"下单失败的"),
	sf_send_fail(4,"派送失败"),
	course_recive_fail(5,"球场端收件异常"),
	sf_express_return(6,"快件已退回/转寄"),
	sf_express_return2(7,"快件已退回/转寄"),
	;
	
	
	Integer code;
	String desc;

	private ExceptionTypeEnum(Integer code,String desc) { 
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
	
	public static ExceptionTypeEnum getByType(Integer type){
		if(type != null){
			for(ExceptionTypeEnum e : values()){
				if(e.getCode() == type){
					return e;
				}
			}
		}
		return null;
	}
	
}
