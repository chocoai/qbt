package com.qbt.web.pojo.address;

public class CityVo {
	
	private Integer id;
	
	private String name;
	
	//Status is '1' : active ; '2' :inactive
	private Integer status;
	
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


}
