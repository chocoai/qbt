package com.qbt.web.pojo.baseBank;

import javax.validation.constraints.NotNull;

public class BaseBankVo {
	
	private int id;
	
	 @NotNull(message = "名称不能为空")
	 private String name;
	 
	 @NotNull(message = "序号不能为空")
	 private String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
