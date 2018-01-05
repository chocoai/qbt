package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.WinnerList;
import com.qbt.persistent.mapper.WinnerListMapper;
import com.qbt.service.WinnerListService;

@Service
public class WinnerListServiceImpl implements WinnerListService{
	
	@Resource
	private WinnerListMapper mapper;
	
	@Override
	public void insert(WinnerList winnerList) {
		// TODO Auto-generated method stub
		mapper.insert(winnerList);
		
	}

	@Override
	public void update(WinnerList winnerList) {
		// TODO Auto-generated method stub
		mapper.update(winnerList);
	}

	@Override
	public List<WinnerList> findByPage(PageEntity<WinnerList> pageEntity) {
		// TODO Auto-generated method stub
		return mapper.findByPage(pageEntity);
	}

}
