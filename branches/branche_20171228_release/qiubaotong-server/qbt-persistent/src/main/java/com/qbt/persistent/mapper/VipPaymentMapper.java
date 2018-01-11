package com.qbt.persistent.mapper;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.VipPayment;

public interface VipPaymentMapper {
	
    int insert(VipPayment vipPayment);

    VipPayment selectById(@Param("id")Integer id);

    int updateById(VipPayment vipPayment);

    VipPayment findByUserId(@Param("userId")Integer userId,@Param("paymethod")Integer paymethod);
    
    VipPayment findByUuid(@Param("uuid")String uuid);
}