package com.qbt.web.pojo.basePartner;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.qbt.persistent.entity.BaseSettmtAmountConfig;

public class BasePartnerVO {
	
	private int id;
	
	@NotNull(message = "旅行社类型不能为空")
	private Integer partnerType;
	
	private Date createTime;
	
	@NotNull(message = "名称不能为空")
	private String name;
	
	@NotNull(message = "地区不能为空")
	private Integer areaId;
	
	@NotNull(message = "地区中文路径不能为空")
	private String treePath;
	
	@NotNull(message = "地址不能为空")
	private String address;
	
	private String memo;
	
	@NotNull(message = "联系人不能为空")
	private String contact;
	
	@NotNull(message = "联系人手机不能为空")
	private String mobile;
	
	@NotNull(message = "logo不能为空")
	private String logo;
	
	@NotNull(message = "网址不能为空")
	private String website;
	
	private String lon;
	
	private String lat;
	
	@NotNull(message = "是否共享订单不能为空")
	private Boolean shareOrder;
	
	@NotNull(message = "结算模式不能为空")
	private Integer settleType;
	
	@NotNull(message = "比例模式不能为空")
	private Integer settleMode;
	
	@NotNull(message = "比例模式结果值不能为空")
	private Double settleModeValue;
	
	private Integer status;
	
	private String treeId;
	
	//是否开票
	private Boolean isTicket;
	
	//开票信息
	private String ticketMessage;
	
	@NotNull(message = "合作社语言不能为空")
	private List<Integer> languageIdList;
	
	private List<BaseSettmtAmountConfig> bsacList;
	
	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Double getSettleModeValue() {
		return settleModeValue;
	}

	public void setSettleModeValue(Double settleModeValue) {
		this.settleModeValue = settleModeValue;
	}

	public List<Integer> getLanguageIdList() {
		return languageIdList;
	}

	public void setLanguageIdList(List<Integer> languageIdList) {
		this.languageIdList = languageIdList;
	}

	public List<BaseSettmtAmountConfig> getBsacList() {
		return bsacList;
	}

	public void setBsacList(List<BaseSettmtAmountConfig> bsacList) {
		this.bsacList = bsacList;
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
