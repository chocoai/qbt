package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderExceptionBook;

public interface OrderExceptionBookMapper {
    int insert(OrderExceptionBook record);

    OrderExceptionBook findById(Integer id);

    int updateById(OrderExceptionBook record);
    
    List<OrderExceptionBook> findByPage(PageEntity<OrderExceptionBook> pageEntity);
}