package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BaseSfArea;

public interface BaseSfAreaMapper {

	List<BaseSfArea> findByCondition(BaseSfArea condition);

	void insert(BaseSfArea baseSfArea);

	BaseSfArea findById(int id);

	List<BaseSfArea> findByParentId(@Param("parentId")int parentId, @Param("status")Boolean status);

	int updateById(BaseSfArea baseSfArea);

	BaseSfArea findByName(@Param("name")String name, @Param("status")Boolean status);

	BaseSfArea findByDistrict(@Param("name")String name, @Param("district")String district);

	List<BaseSfArea> findByLevel(@Param("level")int level);
	
	List<BaseSfArea> findAll();
    
	BaseSfArea findByFullName(@Param("fullName")String fullName);

	List<BaseSfArea> list();
	
	List<BaseSfArea> findByLevelCourse(@Param("level")int level);
	
	List<BaseSfArea> findDistrictById(@Param("id")int id);

}