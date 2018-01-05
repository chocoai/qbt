package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseLink;

public interface BaseLinkMapper {
	
    int insert(BaseLink record);

    BaseLink selectById(Integer id);

	void updateById(BaseLink baseLink);

	void delete(Integer id);

	List<BaseLink> findByPage(PageEntity<BaseLink> pageEntity);

	List<BaseLink> findByCondition(BaseLink condition);

	List<BaseLink> list();

}