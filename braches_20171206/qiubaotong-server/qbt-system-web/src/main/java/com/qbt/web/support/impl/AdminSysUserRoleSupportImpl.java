package com.qbt.web.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.SysUserRole;
import com.qbt.service.SysUserRoleService;
import com.qbt.web.support.AdminSysUserRoleSupport;
@Service
public class AdminSysUserRoleSupportImpl implements AdminSysUserRoleSupport {
	
	@Resource
	private SysUserRoleService sysUserRoleService;
	
	@Override
	public void insert(SysUserRole sysUserRole) {
		// TODO Auto-generated method stub
		sysUserRoleService.insert(sysUserRole);
	}

}
