package com.qbt.web.pojo.order;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.alibaba.fastjson.annotation.JSONField;
import com.qbt.common.annotation.Note;

public class OrderDetailVo {
	
	//订单id
	@NotNull(message="订单ID不能为空")
	private Integer id;
	
	//创建时间
	private Date createTime;

	//用户id
	private Integer userId;
	
	// 大订单ID
	private Integer orderId;

	//用户名
	private String userName;
	
	//用户昵称
	private String nickname;
	
	//订单编号
	@Note("订单编号")
    private String number;
    
    //运单编号
	@Note("运单号")
    private String mailNo;
    
    //实际支付金额
    private Double amount;
    
    //原有订单总金额
    private Double totalAmount;
    
    //唯一号，用于微信支付唯一码（微信订单号）
    private String uuid;
    
    //支付方式 1-微信支付 98-合作方下单免支付 99-现金券满额支付
    private Integer payMethod;
    
    //支付状态 1-预支付 2-支付成功 3-支付失败 4-异常
    private Integer payStatus;
    
    //订单状态： 1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 6-订单关闭-系统关单 7-订单关闭-客服取消
    private Integer orderStatus;
    
    //退款状态： 1-正常状态 2-待退款 3-退款中 4-退款完成 5-退款失败
    private Integer refundStatus;
    
    //物流状态： 1-尚未下单至顺丰 2-待上门收件 3-顺丰已取件 4-顺丰已取件(客服确认) 5-物流运输中 6-派送中 7-已签收
    private Integer deliveryStatus;
    
    ////顺丰BPS状态 1-未发送 2-发送成功 3-发送失败
    private Integer bpsStatus;
    
    //寄件类型：1-次日达 2-隔日达 5-次午达
    @Note("寄件类型")
    private String expressType;
    
    //预计取件时间
    @Note("预计取件时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date sendSfUserTime;
    
    //预计寄件日期
    @Note("预计到达时间")
    private String deliverDate;
    
    //预计寄件时间
    private String deliverTime;
    
    //寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
    @NotNull(message="寄件地址类型不能为空")
    private Integer jAddrType;
    
    //寄件非个人地址ID，个人地址为0
    @NotNull(message="寄件地址ID不能为空")
    private Integer jAddrId;
    
    //寄件地址名称，如果个人地址为空
    @Note("寄件站点")
    private String jAddrName;
    
	private String weixinPayCode;
	private Date weixinPayCodeUpdateTime;
	private String weixinPayCodeOperater;
    
    
    //寄件人
    @Note("寄件人")
    @NotNull(message="寄件人不能为空")
    @Size(min=1,max=10,message="寄件人名字过长")
    private String jContact;
    
    //寄件人手机号
    @Note("寄件人手机号")
    @NotNull(message="寄件人手机号")
    @Pattern(regexp="(^(0[0-9]{2,3}-?)?[0-9]{7,8}$)|(^1[\\d]{10}$)",message="寄件人手机号格式不正确")
    private String jMobile;
    
    //寄件人地区ID
    @NotNull(message="寄件人地区ID不能为空")
    private Integer jAreaId;
    
    //寄件人地区中文路径
    @Note("寄件地区")
    private String jTreePath;
    
    //寄件人地址
    @Note("寄件地址")
    @NotNull(message="寄件地址不能为空")
    private String jAddress;
    
    //收件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
    @NotNull(message="收件地址类型不能为空")
    private Integer dAddrType;
    
    //收件非个人地址ID，个人地址为0
    @NotNull(message="收件地址ID不能为空")
    private Integer dAddrId;
    
    //收件地址名称，如果个人地址为空
    @Note("收件站点")
    private String dAddrName;

    //收件人
    @Note("收件人")
    @NotNull(message="收件人不能为空")
    @Size(min=1,max=10,message="收件人名字过长")
    private String dContact;
    
    //收件人手机号
    @Note("收件人手机号")
    @NotNull(message="收件人手机号不能为空")
    @Pattern(regexp="(^(0[0-9]{2,3}-?)?[0-9]{7,8}$)|(^1[\\d]{10}$)",message="收件人手机号格式不正确")
    private String dMobile;
    
    //收件地区ID
    @NotNull(message="收件地区ID不能为空")
    private Integer dAreaId;
    
    //收件人地区中文路径
    @Note("收件人地区")
    private String dTreePath;
    
    //收件人地址
    @Note("收件人地址")
    @NotNull(message="收件人地址不能为空")
    private String dAddress;
    
    //优惠劵id
    private Integer couponId;
    
    //优惠劵code 交易过程临时使用
    private String couponCode;
    
    //折扣金额
    private Double discount;
    
    //优惠描述
    private String favorableDesc;
    
    //球场人员发包备注
    private String sentRemark;
    
    //客户寄件备注
    @Note("备注")
    private String remark;
    
    //是否代下单
    private Boolean isHelped;
    
    //is_delete
    private Boolean isDelete;
    
    // 处理备注
    private String handleRemar;
    
    // 签收备注
    private String signRemark;
    
    // 预约取包时间
    private String sendTimeSection;
    
    // 运费
    private Double freight;
    
    // 加急费
    private Integer urgentFee;
    
    // 保价金额
    private Double insuredValue;
    
    // 保价费率
    private Double insuredRates;
    
    // 保价费
    private Double insuredFee;
    
    // 1-保存，2-BPS重新下单，3-纸质下单
    @NotNull(message="订单修改类型不能为空")
    private Integer type;
    
    //1-普通用户  2-合作旅行社
    private Integer thirdType;
    
    //合作方id
    private Integer thirdId;
    
    //合作方名称
    private String thirdName;
    
    //语言
    private String langEname;
    
    //1-未结算  2-已结算 3-无效结算记录
  	private Integer settleState;
  	
	//寄件球场状态：1-已签约 2-未签约但可接受球包通球包 3-不接受球包通球包 4-未知状态
    private Integer jCourseStatus;
    
    //收件球场状态：1-已签约 2-未签约但可接受球包通球包 3-不接受球包通球包 4-未知状态
    private Integer dCourseStatus;
    
 	// 是否会员
 	private Boolean isVip;
    
 	// 会员信息Id
 	private int vipId;
 	
 	// 会员卡号
 	private String vipNo;
 	
 	// 客服收款状态:0-无需收款 1-是 2-否
    private Integer kfReceivableStatus;
    
    // 财务收款状态:1-是 2-否
    private Integer cwReceivableStatus;
    
    // 下单原由
    private String reason;
    
    @Note("寄件地区偏远费用")
    private Double jOutRangePrice;
    
    @Note("收件地区偏远费用")
    private Double dOutRangePrice;
    
    private Double inputDiscount;
    
    //订单来源(1-微信下单, 3-PC下单, 5-BOSS下单)
  	private Integer orderSource;
 	
  	//下单代理人ID(大于0代下单，等于0非代下单)
  	private Integer proxyUserId;
  	
  	//代下单人：销售人员名字
  	private String saleUserName;
  	
  	//订单支付人：true-代下单人支付, false-用户支付
  	private Boolean isProxyPay;
  	
  	// 是否发信息
  	private Boolean sendMsg;
  	
	// 打球时间
    private String playTime;
  	
    //寄件地址Id
    private String jTreeId;
    
    //收件地址Id
    private String dTreeId;
    
    private Integer mailChannel;
    
    private String mailNumber;
    
    //机构名称
  	private String orgName;
  	
  	//订单取消费用
  	private Double cancelFee;
  	
  	private Boolean isConfirmReceive;
  	
  	//保价渠道
  	private String insuredChannel;
  	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
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

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
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

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
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

	public String getSentRemark() {
		return sentRemark;
	}

	public void setSentRemark(String sentRemark) {
		this.sentRemark = sentRemark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getIsHelped() {
		return isHelped;
	}

	public void setIsHelped(Boolean isHelped) {
		this.isHelped = isHelped;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getjTreePath() {
		return jTreePath;
	}

	public void setjTreePath(String jTreePath) {
		this.jTreePath = jTreePath;
	}

	public String getdTreePath() {
		return dTreePath;
	}

	public void setdTreePath(String dTreePath) {
		this.dTreePath = dTreePath;
	}

	public String getHandleRemar() {
		return handleRemar;
	}

	public void setHandleRemar(String handleRemar) {
		this.handleRemar = handleRemar;
	}

	public String getSignRemark() {
		return signRemark;
	}

	public void setSignRemark(String signRemark) {
		this.signRemark = signRemark;
	}

	public String getSendTimeSection() {
		return sendTimeSection;
	}

	public void setSendTimeSection(String sendTimeSection) {
		this.sendTimeSection = sendTimeSection;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Integer getUrgentFee() {
		return urgentFee;
	}

	public void setUrgentFee(Integer urgentFee) {
		this.urgentFee = urgentFee;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
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

	public Integer getSettleState() {
		return settleState;
	}

	public void setSettleState(Integer settleState) {
		this.settleState = settleState;
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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	public int getVipId() {
		return vipId;
	}

	public void setVipId(int vipId) {
		this.vipId = vipId;
	}

	public String getVipNo() {
		return vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Double getInputDiscount() {
		return inputDiscount;
	}

	public void setInputDiscount(Double inputDiscount) {
		this.inputDiscount = inputDiscount;
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

	public Boolean getIsProxyPay() {
		return isProxyPay;
	}

	public void setIsProxyPay(Boolean isProxyPay) {
		this.isProxyPay = isProxyPay;
	}

	public Boolean getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(Boolean sendMsg) {
		this.sendMsg = sendMsg;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getjTreeId() {
		return jTreeId;
	}

	public void setjTreeId(String jTreeId) {
		this.jTreeId = jTreeId;
	}

	public String getdTreeId() {
		return dTreeId;
	}

	public void setdTreeId(String dTreeId) {
		this.dTreeId = dTreeId;
	}

	public Integer getMailChannel() {
		return mailChannel;
	}

	public void setMailChannel(Integer mailChannel) {
		this.mailChannel = mailChannel;
	}

	public String getMailNumber() {
		return mailNumber;
	}

	public void setMailNumber(String mailNumber) {
		this.mailNumber = mailNumber;
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

	public Boolean getIsConfirmReceive() {
		return isConfirmReceive;
	}

	public void setIsConfirmReceive(Boolean isConfirmReceive) {
		this.isConfirmReceive = isConfirmReceive;
	}

	public String getInsuredChannel() {
		return insuredChannel;
	}

	public void setInsuredChannel(String insuredChannel) {
		this.insuredChannel = insuredChannel;
	}
	
}
