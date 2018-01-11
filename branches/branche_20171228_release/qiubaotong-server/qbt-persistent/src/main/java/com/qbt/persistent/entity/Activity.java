package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class Activity extends BaseEntity {
	
    private String name;//活动名称

    private String code;//暗码，唯一索引(暗号为4-6位的英文字母和数字组合)

    private String desc;//活动描述

    private Integer maxPerOne;//个人领取次数

    private Date startTime;//活动开始时间

    private Date endTime;//活动结束时间

    private Integer status;//状态：1-正常，2-禁用
    
    private Integer ruleId; // 规则ID
    
    private String ruleName; // 规则name
    
    private Integer type; //活动类型 1-限量现金券活动 2-不限量现金券活动
    
    private Double couponAmount; //券优惠金额
    
    private Double couponLimitAmount; //券限额金额
    
    private Integer couponLimitDay; //券限制天数

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getMaxPerOne() {
        return maxPerOne;
    }

    public void setMaxPerOne(Integer maxPerOne) {
        this.maxPerOne = maxPerOne;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(Double couponAmount) {
		this.couponAmount = couponAmount;
	}

	public Double getCouponLimitAmount() {
		return couponLimitAmount;
	}

	public void setCouponLimitAmount(Double couponLimitAmount) {
		this.couponLimitAmount = couponLimitAmount;
	}

	public Integer getCouponLimitDay() {
		return couponLimitDay;
	}

	public void setCouponLimitDay(Integer couponLimitDay) {
		this.couponLimitDay = couponLimitDay;
	}

}