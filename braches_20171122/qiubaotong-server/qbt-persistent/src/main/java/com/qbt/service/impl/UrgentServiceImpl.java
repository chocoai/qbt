package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Urgent;
import com.qbt.persistent.mapper.UrgentMapper;
import com.qbt.service.UrgentService;

@Service
public class UrgentServiceImpl implements UrgentService {
	
	@Resource
	private UrgentMapper urgentMapper;
	
	@Override
	public List<Urgent> findByPage(PageEntity<Urgent> pageEntity) {
		return urgentMapper.findByPage(pageEntity);
	}

	@Override
	public Urgent findById(Integer id) {
		return urgentMapper.selectById(id);
	}

	@Override
	public int insert(Urgent urgent) {
		urgentMapper.insert(urgent);
		return urgent.getId();
	}

	@Override
	public int update(Urgent urgent) {
		if(urgent.getId() > 0){
			int count = urgentMapper.updateById(urgent);
			return count;
		}
		return 0;
	}

	@Override
	public List<Urgent> findByCondition(Urgent urgent) {
		return urgentMapper.findByCondition(urgent);
	}

	@Override
	public int deleteById(Integer id) {
		return urgentMapper.deleteById(id);
	}

	
}
