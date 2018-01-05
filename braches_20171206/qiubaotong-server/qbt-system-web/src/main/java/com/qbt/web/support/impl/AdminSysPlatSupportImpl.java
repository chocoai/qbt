package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.SysPlat;
import com.qbt.service.SysPlatService;
import com.qbt.web.pojo.SysPlat.AdminSysPlatVO;
import com.qbt.web.support.AdminSysPlatSupport;

@Service
public class AdminSysPlatSupportImpl implements AdminSysPlatSupport{

	@Resource
	private SysPlatService sysPlatService;
	
	@Override
	public List<AdminSysPlatVO> list() {
		List<SysPlat> list = sysPlatService.list();
		List<AdminSysPlatVO> voList = BeanUtil.list2list(list, AdminSysPlatVO.class);
		return voList;
	}

}
