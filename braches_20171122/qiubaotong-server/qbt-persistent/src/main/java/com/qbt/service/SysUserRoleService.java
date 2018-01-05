package com.qbt.service;



import java.util.List;

import com.qbt.persistent.entity.SysUserRole;

public interface SysUserRoleService {
	
	public void insert(SysUserRole sysUserRole);

	public void deleteBySysUserId(int sysUserId);

	public List<SysUserRole> findListBySysUserId(Integer userId);

	public List<SysUserRole> sysRolelistByUserId(Integer platId, int userId);

}
