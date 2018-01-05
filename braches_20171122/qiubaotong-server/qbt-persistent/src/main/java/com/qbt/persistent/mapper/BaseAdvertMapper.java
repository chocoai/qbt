package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseAdvert;

public interface BaseAdvertMapper {
	
    int insert(BaseAdvert record);

    BaseAdvert findById(Integer id);

    int updateById(BaseAdvert record);

	List<BaseAdvert> findByPage(PageEntity<BaseAdvert> pageEntity);

	void updateStatus(@Param("id")Integer id, @Param("status")int status);

	BaseAdvert listByCode(@Param("code")String code, @Param("flatType")Integer flatType);

}