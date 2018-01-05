package com.qbt.persistent.mapper;

import java.util.List;
import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SysRole;

public interface SysRoleMapper {
	//增
    int insert(SysRole record);
    
    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysRole record);

	void delete(int id);
	
	List<SysRole> list();

	List<SysRole> findByPage(PageEntity<SysRole> pageEntity);

	List<SysRole> findByCondition(SysRole condition);

}