package com.qbt.web.pojo.activityRule;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ActivityRuleVo {
	
	//id
	private int id;
	
	//创建时间
	private Date createTime;
	
	//更新时间
	private Date updateTime;
	
	// 规则名称
	@NotNull(message = "规则名称不能为空")
	@Size(min = 1, message = "规则名称不能为空")
	private String name;

	// 规则描述
	@NotNull(message = "规则描述不能为空")
	private String memo;

	// 规则总金额
	private double amount;

	// 状态 1-正常 2-无效
	@NotNull(message = "状态不能为空")
	private Integer status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
