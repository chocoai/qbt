package com.qbt.web.pojo.ticketPackageActivity;

import java.util.Date;

import com.qbt.web.pojo.ticketPackageRule.TicketPackageRuleVo;

public class TicketPackageActivityVo {

	//Activity id
	private int id;
	
	//規則Id
	private int ruleId;
	
	//活動名稱
	private String activityName;
	
	//有效天數
	private int effectiveDay;
	
	//創建時間
	private Date creatTime;	
	
	//狀態 1 - active；2- inactive
	private int status;
	
	//活動描述
	private String description;
	
	//活动对应的规则
	private TicketPackageRuleVo ticketPackageRule;
	
	public TicketPackageRuleVo getTicketPackageRule() {
		return ticketPackageRule;
	}
	public void setTicketPackageRule(TicketPackageRuleVo ticketPackageRule) {
		this.ticketPackageRule = ticketPackageRule;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getEffectiveDay() {
		return effectiveDay;
	}
	public void setEffectiveDay(int effectiveDay) {
		this.effectiveDay = effectiveDay;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
