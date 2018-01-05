package com.qbt.web.pojo.baselink;

import java.util.Date;

public class BaseLinkVo {
	
	private int id;
	
	//名称
	private String name;
	//链接
	private String url;
	//创建时间
	private Date createTime;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	

}
