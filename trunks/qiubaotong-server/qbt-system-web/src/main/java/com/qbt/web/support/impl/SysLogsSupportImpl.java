package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.SysLogs;
import com.qbt.service.SysLogsService;
import com.qbt.web.pojo.sysLogs.SysLogsPageReqVo;
import com.qbt.web.pojo.sysLogs.SysLogsVo;
import com.qbt.web.support.SysLogsSupport;

@Service
public class SysLogsSupportImpl implements SysLogsSupport {

	@Resource
	private SysLogsService sysLogsService; 
	
	@Override
	public void delete(Integer id) {
		sysLogsService.delete(id);
	}

	@Override
	public void insert(SysLogsVo vo) {
		SysLogs sysLogs = BeanUtil.a2b(vo, SysLogs.class);
		sysLogsService.insert(sysLogs);
		
	}

	@Override
	public void updateById(SysLogsVo vo) {
		SysLogs sysLogs = BeanUtil.a2b(vo, SysLogs.class);
		sysLogsService.updateById(sysLogs);
	}

	@Override
	public List<SysLogsVo> findByPage(SysLogsPageReqVo reqVo) {
		PageEntity<SysLogs> pageEntity = BeanUtil.pageConvert(reqVo, SysLogs.class);
		List<SysLogs> list = sysLogsService.findByPage(pageEntity);
		List<SysLogsVo> voList = BeanUtil.list2list(list, SysLogsVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;	
	}

}
