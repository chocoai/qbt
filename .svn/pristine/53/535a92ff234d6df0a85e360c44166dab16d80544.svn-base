package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.persistent.entity.UserProxyAddress;

public interface UserProxyAddressMapper {
	
    int insert(UserProxyAddress address);

    UserProxyAddress findById(@Param("id")Integer id);

    int update(UserProxyAddress address);
    
    int delete(@Param("id")Integer id);
    
    List<UserProxyAddress> findByPage(PageEntity<UserProxyAddress> pageEntity);
    
    List<UserProxyAddress> findByUserId(@Param("proxyUserId")Integer proxyUserId, @Param("userId")Integer userId, @Param("labelType")Integer labelType);
    
	void updateOtherDefault(UserProxyAddress address);
    
	UserProxyAddress findByUuid(@Param("uuid")String uuid);
	
	int exists(@Param("id")Integer id, @Param("uuid")String uuid);
	
	int updateUpdateTime(UserAddress address);
}