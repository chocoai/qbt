package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.ticket.TicketPackageOrderAddReqVo;
import com.qbt.web.pojo.ticket.TicketPackageOrderPageReqVo;
import com.qbt.web.pojo.ticket.TicketPackageOrderVo;

public interface TicketPackageOrderSupport {

	List<TicketPackageOrderVo> findByPage(TicketPackageOrderPageReqVo reqVo);
	
	TicketPackageOrderVo findById(Integer id);
	
	int add(TicketPackageOrderAddReqVo vo);
	
	boolean update(TicketPackageOrderVo vo);
}
