package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseWorkshop;
import com.qbt.persistent.mapper.BaseWorkshopMapper;
import com.qbt.service.BaseWorkshopService;

@Service
public class BaseWorkshopServiceImpl implements BaseWorkshopService{

	@Resource
	private BaseWorkshopMapper baseWorkshopMapper;
	
	@Override
	public List<BaseWorkshop> findByPage(PageEntity<BaseWorkshop> pageEntity) {
		// TODO Auto-generated method stub
		return baseWorkshopMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseWorkshop baseWorkshop) {
		baseWorkshopMapper.insert(baseWorkshop);
	}

	@Override
	public void update(BaseWorkshop baseWorkshop) {
		baseWorkshopMapper.updateByPrimaryKey(baseWorkshop);
	}

	@Override
	public BaseWorkshop findById(Integer id) {
		// TODO Auto-generated method stub
		return baseWorkshopMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		baseWorkshopMapper.deleteById(id);
	}

}
