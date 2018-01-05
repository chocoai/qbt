package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.BaseSfExpressLogDto;
import com.qbt.persistent.entity.BaseSfExpressLog;
import com.qbt.service.BaseSfExpressLogService;
import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogPageReqVo;
import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogPageVo;
import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogVo;
import com.qbt.web.support.BaseSfExpressLogSupport;

@Service
public class BaseSfExpressLogSupportImpl implements BaseSfExpressLogSupport{

	@Resource
	private BaseSfExpressLogService baseSfExpressLogService;
	
	@Override
	public List<BaseSfExpressLogPageVo> findByPage(BaseSfExpressLogPageReqVo reqVo) {
		PageEntity<BaseSfExpressLogDto> pageEntity = BeanUtil.pageConvert(reqVo, BaseSfExpressLogDto.class);
		List<BaseSfExpressLog> list = baseSfExpressLogService.findByPage(pageEntity);
		List<BaseSfExpressLogPageVo> voList = BeanUtil.list2list(list, BaseSfExpressLogPageVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public BaseSfExpressLogVo findById(Integer id) {
		BaseSfExpressLog baseSfExpressLog = baseSfExpressLogService.findById(id);
		BaseSfExpressLogVo baseSfExpressLogVo = BeanUtil.a2b(baseSfExpressLog, BaseSfExpressLogVo.class);
		return baseSfExpressLogVo;
	}

}
