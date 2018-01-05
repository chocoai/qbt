package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.Province;
import com.qbt.persistent.mapper.ProvinceMapper;
import com.qbt.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService{

	@Resource
	private ProvinceMapper provinceMapper;
	
	@Override
	public List<Province> getProvinces() {
		return provinceMapper.getProvinces();
	}

	@Override
	public int insert(Province province) {
		
		return 	provinceMapper.insert(province);
	}

	@Override
	public void update(Province province) {
		provinceMapper.update(province);
	}

	@Override
	public void deleteAll() {
		provinceMapper.deleteAll();
	}
	
	@Override
	public void delete(Province province) {
		provinceMapper.delete(province);
	}

	

}
