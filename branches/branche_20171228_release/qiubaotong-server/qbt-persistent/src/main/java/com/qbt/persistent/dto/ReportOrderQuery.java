package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrderInfo;

public class ReportOrderQuery extends OrderInfo {
	
	private Date startDate;
	
	private Date endDate;
	
	//是否优惠
	private Boolean isFavored;
	
	//1-未结算  2-已结算 3-无效结算记录
	private Integer settleState;
	
	//预约取件开始时间
	private Date sendSfStartTime;
	
	//预约取件结束时间
	private Date sendSfEndTime;
	
	//偏远类型 0-非偏远 1-球场 4-地区
	private Integer outRangeType;
	
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

	public Boolean getIsFavored() {
		return isFavored;
	}

	public void setIsFavored(Boolean isFavored) {
		this.isFavored = isFavored;
	}

	public Integer getSettleState() {
		return settleState;
	}

	public void setSettleState(Integer settleState) {
		this.settleState = settleState;
	}

	public Date getSendSfStartTime() {
		return sendSfStartTime;
	}

	public void setSendSfStartTime(Date sendSfStartTime) {
		this.sendSfStartTime = sendSfStartTime;
	}

	public Date getSendSfEndTime() {
		return sendSfEndTime;
	}

	public void setSendSfEndTime(Date sendSfEndTime) {
		this.sendSfEndTime = sendSfEndTime;
	}

	public Integer getOutRangeType() {
		return outRangeType;
	}

	public void setOutRangeType(Integer outRangeType) {
		this.outRangeType = outRangeType;
	}

}
