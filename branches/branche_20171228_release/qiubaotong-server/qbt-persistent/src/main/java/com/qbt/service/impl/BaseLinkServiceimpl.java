package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseLink;
import com.qbt.persistent.mapper.BaseLinkMapper;
import com.qbt.service.BaseLinkService;

@Service
public class BaseLinkServiceimpl implements BaseLinkService {

	 @Resource
     private BaseLinkMapper baseLinkMapper;
	 
	@Override
	public void add(BaseLink baseLink) {
		baseLinkMapper.insert(baseLink);
	}

	@Override
	public void updateById(BaseLink baseLink) {
		// TODO Auto-generated method stub
		baseLinkMapper.updateById(baseLink);
	}

	@Override
	public BaseLink findById(Integer id) {
		
		return baseLinkMapper.selectById(id);
	}

	@Override
	public void delete(Integer id) {
		baseLinkMapper.delete(id);
		
	}

	@Override
	public List<BaseLink> findByPage(PageEntity<BaseLink> pageEntity) {
		// TODO Auto-generated method stub
		List<BaseLink> list	=baseLinkMapper.findByPage(pageEntity);

		return list;
	}

	@Override
	public List<BaseLink> findByCondition(BaseLink condition) {
		// TODO Auto-generated method stub
		return baseLinkMapper.findByCondition(condition);
	}

	@Override
	public List<BaseLink> list() {
		// TODO Auto-generated method stub
		return baseLinkMapper.list();
	}

	
}
