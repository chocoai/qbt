package com.qbt.persistent.dto;

import com.qbt.persistent.entity.OrderInfo;

public class ReportSiteOrder extends OrderInfo {
	
	private Integer totalOrder;
	
	private Integer validOrder;
	
	private Integer cancelOrder;
	
	private Double validAmount;
	
	private Double cancelAmount;

	public Integer getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(Integer totalOrder) {
		this.totalOrder = totalOrder;
	}

	public Integer getValidOrder() {
		return validOrder;
	}

	public void setValidOrder(Integer validOrder) {
		this.validOrder = validOrder;
	}

	public Integer getCancelOrder() {
		return cancelOrder;
	}

	public void setCancelOrder(Integer cancelOrder) {
		this.cancelOrder = cancelOrder;
	}

	public Double getValidAmount() {
		return validAmount;
	}

	public void setValidAmount(Double validAmount) {
		this.validAmount = validAmount;
	}

	public Double getCancelAmount() {
		return cancelAmount;
	}

	public void setCancelAmount(Double cancelAmount) {
		this.cancelAmount = cancelAmount;
	}
	
}
