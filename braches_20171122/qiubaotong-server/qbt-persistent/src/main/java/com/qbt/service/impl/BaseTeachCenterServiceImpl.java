package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseTeachCenter;
import com.qbt.persistent.mapper.BaseTeachCenterMapper;
import com.qbt.service.BaseTeachCenterService;

@Service
public class BaseTeachCenterServiceImpl implements BaseTeachCenterService {

	@Resource
	private BaseTeachCenterMapper baseTeachCenterMapper;
	
	@Override
	public List<BaseTeachCenter> findByPage(PageEntity<BaseTeachCenter> pageEntity) {
		// TODO Auto-generated method stub
		return baseTeachCenterMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseTeachCenter baseTeachCenter) {
		// TODO Auto-generated method stub
		baseTeachCenterMapper.insert(baseTeachCenter);
	}

	@Override
	public void update(BaseTeachCenter baseTeachCenter) {
		// TODO Auto-generated method stub
		baseTeachCenterMapper.updateByPrimaryKeySelective(baseTeachCenter);
	}

	@Override
	public BaseTeachCenter findById(Integer id) {
		// TODO Auto-generated method stub
		return baseTeachCenterMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		baseTeachCenterMapper.deleteById(id);
	}

}
