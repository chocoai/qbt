package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.OrderRouteTask;

public interface OrderRouteTaskMapper {
    int insert(OrderRouteTask info);

    OrderRouteTask findById(Integer id);

    int update(int id);
    
    List<OrderRouteTask> findAll();
}