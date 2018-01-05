package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseMatchActivity;
import com.qbt.persistent.mapper.BaseMatchActivityMapper;
import com.qbt.service.BaseMatchActivityService;

@Service
public class BaseMatchActivityServiceImpl implements BaseMatchActivityService{

	@Resource
	private BaseMatchActivityMapper baseMatchActivityMapper;
	
	@Override
	public List<BaseMatchActivity> findByPage(PageEntity<BaseMatchActivity> pageEntity) {
		// TODO Auto-generated method stub
		return baseMatchActivityMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseMatchActivity baseTeachCenter) {
		// TODO Auto-generated method stub
		baseMatchActivityMapper.insert(baseTeachCenter);
	}

	@Override
	public void update(BaseMatchActivity baseTeachCenter) {
		// TODO Auto-generated method stub
		baseMatchActivityMapper.updateByPrimaryKeySelective(baseTeachCenter);
	}

	@Override
	public BaseMatchActivity findById(Integer id) {
		// TODO Auto-generated method stub
		return baseMatchActivityMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		baseMatchActivityMapper.deleteById(id);
	}

}
