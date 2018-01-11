package com.qbt.web.pojo.sysRole;

import java.util.List;

import javax.validation.constraints.NotNull;

public class AdminSysRoleVO  {
	
	private int id;
	
	@NotNull(message = "名称不能为空")
	private String name;
	
	private Integer platId;

	@NotNull(message = "资源不能为空")
	private List<Integer> resourceIdList;
	
	public List<Integer> getResourceIdList() {
		return resourceIdList;
	}

	public void setResourceIdList(List<Integer> resourceIdList) {
		this.resourceIdList = resourceIdList;
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

	public Integer getPlatId() {
		return platId;
	}

	public void setPlatId(Integer platId) {
		this.platId = platId;
	}

}
