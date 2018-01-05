package com.qbt.web.pojo.baseNews;

import java.util.Date;

import com.qbt.common.result.Paging;

public class BaseNewsPageReqVo extends Paging {

	//标题
	private String title;
	
	//发布时间
	private Date createTime;
	
	//关键字
	private String keyword;
	
	//类型id
	private Integer categoryId;
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
