package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BasePopUpConfig;

public interface BasePopUpConfigMapper {
	
    int insert(BasePopUpConfig record);

    BasePopUpConfig selectById(@Param("id")Integer id);
    
    int insertBatch(@Param("configs")List<BasePopUpConfig> configs);
    
    int deleteByPopUpId(@Param("popUpId")Integer popUpId);
    
    List<BasePopUpConfig> findByPopUpId(@Param("popUpId")Integer popUpId);
}