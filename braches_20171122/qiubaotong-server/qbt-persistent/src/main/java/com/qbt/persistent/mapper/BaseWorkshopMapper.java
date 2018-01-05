package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseWorkshop;

public interface BaseWorkshopMapper {
    int insert(BaseWorkshop record);

    int insertSelective(BaseWorkshop record);

    BaseWorkshop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseWorkshop record);

    int updateByPrimaryKey(BaseWorkshop record);

	List<BaseWorkshop> findByPage(PageEntity<BaseWorkshop> pageEntity);

	BaseWorkshop findById(Integer id);

	void deleteById(Integer id);

}