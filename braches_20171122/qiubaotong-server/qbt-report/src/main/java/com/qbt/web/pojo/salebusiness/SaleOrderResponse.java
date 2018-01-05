package com.qbt.web.pojo.salebusiness;

public class SaleOrderResponse {

	private String company; // 销售人员工作单位	
	private String idcard;	// 销售人员身份证
	private String mobile;	// 销售人员手机号
	private String name;    // 销售人名称	
	private String salesmanCode; // 销售人员号	
	private double totalAmount; // 总代下单提成金额
	private double  totalOrderAmount; //代下单订单总金额
	private int totalOrderNum; // 代下单订单数
	private int type; // 提成方式 1-固定金额 2-订单金额%
	private double  typeValue; // 提成方式值
	private Integer saleId;//销售人员ID
	
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
	public double getTotalOrderAmount() {
		return totalOrderAmount;
	}
	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}
	public int getTotalOrderNum() {
		return totalOrderNum;
	}
	public void setTotalOrderNum(int totalOrderNum) {
		this.totalOrderNum = totalOrderNum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getTypeValue() {
		return typeValue;
	}
	public void setTypeValue(double typeValue) {
		this.typeValue = typeValue;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	
}
