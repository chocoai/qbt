package com.qbt.common.enums;

public enum ExpressTypeEnum {
	
	tormorow("1", "明日达"),
	after_tomorow("2", "隔日达"),
	tormorow_noon("5", "明晨达"),
	;
	
	private String type;
	
	private String desc;
	
	private ExpressTypeEnum(String type, String desc){
		this.type = type;
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
	
	public static ExpressTypeEnum getByType(String type){
		
		// 加急3等于快件1
		if("3".equals(type)) {
			type = "1";
		}
		
		if(type != null){
			for(ExpressTypeEnum e : values()){
				if(e.getType().equals(type)){
					return e;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return getDesc();
	}
	
}
