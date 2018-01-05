package com.qbt.persistent.entity;

public class Province {
	
	private Integer id;
	
	private String name;
	
	private Integer status;
	
	private Integer courseAmount;
	
	private Integer sortNumber;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

}
