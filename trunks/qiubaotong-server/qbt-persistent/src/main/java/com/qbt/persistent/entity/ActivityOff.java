package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class ActivityOff extends BaseEntity {
	
	//规则名称
	private String name;
	
	//规则描述
	private String memo;
	
	//开始时间
	private Date startTime;
	
	//结束时间
	private Date endTime;
	
	//1-首单满减 2-全员满减 3-球场满减 4-地域满减
	private Integer type;
	
	//范围：1-球场 2-地区
	private Integer scope;
	
	/*
	 * 匹配权重级别：
	 * 首单满减10
	 * 地域满减20
	 * 球场满减30
	 * 首单满赠40
	 * 地域满赠50
	 * 球场满赠60
	 * 全员满减70
	 * 全员满赠80
	 * 个人现金券90
	 * 下单积分100
	 */
	private Integer priority;
	
	//1-正常 2-无效
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getScope() {
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
