package com.qbt.web.pojo.course;

import java.util.Date;

public class CoursePageRespVo {
	
	//id
	private int id;
	
	//创建时间
	private Date createTime;
	
	//球场名称
	private String name;
	
	//地区id
	private Integer areaId;
	
	//地区路径
    private String treePath;
	
    //球场状态：1-已签约 2-未签约但可接受球包通球包 3-不接受球包通球包 4-未知状态
    private Integer status;
    
    //联系人
    private String contact;
    
    //电话
    private String mobile;
    
    //是否删除
    private Boolean isDelete;
    
	//是否有助理
    private Boolean hasAssistant;
    
	// 是否偏远球场
	private Boolean isOutRange;

	// 偏远球场时效(小时)
	private Double outRangeTime;

	// 偏远球场价格
	private Double outRangePrice;
	
	//地址
    private String address;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getHasAssistant() {
		return hasAssistant;
	}

	public void setHasAssistant(Boolean hasAssistant) {
		this.hasAssistant = hasAssistant;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}
