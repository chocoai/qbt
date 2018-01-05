package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.UserProxy;

public interface UserProxyMapper {
	
    int insert(UserProxy userProxy);

    UserProxy findById(@Param("id")Integer id);

    int update(UserProxy userProxy);
    
    List<UserProxy> findByProxyUserId(@Param("proxyUserId")Integer proxyUserId);
    
    UserProxy findByUserId(@Param("proxyUserId")Integer proxyUserId, @Param("userId")Integer userId);
    
    List<UserProxy> findByKeyword(@Param("proxyUserId")Integer proxyUserId, @Param("keyword")String keyword);
}