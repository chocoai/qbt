package com.qbt.persistent.dto;

public class OrderPageDto {

	private int applyId;
	
	private int userId;
	
	private boolean shareOrder;
	
	private int pageNo;
	
	private int pageSize;
	
	private int fromIndex;
	
	private int lastRecordId;
	
	private int orderStatus;//1-待支付 2-运输中 3-已签收
	
	private int thirdType; 
	
	private int type; // 1-个人机构订单。2-机构订单
	
	private Integer proxyUserId;
	
	private int lastRownum;

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isShareOrder() {
		return shareOrder;
	}

	public void setShareOrder(boolean shareOrder) {
		this.shareOrder = shareOrder;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getLastRecordId() {
		return lastRecordId;
	}

	public void setLastRecordId(int lastRecordId) {
		this.lastRecordId = lastRecordId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getThirdType() {
		return thirdType;
	}

	public void setThirdType(int thirdType) {
		this.thirdType = thirdType;
	}

	public int getFromIndex() {
		return fromIndex;
	}

	public void setFromIndex(int fromIndex) {
		this.fromIndex = fromIndex;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getProxyUserId() {
		return proxyUserId;
	}

	public void setProxyUserId(Integer proxyUserId) {
		this.proxyUserId = proxyUserId;
	}

	public int getLastRownum() {
		return lastRownum;
	}

	public void setLastRownum(int lastRownum) {
		this.lastRownum = lastRownum;
	}

}
