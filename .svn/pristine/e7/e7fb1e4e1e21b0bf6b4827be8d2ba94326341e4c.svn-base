package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityTicketPackage;
import com.qbt.persistent.entity.TicketPackageActivity;
import com.qbt.persistent.entity.UserPackageTicket;

public interface TicketPackageActivityService {

	int insert(TicketPackageActivity activity);
	
	List<TicketPackageActivity> findByPage(PageEntity<TicketPackageActivity> pageEntity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	TicketPackageActivity findById(Integer id);
	
	ActivityTicketPackage findByPackageId(int packageId);
	
	void updateTicketByUsed(int ticketId);
	
	void updateTicketAsUsed(int ticketId);
	
	UserPackageTicket findTicketByTicketId(int ticketId);
	
    List<UserPackageTicket> findAvailableTicketByUserId(int userId,String sysdatetime);
	
	List<UserPackageTicket> findDisableTicketByUserId(int userId,String sysdatetime);
}
