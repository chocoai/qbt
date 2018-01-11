package com.qbt.web.pojo.ticket;

import java.util.List;

public class TicketPackageOrderVo {
	int id;
	String activityName;
	// 礼包券活动的id
	int activityId;
	Integer type;
	String purchaser;
	String purchaserAddress;
	String purchaserNumber;
	Integer payStatus;
	String proxyUser;	
	Integer operatorId;
	String operatorName;
	Integer status;//(0 - inactive; 1 - active)
	List<TicketPackageVo> ticketPackageVos;

	public List<TicketPackageVo> getTicketPackageVos() {
		return ticketPackageVos;
	}

	public void setTicketPackageVos(List<TicketPackageVo> ticketPackageVos) {
		this.ticketPackageVos = ticketPackageVos;
	}
	
	
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public String getPurchaserAddress() {
		return purchaserAddress;
	}
	public void setPurchaserAddress(String purchaserAddress) {
		this.purchaserAddress = purchaserAddress;
	}
	public String getPurchaserNumber() {
		return purchaserNumber;
	}
	public void setPurchaserNumber(String purchaserNumber) {
		this.purchaserNumber = purchaserNumber;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public String getProxyUser() {
		return proxyUser;
	}
	public void setProxyUser(String proxyUser) {
		this.proxyUser = proxyUser;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
}
