package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BaseAdv;
import com.qbt.service.BaseAdvService;
import com.qbt.web.pojo.baseAdv.BaseAdvVo;
import com.qbt.web.support.BaseAdvSupport;

@Service
public class BaseAdvSupportImpl implements BaseAdvSupport{

	@Resource
	private BaseAdvService baseAdvService;
	
	@Override
	public List<BaseAdvVo> list(String type,String position) {
		List<BaseAdv> list = baseAdvService.list(type, position);
		List<BaseAdvVo> voList = BeanUtil.list2list(list, BaseAdvVo.class);
		return voList;
	}

}
