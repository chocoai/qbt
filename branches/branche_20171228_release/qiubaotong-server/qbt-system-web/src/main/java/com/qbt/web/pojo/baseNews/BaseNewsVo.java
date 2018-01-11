package com.qbt.web.pojo.baseNews;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseNewsVo {
	
	//id
	private int id;
	
	//1-新闻
	@NotNull(message = "类型不能为空")
	private Integer type;
	
	//标题
	@NotNull(message = "标题不能为空")
	private String title;
	
	//新闻图片
	@NotNull(message = "新闻图片不能为空")
	private String imgUrl; 
	
	//概要
	@NotNull(message = "概要不能为空")
	private String outline;
	
	//内容
	@NotNull(message = "内容不能为空")
	private String content;
	
	//发布时间
	private Date createTime;
	
	//阅读次数
	private Integer readTimes;
	
	//显示状态（1-有效 2-无效）
	private Integer status;
	
	//关键字
	private String keyword;
	
	//分类id
	private Integer categoryId;
	
	//分类名称
	private String categoryName;
	

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
