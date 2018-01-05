package com.qbt.common.enums;

public enum AssistantApplyType {
	
	course_offical(1, "球场官方工作人员"),
	course_private(2, "球场私人工作人员"),
	bank_branch(3, "银行站点工作人员"),
	sf_site(4, "顺丰站点工作人员"),
	airport(5, "顺丰机场工作人员"),
	offical(6, "官方球包助理"),
	normal(7, "普通球包助理"),
	partner(8, "旅行合作社"),
	;
	
	private Integer type;
	
	private String desc;
	
	private AssistantApplyType(Integer type, String desc){
		this.type = type;
		this.desc = desc;
	}

	public Integer getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	public static AssistantApplyType getByType(Integer type){
		if(type != null){
			for(AssistantApplyType t : values()){
				if(t.getType() == type){
					return t;
				}
			}
		}
		return null;
	}
	
}
