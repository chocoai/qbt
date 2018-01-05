package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityTicketPackage;
import com.qbt.persistent.entity.TicketPackageActivity;
import com.qbt.persistent.entity.UserPackageTicket;

public interface TicketPackageActivityMapper {
	
	int insert(TicketPackageActivity activity);
	
	List<TicketPackageActivity> findByPage(PageEntity<TicketPackageActivity> pageEntity);
	
	TicketPackageActivity findById(Integer id);
	
	ActivityTicketPackage findByPackageId(int packageId);
	
	void updateTicketByUsed(int ticketId);
	
	void updateTicketAsUsed(int ticketId);
	
	UserPackageTicket findTicketByTicketId(int ticketId);
	
	List<UserPackageTicket> findAvailableTicketByUserId(@Param("userId")int userId,@Param("sysdatetime")String sysdatetime);
	
	List<UserPackageTicket> findDisableTicketByUserId(@Param("userId")int userId,@Param("sysdatetime")String sysdatetime);
}
