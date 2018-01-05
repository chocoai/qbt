package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipCreate;

public interface VipCreateMapper {
	
    int insert(VipCreate record);

    VipCreate selectById(Integer id);

    int updateById(VipCreate record);
    
    List<VipCreate> findByPage(PageEntity<VipCreate> pageEntity);
    
    int exist(@Param("name")String name);
}