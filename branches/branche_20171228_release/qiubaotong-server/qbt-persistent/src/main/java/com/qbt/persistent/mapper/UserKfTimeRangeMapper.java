package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.UserKfTimeRange;

public interface UserKfTimeRangeMapper {
	
    int insert(UserKfTimeRange record);

    UserKfTimeRange selectById(Integer id);

    int updateById(UserKfTimeRange record);
    
    int deleteById(Integer id);
    
    int deleteByServiceId(Integer serviceId);
    
    List<UserKfTimeRange> findAll();
    
    List<UserKfTimeRange> findByCondition(UserKfTimeRange condition);
}