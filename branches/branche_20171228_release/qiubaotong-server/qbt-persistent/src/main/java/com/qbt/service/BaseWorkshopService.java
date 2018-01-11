package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseWorkshop;

public interface BaseWorkshopService {

	List<BaseWorkshop> findByPage(PageEntity<BaseWorkshop> pageEntity);

	void add(BaseWorkshop baseWorkshop);

	void update(BaseWorkshop baseWorkshop);

	BaseWorkshop findById(Integer id);

	void deleteById(Integer id);

}
