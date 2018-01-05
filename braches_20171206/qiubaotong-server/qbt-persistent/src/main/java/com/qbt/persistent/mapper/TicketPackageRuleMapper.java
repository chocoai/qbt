package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.TicketPackageRule;

public interface TicketPackageRuleMapper {

	int insert(TicketPackageRule tPackageRule);
	
	List<TicketPackageRule> findByPage(PageEntity<TicketPackageRule> pageEntity);
		
	TicketPackageRule findByRuleName(@Param("ruleName")String ruleName);
	
	TicketPackageRule findById(@Param("id")int id);
}
