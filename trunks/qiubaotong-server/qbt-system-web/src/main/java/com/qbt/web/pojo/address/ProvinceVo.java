package com.qbt.web.pojo.address;

public class ProvinceVo {
	//table : province
	
	
	//省份id
	private Integer id;
	
	//省份名称
	private String name;
	
	//1: active 正使用; 2:inactive 禁用
	private Integer status;
	
	//省份球场数量
	private Integer courseAmount;
	
	//排序号
	private Integer sortNumber;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseAmount() {
		return courseAmount;
	}

	public void setCourseAmount(Integer courseAmount) {
		this.courseAmount = courseAmount;
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

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}
	
	
}
