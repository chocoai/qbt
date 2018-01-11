package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SupLanguageMobile;

public interface SupLanguageMobileService {

	public int insert(SupLanguageMobile mobile);
	
	public int delete(String mobile);
	
	public List<SupLanguageMobile> findByPage(PageEntity<SupLanguageMobile> page);
	
	public boolean exists(String mobile);
	
	public List<String> findAllMobile();
}
