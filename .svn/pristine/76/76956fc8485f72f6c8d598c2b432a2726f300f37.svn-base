package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserPackageTicket;
import com.qbt.persistent.mapper.TicketMapper;
import com.qbt.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Resource
	private TicketMapper ticketMapper;
	
	@Override
	public List<UserPackageTicket> findByPage(PageEntity<UserPackageTicket> pageEntity) {
		return ticketMapper.findByPage(pageEntity);
	}

	@Override
	public UserPackageTicket findById(Integer id) {
		return ticketMapper.selectById(id);
	}

	@Override
	public int insert(UserPackageTicket ticket) {
		ticketMapper.insert(ticket);
		return ticket.getId();
	}

	@Override
	public int update(UserPackageTicket ticket) {
		if(ticket.getId() > 0){
			int count = ticketMapper.updateById(ticket);			
			return count;
		}
		return 0;
	}

}
