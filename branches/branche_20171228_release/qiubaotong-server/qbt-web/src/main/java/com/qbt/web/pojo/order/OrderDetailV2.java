package com.qbt.web.pojo.order;

import java.util.Date;

import com.qbt.common.enums.LanguagesEnum;

public class OrderDetailV2 {
    
	private int id;
	// 下单时间
	private long createTime;
	// 订单数量
	private int quantity;
	// 大订单号
 	private String orderNumber;
	// 订单号
	private String number;
	// 订单实际需要支付金额
    private Double amount;
    // 订单总金额
    private Double totalAmount;
    // 顺丰运单号
    private String mailNo;
    // 支付时间
    private Date payTime;
    // 支付ID
    private Integer payId;
    // 订单状态
    private Integer orderStatus;
    // 退款状态
    private Integer refundStatus;
    // 物流状态
    private Integer deliveryStatus;
    // 下发顺丰状态
    private Integer bpsStatus;
    // 订单来源
    private Integer orderSource;
    // 顺丰预约取件时间
    private Date sendSfUserTime;
    // 优惠券券号
    private String couponCode;
    // 优惠金额
    private Double discount;
    // 手动优惠金额
    private Double inputDiscount;
    // 顺丰运费
    private Double freight;
    // 保价费
    private Double insuredValue;
    // 保价费率
    private Double insuredRates;
    // 保价费
    private Double insuredFee;
    // 顺丰时效类型
    private String expressType;
    // 备注
    private String remark;
    // 预计到达时间
    private String deliverDate;
    // 顺丰取包时间段
    private String sendTimeSection;
    // 寄件地址类型
    private Integer jAddrType;
    // 寄件地址类型ID
    private Integer jAddrId;
    // 寄件地址名称
    private String jAddrName;
    // 寄件联系人
    private String jContact;
    // 寄件人手机号
    private String jMobile;
    // 寄件地区ID
    private Integer jAreaId;
    // 寄件地址省市区
    private String jTreePath;
    // 寄件地址省市区id
    private String jTreeId;
    // 寄件地址
    private String jAddress;
    // 寄件地址标签
    private Integer jLabelType;
    // 寄件偏远类型 0-非偏远 1-球场 4-地区
    private Integer jOutRangeType;
    // 寄件球场偏远时效
    private Double jOutRangeTime;
    // 寄件球场偏远价格
    private Double jOutRangePrice;
    
    private Integer dAddrType;

    private Integer dAddrId;

    private String dAddrName;

    private String dContact;

    private String dMobile;

    private Integer dAreaId;

    private String dTreePath;
    // 收件地址省市区id
    private String dTreeId;

    private String dAddress;
    // 收件地址标签
    private Integer dLabelType;
    // 收件偏远类型 0-非偏远 1-球场 4-地区
    private Integer dOutRangeType;
    
    private Double dOutRangeTime;
    
    private Double dOutRangePrice;

    private Boolean isComment;
    
    private Integer thirdType;// 1-普通用户  2-合作旅行社
    
    private Integer thirdId;
    
    private String thirdName;
    
    private String langEname = LanguagesEnum.CHINA.getValue();
    
    private String assistantName;
    
    private int orderId;
    
    private String md5;
    // 是否vip
    private boolean isVip = false;
    
    private int discountType = 0;
    
    private double discountInsuredFee;
    // 打球时间
    private String playTime;
    // 顺丰时效描述
    private String expressDescribe;
    
    private boolean jIsOutRange;
    private boolean dIsOutRange;
    
    private Date confirmTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getMailNo() {
		return mailNo;
	}
	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Integer getPayId() {
		return payId;
	}
	public void setPayId(Integer payId) {
		this.payId = payId;
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
	public Integer getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}
	public Date getSendSfUserTime() {
		return sendSfUserTime;
	}
	public void setSendSfUserTime(Date sendSfUserTime) {
		this.sendSfUserTime = sendSfUserTime;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getInputDiscount() {
		return inputDiscount;
	}
	public void setInputDiscount(Double inputDiscount) {
		this.inputDiscount = inputDiscount;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Double getInsuredValue() {
		return insuredValue;
	}
	public void setInsuredValue(Double insuredValue) {
		this.insuredValue = insuredValue;
	}
	public Double getInsuredRates() {
		return insuredRates;
	}
	public void setInsuredRates(Double insuredRates) {
		this.insuredRates = insuredRates;
	}
	public Double getInsuredFee() {
		return insuredFee;
	}
	public void setInsuredFee(Double insuredFee) {
		this.insuredFee = insuredFee;
	}
	public String getExpressType() {
		return expressType;
	}
	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}
	public String getSendTimeSection() {
		return sendTimeSection;
	}
	public void setSendTimeSection(String sendTimeSection) {
		this.sendTimeSection = sendTimeSection;
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
	public Integer getjOutRangeType() {
		return jOutRangeType;
	}
	public void setjOutRangeType(Integer jOutRangeType) {
		this.jOutRangeType = jOutRangeType;
	}
	public Double getjOutRangeTime() {
		return jOutRangeTime;
	}
	public void setjOutRangeTime(Double jOutRangeTime) {
		this.jOutRangeTime = jOutRangeTime;
	}
	public Double getjOutRangePrice() {
		return jOutRangePrice;
	}
	public void setjOutRangePrice(Double jOutRangePrice) {
		this.jOutRangePrice = jOutRangePrice;
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
	public Integer getdOutRangeType() {
		return dOutRangeType;
	}
	public void setdOutRangeType(Integer dOutRangeType) {
		this.dOutRangeType = dOutRangeType;
	}
	public Double getdOutRangeTime() {
		return dOutRangeTime;
	}
	public void setdOutRangeTime(Double dOutRangeTime) {
		this.dOutRangeTime = dOutRangeTime;
	}
	public Double getdOutRangePrice() {
		return dOutRangePrice;
	}
	public void setdOutRangePrice(Double dOutRangePrice) {
		this.dOutRangePrice = dOutRangePrice;
	}
	public Boolean getIsComment() {
		return isComment;
	}
	public void setIsComment(Boolean isComment) {
		this.isComment = isComment;
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
	public String getAssistantName() {
		return assistantName;
	}
	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscountType() {
		return discountType;
	}
	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}
	public double getDiscountInsuredFee() {
		return discountInsuredFee;
	}
	public void setDiscountInsuredFee(double discountInsuredFee) {
		this.discountInsuredFee = discountInsuredFee;
	}
	public String getjTreeId() {
		return jTreeId;
	}
	public void setjTreeId(String jTreeId) {
		this.jTreeId = jTreeId;
	}
	public Integer getjLabelType() {
		return jLabelType;
	}
	public void setjLabelType(Integer jLabelType) {
		this.jLabelType = jLabelType;
	}
	public String getdTreeId() {
		return dTreeId;
	}
	public void setdTreeId(String dTreeId) {
		this.dTreeId = dTreeId;
	}
	public Integer getdLabelType() {
		return dLabelType;
	}
	public void setdLabelType(Integer dLabelType) {
		this.dLabelType = dLabelType;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	public String getExpressDescribe() {
		return expressDescribe;
	}
	public void setExpressDescribe(String expressDescribe) {
		this.expressDescribe = expressDescribe;
	}
	public boolean isjIsOutRange() {
		return jIsOutRange;
	}
	public void setjIsOutRange(boolean jIsOutRange) {
		this.jIsOutRange = jIsOutRange;
	}
	public boolean isdIsOutRange() {
		return dIsOutRange;
	}
	public void setdIsOutRange(boolean dIsOutRange) {
		this.dIsOutRange = dIsOutRange;
	}
	public Date getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
    
}
