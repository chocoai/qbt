package com.qbt.web.pojo.bagCode;

import java.util.Date;

public class BagCodeUserVo {
	
	private int id;
	
	private Date createTime;
	
	private Date updateTime;
	
    private Integer bagCodePartnerId;

    private String bagCodePartnerName;

    private String bagCode;

    private Integer userId;

    private String nickname;

    private String name;

    private String mobile;

    private Integer activityId;

    private String activityName;

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

	public Integer getBagCodePartnerId() {
		return bagCodePartnerId;
	}

	public void setBagCodePartnerId(Integer bagCodePartnerId) {
		this.bagCodePartnerId = bagCodePartnerId;
	}

	public String getBagCodePartnerName() {
		return bagCodePartnerName;
	}

	public void setBagCodePartnerName(String bagCodePartnerName) {
		this.bagCodePartnerName = bagCodePartnerName;
	}

	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

}