package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BaseVersion;
import com.qbt.service.BaseVersionService;
import com.qbt.web.pojo.base.BaseVersionVo;
import com.qbt.web.support.BaseVersionSupport;

@Service
public class BaseVersionSupportImpl implements BaseVersionSupport {
	
	@Resource
	private BaseVersionService baseVersionService;
	
	@Override
	public List<BaseVersionVo> findAll() {
		List<BaseVersion> list = baseVersionService.findAll();
		List<BaseVersionVo> voList = BeanUtil.list2list(list, BaseVersionVo.class);
		return voList;
	}

	@Override
	public Integer add(BaseVersionVo vo) {
		BaseVersion baseVersion = BeanUtil.a2b(vo, BaseVersion.class);
		return baseVersionService.insert(baseVersion);
	}

}
