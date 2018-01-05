package com.qbt.web.pojo.reminder;

import com.qbt.common.result.Paging;

public class ReminderPageReqVo extends Paging {
	
	private String name;//提示名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
