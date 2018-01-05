package com.qbt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.persistent.entity.SysUser;

@Service
public interface SysUserService {
	
	public List<SysUser> list();

	public int insert(SysUser sysUser);

	public int delete(Integer id);

	public SysUser selectById(Integer id);
	
	public SysUser getUserByToken(String token);
	
	public List<SysUser> findByPage(PageEntity<SysUser> pageEntity);
	
	/**
	 * 检查用户token
	 * @param token
	 * @return
	 * @throws BusinessException
	 * @throws Exception
	 */
	public SysUser tokenCheck(String token);
	
	/**
	 * 后台用户登出
	 * @param token
	 */
	public void logout(String token);
	
	/**
	 * 后台用户登录
	 * @param mobile
	 * @param pwd
	 * @return
	 */
	public String login(Integer sysUserId);

	public List<SysUser> findByCondition(SysUser sysUser);
	
	int update(SysUser sysUser);

	public SysUser findByMobile(String mobile);

	public List<SysUser> listUserByRoleId(int roleId);

	public List<Integer> getPlatId(String mobile);

	
}
