package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class RewardActitvity extends BaseEntity {

	private Date startDate;
	private Date endDate;
	private String actitvityName;
	private Integer actitvityType;
	private Integer rewardType;
	private Integer probability ;
	private String	prize;
	private Integer status;
	private String remark;
	private Integer operator;
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
	public Integer getProbability() {
		return probability;
	}
	public void setProbability(Integer probability) {
		this.probability = probability;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	public String getActitvityName() {
		return actitvityName;
	}
	public void setActitvityName(String actitvityName) {
		this.actitvityName = actitvityName;
	}
	

	
	
	
	
}
