package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserKf;

public interface UserKfMapper {
	
    int insert(UserKf record);

    UserKf findById(Integer id);
    
    UserKf selectById(Integer id);

    int updateById(UserKf record);
    
    List<UserKf> findByType(int type);
    
    int delete(Integer id);
    
    List<UserKf> findByPage(PageEntity<UserKf> pageEntity);

	List<UserKf> findByCondition(UserKf condition);
}