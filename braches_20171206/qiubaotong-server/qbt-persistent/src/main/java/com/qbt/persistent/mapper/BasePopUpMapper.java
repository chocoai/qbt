package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BasePopUp;

public interface BasePopUpMapper {
	
    int insert(BasePopUp record);

    BasePopUp selectById(@Param("id")Integer id);

    int updateById(BasePopUp record);
    
    int deleteById(@Param("id")Integer id);
    
    List<BasePopUp> findByPage(PageEntity<BasePopUp> pageEntity);

	List<BasePopUp> query(BasePopUp popUp);
    
}