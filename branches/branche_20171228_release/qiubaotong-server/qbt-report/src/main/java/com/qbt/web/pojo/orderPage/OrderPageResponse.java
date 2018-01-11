package com.qbt.web.pojo.orderPage;

import java.util.Date;

public class OrderPageResponse {

	// 订单id
	private Integer id;

	// 创建时间
	private Date createTime;

	// 用户id
	private Integer userId;

	// 用户名
	private String userName;
	
	// 用户昵称
	private String nickname;

	// 订单编号
	private String number;

	// 运单编号
	private String mailNo;

	// 预计取件时间
	private Date sendSfUserTime;

	// 预计寄件日期
	private String deliverDate;

	// 预计寄件时间
	private String deliverTime;

	// 订单状态： 1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 6-订单关闭-系统关单 7-订单关闭-客服取消
	private Integer orderStatus;

	// 退款状态： 1-正常状态 2-待退款 3-退款中 4-退款完成 5-退款失败
	private Integer refundStatus;

	// 物流状态： 1-尚未下单至顺丰 2-待上门收件 3-顺丰已取件 4-顺丰已取件(客服确认) 5-物流运输中 6-派送中 7-已签收
	private Integer deliveryStatus;

	// 顺丰BPS状态 1-未发送 2-发送成功 3-发送失败
	private Integer bpsStatus;

	// 寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	private Integer jAddrType;

	// 寄件非个人地址ID，个人地址为0
	private Integer jAddrId;

	// 寄件地址名称，如果个人地址为空
	private String jAddrName;

	// 寄件人
	private String jContact;

	// 寄件人手机号
	private String jMobile;

	// 寄件人地区ID
	private Integer jAreaId;

	// 寄件人地区中文路径
	private String jTreePath;

	// 寄件人地址
	private String jAddress;

	// 收件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	private Integer dAddrType;

	// 收件非个人地址ID，个人地址为0
	private Integer dAddrId;

	// 收件地址名称，如果个人地址为空
	private String dAddrName;

	// 收件人
	private String dContact;

	// 收件人手机号
	private String dMobile;

	// 收件人地区ID
	private Integer dAreaId;

	// 收件人地区中文路径
	private String dTreePath;

	// 收件人地址
	private String dAddress;

	// 1-普通用户 2-合作旅行社
	private Integer thirdType;

	// 合作方id
	private Integer thirdId;

	// 合作方名称
	private String thirdName;

	// 语言
	private String langEname;

	// 寄件球场状态：1-已签约 2-未签约但可接受球包通球包 3-不接受球包通球包 4-未知状态
	private Integer jCourseStatus;

	// 收件球场状态：1-已签约 2-未签约但可接受球包通球包 3-不接受球包通球包 4-未知状态
	private Integer dCourseStatus;

	// 寄件偏远类型 0-非偏远 1-球场 4-地区
	private Integer jOutRangeType;
	
	// 收件偏远类型 0-非偏远 1-球场 4-地区
	private Integer dOutRangeType;
	
	// 是否会员
	private boolean isVip;
	
	//下单代理人ID
	private Integer proxyUserId;
	
	//销售人员名称
	private String saleUserName;
	
	//销售人员id
	private Integer saleUserId;
	
	//订单来源(1-微信下单, 3-PC下单, 5-BOSS下单)
	private Integer orderSource;
	
	private Integer mailChannel;
	
	//保价渠道
	private String insuredChannel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public Date getSendSfUserTime() {
		return sendSfUserTime;
	}

	public void setSendSfUserTime(Date sendSfUserTime) {
		this.sendSfUserTime = sendSfUserTime;
	}

	public String getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}

	public String getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
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

	public Integer getBpsStatus() {
		return bpsStatus;
	}

	public void setBpsStatus(Integer bpsStatus) {
		this.bpsStatus = bpsStatus;
	}

	public Integer getjAddrType() {
		return jAddrType;
	}

	public void setjAddrType(Integer jAddrType) {
		this.jAddrType = jAddrType;
	}

	public Integer getjAddrId() {
		return jAddrId;
	}

	public void setjAddrId(Integer jAddrId) {
		this.jAddrId = jAddrId;
	}

	public String getjAddrName() {
		return jAddrName;
	}

	public void setjAddrName(String jAddrName) {
		this.jAddrName = jAddrName;
	}

	public String getjContact() {
		return jContact;
	}

	public void setjContact(String jContact) {
		this.jContact = jContact;
	}

	public String getjMobile() {
		return jMobile;
	}

	public void setjMobile(String jMobile) {
		this.jMobile = jMobile;
	}

	public Integer getjAreaId() {
		return jAreaId;
	}

	public void setjAreaId(Integer jAreaId) {
		this.jAreaId = jAreaId;
	}

	public String getjTreePath() {
		return jTreePath;
	}

	public void setjTreePath(String jTreePath) {
		this.jTreePath = jTreePath;
	}

	public String getjAddress() {
		return jAddress;
	}

	public void setjAddress(String jAddress) {
		this.jAddress = jAddress;
	}

	public Integer getdAddrType() {
		return dAddrType;
	}

	public void setdAddrType(Integer dAddrType) {
		this.dAddrType = dAddrType;
	}

	public Integer getdAddrId() {
		return dAddrId;
	}

	public void setdAddrId(Integer dAddrId) {
		this.dAddrId = dAddrId;
	}

	public String getdAddrName() {
		return dAddrName;
	}

	public void setdAddrName(String dAddrName) {
		this.dAddrName = dAddrName;
	}

	public String getdContact() {
		return dContact;
	}

	public void setdContact(String dContact) {
		this.dContact = dContact;
	}

	public String getdMobile() {
		return dMobile;
	}

	public void setdMobile(String dMobile) {
		this.dMobile = dMobile;
	}

	public Integer getdAreaId() {
		return dAreaId;
	}

	public void setdAreaId(Integer dAreaId) {
		this.dAreaId = dAreaId;
	}

	public String getdTreePath() {
		return dTreePath;
	}

	public void setdTreePath(String dTreePath) {
		this.dTreePath = dTreePath;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public Integer getThirdType() {
		return thirdType;
	}

	public void setThirdType(Integer thirdType) {
		this.thirdType = thirdType;
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

	public String getLangEname() {
		return langEname;
	}

	public void setLangEname(String langEname) {
		this.langEname = langEname;
	}

	public Integer getjCourseStatus() {
		return jCourseStatus;
	}

	public void setjCourseStatus(Integer jCourseStatus) {
		this.jCourseStatus = jCourseStatus;
	}

	public Integer getdCourseStatus() {
		return dCourseStatus;
	}

	public void setdCourseStatus(Integer dCourseStatus) {
		this.dCourseStatus = dCourseStatus;
	}

	public Integer getjOutRangeType() {
		return jOutRangeType;
	}

	public void setjOutRangeType(Integer jOutRangeType) {
		this.jOutRangeType = jOutRangeType;
	}

	public Integer getdOutRangeType() {
		return dOutRangeType;
	}

	public void setdOutRangeType(Integer dOutRangeType) {
		this.dOutRangeType = dOutRangeType;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public Integer getProxyUserId() {
		return proxyUserId;
	}

	public void setProxyUserId(Integer proxyUserId) {
		this.proxyUserId = proxyUserId;
	}

	public String getSaleUserName() {
		return saleUserName;
	}

	public void setSaleUserName(String saleUserName) {
		this.saleUserName = saleUserName;
	}

	public Integer getSaleUserId() {
		return saleUserId;
	}

	public void setSaleUserId(Integer saleUserId) {
		this.saleUserId = saleUserId;
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

	public String getInsuredChannel() {
		return insuredChannel;
	}

	public void setInsuredChannel(String insuredChannel) {
		this.insuredChannel = insuredChannel;
	}
	
}
