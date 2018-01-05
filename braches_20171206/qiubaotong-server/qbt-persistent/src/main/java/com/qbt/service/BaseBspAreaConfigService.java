package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBspAreaConfig;

public interface BaseBspAreaConfigService {
	
	int insert(BaseBspAreaConfig config);
	
	int deleteById(Integer id);
	
	List<BaseBspAreaConfig> findByPage(PageEntity<BaseBspAreaConfig> pageEntity);
	
	BaseBspAreaConfig findById(Integer id);
	
	BaseBspAreaConfig findBySrcArea(String srcCity, String srcCountry);
	
}
