package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseSpecialStore;

public interface BaseSpecialStoreService {

	List<BaseSpecialStore> findByPage(PageEntity<BaseSpecialStore> pageEntity);

	void add(BaseSpecialStore baseTeachCenter);

	void update(BaseSpecialStore baseTeachCenter);

	BaseSpecialStore findById(Integer id);

	void deleteById(Integer id);

}
