package com.qbt.web.pojo.ticketPackageRule;

import com.qbt.common.result.Paging;

public class TicketPackageRulePageReqVo extends Paging{
	
	Integer status;
	private String ruleName;

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
