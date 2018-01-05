package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityTicketPackage;
import com.qbt.persistent.entity.TicketPackageActivity;
import com.qbt.persistent.entity.UserPackageTicket;
import com.qbt.persistent.mapper.TicketPackageActivityMapper;
import com.qbt.service.TicketPackageActivityService;

@Service
public class TicketPackageActivityServiceImpl implements
		TicketPackageActivityService {

	@Resource
	private TicketPackageActivityMapper mapper;
	
	@Override
	public int insert(TicketPackageActivity activity) {
		mapper.insert(activity);
		return activity.getId();
	}

	@Override
	public List<TicketPackageActivity> findByPage(
			PageEntity<TicketPackageActivity> pageEntity) {
		
		return mapper.findByPage(pageEntity);
	}

	@Override
	public TicketPackageActivity findById(Integer id) {
		return mapper.findById(id);
	}

	@Override
	public List<UserPackageTicket> findAvailableTicketByUserId(
			int userId, String sysdate) {
		
		return mapper.findAvailableTicketByUserId(userId, sysdate);
	}

	@Override
	public List<UserPackageTicket> findDisableTicketByUserId(int userId,
			String sysdatetime) {
		
		return mapper.findDisableTicketByUserId(userId, sysdatetime);
	}

	@Override
	public void updateTicketByUsed(int ticketId) {
		mapper.updateTicketByUsed(ticketId);
	}

	@Override
	public UserPackageTicket findTicketByTicketId(int ticketId) {
		return mapper.findTicketByTicketId(ticketId);
	}

	@Override
	public void updateTicketAsUsed(int ticketId) {
		mapper.updateTicketAsUsed(ticketId);
	}

	@Override
	public ActivityTicketPackage findByPackageId(int packageId) {
		return mapper.findByPackageId(packageId);
	}
}
