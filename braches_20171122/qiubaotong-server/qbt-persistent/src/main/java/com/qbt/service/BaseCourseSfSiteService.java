package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseCourseSfSite;

public interface BaseCourseSfSiteService {

	List<BaseCourseSfSite> findByPage(PageEntity<BaseCourseSfSite> pageEntity);

	void add(BaseCourseSfSite baseCourseSfSite);

	void update(BaseCourseSfSite baseCourseSfSite);

	BaseCourseSfSite findById(Integer id);

	void deleteById(Integer id);

}
