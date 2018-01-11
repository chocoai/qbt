package com.qbt.web.pojo.ticket;

import java.util.Date;
import java.util.List;

public class UserActivityPackageVo {
	int id;
	int userId;
	int orderId;
	int orderDetailId;
	Integer status;//(0 - inactive; 1 - active)
	int operatorId;
	String operatorName;
	List<UserPackageTicketVo> ticketVos;
	Date expirationTime;
	String activityName;
	float price;
	int effectiveDay;
	int packageType;
	Date activateTime;
	int expirationStatus;//(0 - 没有过期,1 - 过期了)
	int used_status;//(0 - 该券包下的所有券还没有使用完,1 - 该券包下的所有券已使用完)
	String code;
	String qrCode;
	Date creatTime;
	Date updateTime;
	
	public List<UserPackageTicketVo> getTicketVos() {
		return ticketVos;
	}
	public void setTicketVos(List<UserPackageTicketVo> ticketVos) {
		this.ticketVos = ticketVos;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getEffectiveDay() {
		return effectiveDay;
	}
	public void setEffectiveDay(int effectiveDay) {
		this.effectiveDay = effectiveDay;
	}
	public int getPackageType() {
		return packageType;
	}
	public void setPackageType(int packageType) {
		this.packageType = packageType;
	}
	public Date getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	public Date getActivateTime() {
		return activateTime;
	}
	public void setActivateTime(Date activateTime) {
		this.activateTime = activateTime;
	}
	public int getExpirationStatus() {
		return expirationStatus;
	}
	public void setExpirationStatus(int expirationStatus) {
		this.expirationStatus = expirationStatus;
	}
	public int getUsed_status() {
		return used_status;
	}
	public void setUsed_status(int used_status) {
		this.used_status = used_status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
