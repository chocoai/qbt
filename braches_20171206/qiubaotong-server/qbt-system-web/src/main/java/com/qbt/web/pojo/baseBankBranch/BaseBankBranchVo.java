package com.qbt.web.pojo.baseBankBranch;

import javax.validation.constraints.NotNull;

public class BaseBankBranchVo {
	private int id;
	
	@NotNull(message = "网点名称不能为空")
	private String name;
	
	@NotNull(message = "地区ID不能为空")
	private Integer areaId;
	
	private String treeId;
	
	private String treePath;
	 
	private String contact;
	 
	private String mobile;
	
	@NotNull(message = "详细地址不能为空")
	private String address;
	
	@NotNull(message = "经度不能为空")
	private String lon;
	
	@NotNull(message = "纬度度不能为空")
    private String lat;
	
	private Boolean isDelete;
	
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		this.treePath = treePath;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
}
