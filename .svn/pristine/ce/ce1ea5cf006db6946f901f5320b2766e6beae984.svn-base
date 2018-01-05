package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SysLogs;
import com.qbt.persistent.mapper.SysLogsMapper;
import com.qbt.service.SysLogsService;

@Service
public class SysLogsServiceImpl implements SysLogsService {

	@Resource
	private SysLogsMapper sysLogsMapper;
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		sysLogsMapper.delete(id);
	}

	@Override
	public void insert(SysLogs sysLogs) {
		// TODO Auto-generated method stub
		sysLogsMapper.insert(sysLogs);
	}

	@Override
	public void updateById(SysLogs sysLogs) {
		// TODO Auto-generated method stub
		sysLogsMapper.updateById(sysLogs);
	}

	@Override
	public List<SysLogs> findByPage(PageEntity<SysLogs> pageEntity) {
		// TODO Auto-generated method stub
		return sysLogsMapper.findByPage(pageEntity);
	}

}
