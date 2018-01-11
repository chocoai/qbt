package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.SysRoleResource;

public interface SysRoleResourceMapper {
    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

	void deleteByRoleId(Integer roleId);

	List<SysRoleResource> listById(int id);

}