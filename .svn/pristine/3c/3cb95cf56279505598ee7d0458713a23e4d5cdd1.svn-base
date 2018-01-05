package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserAddress;

public interface UserAddressMapper {
	
    int insert(UserAddress address);

    UserAddress findById(@Param("id")Integer id);

    int update(UserAddress address);
    
    int updateUpdateTime(UserAddress address);
    
    int delete(int id);
    
    List<UserAddress> findByPage(PageEntity<UserAddress> pageEntity);
    
    List<UserAddress> findByUserId(@Param("userId")Integer userId, @Param("labelType")Integer labelType);
    
	void updateOtherDefault(UserAddress address);
    
	UserAddress findByUuid(@Param("uuid")String uuid);
	
	int exists(@Param("id")Integer id, @Param("uuid")String uuid);
}