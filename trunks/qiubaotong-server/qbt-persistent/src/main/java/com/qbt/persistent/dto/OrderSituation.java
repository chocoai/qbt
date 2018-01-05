package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrderInfo;

public class OrderSituation extends OrderInfo {

	private Date date;
	
	private int total;
	
	private int effectiveOrder;
	
	private int waitPay;
	
	private int destroyOrder;
	
	private int cancelOrder;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getEffectiveOrder() {
		return effectiveOrder;
	}

	public void setEffectiveOrder(int effectiveOrder) {
		this.effectiveOrder = effectiveOrder;
	}

	public int getWaitPay() {
		return waitPay;
	}

	public void setWaitPay(int waitPay) {
		this.waitPay = waitPay;
	}

	public int getDestroyOrder() {
		return destroyOrder;
	}

	public void setDestroyOrder(int destroyOrder) {
		this.destroyOrder = destroyOrder;
	}

	public int getCancelOrder() {
		return cancelOrder;
	}

	public void setCancelOrder(int cancelOrder) {
		this.cancelOrder = cancelOrder;
	}
	
}
