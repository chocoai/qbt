package com.qbt.web.pojo.rewardActitvity;

import java.util.Date;

import javax.validation.constraints.NotNull;


public class RewardActitvityVo {
	private int id;
	private Date createTime;//创建时间
    private Date updateTime;//创建时间
    @NotNull(message = "活动名称不能为空") 
	private String actitvityName;
	@NotNull(message = "活动开始时间不能为空")
	private Date startDate;
	@NotNull(message = "活动结束时间不能为空")
	private Date endDate;
	@NotNull(message = "活动类型不能为空") 
	private Integer actitvityType;
	@NotNull(message = "奖励类型不能为空") 
	private Integer rewardType;
	@NotNull(message = "中将几率不能为空") 
	private Integer probability ;
	@NotNull(message = "奖励内容不能为空")
	private String	prize;
	@NotNull(message = "活动状态不能为空")
	private Integer status;
	private String remark;
	private Integer operator;
	private String sd;
	private String ed;
	private String prizeName;
	private String prizeType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getActitvityName() {
		return actitvityName;
	}
	public void setActitvityName(String actitvityName) {
		this.actitvityName = actitvityName;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public String getEd() {
		return ed;
	}
	public void setEd(String ed) {
		this.ed = ed;
	}
	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public String getPrizeType() {
		return prizeType;
	}
	public void setPrizeType(String prizeType) {
		this.prizeType = prizeType;
	}
	
}
