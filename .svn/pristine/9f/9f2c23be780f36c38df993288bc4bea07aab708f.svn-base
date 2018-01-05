package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.SysPlat;
import com.qbt.persistent.mapper.SysPlatMapper;
import com.qbt.service.SysPlatService;

@Service
public class SysPlatServiceImpl implements SysPlatService{
	@Resource
	private SysPlatMapper sysPlatMapper;
	@Override
	public SysPlat get(int id) {
		// TODO Auto-generated method stub
		return sysPlatMapper.get(id);
	}
	@Override
	public List<SysPlat> list() {
		// TODO Auto-generated method stub
		return sysPlatMapper.list();
	}

}
