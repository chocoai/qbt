package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Urgent;

public interface UrgentMapper {
	
    int insert(Urgent record);

    Urgent selectById(Integer id);

    int updateById(Urgent record);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<Urgent> findByPage(PageEntity<Urgent> pageEntity);
    
    /**
     * 根据条件查询
     * @param urgent
     * @return
     */
    List<Urgent> findByCondition(Urgent urgent);
    
    int deleteById(Integer id);
}