package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.City;
import com.qbt.persistent.mapper.CityMapper;
import com.qbt.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Resource
	private CityMapper cityMapper;
	
	@Override
	public List<City> getCities(PageEntity<City> pageEntity) {
		return cityMapper.getCities(pageEntity);
	}

	@Override
	public int insert(City city) {
		
		return cityMapper.insert(city);
	}

	@Override
	public void update(City city) {
		
		cityMapper.update(city);
	}

	@Override
	public void deleteAll() {
		
		cityMapper.deleteAll();
	}
	
	@Override
	public void delete(City city) {
		
		cityMapper.delete(city);
	}

	@Override
	public List<City> listHotCity() {
		
		return cityMapper.listHotCity();
	}

}
