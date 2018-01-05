package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseSettmtAmountConfig;
import com.qbt.persistent.mapper.BaseSettmtAmountConfigMapper;
import com.qbt.service.BaseSettmtAmountConfigService;

@Service
public class BaseSettmtAmountConfigServiceImpl implements BaseSettmtAmountConfigService {
	
	@Resource
	private BaseSettmtAmountConfigMapper baseSettmtAmountConfigMapper;
	
	@Override
	public int insert(BaseSettmtAmountConfig config) {
		baseSettmtAmountConfigMapper.insert(config);
		return config.getId();
	}

	@Override
	public int insertByBatch(List<BaseSettmtAmountConfig> configs) {
		return baseSettmtAmountConfigMapper.insertByBatch(configs);
	}

	@Override
	public int deleteByPartnerlId(Integer partnerlId) {
		return baseSettmtAmountConfigMapper.deleteByPartnerlId(partnerlId);
	}

	@Override
	public List<BaseSettmtAmountConfig> findByPartnerlId(Integer partnerlId) {
		return baseSettmtAmountConfigMapper.findByPartnerlId(partnerlId);
	}

	@Override
	public BaseSettmtAmountConfig findByAmount(Integer partnerlId, Double amount) {
		return baseSettmtAmountConfigMapper.findByAmount(partnerlId, amount);
	}

}
