package com.qbt.persistent.entity;

public class CourseAddress {

	private int id;
	
	private int provinceId;
	
	private String courseName;
	
	private String provinceName;

	
	private String address;

	private double juli;

	private int areaId;

	
	private String wechatTip;
	
	private Boolean isOutRange;
    
    private Double outRangeTime;
    
    private Double outRangePrice;
    
    private Boolean isTip;

 
    

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getWechatTip() {
		return wechatTip;
	}

	public void setWechatTip(String wechatTip) {
		this.wechatTip = wechatTip;
	}

	public Boolean getIsOutRange() {
		return isOutRange;
	}

	public void setIsOutRange(Boolean isOutRange) {
		this.isOutRange = isOutRange;
	}

	public Double getOutRangeTime() {
		return outRangeTime;
	}

	public void setOutRangeTime(Double outRangeTime) {
		this.outRangeTime = outRangeTime;
	}

	public Double getOutRangePrice() {
		return outRangePrice;
	}

	public void setOutRangePrice(Double outRangePrice) {
		this.outRangePrice = outRangePrice;
	}

	public Boolean getIsTip() {
		return isTip;
	}

	public void setIsTip(Boolean isTip) {
		this.isTip = isTip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getJuli() {
		return juli;
	}

	public void setJuli(double juli) {
		this.juli = juli;
	}


	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	
	
	
}
