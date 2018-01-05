package com.qbt.web.pojo.baseAdv;

import java.util.Date;

public class BaseAdvVo {

	private int id;
	
	//图片名称
	private String name;
	
	//图片内容
	private String image;
	
	//广告链接
	private String url;
	
	//类型（微信：wx，pc：pc）
	private String type;
	
	//位置（首页：home，设置：set，球场：course）
	private String position;
	
	//顺序（1,2,3.........）
	private Integer number;
	
	private Date createTime;

	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	
	
	
}
