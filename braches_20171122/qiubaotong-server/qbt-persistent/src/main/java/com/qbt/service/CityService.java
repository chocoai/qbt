package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.City;

public interface CityService {


	List<City> getCities(PageEntity<City> pageEntity);

	int insert(City city);
	
	void update(City city);
	
	void deleteAll();
	
	void delete(City city);
	
	List<City> listHotCity();
	
}
