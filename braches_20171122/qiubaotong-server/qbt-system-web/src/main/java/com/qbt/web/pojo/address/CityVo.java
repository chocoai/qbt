package com.qbt.web.pojo.address;


public class CityVo {
	
	//城市的id
	private Integer id;
	
	//城市名
	private String name;
	
	//Status is '1' : 热门城市 ; '2' :非热门
	private Integer status;
	
	//城市中球场数量
	private Integer courseAmount;
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCourseAmount() {
		return courseAmount;
	}

	public void setCourseAmount(Integer courseAmount) {
		this.courseAmount = courseAmount;
	}

	
	
}
