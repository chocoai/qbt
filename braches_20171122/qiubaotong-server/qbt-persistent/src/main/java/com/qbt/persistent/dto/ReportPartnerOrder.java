package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrderInfo;

public class ReportPartnerOrder extends OrderInfo {

	// 用户名
	private String userName;

	// 支付号
	private String uuid;

	// 券面额
	private Double childAmount;

	// 结算金额
	private Double settleAmount;
	
	// 分润金额
	private Double settleFee;

	// 1-总金额比例模式，2-按单比例，3-按单固定返利
	private Integer settleModel;

	// settle_mode为1模式时为0
	private Double settleModeValue;

	// 1-未结算 2-已结算 3-无效结算记录
	private Integer settleState;

	// 结算时间
	private Date settleTime;
	
	// 结算备注
	private String settleRemark;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Double getChildAmount() {
		return childAmount;
	}

	public void setChildAmount(Double childAmount) {
		this.childAmount = childAmount;
	}

	public Double getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(Double settleAmount) {
		this.settleAmount = settleAmount;
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

	public Date getSettleTime() {
		return settleTime;
	}

	public void setSettleTime(Date settleTime) {
		this.settleTime = settleTime;
	}

	public String getSettleRemark() {
		return settleRemark;
	}

	public void setSettleRemark(String settleRemark) {
		this.settleRemark = settleRemark;
	}

	public Double getSettleFee() {
		return settleFee;
	}

	public void setSettleFee(Double settleFee) {
		this.settleFee = settleFee;
	}

}
