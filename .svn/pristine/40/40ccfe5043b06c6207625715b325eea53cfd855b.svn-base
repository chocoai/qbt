package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityPackage;
import com.qbt.persistent.mapper.TicketPackageMapper;
import com.qbt.service.TicketPackageService;

@Service
public class TicketPackageServiceImpl implements TicketPackageService {
	
	@Resource
	private TicketPackageMapper ticketPackageMapper;
	
	@Override
	public List<UserActivityPackage> findByPage(PageEntity<UserActivityPackage> pageEntity) {
		return ticketPackageMapper.findByPage(pageEntity);
	}

	@Override
	public UserActivityPackage findById(Integer id) {
		return ticketPackageMapper.selectById(id);
	}

	@Override
	public int insert(UserActivityPackage ticket) {
		ticketPackageMapper.insert(ticket);
		return ticket.getId();
	}

	@Override
	public int update(UserActivityPackage ticket) {
		if(ticket.getId() > 0){
			int count = ticketPackageMapper.updateById(ticket);			
			return count;
		}
		return 0;
	}

}
