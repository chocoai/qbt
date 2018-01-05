package com.qbt.persistent.mapper;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.TicketPackagePayment;

public interface TicketPackagePaymentMapper {

	int insert(TicketPackagePayment ticketPackagePayment);

	TicketPackagePayment selectById(@Param("id")Integer id);

    int updateById(TicketPackagePayment ticketPackagePayment);

    TicketPackagePayment findByUserId(@Param("userId")Integer userId,@Param("paymethod")Integer paymethod);
    
    TicketPackagePayment findByUuid(@Param("uuid")String uuid);

}
