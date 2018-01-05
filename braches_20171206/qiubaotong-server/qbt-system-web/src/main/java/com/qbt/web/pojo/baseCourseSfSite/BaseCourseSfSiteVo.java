package com.qbt.web.pojo.baseCourseSfSite;

import java.util.Date;

public class BaseCourseSfSiteVo {

	private int id;
	//创建时间
	private Date createTime;
	//名称
	private String name;
	//球场id
	private int courseId;
	//地区id
	private int areaId;
	//省市区
	private String treePath;
	//treeId
	private String treeId;
	//详细地址
	private String address;
	//网点编号
	private String siteNumber;
	//联系人
	private String content;
	//联系人电话
	private String contentMobile;
	
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getTreePath() {
		return treePath;
	}
	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSiteNumber() {
		return siteNumber;
	}
	public void setSiteNumber(String siteNumber) {
		this.siteNumber = siteNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentMobile() {
		return contentMobile;
	}
	public void setContentMobile(String contentMobile) {
		this.contentMobile = contentMobile;
	}
	
	
	
}
