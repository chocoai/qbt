package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.SysUserRole;
import com.qbt.persistent.mapper.SysUserRoleMapper;
import com.qbt.service.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{
	@Resource
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public void insert(SysUserRole sysUserRole) {
		// TODO Auto-generated method stub
		sysUserRoleMapper.insert(sysUserRole);
	}

	@Override
	public void deleteBySysUserId(int sysUserId) {
		// TODO Auto-generated method stub
		sysUserRoleMapper.deleteBySysUserId(sysUserId);
	}

	@Override
	public List<SysUserRole> findListBySysUserId(Integer userId) {
		// TODO Auto-generated method stub
		return sysUserRoleMapper.findListBySysUserId(userId);
		//return sysUserRoleMapper.sysUserRoleMapper(sysUserId);
	}

	@Override
	public List<SysUserRole> sysRolelistByUserId(Integer platId, int userId) {
		// TODO Auto-generated method stub
		return sysUserRoleMapper.findRoleListBySysUserId(platId, userId);
	}


}
