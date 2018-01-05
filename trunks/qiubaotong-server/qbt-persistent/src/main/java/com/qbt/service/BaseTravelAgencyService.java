package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseTravelAgency;

public interface BaseTravelAgencyService {

	List<BaseTravelAgency> findByPage(PageEntity<BaseTravelAgency> pageEntity);

	void add(BaseTravelAgency baseTeachCenter);
	
	void update(BaseTravelAgency baseTeachCenter);

	BaseTravelAgency findById(Integer id);

	void deleteById(Integer id);


}
