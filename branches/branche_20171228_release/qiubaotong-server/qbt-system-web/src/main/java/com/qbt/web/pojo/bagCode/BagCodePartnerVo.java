package com.qbt.web.pojo.bagCode;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.qbt.common.util.DateUtil;

public class BagCodePartnerVo {
	
	private int id;
	
	private Date createTime;
	
	private Date updateTime;
	
	@NotNull(message = "合作方名称不能为空")
    private String name;
	
	@NotNull(message = "包包码不能为空")
    private String bagCode;
	
	@NotNull(message = "合作开始日期不能为空")
    private Date startDate;
	
	@NotNull(message = "合作结束日期不能为空")
    private Date endDate;
	
	@NotNull(message = "券活动id不能为空")
    private Integer activityId;

    private String activityName;
    
    @NotNull(message = "寄件人和收件人一致不能为空")
    private Boolean sameInfo;
    
    @NotNull(message = "寄件人信息随意不能为空")
    private Boolean senderRandom;
    //状态 1-可用 2-禁用
    private Integer status;

    private Integer operatorId;

    private String operatorName;
    
    private String contact;
    
    private String mobile;
    
    private String remark;
    
    private String startDateStr;
    
    private String endDateStr;

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

	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
		setStartDateStr(DateUtil.formatDate(startDate));
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		setEndDateStr(DateUtil.formatDate(endDate));
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Boolean getSameInfo() {
		return sameInfo;
	}

	public void setSameInfo(Boolean sameInfo) {
		this.sameInfo = sameInfo;
	}

	public Boolean getSenderRandom() {
		return senderRandom;
	}

	public void setSenderRandom(Boolean senderRandom) {
		this.senderRandom = senderRandom;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

}