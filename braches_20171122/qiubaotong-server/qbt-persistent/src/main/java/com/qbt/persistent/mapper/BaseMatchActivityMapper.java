package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseMatchActivity;

public interface BaseMatchActivityMapper {
	
    int insert(BaseMatchActivity record);

    int insertSelective(BaseMatchActivity record);

    BaseMatchActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseMatchActivity record);

    int updateByPrimaryKey(BaseMatchActivity record);

	List<BaseMatchActivity> findByPage(PageEntity<BaseMatchActivity> pageEntity);

	BaseMatchActivity findById(Integer id);

	void deleteById(Integer id);
}