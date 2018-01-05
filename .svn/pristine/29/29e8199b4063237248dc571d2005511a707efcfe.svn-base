package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SysResource;
import com.qbt.persistent.mapper.SysResourceMapper;
import com.qbt.service.SysResourceService;
@Service
public class SysResourceServiceImpl implements SysResourceService {

	@Resource
	private SysResourceMapper sysResourceMapper;
	
	@Override
	public List<SysResource> list() {
		// TODO Auto-generated method stub
		return sysResourceMapper.list();
	}

	@Override
	public List<SysResource> getSysResourceListById(Integer id) {
		// TODO Auto-generated method stub
		return sysResourceMapper.getSysResourceListById(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		sysResourceMapper.delete(id);
	}

	@Override
	public void intsert(SysResource sysRecource) {
		// TODO Auto-generated method stub
		sysResourceMapper.insert(sysRecource);
	}

	@Override
	public SysResource get(int id) {
		// TODO Auto-generated method stub
		return sysResourceMapper.get(id);
	}

	@Override
	public void update(SysResource sysResource) {
		// TODO Auto-generated method stub
		sysResourceMapper.updateByPrimaryKey(sysResource);
	}

	@Override
	public List<SysResource> findByPage(PageEntity<SysResource> pageEntity) {
		// TODO Auto-generated method stub
		return sysResourceMapper.findByPage(pageEntity);
	}

	@Override
	public List<SysResource> findByCondition(SysResource condition) {
		// TODO Auto-generated method stub
		return sysResourceMapper.findByCondition(condition);
	}

	@Override
	public List<SysResource> listByUserId(Integer userId, Integer platId) {
		// TODO Auto-generated method stub
		return sysResourceMapper.listByUserId(userId, platId );
	}



}
