package com.qbt.web.pojo.basePartner;

import com.qbt.common.result.Paging;

public class BasePartnerPageReqVo extends Paging {

	private String name;
	
	private Integer areaId;
	
	private Boolean shareOrder;
	
	private Integer settleType;
	
	private Integer status;
	
	private Boolean isTicket;

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

	public Boolean getIsTicket() {
		return isTicket;
	}

	public void setIsTicket(Boolean isTicket) {
		this.isTicket = isTicket;
	}

}
