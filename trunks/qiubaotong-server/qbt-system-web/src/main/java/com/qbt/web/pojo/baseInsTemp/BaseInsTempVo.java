package com.qbt.web.pojo.baseInsTemp;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class BaseInsTempVo {
	
	private int id;
	
	@NotNull(message = "名称不能为空")
	private String name;
	
	@NotNull(message = "保价费率不能为空")
    private BigDecimal insuredRates;
	
	@NotNull(message = "免费保价金额不能为空")
    private BigDecimal freeInsured;
	
	@NotNull(message = "最小保价金额不能为空")
    private BigDecimal insuredMinimum;
	
	@NotNull(message = "最大保价金额不能为空")
    private BigDecimal insuredMaximum;
    
    private String descInsuredMinimum;
    
    private String descInsuredMaximum;
    
    @NotNull(message = "状态不能为空")
    private Integer state;
    
    private String remark;
    
    //原保价费率
    @NotNull(message = "原保价费率不能为空")
    private Double insuredOriginRates;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.descInsuredMinimum = descInsuredMinimum;
	}

	public String getDescInsuredMaximum() {
		return descInsuredMaximum;
	}

	public void setDescInsuredMaximum(String descInsuredMaximum) {
		this.descInsuredMaximum = descInsuredMaximum;
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
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getInsuredOriginRates() {
		return insuredOriginRates;
	}

	public void setInsuredOriginRates(Double insuredOriginRates) {
		this.insuredOriginRates = insuredOriginRates;
	}
}
