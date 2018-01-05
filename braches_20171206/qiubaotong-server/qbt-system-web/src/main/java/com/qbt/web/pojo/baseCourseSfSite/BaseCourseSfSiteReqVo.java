package com.qbt.web.pojo.baseCourseSfSite;

import com.qbt.common.result.Paging;

public class BaseCourseSfSiteReqVo extends Paging{
	
	//名称
	private String name;
	//详细地址
	private String address;
	//网点编号
	private String siteNumber;
	//联系人
	private String content;
	//联系人电话
	private String contentMobile;
	
	private int courseId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	

}
