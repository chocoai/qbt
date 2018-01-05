package com.qbt.persistent.dto;

import java.util.Date;

public class SaleSubcripbeInfoDto {
	private String company; // 销售人员工作单位	
	private String idcard;	// 销售人员身份证
	private String mobile;	// 销售人员手机号
	private String name;    // 销售人名称	
	private String salesmanCode; // 销售人员号	
	private double totalAmount; // 关注总金额
	private double  amount; // 关注奖金
	private int num; // 新拉用户数
	
    private Integer settleStatus;
    private Date startDate;
    private Date endDate;
    
    private Integer saleId;//销售人员ID
    
    private String queryDate;
	private String orderDate;
    
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalesmanCode() {
		return salesmanCode;
	}
	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Integer getSettleStatus() {
		return settleStatus;
	}
	public void setSettleStatus(Integer settleStatus) {
		this.settleStatus = settleStatus;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
    
}
