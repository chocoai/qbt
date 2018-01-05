package com.qbt.web.pojo.payment;

import java.util.Date;

public class PaymentVo {
	
	// id
	private int id;
	
	// 支付流水时间
	private Date createTime;
	
	// 支付流水号
	private String uuid;
	
	// 订单Id
    private Integer orderId;
    
    // 订单编号
    private String orderNumber;
    
    // 支付方式 1-微信支付 98-合作方下单免支付 99-现金券满额支付
    private Integer payMethod;
    
    // 支付金额
    private double payAmount;
    
    // 支付状态 1-预支付 2-支付成功 3-支付失败 4-异常
    private Integer status;

    // 第三方支付号
    private String payBakNo;
    
	//订单状态： 1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 6-订单关闭-系统关单 7-订单关闭-客服取消
    private Integer orderStatus;
    
	//退款状态： 1-正常状态 2-待退款 3-退款中 4-退款完成 5-退款失败
    private Integer refundStatus;
    
    // 订单支付金额
    private Double orderAmount;

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPayBakNo() {
		return payBakNo;
	}

	public void setPayBakNo(String payBakNo) {
		this.payBakNo = payBakNo;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
}
