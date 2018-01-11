package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.ticket.TicketPackageAddReqVo;
import com.qbt.web.pojo.ticket.TicketPackagePageReqVo;
import com.qbt.web.pojo.ticket.TicketPackageVo;

public interface TicketPackageSupport {

	List<TicketPackageVo> findByPage(TicketPackagePageReqVo reqVo);
	
	TicketPackageVo findById(Integer id);
	
	int add(TicketPackageAddReqVo vo);
	
	boolean update(TicketPackageVo vo);
}
