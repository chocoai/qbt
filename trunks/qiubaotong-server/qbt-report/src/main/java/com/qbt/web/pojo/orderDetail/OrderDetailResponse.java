package com.qbt.web.pojo.orderDetail;

import java.util.Date;

public class OrderDetailResponse {
	
	//订单id
	private int id;
	
	//订单编号
	private String number;
	
	//运单编号
	private String mailNo;
	
	//创建时间
	private Date createTime;
	
	//用户id
	private Integer userId;
	
	//用户名
	private String userName;
	
	//预计取件时间
	private Date sendSfUserTime;
	
	//寄件人
	private String jContact;
	
	//寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	private Integer jAddrType;
	
	//寄件非个人地址ID，个人地址为0
	private Integer jAddrId;
	
	//寄件地址名称，如果个人地址为空
	private String jAddrName;
	
	//寄件人地区ID
	private Integer jAreaId;
	
	//寄件人地区中文路径
	private String jTreePath;
	
	//寄件人地址
	private String jAddress;
	
	//收件人
	private String dContact;
	
	//收件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	private Integer dAddrType;
	
	//收件非个人地址ID，个人地址为0
	private Integer dAddrId;
	
	//收件地址名称，如果个人地址为空
	private String dAddrName;
	
	//收件人地区ID
	private Integer dAreaId;
	
	//收件人地区中文路径
	private String dTreePath;
	
	//收件人地址
	private String dAddress;
	
	//寄件类型：1-次日达 2-隔日达 5-次午达
	private String expressType;
	
	//实收金额
	private Double amount;
	
	//是否使用优惠
	private Boolean isFavored;
	
	//优惠券类型：1:现金券;2:折扣券;3:特价券
	private Integer couponType;
	
	//优惠券编码
	private String couponCode;
	
	//优惠活动
	private String favorableDesc;
	
	//是否用户首单
	private Boolean firstOrder;
	
	/*
	 * 订单状态： 
	 * 1-待支付 
	 * 2-支付中 
	 * 3-支付成功 
	 * 4-支付失败(可重新) 
	 * 5-订单关闭-用户取消 
	 * 7-订单关闭-客服取消
	*/
	private Integer orderStatus;
	
	/*
	 * 退款状态：
	 * 1-正常状态
	 * 2-待退款
	 * 3-退款中
	 * 4-退款完成
	 * 5-退款失败
	 */
    private Integer refundStatus;
    
    /*
	 * 物流状态：
	 * 1-尚未下单至顺丰
	 * 2-待上门收件
	 * 3-顺丰已取件
	 * 4-顺丰已取件(客服确认)
	 * 5-物流运输中
	 * 6-派送中
	 * 7-已签收
	 */
    private Integer deliveryStatus;
    
    /*
     * 顺丰BPS状态
	 * 1-未发送
	 * 2-发送成功
	 * 3-发送失败
     */
    private Integer bpsStatus;
    
    /*
     * 问题签收：
	 * 1-正常签收
	 * 2-异常签收
     */
    private Integer questionStatus;
    
    //1-普通用户  2-合作旅行社
    private Integer thirdType;
    
    //是否偏远球场(1:是，0：否)
  	private Integer isOutRange;
  	
  	//偏远费用字段
  	private Double outRangePrice;
  	
  	//包包码
  	private String bagCode;
  	
	//取消订单费用
  	private Double cancelFee;
  	
  	//加急费
  	private Integer urgentFee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getSendSfUserTime() {
		return sendSfUserTime;
	}

	public void setSendSfUserTime(Date sendSfUserTime) {
		this.sendSfUserTime = sendSfUserTime;
	}

	public String getjContact() {
		return jContact;
	}

	public void setjContact(String jContact) {
		this.jContact = jContact;
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

	public String getdContact() {
		return dContact;
	}

	public void setdContact(String dContact) {
		this.dContact = dContact;
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

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean getIsFavored() {
		return isFavored;
	}

	public void setIsFavored(Boolean isFavored) {
		this.isFavored = isFavored;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getFavorableDesc() {
		return favorableDesc;
	}

	public void setFavorableDesc(String favorableDesc) {
		this.favorableDesc = favorableDesc;
	}

	public Boolean getFirstOrder() {
		return firstOrder;
	}

	public void setFirstOrder(Boolean firstOrder) {
		this.firstOrder = firstOrder;
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

	public Integer getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(Integer questionStatus) {
		this.questionStatus = questionStatus;
	}

	public Integer getThirdType() {
		return thirdType;
	}

	public void setThirdType(Integer thirdType) {
		this.thirdType = thirdType;
	}

	public Integer getIsOutRange() {
		return isOutRange;
	}

	public void setIsOutRange(Integer isOutRange) {
		this.isOutRange = isOutRange;
	}

	public Double getOutRangePrice() {
		return outRangePrice;
	}

	public void setOutRangePrice(Double outRangePrice) {
		this.outRangePrice = outRangePrice;
	}

	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}

	public Double getCancelFee() {
		return cancelFee;
	}

	public void setCancelFee(Double cancelFee) {
		this.cancelFee = cancelFee;
	}

	public Integer getUrgentFee() {
		return urgentFee;
	}

	public void setUrgentFee(Integer urgentFee) {
		this.urgentFee = urgentFee;
	}
	
}
