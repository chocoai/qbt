package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.City;

public interface CityMapper {
	
	List<City> getCities(PageEntity<City> pageEntity);

	int insert(City city);
	
	void update(City city);
	
	void deleteAll();
	
	void delete(City city);
	
	List<City> listHotCity();
}
