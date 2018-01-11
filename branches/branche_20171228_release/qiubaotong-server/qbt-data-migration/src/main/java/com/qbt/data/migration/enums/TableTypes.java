package com.qbt.data.migration.enums;

public enum TableTypes {


	User_Weixin(1, "微信用户"),
	base_brand(2, "球包牌"),
	user_contact(3, "联系人"),
	sf_price(4, "顺丰价格"),
	user_address(5, "用户地址"),
	activity(48, "活动"),
	coupon(49, "券码"),
	order(50, "订单"),
	User_Assistant(20,"助理用户"),
	User_Assistant_Apply(21,"助理申请"),
	User_Assistant_Fee(22,"助理申请"),
	User_Kf(23,"客服"),
	User_Sf_Kf(24,"顺丰客服"),
	User_Kf_Time_Range(25,"客服顺丰服务时间"),
	;
	
	private Integer type;
	
	private String desc;
	
	private TableTypes(Integer type, String desc){
		this.type = type;
		this.desc = desc;
	}

	public Integer getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
	
	public static TableTypes getByType(Integer type){
		if(type != null){
			for(TableTypes c : values()){
				if(c.getType() == type){
					return c;
				}
			}
		}
		return null;
	}
	
}
