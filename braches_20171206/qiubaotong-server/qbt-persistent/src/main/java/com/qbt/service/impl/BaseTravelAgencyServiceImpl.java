package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseTravelAgency;
import com.qbt.persistent.mapper.BaseTravelAgencyMapper;
import com.qbt.service.BaseTravelAgencyService;

@Service
public class BaseTravelAgencyServiceImpl implements BaseTravelAgencyService{

	@Resource
	private BaseTravelAgencyMapper baseTravelAgencyMapper;
	
	@Override
	public List<BaseTravelAgency> findByPage(PageEntity<BaseTravelAgency> pageEntity) {
		return baseTravelAgencyMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseTravelAgency baseTeachCenter) {
		baseTravelAgencyMapper.insert(baseTeachCenter);
	}

	@Override
	public void update(BaseTravelAgency baseTeachCenter) {
		baseTravelAgencyMapper.updateByPrimaryKeySelective(baseTeachCenter);
		
	}

	@Override
	public BaseTravelAgency findById(Integer id) {
		return baseTravelAgencyMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		baseTravelAgencyMapper.deleteById(id);
		
	}

}
