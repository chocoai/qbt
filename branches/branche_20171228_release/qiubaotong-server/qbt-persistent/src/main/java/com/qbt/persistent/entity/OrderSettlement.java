package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class OrderSettlement extends BaseEntity {
	
	//订单ID
	private Integer orderId;
	
	//订单总金额
	private Double orderTotalAmount;
	
	//订单优惠金额
	private Double orderDicount;
	
	//订单支付金额
	private Double orderAmount;
	
	//结算金额
	private Double settleAmount;
	
	//分润金额
	private Double settleFee;
	
	//1-总金额比例模式，2-按单比例，3-按单固定返利
	private Integer settleModel;
	
	//settle_mode为1模式时为0
	private Double settleModeValue;
	
	//1-未结算  2-已结算 3-无效结算记录
	private Integer settleState;
	
	//微信用户ID
	private Integer userId;
	
	//用户微信昵称
	private String userName;
	
	//合作方ID
	private Integer thirdId;
	
	//合作方名称
	private String thirdName;
	
	//结算时间
	private Date settleTime;
	
	//结算人员ID
	private Integer sysUserId;
	
	//结算人名称
	private String sysUserName;
	
	//备注
	private String remark;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(Double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public Double getOrderDicount() {
		return orderDicount;
	}

	public void setOrderDicount(Double orderDicount) {
		this.orderDicount = orderDicount;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(Double settleAmount) {
		this.settleAmount = settleAmount;
	}

	public Double getSettleFee() {
		return settleFee;
	}

	public void setSettleFee(Double settleFee) {
		this.settleFee = settleFee;
	}

	public Integer getSettleModel() {
		return settleModel;
	}

	public void setSettleModel(Integer settleModel) {
		this.settleModel = settleModel;
	}

	public Double getSettleModeValue() {
		return settleModeValue;
	}

	public void setSettleModeValue(Double settleModeValue) {
		this.settleModeValue = settleModeValue;
	}

	public Integer getSettleState() {
		return settleState;
	}

	public void setSettleState(Integer settleState) {
		this.settleState = settleState;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getThirdId() {
		return thirdId;
	}

	public void setThirdId(Integer thirdId) {
		this.thirdId = thirdId;
	}

	public String getThirdName() {
		return thirdName;
	}

	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}

	public Date getSettleTime() {
		return settleTime;
	}

	public void setSettleTime(Date settleTime) {
		this.settleTime = settleTime;
	}

	public Integer getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
