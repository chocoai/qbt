package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.BaseSfArea;

public interface BaseSfAreaService {
	
	void add(BaseSfArea baseSfArea);

	List<BaseSfArea> findByCondition(BaseSfArea condition);

	BaseSfArea findById(int id);

	List<BaseSfArea> findByParentId(int parentId, Boolean status);

	int update(BaseSfArea baseSfArea);

	BaseSfArea findByName(String name, Boolean status);

	BaseSfArea findByDistrict(String name, String district);

	List<BaseSfArea> findByLevel(int level);
	
	List<BaseSfArea> list();
	
	List<BaseSfArea> findByLevelCourse(int level);

	List<BaseSfArea> findDistrictById(int parentId);
}
