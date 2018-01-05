package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class CouponCodeActivity extends BaseEntity {

    private String name;

    private Date startTime;

    private Date endTime;

    private String code;

    private Integer count;

    private Integer useCount;

    private Double ruleFull;

    private Double ruleReduce;

    private Integer ruleType;

    private Integer status;

    private String remark;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
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
        this.remark = remark == null ? null : remark.trim();
    }

	public Double getRuleFull() {
		return ruleFull;
	}

	public void setRuleFull(Double ruleFull) {
		this.ruleFull = ruleFull;
	}

	public Double getRuleReduce() {
		return ruleReduce;
	}

	public void setRuleReduce(Double ruleReduce) {
		this.ruleReduce = ruleReduce;
	}
}