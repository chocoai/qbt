package com.qbt.web.pojo.payment;

import java.util.Date;

import com.qbt.common.result.Paging;

public class PaymentPageReqVo extends Paging {
	
	// 开始时间
	private Date startDate;
	
	// 结束时间
	private Date endDate;
	
	//支付流水号
	private String uuid;
	
	// 订单编号
	private String orderNumber;
	
	// 支付方式 1-微信支付 98-合作方下单免支付 99-现金券满额支付
	private Integer payMethod;
	
	// 支付状态 1-预支付 2-支付成功 3-支付失败 4-异常
    private Integer status;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
