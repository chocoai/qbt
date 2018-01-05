package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.SysRoleResource;
import com.qbt.persistent.mapper.SysRoleResourceMapper;
import com.qbt.service.SysRoleResourceService;
@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService{

	@Resource
	private SysRoleResourceMapper sysRoleResourceMapper; 
	
	@Override
	public void insert(SysRoleResource sysRoleResouece) {
		// TODO Auto-generated method stub
		sysRoleResourceMapper.insert(sysRoleResouece);
	}

	@Override
	public void deleteByRoleId(Integer id) {
		sysRoleResourceMapper.deleteByRoleId(id);
	}

	@Override
	public List<SysRoleResource> listById(int id) {
		// TODO Auto-generated method stub
		return sysRoleResourceMapper.listById(id);
	}
	
}
