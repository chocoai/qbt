package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BasePartner;

public interface BasePartnerService {

	List<BasePartner> findByCondition(BasePartner condition);

	void insert(BasePartner basePartner);

	List<BasePartner> findByPage(PageEntity<BasePartner> pageEntity);

	void update(BasePartner basePartner);

	BasePartner findById(Integer id);

	void updateStatus(Integer id, int status);
	
	List<BasePartner> findAll(int type);
	
}
