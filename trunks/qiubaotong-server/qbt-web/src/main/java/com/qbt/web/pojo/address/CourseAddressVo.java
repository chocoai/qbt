package com.qbt.web.pojo.address;


public class CourseAddressVo {
	
	private int id;//球场id
	
	private String name;//球场名字
	
	private double juli;//球场距离定位的距离
	
	private String juliStr;//球场距离定位的距离
	
	private int areaId;//区域的id
	
	private String address;//球场地址

	private int activityType;
	
	private String wechatTip;//微信贴士
	
	private Boolean isOutRange;//是否是偏远球场
    
    private Double outRangeTime;//离偏远球场时间
    
    private Double outRangePrice;//偏远球场需要的价格
    
    private Boolean isTip;//是否需要贴士
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getJuli() {
		return juli;
	}

	public void setJuli(double juli) {
		this.juli = juli;
	}


	public String getJuliStr() {
		return juliStr;
	}

	public void setJuliStr(String juliStr) {
		this.juliStr = juliStr;
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

	
	


	
}
