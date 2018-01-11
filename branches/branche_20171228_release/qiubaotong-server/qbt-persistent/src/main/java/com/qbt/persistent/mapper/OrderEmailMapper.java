package com.qbt.persistent.mapper;

import com.qbt.persistent.entity.OrderEmail;

public interface OrderEmailMapper {
	
    int insert(OrderEmail record);

    OrderEmail findById(Integer id);

    int updateById(OrderEmail record);

    int updateByPrimaryKey(OrderEmail record);

	OrderEmail findByCode(String code);
}