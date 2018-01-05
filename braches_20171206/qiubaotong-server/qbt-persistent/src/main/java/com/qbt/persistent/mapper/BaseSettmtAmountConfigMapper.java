package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BaseSettmtAmountConfig;

public interface BaseSettmtAmountConfigMapper {
	
	int insert(BaseSettmtAmountConfig config);
	
	int insertByBatch(@Param("configs")List<BaseSettmtAmountConfig> configs);
	
	int deleteByPartnerlId(@Param("partnerlId")Integer partnerlId);
	
	List<BaseSettmtAmountConfig> findByPartnerlId(@Param("partnerlId")Integer partnerlId);
	
	BaseSettmtAmountConfig findByAmount(@Param("partnerlId")Integer partnerlId, @Param("amount")Double amount);
	
}
