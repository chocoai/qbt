package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrderInfo;

public class ReportOrderPage extends OrderInfo {

	//取件起始时间
	private Date begSendTime;
	
	//取件结束时间
	private Date endSendTime;
	
	//预计到达开始时间
	private Date deliverStartTime;
	
	//预计到达结束时间
	private Date deliverEndTime;
	
	//物流状态： 1-尚未下单至顺丰 2-待上门收件 3-顺丰已取件 4-顺丰已取件(客服确认) 5-物流运输中 6-派送中 7-已签收
	private Integer deliveryStatus;
	
	//订单状态： 1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 6-订单关闭-系统关单 7-订单关闭-客服取消
	private Integer orderStatus;
	
	//取包是球场(1:是，0：否)
	private Integer jBagIsCourse;
	
	//送包是球场(1:是，0：否)
	private Integer dBagIsCourse;
	
	//取包同地址(1:是，0：否)
	private Integer jBagIsSameAdree;
	
	//送包同地址(1:是，0：否)
	private Integer dBagIsSameAdree;
	
	//物流渠道筛选
	private Integer mailChannel;

	public Date getBegSendTime() {
		return begSendTime;
	}

	public void setBegSendTime(Date begSendTime) {
		this.begSendTime = begSendTime;
	}

	public Date getEndSendTime() {
		return endSendTime;
	}

	public void setEndSendTime(Date endSendTime) {
		this.endSendTime = endSendTime;
	}

	public Date getDeliverStartTime() {
		return deliverStartTime;
	}

	public void setDeliverStartTime(Date deliverStartTime) {
		this.deliverStartTime = deliverStartTime;
	}

	public Date getDeliverEndTime() {
		return deliverEndTime;
	}

	public void setDeliverEndTime(Date deliverEndTime) {
		this.deliverEndTime = deliverEndTime;
	}

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getjBagIsCourse() {
		return jBagIsCourse;
	}

	public void setjBagIsCourse(Integer jBagIsCourse) {
		this.jBagIsCourse = jBagIsCourse;
	}

	public Integer getdBagIsCourse() {
		return dBagIsCourse;
	}

	public void setdBagIsCourse(Integer dBagIsCourse) {
		this.dBagIsCourse = dBagIsCourse;
	}

	public Integer getjBagIsSameAdree() {
		return jBagIsSameAdree;
	}

	public void setjBagIsSameAdree(Integer jBagIsSameAdree) {
		this.jBagIsSameAdree = jBagIsSameAdree;
	}

	public Integer getdBagIsSameAdree() {
		return dBagIsSameAdree;
	}

	public void setdBagIsSameAdree(Integer dBagIsSameAdree) {
		this.dBagIsSameAdree = dBagIsSameAdree;
	}

	public Integer getMailChannel() {
		return mailChannel;
	}

	public void setMailChannel(Integer mailChannel) {
		this.mailChannel = mailChannel;
	}

}
