package com.qbt.web.pojo.baselink;

import java.util.Date;

import com.qbt.common.result.Paging;

public class BaseLinkPageReqVo extends Paging{
	
	private String name;
	
	private String url;
	
	private Date createTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
