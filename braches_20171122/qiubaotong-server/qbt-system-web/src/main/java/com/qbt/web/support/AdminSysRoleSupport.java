package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.persistent.entity.SysRole;
import com.qbt.persistent.entity.SysUserRole;
import com.qbt.web.pojo.sysRole.AdminSysRoleVO;
import com.qbt.web.pojo.sysRole.SysRolePageReqVo;

public interface AdminSysRoleSupport {
	
	public List<AdminSysRoleVO> list();

	public void insert(AdminSysRoleVO adminSysRoleVO) throws BusinessException;
	
	public void delete(Integer id);

	public void update(AdminSysRoleVO vo);

	public List<AdminSysRoleVO> findByPage(SysRolePageReqVo reqVo);

	public List<SysUserRole> sysUserRolelistByUserId(Integer userId);

	public List<SysRole> sysRolelistByUserId(Integer platId, int userId);

}
