package com.qbt.web.pojo.orderSite;

public class OrderSiteResponse {

	// 寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-地域
	private Integer jAddrType;

	// 寄件非个人地址ID，个人地址为0
	private Integer jAddrId;

	// 寄件地址名称，如果个人地址为空
	private String jAddrName;

	// 寄件人地区ID
	private Integer jAreaId;

	// 寄件人地区中文路径
	private String jTreePath;

	// 收件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
	private Integer dAddrType;

	// 收件非个人地址ID，个人地址为0
	private Integer dAddrId;

	// 收件地址名称，如果个人地址为空
	private String dAddrName;

	// 收件人地区ID
	private Integer dAreaId;

	// 收件人地区中文路径
	private String dTreePath;

	// 总订单数
	private Integer totalOrder;

	// 有效订单数
	private Integer validOrder;

	// 取消订单数
	private Integer cancelOrder;

	// 总金额
	private Double totalAmount;

	// 有效金额
	private Double validAmount;

	// 退款金额
	private Double cancelAmount;

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

	public Integer getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(Integer totalOrder) {
		this.totalOrder = totalOrder;
	}

	public Integer getValidOrder() {
		return validOrder;
	}

	public void setValidOrder(Integer validOrder) {
		this.validOrder = validOrder;
	}

	public Integer getCancelOrder() {
		return cancelOrder;
	}

	public void setCancelOrder(Integer cancelOrder) {
		this.cancelOrder = cancelOrder;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getValidAmount() {
		return validAmount;
	}

	public void setValidAmount(Double validAmount) {
		this.validAmount = validAmount;
	}

	public Double getCancelAmount() {
		return cancelAmount;
	}

	public void setCancelAmount(Double cancelAmount) {
		this.cancelAmount = cancelAmount;
	}
	
}
