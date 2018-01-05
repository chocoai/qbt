package com.qbt.web.pojo.saleOrderInfo;

import java.util.Date;

public class SaleOrderInfoVo {
	
	//订单号
	private String number;
	
	//下单时间
	private Date createTime;
	
    //订单金额
    private Double orderAmount;

    //提成金额
    private Double amount;
    
    //订单状态（1-有效（已签收） 2-待生效 3-无效（2，3未签收））
    private Integer status;

    //结算（1-未结算 2-已结算）
    private Integer settleStatus;

    //结算时间
    private Date settleTime;

    //结算人
    private String sysUserName;

    //结算方式（支付方式 1-微信 3-支付宝 4-汇款 5-现金）
    private Integer settleMethod;

    //备注
    private String remark;
    
    //订单id
    private Integer orderId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSettleStatus() {
		return settleStatus;
	}

	public void setSettleStatus(Integer settleStatus) {
		this.settleStatus = settleStatus;
	}

	public Date getSettleTime() {
		return settleTime;
	}

	public void setSettleTime(Date settleTime) {
		this.settleTime = settleTime;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public Integer getSettleMethod() {
		return settleMethod;
	}

	public void setSettleMethod(Integer settleMethod) {
		this.settleMethod = settleMethod;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
    
}
