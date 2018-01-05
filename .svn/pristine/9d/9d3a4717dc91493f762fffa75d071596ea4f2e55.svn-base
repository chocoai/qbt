package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.UserImage;

public interface UserImageMapper {
	
    int insert(UserImage record);

    UserImage selectById(Integer id);

    int updateById(UserImage record);
    
    int deleteById(Integer id);
    
    List<UserImage> selectByUserId(@Param("userId")Integer userId, @Param("type")Integer type);
    
    int deleteByIds(@Param("ids")List<Integer> ids);
    
    List<UserImage> selectByIds(@Param("ids")List<Integer> ids);
}