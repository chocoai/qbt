package com.qbt.common.enums;

public enum ActivityOffPriority {
	
	first_cut(10, "首单满减"),
	area_cut(20, "地域满减"),
	course_cut(30, "球场满减"),
	first_gift(40, "首单满赠"),
	area_gift(50, "地域满赠"),
	course_gift(60, "球场满赠"),
	all_cut(70, "全员满减"),
	all_gift(80, "全员满赠"),
	personal_cash(90, "个人现金券"),
	point(100, "下单积分"),
	;
	
	private Integer priority;
	
	private String desc;
	
	private ActivityOffPriority(Integer priority, String desc){
		this.priority = priority;
		this.desc = desc;
	}

	public Integer getPriority() {
		return priority;
	}

	public String getDesc() {
		return desc;
	}

	public static ActivityOffPriority getByPriority(Integer priority){
		if(priority != null){
			for(ActivityOffPriority p : values()){
				if(p.getPriority() == priority){
					return p;
				}
			}
		}
		return null;
	}
	
}
