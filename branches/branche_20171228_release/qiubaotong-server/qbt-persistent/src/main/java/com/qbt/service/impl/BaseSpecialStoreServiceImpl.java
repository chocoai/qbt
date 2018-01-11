package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseSpecialStore;
import com.qbt.persistent.mapper.BaseSpecialStoreMapper;
import com.qbt.service.BaseSpecialStoreService;

@Service
public class BaseSpecialStoreServiceImpl implements BaseSpecialStoreService{

	@Resource
	private BaseSpecialStoreMapper baseSpecialStoreMapper;
	
	@Override
	public List<BaseSpecialStore> findByPage(PageEntity<BaseSpecialStore> pageEntity) {
		// TODO Auto-generated method stub
		return baseSpecialStoreMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseSpecialStore baseTeachCenter) {
		// TODO Auto-generated method stub
		baseSpecialStoreMapper.insert(baseTeachCenter);
	}

	@Override
	public void update(BaseSpecialStore baseTeachCenter) {
		// TODO Auto-generated method stub
		baseSpecialStoreMapper.updateByPrimaryKeySelective(baseTeachCenter);
	}

	@Override
	public BaseSpecialStore findById(Integer id) {
		// TODO Auto-generated method stub
		return baseSpecialStoreMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		baseSpecialStoreMapper.deleteById(id);
	}

}
