package com.qbt.web.pojo.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qbt.web.pojo.activity.OrderActivity;

public class OrderDetail extends OrderActivity{
	
	private int id;
	// 下单时间
	private long createTime;
	// 大订单号
	private String orderNumber;
	// 订单号
	private String number;
	// 子订单号集
	private List<String> numbers = new ArrayList<String>();
	// 订单实际支付金额
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
    // 寄件地址名称
    private String jAddressName;
    // 寄件地址省市区
    private String jCityName;
    // 寄件地址类型
    private Integer jAddrType;
    // 寄件地址地区ID
    private Integer jAreaId;
    // 寄件地址地区ID
    private String jAddress;
    // 地区信息
    private Integer jAddrId;
    // 寄件人姓名
    private String jUserName;
    // 寄件人手机号
    private String jMobile;
    // 寄件地址名称
    private String dAddressName;
    // 收件地址类型
    private Integer dAddrType;
    // 收件地址地区ID
    private Integer dAreaId;
    // 收件地址地区ID
    private String dAddress;
    // 地区信息
    private Integer dAddrId;
    // 收件人姓名
    private String dUserName;
    // 收件人手机号
    private String dMobile;
    // 收件地址省市区
    private String dCityName;
    // 顺丰预计到到达时间
    private String deliverTime;
    // 寄件类型
    private String busnissType;
    // 预约寄件时间
    private String sendTimeSection;
    // 保价金额
    private double insureValue;
    // 保价费
    private double insureFee;
    // 优惠金额
    private double freight;
    // 折扣金额
    private double discount;
    // 是否评论
    private boolean comment;
    // 备注
    private String remark;
    // 是否合作方订单
    private boolean partnerOrder = false;
    // 合作方支持的语言库
    private String[] partnerLangs;
    // 助理姓名
    private String assistantName;
    // 语言
    private String langName;
    // 是否VIP订单
    private boolean vipOrder = false;
    // vip订单金额
    private double vipOrderAmount;
    // 偏远价格
    private double outRangeAmount;
    // VIP订单对应的vip卡ID。
    private List<Integer> vipIds = new ArrayList<Integer>();
	// 寄件偏远类型 0-非偏远 1-球场 4-地区
    private Integer jOutRangeType;
    // 收件偏远类型 0-非偏远 1-球场 4-地区
    private Integer dOutRangeType;
    // 优惠保价金额
    private double discountInsuredFee;
    
    private int rownum;
	// 打球时间
    private String playTime;
    //优惠类型（群机构优惠：3）
    private Integer discountType;
    // 顺丰时效描述
    private String expressDescribe;
	//寄件地区偏远费用
    private Double jOutRangePrice;
	//收件地区偏远费用
    private Double dOutRangePrice;
    //寄件地区是否偏远
    private Boolean jIsOutRange = false;
    //收件地区是否偏远
    private Boolean dIsOutRange = false;
    //订单是否可取消
    private boolean cancelAble;
    
    //是否已经开过发票
  	private Boolean isDrawedBill;
  	
	//是否确认收包
  	private Boolean isConfirmReceive;
  	//与预约取包时间相比,是否当天
  	private Boolean isCurrent = false;
  	
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
	public List<String> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
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
	public String getjAddressName() {
		return jAddressName;
	}
	public void setjAddressName(String jAddressName) {
		this.jAddressName = jAddressName;
	}
	public String getjCityName() {
		return jCityName;
	}
	public void setjCityName(String jCityName) {
		this.jCityName = jCityName;
	}
	public Integer getjAddrType() {
		return jAddrType;
	}
	public void setjAddrType(Integer jAddrType) {
		this.jAddrType = jAddrType;
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
	public Integer getjAddrId() {
		return jAddrId;
	}
	public void setjAddrId(Integer jAddrId) {
		this.jAddrId = jAddrId;
	}
	public String getjUserName() {
		return jUserName;
	}
	public void setjUserName(String jUserName) {
		this.jUserName = jUserName;
	}
	public String getjMobile() {
		return jMobile;
	}
	public void setjMobile(String jMobile) {
		this.jMobile = jMobile;
	}
	public String getdAddressName() {
		return dAddressName;
	}
	public void setdAddressName(String dAddressName) {
		this.dAddressName = dAddressName;
	}
	public Integer getdAddrType() {
		return dAddrType;
	}
	public void setdAddrType(Integer dAddrType) {
		this.dAddrType = dAddrType;
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
	public Integer getdAddrId() {
		return dAddrId;
	}
	public void setdAddrId(Integer dAddrId) {
		this.dAddrId = dAddrId;
	}
	public String getdUserName() {
		return dUserName;
	}
	public void setdUserName(String dUserName) {
		this.dUserName = dUserName;
	}
	public String getdMobile() {
		return dMobile;
	}
	public void setdMobile(String dMobile) {
		this.dMobile = dMobile;
	}
	public String getdCityName() {
		return dCityName;
	}
	public void setdCityName(String dCityName) {
		this.dCityName = dCityName;
	}
	public String getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getBusnissType() {
		return busnissType;
	}
	public void setBusnissType(String busnissType) {
		this.busnissType = busnissType;
	}
	public String getSendTimeSection() {
		return sendTimeSection;
	}
	public void setSendTimeSection(String sendTimeSection) {
		this.sendTimeSection = sendTimeSection;
	}
	public double getInsureValue() {
		return insureValue;
	}
	public void setInsureValue(double insureValue) {
		this.insureValue = insureValue;
	}
	public double getInsureFee() {
		return insureFee;
	}
	public void setInsureFee(double insureFee) {
		this.insureFee = insureFee;
	}
	public double getFreight() {
		return freight;
	}
	public void setFreight(double freight) {
		this.freight = freight;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public boolean isComment() {
		return comment;
	}
	public void setComment(boolean comment) {
		this.comment = comment;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isPartnerOrder() {
		return partnerOrder;
	}
	public void setPartnerOrder(boolean partnerOrder) {
		this.partnerOrder = partnerOrder;
	}
	public String[] getPartnerLangs() {
		return partnerLangs;
	}
	public void setPartnerLangs(String[] partnerLangs) {
		this.partnerLangs = partnerLangs;
	}
	public String getAssistantName() {
		return assistantName;
	}
	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}
	public String getLangName() {
		return langName;
	}
	public void setLangName(String langName) {
		this.langName = langName;
	}
	public boolean isVipOrder() {
		return vipOrder;
	}
	public void setVipOrder(boolean vipOrder) {
		this.vipOrder = vipOrder;
	}
	public double getVipOrderAmount() {
		return vipOrderAmount;
	}
	public void setVipOrderAmount(double vipOrderAmount) {
		this.vipOrderAmount = vipOrderAmount;
	}
	public double getOutRangeAmount() {
		return outRangeAmount;
	}
	public void setOutRangeAmount(double outRangeAmount) {
		this.outRangeAmount = outRangeAmount;
	}
	public List<Integer> getVipIds() {
		return vipIds;
	}
	public void setVipIds(List<Integer> vipIds) {
		this.vipIds = vipIds;
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
	public double getDiscountInsuredFee() {
		return discountInsuredFee;
	}
	public void setDiscountInsuredFee(double discountInsuredFee) {
		this.discountInsuredFee = discountInsuredFee;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	public Integer getDiscountType() {
		return discountType;
	}
	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}
	public String getExpressDescribe() {
		return expressDescribe;
	}
	public void setExpressDescribe(String expressDescribe) {
		this.expressDescribe = expressDescribe;
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
	public Boolean getjIsOutRange() {
		return jIsOutRange;
	}
	public void setjIsOutRange(Boolean jIsOutRange) {
		this.jIsOutRange = jIsOutRange;
	}
	public Boolean getdIsOutRange() {
		return dIsOutRange;
	}
	public void setdIsOutRange(Boolean dIsOutRange) {
		this.dIsOutRange = dIsOutRange;
	}
	public boolean isCancelAble() {
		return cancelAble;
	}
	public void setCancelAble(boolean cancelAble) {
		this.cancelAble = cancelAble;
	}
	public Boolean getIsDrawedBill() {
		return isDrawedBill;
	}
	public void setIsDrawedBill(Boolean isDrawedBill) {
		this.isDrawedBill = isDrawedBill;
	}
	public Boolean getIsConfirmReceive() {
		return isConfirmReceive;
	}
	public void setIsConfirmReceive(Boolean isConfirmReceive) {
		this.isConfirmReceive = isConfirmReceive;
	}
	public Boolean getIsCurrent() {
		return isCurrent;
	}
	public void setIsCurrent(Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
    
}
