package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.TicketPackageRuleConfig;

public interface TicketPackageRuleConfigService {
	
	int insertByBatch(List<TicketPackageRuleConfig> configList);
	
	List<TicketPackageRuleConfig> findByRuleId(int id);

}
