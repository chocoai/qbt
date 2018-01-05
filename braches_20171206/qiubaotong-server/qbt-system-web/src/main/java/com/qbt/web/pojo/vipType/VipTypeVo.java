package com.qbt.web.pojo.vipType;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class VipTypeVo {

    private int id;
    
    private Date createTime;
    
    private Date updateTime;
    
    @NotNull(message = "名称不能为空")
    private String name;
    
    private BigDecimal amount;
    
    private BigDecimal orderAmount;
    
    private String validDesc;
    
    private Integer valid;
    
    private Integer status;
    
    private String rules;

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
		this.validDesc = validDesc;
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
