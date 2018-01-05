package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;
import com.qbt.common.enums.LanguagesEnum;

/**
 *  订单信息表
  * @ClassName: OrderInfo
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public class OrderInfo extends BaseEntity {

    private Integer userId;

    private String number;

    private Double amount;

    private Double totalAmount;

    private String mailNo;

    private Date payTime;

    private Integer payId;

    private Integer orderStatus;

    private Integer refundStatus;

    private Integer deliveryStatus;

    private Integer bpsStatus;

    private Integer questionStatus;

    private Integer orderSource;
    
    private Integer handleType;
    
    private Date sendSfUserTime;

    private Integer couponId;

    private String couponCode;

    private Double discount;
    
    private Double inputDiscount;

    private Double favorable;

    private String favorableDesc;

    private Double freight;
    
    private Integer urgentFee;

    private Double insuredValue;

    private Double insuredRates;

    private Double insuredFee;

    private Double extraAmount;

    private String extraDesc;

    private String expressType;

    private Boolean isHandleQuestion;

    private String handleRemar;

    private String signRemark;

    private String sentRemark;

    private String remark;

    private String deliverDate;

    private String deliverTime;

    private String sendTimeSection;

    private Integer jAddrType;

    private Integer jAddrId;

    private String jAddrName;

    private String jContact;

    private String jMobile;

    private Integer jAreaId;

    private String jTreePath;

    private String jAddress;
    
    private Integer jOutRangeType;//偏远类型 0-非偏远 1-球场 4-地区
    
    private Double jOutRangeTime;
    
    private Double jOutRangePrice;

    private Integer dAddrType;

    private Integer dAddrId;

    private String dAddrName;

    private String dContact;

    private String dMobile;

    private Integer dAreaId;

    private String dTreePath;

    private String dAddress;
    
    private Integer dOutRangeType;//偏远类型 0-非偏远 1-球场 4-地区
    
    private Double dOutRangeTime;
    
    private Double dOutRangePrice;

    private Boolean isHelped;

    private Boolean isDelete;

    private Date deleteTime;
    
    private String openid;
    
    private Boolean firstOrder;
    
    private Boolean isComment;
    
    private Integer thirdType;// 1-普通用户  2-合作旅行社
    
    private Integer thirdId;
    
    private String thirdName;
    
    private String langEname = LanguagesEnum.CHINA.getValue();
    
    private String assistantName;
    
    private int orderId;
    
    private String orderNumber;
    
    private String md5;
    // 是否vip
    private Boolean isVip;
    // vip会员卡ID
    private int vipId = 0;
    // 客服收款状态:0-无需收款 1-是 2-否
    private Integer kfReceivableStatus;
    // 财务收款状态:1-是 2-否
    private Integer cwReceivableStatus;
    // 下单原因
    private String reason;
    // 代下单用户Id
    private Integer proxyUserId = 0;
    // 代下单需要用户下单自身ID
    private Integer proxySelfUserId = 0;
    // 打球时间
    private String playTime;
    
    private Integer mailChannel;
    //是否机构群优惠
    private Boolean isOrg;
    //机构群id
    private int orgId;
    //机构群名称
    private String orgName;
    
    private String mailNumber;
    //是否使用包包码
    private Boolean isBagCode;
    //包包码
    private String bagCode;
    //包包码合作方id
    private int bagCodePartnerId;
    //包包码合作方名称
    private String bagCodePartnerName;
    
	private String weixinPayCode;
	private Date weixinPayCodeUpdateTime;
	private String weixinPayCodeOperater;
	
	//是否确认收包
	private Boolean isConfirmReceive;
	
	//是否已经开过发票
	private Boolean isDrawedBill;
	
	//确认签收时间
	private Date confirmTime;
	
	//保价渠道
	private String insuredChannel;
    
    public Integer getUserId() {
        return userId;
    }

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(Integer questionStatus) {
		this.questionStatus = questionStatus;
	}

	public Integer getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

	public Integer getHandleType() {
		return handleType;
	}

	public void setHandleType(Integer handleType) {
		this.handleType = handleType;
	}

	public Date getSendSfUserTime() {
		return sendSfUserTime;
	}

	public void setSendSfUserTime(Date sendSfUserTime) {
		this.sendSfUserTime = sendSfUserTime;
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

	public Double getFavorable() {
		return favorable;
	}

	public void setFavorable(Double favorable) {
		this.favorable = favorable;
	}

	public String getFavorableDesc() {
		return favorableDesc;
	}

	public void setFavorableDesc(String favorableDesc) {
		this.favorableDesc = favorableDesc;
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

	public Double getExtraAmount() {
		return extraAmount;
	}

	public void setExtraAmount(Double extraAmount) {
		this.extraAmount = extraAmount;
	}

	public String getExtraDesc() {
		return extraDesc;
	}

	public void setExtraDesc(String extraDesc) {
		this.extraDesc = extraDesc;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public Boolean getIsHandleQuestion() {
		return isHandleQuestion;
	}

	public void setIsHandleQuestion(Boolean isHandleQuestion) {
		this.isHandleQuestion = isHandleQuestion;
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

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Boolean getFirstOrder() {
		return firstOrder;
	}

	public void setFirstOrder(Boolean firstOrder) {
		this.firstOrder = firstOrder;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
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

	public Integer getProxySelfUserId() {
		return proxySelfUserId;
	}

	public void setProxySelfUserId(Integer proxySelfUserId) {
		this.proxySelfUserId = proxySelfUserId;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public Integer getMailChannel() {
		return mailChannel;
	}

	public void setMailChannel(Integer mailChannel) {
		this.mailChannel = mailChannel;
	}

	public Boolean getIsOrg() {
		return isOrg;
	}

	public void setIsOrg(Boolean isOrg) {
		this.isOrg = isOrg;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getMailNumber() {
		return mailNumber;
	}

	public void setMailNumber(String mailNumber) {
		this.mailNumber = mailNumber;
	}

	public Boolean getIsBagCode() {
		return isBagCode;
	}

	public void setIsBagCode(Boolean isBagCode) {
		this.isBagCode = isBagCode;
	}

	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}

	public int getBagCodePartnerId() {
		return bagCodePartnerId;
	}

	public void setBagCodePartnerId(int bagCodePartnerId) {
		this.bagCodePartnerId = bagCodePartnerId;
	}

	public String getBagCodePartnerName() {
		return bagCodePartnerName;
	}

	public void setBagCodePartnerName(String bagCodePartnerName) {
		this.bagCodePartnerName = bagCodePartnerName;
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

	

	public Boolean getIsConfirmReceive() {
		return isConfirmReceive;
	}

	public void setIsConfirmReceive(Boolean isConfirmReceive) {
		this.isConfirmReceive = isConfirmReceive;
	}

	public Boolean getIsDrawedBill() {
		return isDrawedBill;
	}

	public void setIsDrawedBill(Boolean isDrawedBill) {
		this.isDrawedBill = isDrawedBill;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getInsuredChannel() {
		return insuredChannel;
	}

	public void setInsuredChannel(String insuredChannel) {
		this.insuredChannel = insuredChannel;
	}
	
}