package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.BaseVersion;

public interface BaseVersionMapper {
	
    int insert(BaseVersion record);

    BaseVersion selectById(Integer id);

    int updateById(BaseVersion record);
    
    List<BaseVersion> findAll();

}