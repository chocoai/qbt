package com.qbt.persistent.mapper;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.OrderEmailInsured;

public interface OrderEmailInsuredMapper {
	
    int insert(OrderEmailInsured record);

    OrderEmailInsured findById(Integer id);

    int updateById(OrderEmailInsured record);

	OrderEmailInsured findByMinMaxAndOrderEmailId(@Param("insuredValue")Double insuredValue, @Param("orderEmailId")int orderEmailId);

}