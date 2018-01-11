package com.qbt.web.pojo.orderAmount;

import java.util.Date;

public class OrderAmountResponse {

	// 订单id
	private int id;

	// 下单时间
	private Date createTime;

	// 用户id
	private Integer userId;

	// 用户名
	private String userName;

	// 订单编号
	private String number;

	// 运单号
	private String mailNo;

	//订单状态： 1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 7-订单关闭-客服取消
	private Integer orderStatus;

	//退款状态： 1-正常状态 2-待退款 3-退款中 4-退款完成 5-退款失败
	private Integer refundStatus;

	//物流状态： 1-尚未下单至顺丰 2-待上门收件 3-顺丰已取件 4-顺丰已取件(客服确认) 5-物流运输中 6-派送中 7-已签收
	private Integer deliveryStatus;

	//顺丰BPS状态 1-未发送 2-发送成功 3-发送失败
	private Integer bpsStatus;

	// 1-正常下单 2-BPS重新下单 3-纸质下单
	private Integer handleType;

	// 是否优惠
	private Boolean isFavored;

	// 实际支付金额
	private Double amount;

	// 原有订单总金额
	private Double totalAmount;

	// 订单优惠金额
	private Double discount;

	// 优惠活动
	private String favorableDesc;

	// 优惠券ID
	private Integer couponId;

	// 优惠券码
	private String couponCode;

	// 保价金额
	private Double insuredValue;

	// 保价费率
	private Double insuredRates;

	// 保价费
	private Double insuredFee;

	// 寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	private Integer jAddrType;

	// 寄件非个人地址ID，个人地址为0
	private Integer jAddrId;

	// 寄件地址名称，如果个人地址为空
	private String jAddrName;

	// 寄件人
	private String jContact;

	// 寄件人地区ID
	private Integer jAreaId;

	// 寄件人地区中文路径
	private String jTreePath;

	// 寄件人地址
	private String jAddress;

	// 偏远寄件球场增加价格
	private Double jOutRangePrice;

	// 收件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	private Integer dAddrType;

	// 收件非个人地址ID，个人地址为0
	private Integer dAddrId;

	// 收件地址名称，如果个人地址为空
	private String dAddrName;

	// 收件人
	private String dContact;

	// 收件人地区ID
	private Integer dAreaId;

	// 收件人地区中文路径
	private String dTreePath;

	// 收件人地址
	private String dAddress;

	// 偏远收件球场增加价格
	private Double dOutRangePrice;

	// 备注
	private String remark;

	// 客服记录
	private String memo;

	// 商户支付号
	private String uuid;

	// 券面额
	private Double childAmount;

	// 1-普通用户 2-合作旅行社
	private Integer thirdType;

	// 合作方名称
	private String thirdName;

	// 是否会员
	private Boolean isVip;
	
	//支付方式：1-微信支付,2-boss购买,97-boss下单免支付,98-合作方下单免支付,99-现金券满额支付
	private Integer payMethod;
	
	// 客服收款状态:0-无需收款 1-是 2-否
    private Integer kfReceivableStatus;
    
    // 财务收款状态:1-是 2-否
    private Integer cwReceivableStatus;
    
    //BOSS手动优惠金额￥
    private Double inputDiscount;
    
    //费用增减
    private String costItem;
    
	private String weixinPayCode;
	private Date weixinPayCodeUpdateTime;
	private String weixinPayCodeOperater;
	
	//取消订单费用
	private Double cancelFee;
	
	private Integer mailChannel;
	
	private Integer urgentFee;
	
	public String getThirdName() {
		return thirdName;
	}

	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Integer getHandleType() {
		return handleType;
	}

	public void setHandleType(Integer handleType) {
		this.handleType = handleType;
	}

	public Boolean getIsFavored() {
		return isFavored;
	}

	public void setIsFavored(Boolean isFavored) {
		this.isFavored = isFavored;
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

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getFavorableDesc() {
		return favorableDesc;
	}

	public void setFavorableDesc(String favorableDesc) {
		this.favorableDesc = favorableDesc;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public Integer getThirdType() {
		return thirdType;
	}

	public void setThirdType(Integer thirdType) {
		this.thirdType = thirdType;
	}

	public Double getjOutRangePrice() {
		return jOutRangePrice;
	}

	public void setjOutRangePrice(Double jOutRangePrice) {
		this.jOutRangePrice = jOutRangePrice;
	}

	public Double getdOutRangePrice() {
		return dOutRangePrice;
	}

	public void setdOutRangePrice(Double dOutRangePrice) {
		this.dOutRangePrice = dOutRangePrice;
	}

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getKfReceivableStatus() {
		return kfReceivableStatus;
	}

	public void setKfReceivableStatus(Integer kfReceivableStatus) {
		this.kfReceivableStatus = kfReceivableStatus;
	}

	public Integer getCwReceivableStatus() {
		return cwReceivableStatus;
	}

	public void setCwReceivableStatus(Integer cwReceivableStatus) {
		this.cwReceivableStatus = cwReceivableStatus;
	}

	public Double getInputDiscount() {
		return inputDiscount;
	}

	public void setInputDiscount(Double inputDiscount) {
		this.inputDiscount = inputDiscount;
	}

	public String getCostItem() {
		return costItem;
	}

	public void setCostItem(String costItem) {
		this.costItem = costItem;
	}

	public String getWeixinPayCode() {
		return weixinPayCode;
	}

	public void setWeixinPayCode(String weixinPayCode) {
		this.weixinPayCode = weixinPayCode;
	}

	public Date getWeixinPayCodeUpdateTime() {
		return weixinPayCodeUpdateTime;
	}

	public void setWeixinPayCodeUpdateTime(Date weixinPayCodeUpdateTime) {
		this.weixinPayCodeUpdateTime = weixinPayCodeUpdateTime;
	}

	public String getWeixinPayCodeOperater() {
		return weixinPayCodeOperater;
	}

	public void setWeixinPayCodeOperater(String weixinPayCodeOperater) {
		this.weixinPayCodeOperater = weixinPayCodeOperater;
	}

	public Double getCancelFee() {
		return cancelFee;
	}

	public void setCancelFee(Double cancelFee) {
		this.cancelFee = cancelFee;
	}

	public Integer getMailChannel() {
		return mailChannel;
	}

	public void setMailChannel(Integer mailChannel) {
		this.mailChannel = mailChannel;
	}

	public Integer getUrgentFee() {
		return urgentFee;
	}

	public void setUrgentFee(Integer urgentFee) {
		this.urgentFee = urgentFee;
	}
}
