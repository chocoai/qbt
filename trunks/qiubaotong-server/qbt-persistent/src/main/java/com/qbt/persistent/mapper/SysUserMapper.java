package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SysUser;

public interface SysUserMapper {
    int insert(SysUser record);

    SysUser selectById(Integer id);

    int updateById(SysUser record);

    List<SysUser> list();

	int delete(Integer id);

	List<SysUser> findByPage(PageEntity<SysUser> pageEntity);

	SysUser findByMobile(@Param("mobile")String mobile);

	List<SysUser> findByCondition(SysUser sysUser);

	List<SysUser> listUserByRoleId(int roleId);

	List<Integer> getPlatId(String mobile);
	
}