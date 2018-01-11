package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.persistent.mapper.TicketPackageOrderMapper;
import com.qbt.service.TicketPackageOrderService;

@Service
public class TicketPackageOrderServiceImpl implements TicketPackageOrderService {
	
	@Resource
	private TicketPackageOrderMapper ticketPackageOrderMapper;
	
	@Override
	public List<UserActivityOrder> findByPage(PageEntity<UserActivityOrder> pageEntity) {
		return ticketPackageOrderMapper.findByPage(pageEntity);
	}

	@Override
	public UserActivityOrder findById(Integer id) {
		return ticketPackageOrderMapper.selectById(id);
	}

	@Override
	public int insert(UserActivityOrder ticket) {
		ticketPackageOrderMapper.insert(ticket);
		return ticket.getId();
	}

	@Override
	public int update(UserActivityOrder ticket) {
		if(ticket.getId() > 0){
			int count = ticketPackageOrderMapper.updateById(ticket);			
			return count;
		}
		return 0;
	}

}
