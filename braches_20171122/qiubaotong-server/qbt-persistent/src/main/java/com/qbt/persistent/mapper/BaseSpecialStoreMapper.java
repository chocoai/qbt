package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseSpecialStore;

public interface BaseSpecialStoreMapper {
    int insert(BaseSpecialStore record);

    int insertSelective(BaseSpecialStore record);

    BaseSpecialStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseSpecialStore record);

    int updateByPrimaryKey(BaseSpecialStore record);

	List<BaseSpecialStore> findByPage(PageEntity<BaseSpecialStore> pageEntity);

	BaseSpecialStore findById(Integer id);

	void deleteById(Integer id);
}