package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseSfSite;

public interface BaseSfSiteService {
	
	public List<BaseSfSite> findList();
	
	public BaseSfSite findById(int id);

	public List<BaseSfSite> findByPage(PageEntity<BaseSfSite> pageEntity);

	public void update(BaseSfSite baseSfSite);
	
	public void add(BaseSfSite baseSfSite);

	public List<BaseSfSite> findByCondition(BaseSfSite condition);

	public List<BaseSfSite> list();

	public void deleteById(Integer id);

	public int deleteById2(Integer id, Boolean isDelete);

}
