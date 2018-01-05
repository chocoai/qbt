package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.BaseSettmtAmountConfig;

public interface BaseSettmtAmountConfigService {
	
	int insert(BaseSettmtAmountConfig config);
	
	int insertByBatch(List<BaseSettmtAmountConfig> configs);
	
	int deleteByPartnerlId(Integer partnerlId);
	
	List<BaseSettmtAmountConfig> findByPartnerlId(Integer partnerlId);
	
	BaseSettmtAmountConfig findByAmount(Integer partnerlId, Double amount);
}
