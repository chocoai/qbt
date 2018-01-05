package com.qbt.web.pojo.airport;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseAirportVo {
	
	private int id;

	private Date createTime;

	@NotNull(message = "机场名称不能为空")
	private String name;
	
	@NotNull(message = "地区ID不能为空")
	private Integer areaId;
	
	private String treeId;
	
	private String treePath;

	private String address;

	private String contact;

	private String mobile;

	private String lon;

	private String lat;
	
	private Boolean isDelete;

	private String remark;
	
	//首字母
	private String firstLetter;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		this.name = name == null ? null : name.trim();
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath == null ? null : treePath.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact == null ? null : contact.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon == null ? null : lon.trim();
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat == null ? null : lat.trim();
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}
}