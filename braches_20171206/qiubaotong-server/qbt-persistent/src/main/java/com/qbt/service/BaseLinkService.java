package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseLink;

public interface BaseLinkService {

	void add(BaseLink baseLink);

	void updateById(BaseLink baseLink);

	BaseLink findById(Integer id);

	void delete(Integer id);

	List<BaseLink> findByPage(PageEntity<BaseLink> pageEntity);

	List<BaseLink> findByCondition(BaseLink condition);

	List<BaseLink> list();

}
