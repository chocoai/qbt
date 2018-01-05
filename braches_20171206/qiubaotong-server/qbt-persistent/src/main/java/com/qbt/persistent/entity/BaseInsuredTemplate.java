package com.qbt.persistent.entity;

import java.math.BigDecimal;

import com.qbt.common.entity.BaseEntity;

/**
 *  保价模板
 * @author share
 *
 */
public class BaseInsuredTemplate extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

    private BigDecimal insuredRates;

    private BigDecimal freeInsured;

    private BigDecimal insuredMinimum;

    private BigDecimal insuredMaximum;

    private String descInsuredMinimum;

    private String descInsuredMaximum;

    private Integer state;
    
    private String remark;
    
    private Double insuredOriginRates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getInsuredRates() {
        return insuredRates;
    }

    public void setInsuredRates(BigDecimal insuredRates) {
        this.insuredRates = insuredRates;
    }

    public BigDecimal getFreeInsured() {
        return freeInsured;
    }

    public void setFreeInsured(BigDecimal freeInsured) {
        this.freeInsured = freeInsured;
    }

    public BigDecimal getInsuredMinimum() {
        return insuredMinimum;
    }

    public void setInsuredMinimum(BigDecimal insuredMinimum) {
        this.insuredMinimum = insuredMinimum;
    }

    public BigDecimal getInsuredMaximum() {
        return insuredMaximum;
    }

    public void setInsuredMaximum(BigDecimal insuredMaximum) {
        this.insuredMaximum = insuredMaximum;
    }

    public String getDescInsuredMinimum() {
        return descInsuredMinimum;
    }

    public void setDescInsuredMinimum(String descInsuredMinimum) {
        this.descInsuredMinimum = descInsuredMinimum == null ? null : descInsuredMinimum.trim();
    }

    public String getDescInsuredMaximum() {
        return descInsuredMaximum;
    }

    public void setDescInsuredMaximum(String descInsuredMaximum) {
        this.descInsuredMaximum = descInsuredMaximum == null ? null : descInsuredMaximum.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Double getInsuredOriginRates() {
		return insuredOriginRates;
	}

	public void setInsuredOriginRates(Double insuredOriginRates) {
		this.insuredOriginRates = insuredOriginRates;
	}
}