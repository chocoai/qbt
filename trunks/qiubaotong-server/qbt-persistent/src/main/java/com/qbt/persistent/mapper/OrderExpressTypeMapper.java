package com.qbt.persistent.mapper;

import com.qbt.persistent.entity.OrderExpressType;

public interface OrderExpressTypeMapper {
    int insert(OrderExpressType record);

    int insertSelective(OrderExpressType record);

    OrderExpressType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderExpressType record);

    int updateByPrimaryKey(OrderExpressType record);
}