package com.qbt.web.pojo.thirdOrder;

import java.util.Date;

import com.qbt.common.result.Paging;

public class ThirdOrderPageReqVo extends Paging {

	// 支付起始时间
	private Date startDate;

	// 支付结束时间
	private Date endDate;

	// 订单编号
	private String orderNumber;
	
	//订单状态： 1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 6-订单关闭-系统关单 7-订单关闭-客服取消
	private Integer orderStatus;

	// 1-总金额比例模式，2-按单比例，3-按单固定返利
	private Integer settleModel;

	// 1-未结算 2-已结算 3-无效结算记录
	private Integer settleState;

	// 用户微信昵称
	private String userName;

	// 合作方ID
	private Integer thirdId;

	// 备注
	private String remark;

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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getSettleModel() {
		return settleModel;
	}

	public void setSettleModel(Integer settleModel) {
		this.settleModel = settleModel;
	}

	public Integer getSettleState() {
		return settleState;
	}

	public void setSettleState(Integer settleState) {
		this.settleState = settleState;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
