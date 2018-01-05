package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.OrderEmailTemplet;

public interface OrderEmailTempletMapper {
	
    int insert(OrderEmailTemplet record);

    OrderEmailTemplet findById(Integer id);

    int updateById(OrderEmailTemplet record);

	List<OrderEmailTemplet> findByOrderEmailInsuredId(int orderEmailInsuredId);

}