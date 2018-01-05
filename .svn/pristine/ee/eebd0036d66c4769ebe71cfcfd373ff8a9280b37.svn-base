package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.TicketPackageRuleConfig;
import com.qbt.persistent.mapper.TicketPackageRuleConfigMapper;
import com.qbt.service.TicketPackageRuleConfigService;

@Service
public class TicketPackageRuleConfigServiceImpl implements
		TicketPackageRuleConfigService {
	
	@Resource
	private TicketPackageRuleConfigMapper mapper;

	@Override
	public int insertByBatch(List<TicketPackageRuleConfig> configList) {
		
		return mapper.insertByBatch(configList);
	}

	@Override
	public List<TicketPackageRuleConfig> findById(int id) {
		return mapper.findById(id);
	}

	
}
