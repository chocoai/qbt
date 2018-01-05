package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.persistent.entity.SysPlat;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.sysRole.AdminSysRoleVO;
import com.qbt.web.pojo.sysuser.AdminSysUserVO;
import com.qbt.web.pojo.sysuser.AdminUserPageReqVo;
import com.qbt.web.pojo.sysuser.UserPassVo;

public interface AdminSysUserSupport {
	
	public List<AdminSysUserVO> list();

	public int insert(AdminSysUserVO adminSysUserVO) throws BusinessException ;

	public void delete(Integer id);

	public void update(AdminSysUserVO adminSysUserVO);

	public List<AdminSysUserVO> findByPage(AdminUserPageReqVo reqVo);

	public List<AdminSysRoleVO> findRoleListById(Integer id);

	public List<SysPlat> findPlatListById(Integer id);

	public AdminSysUserVO findById(Integer id);

	public boolean updatePasswod(UserPassVo vo, SysUser sysUser) throws Exception ;

	public boolean resetPwdByUserId(Integer userId);

	public List<AdminSysUserVO> listUserByRoleId(int roleId);
}
