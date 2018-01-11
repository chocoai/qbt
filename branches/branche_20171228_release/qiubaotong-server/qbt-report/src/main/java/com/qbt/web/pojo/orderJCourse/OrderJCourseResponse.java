package com.qbt.web.pojo.orderJCourse;

public class OrderJCourseResponse {
	
	//寄件人手机号
	private String jMobile;
	
	//寄件人姓名
	private String jContact;
    
	//寄件非个人地址ID，个人地址为0
    private Integer jAddrId;
    
    //寄件地址名称，如果个人地址为空
    private String jAddrName;
    
    //收件非个人地址ID，个人地址为0
    private Integer dAddrId;
    
    //收件地址名称，如果个人地址为空
    private String dAddrName;
    
    //总订单数
    private Integer totalOrder;
	
    //有效订单数
	private Integer validOrder;
	
	//取消订单数
	private Integer cancelOrder;
	
	//总金额
	private Double totalAmount;
	
	//有效金额
	private Double validAmount;
	
	//退款金额
	private Double cancelAmount;

	public String getjMobile() {
		return jMobile;
	}

	public void setjMobile(String jMobile) {
		this.jMobile = jMobile;
	}

	public String getjContact() {
		return jContact;
	}

	public void setjContact(String jContact) {
		this.jContact = jContact;
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
