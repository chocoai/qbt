package com.qbt.web.pojo.bill;

import java.util.Date;

import com.qbt.persistent.entity.Bill;

public class BillVo {
	
	private int id;
	private Date createTime;//创建时间
    private Date updateTime;//创建时间
    private int userId;	// 用户ID
	private String orderId; //订单ID， 用逗号分隔开
	private double price; //金额
	private int status;	// 状态：1.已申请，2.已邮寄
	private int operater; // 财务ID
	private int content;	//发票内容：1.服务费
	private String number;	// 发票号
	private String remark;  //备注
	private String userName; //用户名
	private String orderNumber;  //订单号
	
	private int billType;
	private int orgType;
	private String title;
	private String email;
	private String name;
	private String telephone;
	private String address;
	
	private String taxFileNumber;
	private String bankNumber;	// 公司银行账号
	private String companyTelephone; //公司电话
	private String companyAddress;  //公司地址
	
	private String bank;  //开户行

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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	

}
