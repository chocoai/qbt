package com.qbt.persistent.entity;

import java.io.Serializable;
import java.util.Date;


public class Bill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7145674662866435173L;

	/**
	 * 数据ID，不需要主动维护
	 */
	private int id;
	
	/**
	 * 数据创建时间，不需要主动维护
	 */
	private Date createTime = new Date();
	
	private Date updateTime ;
	
	private int userId;	// 用户ID
	private String orderId; //订单ID， 用逗号分隔开
	private double price; //金额
	private int status;	// 状态：1.已申请，2.已邮寄
	private int operater; // 财务ID
	private int addressId; // 发票地址Id
	private int content;	//发票内容：1.服务费
	private String number;	// 发票号
	private String remark;  //备注
	private String userName; //用户名
	private String orderNumber;  //订单号
	
	private int billType; // 发票类型：1,电子；2，纸质
	private int orgType;	//组织类型：1.个人；2.  公司
	private String title;	//抬头
	private String email;	// 电子邮箱
	private String name;	// 收件人姓名
	private String telephone; //收件人电话
	private String address;		//收件人地址
	
	private String taxFileNumber; // 公司税号
	private String bankNumber;	// 公司银行账号
	private String companyTelephone; //公司电话
	private String companyAddress;  //公司地址
	private String operaterName;  // 操作人姓名
	private String bank;  //开户行
	
	private String startTime;
	private String endTime;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOperater() {
		return operater;
	}
	public void setOperater(int operater) {
		this.operater = operater;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getBillType() {
		return billType;
	}
	public void setBillType(int billType) {
		this.billType = billType;
	}
	public int getOrgType() {
		return orgType;
	}
	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTaxFileNumber() {
		return taxFileNumber;
	}
	public void setTaxFileNumber(String taxFileNumber) {
		this.taxFileNumber = taxFileNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	public String getCompanyTelephone() {
		return companyTelephone;
	}
	public void setCompanyTelephone(String companyTelephone) {
		this.companyTelephone = companyTelephone;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getOperaterName() {
		return operaterName;
	}
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
}
