package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BaseArea;

public interface BaseAreaMapper {
    int insert(BaseArea area);

    BaseArea findById(Integer id);

    int updateById(BaseArea area);
    
    List<BaseArea> findBySupperId(int superId);
    
    BaseArea findByName(String name);
    
    BaseArea findLikeName(@Param("name")String name,@Param("level")int level,@Param("superId")int superId);

    int updateCodeBySf(@Param("name")String name,@Param("level")int level,@Param("superId")int superId,@Param("code")String code);
    
	List<BaseArea> findByLevel(int level);

	BaseArea findByDistrict(@Param("city")String city, @Param("district")String district);
    
}