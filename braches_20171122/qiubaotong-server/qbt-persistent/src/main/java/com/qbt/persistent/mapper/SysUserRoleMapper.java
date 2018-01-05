package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.SysUserRole;

public interface SysUserRoleMapper {
	
    int insert(SysUserRole sysUserRole);

	void deleteBySysUserId(int sysUserId);

	List<SysUserRole> findListBySysUserId(Integer userId);
//	List<SysUserRole> sysUserRoleMapper(Integer sysUserId);
	
	List<SysUserRole> findRoleListBySysUserId(@Param("platId")Integer platId, @Param("userId")Integer userId);

}