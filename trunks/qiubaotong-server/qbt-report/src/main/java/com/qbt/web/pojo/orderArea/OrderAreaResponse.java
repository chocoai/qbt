package com.qbt.web.pojo.orderArea;

public class OrderAreaResponse {
	
	//寄件地区ID
    private Integer jAreaId;
    
    //寄件地区中文路径
    private String jTreePath;
    
    //收件地区ID
    private Integer dAreaId;
    
    //收件地区中文路径
    private String dTreePath;
    
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
