package com.qbt.common.enums;

public enum CouponTypeEnum {
	
	cash_coupon(1, "现金券"),
	discount_coupon(2, "折扣券"),
	special_coupon(3, "特价券"),
	;
	
	private Integer type;
	
	private String desc;
	
	private CouponTypeEnum(Integer type, String desc){
		this.type = type;
		this.desc = desc;
	}

	public Integer getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
	
	public static CouponTypeEnum getByType(Integer type){
		if(type != null){
			for(CouponTypeEnum c : values()){
				if(c.getType() == type){
					return c;
				}
			}
		}
		return null;
	}
}
