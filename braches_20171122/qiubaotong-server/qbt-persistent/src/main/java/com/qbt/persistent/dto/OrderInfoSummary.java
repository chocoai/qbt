package com.qbt.persistent.dto;

import com.qbt.persistent.entity.OrderInfo;

public class OrderInfoSummary extends OrderInfo {
	
	private Integer validOrder;
	
	private Integer cancelOrder;
	
	private Integer normalOrder;
	
	private Integer deleteOrder;

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

	public Integer getNormalOrder() {
		return normalOrder;
	}

	public void setNormalOrder(Integer normalOrder) {
		this.normalOrder = normalOrder;
	}

	public Integer getDeleteOrder() {
		return deleteOrder;
	}

	public void setDeleteOrder(Integer deleteOrder) {
		this.deleteOrder = deleteOrder;
	}
	
}
