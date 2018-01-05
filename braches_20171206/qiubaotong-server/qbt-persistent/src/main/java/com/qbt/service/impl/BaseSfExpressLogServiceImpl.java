package com.qbt.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BaseSfExpressLogDto;
import com.qbt.persistent.entity.BaseSfExpressLog;
import com.qbt.persistent.mapper.BaseSfExpressLogMapper;
import com.qbt.service.BaseSfExpressLogService;

@Service
public class BaseSfExpressLogServiceImpl implements BaseSfExpressLogService {

	@Resource
	private BaseSfExpressLogMapper baseSfExpressLogMapper;
	
	@Override
	public List<BaseSfExpressLog> findByPage(PageEntity<BaseSfExpressLogDto> pageEntity) {
		return baseSfExpressLogMapper.findByPage(pageEntity);
	}
	
	public int insert(BaseSfExpressLog baseSfExpressLog) {
		baseSfExpressLogMapper.insert(baseSfExpressLog);
		return baseSfExpressLog.getId();
	}

	@Override
	public BaseSfExpressLog findById(Integer id) {
		return baseSfExpressLogMapper.selectById(id);
	}

	@Override
	public int updateById(BaseSfExpressLog baseSfExpressLog) {
		return baseSfExpressLogMapper.updateById(baseSfExpressLog);
	}

	@Override
	public int deleteByDay(int day) {
		return baseSfExpressLogMapper.deleteByDay(day);
	}

}
