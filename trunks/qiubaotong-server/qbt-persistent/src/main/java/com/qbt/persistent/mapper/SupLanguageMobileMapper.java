package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SupLanguageMobile;

public interface SupLanguageMobileMapper {

	int insert(SupLanguageMobile mobile);
	
	int delete(String mobile);
	
	List<SupLanguageMobile> findByPage(PageEntity<SupLanguageMobile> page);
	
	SupLanguageMobile findByMobile(String mobile);
	
	List<String> findAllMobile();
}
