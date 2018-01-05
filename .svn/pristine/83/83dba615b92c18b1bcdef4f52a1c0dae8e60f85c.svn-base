package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.TicketPackageRule;
import com.qbt.persistent.mapper.TicketPackageRuleMapper;
import com.qbt.service.TicketPackageRuleService;

@Service
public class TicketPackageRuleServiceImpl implements TicketPackageRuleService {

	@Resource
	private TicketPackageRuleMapper ticketPackageRuleMapper;
	
	@Override
	public int insert(TicketPackageRule tickPaRule) {
		ticketPackageRuleMapper.insert(tickPaRule);
		return tickPaRule.getId();
	}

	@Override
	public List<TicketPackageRule> findByPage(
			PageEntity<TicketPackageRule> pageEntity) {
		
		return ticketPackageRuleMapper.findByPage(pageEntity);
	}

	@Override
	public TicketPackageRule findByRuleName(String name) {
		
		return ticketPackageRuleMapper.findByRuleName(name);
	}

	@Override
	public TicketPackageRule findById(int id) {
		return ticketPackageRuleMapper.findById(id);
	}

}
