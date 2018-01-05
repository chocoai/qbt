package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBspAreaConfig;

public interface BaseBspAreaConfigMapper {
	
	int insert(BaseBspAreaConfig config);
	
	int deleteById(@Param("id")Integer id);
	
	List<BaseBspAreaConfig> findByPage(PageEntity<BaseBspAreaConfig> pageEntity);
	
	BaseBspAreaConfig findById(@Param("id")Integer id);
	
	List<BaseBspAreaConfig> findBySrcArea(@Param("srcCity")String srcCity, @Param("srcCountry")String srcCountry);
}
