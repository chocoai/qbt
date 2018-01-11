package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserSfKf;

public interface UserSfKfMapper {
	
    int insert(UserSfKf userSfKf);

    UserSfKf selectById(Integer id);

    int deleteById(Integer id);
    
    List<UserSfKf> findByPage(PageEntity<UserSfKf> pageEntity);
    
    List<UserSfKf> findAll();

	UserSfKf findDutyKf(@Param("week")int week, @Param("hour")int hour);
    
    List<UserSfKf> findByCondition(UserSfKf userSfKf);
    
    int isExist(@Param("name")String name, @Param("mobile")String mobile);
    
}