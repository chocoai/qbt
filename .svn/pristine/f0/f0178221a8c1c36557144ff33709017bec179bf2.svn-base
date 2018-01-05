package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SysRole;
import com.qbt.persistent.mapper.SysRoleMapper;
import com.qbt.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Resource
	private SysRoleMapper sysRoleMapper; 
	
	@Override
	public void insert(SysRole syUserRole) {
		// TODO Auto-generated method stub
		sysRoleMapper.insert(syUserRole);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sysRoleMapper.delete(id);
	}

	@Override
	public void update(SysRole sysRole) {
		// TODO Auto-generated method stub
		sysRoleMapper.updateByPrimaryKey(sysRole);
	}

	@Override
	public List<SysRole> list() {
		// TODO Auto-generated method stub
		return sysRoleMapper.list();
	}

	@Override
	public SysRole get(Integer id) {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysRole> findByPage(PageEntity<SysRole> pageEntity) {
		// TODO Auto-generated method stub
		return sysRoleMapper.findByPage(pageEntity);
	}

	@Override
	public List<SysRole> findByCondition(SysRole condition) {
		// TODO Auto-generated method stub
		return sysRoleMapper.findByCondition(condition);
	}

}
