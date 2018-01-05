package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseCourseSfSite;
import com.qbt.persistent.mapper.BaseCourseSfSiteMapper;
import com.qbt.service.BaseCourseSfSiteService;

@Service
public class BaseCourseSfSiteServiceImpl implements BaseCourseSfSiteService {

	@Resource
	private BaseCourseSfSiteMapper baseCourseSfSiteMapper;
	
	@Override
	public List<BaseCourseSfSite> findByPage(PageEntity<BaseCourseSfSite> pageEntity) {
		// TODO Auto-generated method stub
		return baseCourseSfSiteMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseCourseSfSite baseCourseSfSite) {
		// TODO Auto-generated method stub
		baseCourseSfSiteMapper.insert(baseCourseSfSite);
	}

	@Override
	public void update(BaseCourseSfSite baseCourseSfSite) {
		// TODO Auto-generated method stub
		baseCourseSfSiteMapper.updateByPrimaryKeySelective(baseCourseSfSite);
	}

	@Override
	public BaseCourseSfSite findById(Integer id) {
		// TODO Auto-generated method stub
		return baseCourseSfSiteMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		baseCourseSfSiteMapper.deleteById(id);
	}

}
