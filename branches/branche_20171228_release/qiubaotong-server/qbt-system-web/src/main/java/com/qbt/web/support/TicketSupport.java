package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.ticket.TicketAddReqVo;
import com.qbt.web.pojo.ticket.TicketPageReqVo;
import com.qbt.web.pojo.ticket.TicketVo;

public interface TicketSupport {

	List<TicketVo> findByPage(TicketPageReqVo reqVo);
	
	TicketVo findById(Integer id);
	
	int add(TicketAddReqVo vo);
	
	boolean update(TicketVo vo);
}
