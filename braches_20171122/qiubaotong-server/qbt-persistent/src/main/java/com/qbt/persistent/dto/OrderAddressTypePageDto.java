/**
 * Project Name:qbt-persistent
 * File Name:OrderAddressTypePageDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年3月13日下午2:05:10
 *
*/

package com.qbt.persistent.dto;

import java.util.Date;

/**
 * ClassName:OrderAddressTypePageDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月13日 下午2:05:10
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderAddressTypePageDto {
	
	private int userId;
	private int addrType;
	private int countryAreaId;
	private String countryAreaName;
	private int provinceAreaId;
	private String provinceAreaName;
	private int cityAreaId;
	private String cityAreaName;
	private int districtAreaId;
	private String districtAreaName;
	private String treePath;
	private int addrId;
	private String addrName;
	private String address;
	private String contact;
	private String mobile;
	private int orderCount;
	
	private Date startOrderTime;
	private Date endOrderTime;
	private int type;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAddrType() {
		return addrType;
	}
	public void setAddrType(int addrType) {
		this.addrType = addrType;
	}
	public int getCountryAreaId() {
		return countryAreaId;
	}
	public void setCountryAreaId(int countryAreaId) {
		this.countryAreaId = countryAreaId;
	}
	public String getCountryAreaName() {
		return countryAreaName;
	}
	public void setCountryAreaName(String countryAreaName) {
		this.countryAreaName = countryAreaName;
	}
	public int getProvinceAreaId() {
		return provinceAreaId;
	}
	public void setProvinceAreaId(int provinceAreaId) {
		this.provinceAreaId = provinceAreaId;
	}
	public String getProvinceAreaName() {
		return provinceAreaName;
	}
	public void setProvinceAreaName(String provinceAreaName) {
		this.provinceAreaName = provinceAreaName;
	}
	public int getCityAreaId() {
		return cityAreaId;
	}
	public void setCityAreaId(int cityAreaId) {
		this.cityAreaId = cityAreaId;
	}
	public String getCityAreaName() {
		return cityAreaName;
	}
	public void setCityAreaName(String cityAreaName) {
		this.cityAreaName = cityAreaName;
	}
	public int getDistrictAreaId() {
		return districtAreaId;
	}
	public void setDistrictAreaId(int districtAreaId) {
		this.districtAreaId = districtAreaId;
	}
	public String getDistrictAreaName() {
		return districtAreaName;
	}
	public void setDistrictAreaName(String districtAreaName) {
		this.districtAreaName = districtAreaName;
	}
	public String getTreePath() {
		return treePath;
	}
	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	public String getAddrName() {
		return addrName;
	}
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public Date getStartOrderTime() {
		return startOrderTime;
	}
	public void setStartOrderTime(Date startOrderTime) {
		this.startOrderTime = startOrderTime;
	}
	public Date getEndOrderTime() {
		return endOrderTime;
	}
	public void setEndOrderTime(Date endOrderTime) {
		this.endOrderTime = endOrderTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
