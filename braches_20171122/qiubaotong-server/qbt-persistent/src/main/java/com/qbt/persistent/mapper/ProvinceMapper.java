package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.Province;


public interface ProvinceMapper {
	
	List<Province> getProvinces();
	
	int insert(Province province);
	
	void update(Province province);
	
	void deleteAll();
	
	void delete(Province province);
	
}
