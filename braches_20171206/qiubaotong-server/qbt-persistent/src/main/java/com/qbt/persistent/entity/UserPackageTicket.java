package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

/**
 * 礼品券
 * @author feng.xuan
 *
 */
public class UserPackageTicket extends BaseEntity {
	int id;
	Integer packageId; //券包id
	Integer orderDetailId;
	Integer ticketPrice;
	String ticketName;		
	Integer quantity;
	Integer usedQuantity;
	Integer useLimit;
	Integer useStatus;
	int userId;
	Date expirationTime;
	int effectiveDay;
	Date activateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public Integer getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getUsedQuantity() {
		return usedQuantity;
	}
	public void setUsedQuantity(Integer usedQuantity) {
		this.usedQuantity = usedQuantity;
	}
	public Integer getUseLimit() {
		return useLimit;
	}
	public void setUseLimit(Integer useLimit) {
		this.useLimit = useLimit;
	}
	public Integer getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	public int getEffectiveDay() {
		return effectiveDay;
	}
	public void setEffectiveDay(int effectiveDay) {
		this.effectiveDay = effectiveDay;
	}
	public Date getActivateTime() {
		return activateTime;
	}
	public void setActivateTime(Date activateTime) {
		this.activateTime = activateTime;
	}

}
