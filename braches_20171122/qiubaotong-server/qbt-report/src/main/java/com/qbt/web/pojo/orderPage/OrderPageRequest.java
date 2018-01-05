package com.qbt.web.pojo.orderPage;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

public class OrderPageRequest extends Paging{

	//预约取件开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date begSendTime;
	
	//预约取件结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endSendTime;
	
	//预计到达开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliverStartTime;
	
	//预计到达结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliverEndTime;
	
	//物流状态： 1-尚未下单至顺丰 2-待上门收件 3-顺丰已取件 4-顺丰已取件(客服确认) 5-物流运输中 6-派送中 7-已签收
	private Integer deliveryStatus;
	
	//订单状态： 1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 6-订单关闭-系统关单 7-订单关闭-客服取消
	private Integer orderStatus;
	
	//1-course球场，2-airport机场,3-bank银行,4-address个人地址
	//取包是球场(1:是，0：否)
	private Integer jAddrType;
	
	//收件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	//送包是球场(1:是，0：否)
	private Integer dAddrType;
	
	//取包同地址(1:是，0：否)
	private Integer jBagIsSameAdree;
	
	//送包同地址(1:是，0：否)
	private Integer dBagIsSameAdree;
	
	//物流渠道筛选
	private Integer mailChannel;
	
	//保价渠道
	private String insuredChannel;
	
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

	public Integer getjAddrType() {
		return jAddrType;
	}

	public void setjAddrType(Integer jAddrType) {
		this.jAddrType = jAddrType;
	}

	public Integer getdAddrType() {
		return dAddrType;
	}

	public void setdAddrType(Integer dAddrType) {
		this.dAddrType = dAddrType;
	}

	public String getInsuredChannel() {
		return insuredChannel;
	}

	public void setInsuredChannel(String insuredChannel) {
		this.insuredChannel = insuredChannel;
	}
	
}
