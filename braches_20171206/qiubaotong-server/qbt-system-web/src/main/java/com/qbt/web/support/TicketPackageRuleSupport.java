package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.ticketPackageRule.TicketPackageRulePageReqVo;
import com.qbt.web.pojo.ticketPackageRule.TicketPackageRuleVo;

public interface TicketPackageRuleSupport {

	int insert(TicketPackageRuleVo ticketPackageRuleVo);
	
	List<TicketPackageRuleVo> findByPage(TicketPackageRulePageReqVo reqVo);
	
	TicketPackageRuleVo findById(int id);
}
