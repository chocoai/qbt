package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.SysRoleResource;
import com.qbt.service.SysRoleResourceService;
import com.qbt.web.support.SysRoleResourceSupport;

@Service
public class SysRoleResourceSupportImpl implements SysRoleResourceSupport{

	@Resource
	private SysRoleResourceService sysRoleResourceService;
	
	@Override
	public List<SysRoleResource> listByRoleId(int roleId) {
		return sysRoleResourceService.listById(roleId);
	}

}
