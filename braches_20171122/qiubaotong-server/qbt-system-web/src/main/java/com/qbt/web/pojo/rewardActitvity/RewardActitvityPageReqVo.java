package com.qbt.web.pojo.rewardActitvity;

import java.util.Date;

import com.qbt.common.result.Paging;

public class RewardActitvityPageReqVo extends Paging{
	private String actitvityName;
	private Integer actitvityType;
	private Integer rewardType;
	private Date startDate;
	private Date endDate;
	public String getActitvityName() {
		return actitvityName;
	}
	public void setActitvityName(String actitvityName) {
		this.actitvityName = actitvityName;
	}
	public Integer getActitvityType() {
		return actitvityType;
	}
	public void setActitvityType(Integer actitvityType) {
		this.actitvityType = actitvityType;
	}
	public Integer getRewardType() {
		return rewardType;
	}
	public void setRewardType(Integer rewardType) {
		this.rewardType = rewardType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
