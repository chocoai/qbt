package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseMatchActivity;

public interface BaseMatchActivityService {

	List<BaseMatchActivity> findByPage(PageEntity<BaseMatchActivity> pageEntity);

	void add(BaseMatchActivity baseTeachCenter);

	void update(BaseMatchActivity baseTeachCenter);

	BaseMatchActivity findById(Integer id);

	void deleteById(Integer id);

}
