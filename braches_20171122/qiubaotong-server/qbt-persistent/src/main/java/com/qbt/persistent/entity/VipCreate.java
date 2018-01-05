package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class VipCreate extends BaseEntity {
	
    private String name;

    private Integer number;

    private Date endTime;

    private Integer vipTypeId;

    private String vipTypeName;

    private Double vipTypeAmount;

    private Integer vipTypeValidDay;

    private Integer optUserId;

    private String optUserName;
    
    private Date createDate;
    
    //=================查询字段=====================
    private String vipNo;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getVipTypeId() {
        return vipTypeId;
    }

    public void setVipTypeId(Integer vipTypeId) {
        this.vipTypeId = vipTypeId;
    }

    public String getVipTypeName() {
        return vipTypeName;
    }

    public void setVipTypeName(String vipTypeName) {
        this.vipTypeName = vipTypeName == null ? null : vipTypeName.trim();
    }

    public Double getVipTypeAmount() {
		return vipTypeAmount;
	}

	public void setVipTypeAmount(Double vipTypeAmount) {
		this.vipTypeAmount = vipTypeAmount;
	}

	public Integer getVipTypeValidDay() {
        return vipTypeValidDay;
    }

    public void setVipTypeValidDay(Integer vipTypeValidDay) {
        this.vipTypeValidDay = vipTypeValidDay;
    }

    public Integer getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(Integer optUserId) {
        this.optUserId = optUserId;
    }

    public String getOptUserName() {
        return optUserName;
    }

    public void setOptUserName(String optUserName) {
        this.optUserName = optUserName == null ? null : optUserName.trim();
    }

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getVipNo() {
		return vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}
    
}