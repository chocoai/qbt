package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SysLogs;


public interface SysLogsMapper {

	void delete(Integer id);

	void insert(SysLogs sysLogs);

	void updateById(SysLogs sysLogs);

	List<SysLogs> findByPage(PageEntity<SysLogs> pageEntity);
    
}