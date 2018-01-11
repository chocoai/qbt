package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BasePartner extends BaseEntity {

	private Integer partnerType;
	
	private String name;
	
	private Integer areaId;
	
	private String treePath;
	
	private String address;
	
	private String memo;
	
	private String contact;
	
	private String mobile;
	
	private String logo;
	
	private String website;
	
	private String lon;
	
	private String lat;
	
	private Boolean shareOrder;
	
	private Integer settleType;
	
	private Integer settleMode;
	
	private double settleModeValue;
	
	private Integer status;
	
	private Boolean isTicket;
	
	private String ticketMessage;

	public Integer getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public Boolean getShareOrder() {
		return shareOrder;
	}

	public void setShareOrder(Boolean shareOrder) {
		this.shareOrder = shareOrder;
	}

	public Integer getSettleType() {
		return settleType;
	}

	public void setSettleType(Integer settleType) {
		this.settleType = settleType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSettleMode() {
		return settleMode;
	}

	public void setSettleMode(Integer settleMode) {
		this.settleMode = settleMode;
	}

	public double getSettleModeValue() {
		return settleModeValue;
	}

	public void setSettleModeValue(double settleModeValue) {
		this.settleModeValue = settleModeValue;
	}

	public Boolean getIsTicket() {
		return isTicket;
	}

	public void setIsTicket(Boolean isTicket) {
		this.isTicket = isTicket;
	}

	public String getTicketMessage() {
		return ticketMessage;
	}

	public void setTicketMessage(String ticketMessage) {
		this.ticketMessage = ticketMessage;
	}

}
