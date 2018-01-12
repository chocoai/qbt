package com.qbt.web.support;

import java.util.Map;

import com.qbt.web.pojo.ticketPackage.UserPackageTicketVo;

public interface TicketPackageSupport {
	public Map<String, Object> export(UserPackageTicketVo vo);
}
