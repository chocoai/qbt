package com.qbt.web.pojo.order;

import java.util.Date;

import com.qbt.common.result.Paging;

public class OrderPageReqVo extends Paging {
	
	//用户id
	private Integer userId;
	
	//关键字查询：用户名(模糊) 寄件人(模糊) 收件人(模糊)
	private String keyWord;
	
	//订单状态： 1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 6-订单关闭-系统关单 7-订单关闭-客服取消
	private Integer orderStatus;
	
	//退款状态： 1-正常状态 2-待退款 3-退款中 4-退款完成 5-退款失败
	private Integer refundStatus;
	
	//物流状态： 1-尚未下单至顺丰 2-待上门收件 3-顺丰已取件 4-顺丰已取件(客服确认) 5-物流运输中 6-派送中 7-已签收
	private Integer deliveryStatus;
	
	//顺丰BPS状态 1-未发送 2-发送成功 3-发送失败
    private Integer bpsStatus;
	
	//订单编号(模糊)
	private String orderNo;
	
	//取件起始时间
	private Date begSendTime;
	
	//取件结束时间
	private Date endSendTime;
	
	//下单起始时间
	private Date begCreateTime;
	
	//下单结束时间
	private Date endCreateTime;
	
	//预计到达开始时间
	private Date deliverStartTime;
	
	//预计到达结束时间
	private Date deliverEndTime;
	
	//运单号(模糊)
	private String mailNo;
	
	//1-普通用户  2-合作旅行社
    private Integer thirdType;
    
    //地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
    private Integer addrType;
    
    //非个人地址ID，个人地址为0
    private Integer addrId;
    
    //寄收人手机号
    private String concactMobile;
    
    //偏远类型 0-非偏远 1-球场 4-地区
    private Integer outRangeType;
    
    //1-微信下单, 3-PC下单, 5-BOSS下单
    private Integer orderSource;
    
    private Integer mailChannel;
    
    //机构id
  	private Integer orgId;
  	
  	//支付开始时间
  	private Date payTimeStartTime;
  	
  	//支付结束时间
  	private Date payTimeEndTime;
  	
  	//机构名称
  	private String orgName;
  	
  	//是否群机构（1,0）
  	private Integer isOrg;
  	
  	private Integer expressType;
  	
  	private int[] ids;
  	
  	//是否加急 (0=all,1=加急,2=不加急)
  	private Integer urgentFee;
  	
  	//保价渠道
  	private String insuredChannel;
  	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

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

	public Integer getBpsStatus() {
		return bpsStatus;
	}

	public void setBpsStatus(Integer bpsStatus) {
		this.bpsStatus = bpsStatus;
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

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public Integer getThirdType() {
		return thirdType;
	}

	public void setThirdType(Integer thirdType) {
		this.thirdType = thirdType;
	}

	public Integer getAddrType() {
		return addrType;
	}

	public void setAddrType(Integer addrType) {
		this.addrType = addrType;
	}

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public String getConcactMobile() {
		return concactMobile;
	}

	public void setConcactMobile(String concactMobile) {
		this.concactMobile = concactMobile;
	}

	public Integer getOutRangeType() {
		return outRangeType;
	}

	public void setOutRangeType(Integer outRangeType) {
		this.outRangeType = outRangeType;
	}

	public Date getBegCreateTime() {
		return begCreateTime;
	}

	public void setBegCreateTime(Date begCreateTime) {
		this.begCreateTime = begCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

	public Integer getMailChannel() {
		return mailChannel;
	}

	public void setMailChannel(Integer mailChannel) {
		this.mailChannel = mailChannel;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Date getPayTimeStartTime() {
		return payTimeStartTime;
	}

	public void setPayTimeStartTime(Date payTimeStartTime) {
		this.payTimeStartTime = payTimeStartTime;
	}

	public Date getPayTimeEndTime() {
		return payTimeEndTime;
	}

	public void setPayTimeEndTime(Date payTimeEndTime) {
		this.payTimeEndTime = payTimeEndTime;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getIsOrg() {
		return isOrg;
	}

	public void setIsOrg(Integer isOrg) {
		this.isOrg = isOrg;
	}

	public Integer getExpressType() {
		return expressType;
	}

	public void setExpressType(Integer expressType) {
		this.expressType = expressType;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public String getInsuredChannel() {
		return insuredChannel;
	}

	public void setInsuredChannel(String insuredChannel) {
		this.insuredChannel = insuredChannel;
	}

	public Integer getUrgentFee() {
		return urgentFee;
	}

	public void setUrgentFee(Integer urgentFee) {
		this.urgentFee = urgentFee;
	}
	
}
