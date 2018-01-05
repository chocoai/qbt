package com.qbt.web.pojo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *  地址管理
 * @author share
 *
 */
public class Address {

	private int id;
	
	private int userId;
	
	private int areaId;
	@NotNull(message = "地址不能为空")
	private String address;
	@NotNull(message = "手机号不能为空")
//	@Pattern(regexp = "(^(0[0-9]{2,3}-?)?[0-9]{7,8}$)|(^1[\\d]{10}$)", message = "手机号或座机号格式不正确")
	private String mobile;
	@NotNull(message = "名字不能为空")
	private String name;
	
	private String cityName;
	
	private boolean def;
	
	private Boolean isOutRange = false;
	
	//1-家 2-公司 3-其他
	private Integer labelType = 3;
	
	private String treeId;
	
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
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public boolean isDef() {
		return def;
	}
	public void setDef(boolean def) {
		this.def = def;
	}
	public Integer getLabelType() {
		return labelType;
	}
	public void setLabelType(Integer labelType) {
		this.labelType = labelType;
	}
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	public Boolean getIsOutRange() {
		return isOutRange;
	}
	public void setIsOutRange(Boolean isOutRange) {
		this.isOutRange = isOutRange;
	}
	
	
	
}
