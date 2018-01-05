package com.qbt.web.pojo.activityRule;

import com.qbt.common.result.Paging;

public class ActivityRulePageReqVo extends Paging {
	
	// 规则名称
	private String name;

	// 规则描述
	private String memo;

	// 状态 1-正常 2-无效
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
