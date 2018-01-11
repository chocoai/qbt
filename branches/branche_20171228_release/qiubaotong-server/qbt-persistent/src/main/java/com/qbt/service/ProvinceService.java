package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.Province;

public interface ProvinceService {

	List<Province> getProvinces();
	
	int insert(Province province);
	
	void update(Province province);
	
	void deleteAll();
	
	void delete(Province province);
	
	
}
