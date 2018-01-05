package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.SysRoleResource;

public interface SysRoleResourceService {
	
	public void insert(SysRoleResource sysRoleResouece);

	public void deleteByRoleId(Integer id);

	public List<SysRoleResource> listById(int id);
}
