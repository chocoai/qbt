package com.qbt.web.pojo.orderChangeBook;

import java.util.Date;

public class OrderChangeBookVo {
	
	private Integer orderId;
	
    private String newOrderNumber;
	
	private String oldOrderNumber;
	
	private String newMailNo;
	
	private String oldMailNo;
	
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNewOrderNumber() {
		return newOrderNumber;
	}

	public void setNewOrderNumber(String newOrderNumber) {
		this.newOrderNumber = newOrderNumber;
	}

	public String getOldOrderNumber() {
		return oldOrderNumber;
	}

	public void setOldOrderNumber(String oldOrderNumber) {
		this.oldOrderNumber = oldOrderNumber;
	}

	public String getNewMailNo() {
		return newMailNo;
	}

	public void setNewMailNo(String newMailNo) {
		this.newMailNo = newMailNo;
	}

	public String getOldMailNo() {
		return oldMailNo;
	}

	public void setOldMailNo(String oldMailNo) {
		this.oldMailNo = oldMailNo;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
	
}
