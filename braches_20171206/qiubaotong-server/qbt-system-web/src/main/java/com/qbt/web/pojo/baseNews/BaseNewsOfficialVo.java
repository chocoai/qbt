package com.qbt.web.pojo.baseNews;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseNewsOfficialVo {
	
	//id
	private int id;
	
	//新闻图片
	@NotNull(message = "新闻图片不能为空")
	private String imgUrl; 
	
	//标题
	@NotNull(message = "标题不能为空")
	private String title;
	
	//发布时间
	private Date createTime;
	
	//阅读次数
	private Integer readTimes;
	
	//概要
	@NotNull(message = "概要不能为空")
	private String outline;
	
	//类型id
	private Integer categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public Integer getReadTimes() {
		return readTimes;
	}

	public void setReadTimes(Integer readTimes) {
		this.readTimes = readTimes;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
}
