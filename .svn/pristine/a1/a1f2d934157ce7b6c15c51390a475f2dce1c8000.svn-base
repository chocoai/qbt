package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Reminder;

public interface ReminderMapper {
	
    int insert(Reminder record);

    Reminder selectById(Integer id);

    int updateById(Reminder record);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<Reminder> findByPage(PageEntity<Reminder> pageEntity);
    
    List<Reminder> list();
}