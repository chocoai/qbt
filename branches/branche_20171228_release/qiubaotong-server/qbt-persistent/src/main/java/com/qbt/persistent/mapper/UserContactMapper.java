package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserContact;

public interface UserContactMapper {
	
    int insert(UserContact userContact);

    UserContact findById(@Param("id")Integer id);

    UserContact findByMobile(@Param("mobile")String mobile);
    
    int updateById(UserContact userContact);
    
    int deleteByMobile(@Param("mobile")String mobile, @Param("isDelete")Boolean isDelete);
    
    List<UserContact> findByPage(PageEntity<UserContact> pageEntity);
    
    int removeByMobile(@Param("mobile")String mobile);
}