package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.ticketPackageActivity.TicketPackageActivityPageReqVo;
import com.qbt.web.pojo.ticketPackageActivity.TicketPackageActivityVo;

public interface TicketPackageActivitySupport {

	int insert(TicketPackageActivityVo activityVo);
	
	List<TicketPackageActivityVo> findByPage(TicketPackageActivityPageReqVo vo);
}
