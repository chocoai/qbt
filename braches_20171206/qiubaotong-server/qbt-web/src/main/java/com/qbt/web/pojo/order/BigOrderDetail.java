package com.qbt.web.pojo.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BigOrderDetail {
	private int id;
	// 下单时间
	private long createTime;
	
	private String number;
	
	private String subNumber;

    private Date payTime;

    private Integer payMethod;

    private Integer payStatus;

    private Integer orderStatus;

    private int quantity;

    private String assistantName;
    
    private Integer jAddrType;
    
    private String jAddrName;

    private String jContact;

    private String jMobile;

    private String jTreePath;
    
    private Integer dAddrType;
    
    private String dAddrName;

    private String dContact;

    private String dMobile;

    private String dTreePath;
    
    private double amount;
    
    private Integer busnissType;
    // 顺丰预计到到达时间
    private String deliverTime;
    // 预约寄件时间
    private String sendTimeSection;
    // 保价金额
    private double insureValue;
    // 保价费
    private double insureFee;
    
    private double discount;
    // 偏远价格
    private double outRangeAmount;
    // vip订单金额
    private double vipOrderAmount;
    // 订单原金额
    private double totalAmount;
    
    private Boolean jActivity = false;
	
	private Boolean dActivity = false;
    
    // 子订单号集
 	private List<String> numbers = new ArrayList<String>();
    
	// 打球时间
    private String playTime;
    
    // 顺丰时效描述
    private String expressDescribe;
    
    //偏远类型 0-非偏远 1-球场 4-地区
    private Integer jOutRangeType;
    
    //收件偏远类型 0-非偏远 1-球场 4-地区
    private Integer dOutRangeType;
 	
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSubNumber() {
		return subNumber;
	}

	public void setSubNumber(String subNumber) {
		this.subNumber = subNumber;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
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

	public String getjTreePath() {
		return jTreePath;
	}

	public void setjTreePath(String jTreePath) {
		this.jTreePath = jTreePath;
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

	public String getdTreePath() {
		return dTreePath;
	}

	public void setdTreePath(String dTreePath) {
		this.dTreePath = dTreePath;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getBusnissType() {
		return busnissType;
	}

	public void setBusnissType(Integer busnissType) {
		this.busnissType = busnissType;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getOutRangeAmount() {
		return outRangeAmount;
	}

	public void setOutRangeAmount(double outRangeAmount) {
		this.outRangeAmount = outRangeAmount;
	}

	public double getVipOrderAmount() {
		return vipOrderAmount;
	}

	public void setVipOrderAmount(double vipOrderAmount) {
		this.vipOrderAmount = vipOrderAmount;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

	public Boolean getjActivity() {
		return jActivity;
	}

	public void setjActivity(Boolean jActivity) {
		this.jActivity = jActivity;
	}

	public Boolean getdActivity() {
		return dActivity;
	}

	public void setdActivity(Boolean dActivity) {
		this.dActivity = dActivity;
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
    
}
