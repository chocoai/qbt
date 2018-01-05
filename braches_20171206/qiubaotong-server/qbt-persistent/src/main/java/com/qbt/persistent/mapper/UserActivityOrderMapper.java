package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityOrder;

public interface UserActivityOrderMapper {
	
    int insert(UserActivityOrder record);

    UserActivityOrder selectById(Integer id);

    int updateById(UserActivityOrder record);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<UserActivityOrder> findByPage(PageEntity<UserActivityOrder> pageEntity);
}