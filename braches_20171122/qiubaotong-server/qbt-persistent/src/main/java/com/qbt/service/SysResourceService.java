package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SysResource;

public interface SysResourceService {

	List<SysResource> list();

	public List<SysResource> getSysResourceListById(Integer id);

	void delete(Integer id);

	void intsert(SysResource sysRecource);

	SysResource get(int id);

	void update(SysResource sysResource);

	List<SysResource> findByPage(PageEntity<SysResource> pageEntity);

	List<SysResource> findByCondition(SysResource condition);

	List<SysResource> listByUserId(Integer userId, Integer platId);


	
}
