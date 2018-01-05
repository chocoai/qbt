package com.qbt.web.pojo.assistant;

import com.qbt.common.result.Paging;

public class UserAssistantPageReqVo extends Paging{
	
    private String siteName;
    
    private String name;
    
    private String mobile;
    
    private Integer siteId;
    
    private Integer status;
    
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
