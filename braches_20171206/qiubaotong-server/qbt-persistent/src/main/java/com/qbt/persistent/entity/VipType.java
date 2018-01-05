package com.qbt.persistent.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class VipType extends BaseEntity {
   
    //会员卡名称 	
    private String name;
    //会员卡购买金额
    private BigDecimal amount;
    //下单金额
    private BigDecimal orderAmount;
    //有效期描述
    private String validDesc;
    //有效期，单位天
    private Integer valid;
    //1-正常 2-禁用
    private Integer status;
    //细则
    private String rules;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getValidDesc() {
        return validDesc;
    }

    public void setValidDesc(String validDesc) {
        this.validDesc = validDesc == null ? null : validDesc.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}
}