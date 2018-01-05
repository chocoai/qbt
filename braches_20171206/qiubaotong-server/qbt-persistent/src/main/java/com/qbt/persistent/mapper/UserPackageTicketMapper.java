package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserPackageTicket;

public interface UserPackageTicketMapper {
	
    int insert(UserPackageTicket record);

    UserPackageTicket selectById(Integer id);

    int updateById(UserPackageTicket record);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<UserPackageTicket> findByPage(PageEntity<UserPackageTicket> pageEntity);
    
    List<UserPackageTicket> findTicketsForOrderDetail(Integer orderDetailId);
}