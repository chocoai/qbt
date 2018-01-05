package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.OrderDelayTask;

public interface OrderDelayTaskMapper {
    int insert(OrderDelayTask record);

    OrderDelayTask findById(Integer id);

    int updateById(@Param("status")int status,@Param("id")int id);
    
    List<OrderDelayTask>  findValidTasks();
}