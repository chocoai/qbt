package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityTicketPackage;
import com.qbt.persistent.entity.UserPackageTicket;

public interface UserPackageTicketMapper {
	
    int insert(UserPackageTicket record);

    UserPackageTicket selectById(Integer id);

    int updateById(UserPackageTicket record);
    
	int checkPackageIsUsed(int packageId);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<UserPackageTicket> findByPage(PageEntity<UserPackageTicket> pageEntity);
    
    List<UserPackageTicket> findTicketsForOrderDetail(Integer orderDetailId);
    
	ActivityTicketPackage findByPackageId(int packageId);
    
    List<UserPackageTicket> findAvailableTicketByUserId(@Param("userId")int userId,@Param("sysdatetime")String sysdatetime);
	
	List<UserPackageTicket> findDisableTicketByUserId(@Param("userId")int userId,@Param("sysdatetime")String sysdatetime);
	
	List<UserPackageTicket> findTicketsByPackageId(@Param("packageId")int packageId);
}