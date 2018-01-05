package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipType;
import com.qbt.persistent.mapper.VipTypeMapper;
import com.qbt.service.VipTypeService;

@Service
public class VipTypeServiceImpl implements VipTypeService {

	@Resource
	private VipTypeMapper vipTypeMapper;
	
	@Override
	public List<VipType> findByPage(PageEntity<VipType> pageEntity) {
		// TODO Auto-generated method stub
		return vipTypeMapper.findByPage(pageEntity);
	}

	@Override
	public VipType findById(Integer id) {
		// TODO Auto-generated method stub
		return vipTypeMapper.selectById(id);
	}

	
	@Override
	public List<VipType> selectByStatus(Integer status) {
		// TODO Auto-generated method stub
		return vipTypeMapper.selectByStatus(status);
	}

	@Override
	public void updateStatus(VipType vipType) {
		// TODO Auto-generated method stub
		vipTypeMapper.updateById(vipType);
	}

	@Override
	public void add(VipType vipType) {
		// TODO Auto-generated method stub
		vipTypeMapper.insert(vipType);
	}

	@Override
	public List<VipType> findByCondition(VipType condition) {
		// TODO Auto-generated method stub
		return vipTypeMapper.findByCondition(condition);
	}

	@Override
	public VipType findOne() {
		// TODO Auto-generated method stub
		return vipTypeMapper.findOne();
	}

}
