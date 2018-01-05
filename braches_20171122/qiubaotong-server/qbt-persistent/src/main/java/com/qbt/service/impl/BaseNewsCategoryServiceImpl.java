package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseNewsCategory;
import com.qbt.persistent.mapper.BaseNewsCategoryMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseNewsCategoryService;

@Service
public class BaseNewsCategoryServiceImpl implements BaseNewsCategoryService {

	@Resource
	private BaseNewsCategoryMapper newsCatagortMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public int insert(BaseNewsCategory record) {
		return newsCatagortMapper.insert(record);
	}

	@Override
	public BaseNewsCategory selectById(Integer id) {
		return newsCatagortMapper.selectById(id);
	}

	@Override
	public int updateById(BaseNewsCategory record) {
		return newsCatagortMapper.updateById(record);
	}

	@Override
	public int deleteById(Integer id) {
		return newsCatagortMapper.deleteById(id);
	}

	@Override
	public List<BaseNewsCategory> findByPage(PageEntity<BaseNewsCategory> pageEntity) {
		return newsCatagortMapper.findByPage(pageEntity);
	}

	@Override
	public List<BaseNewsCategory> findList() {
		return newsCatagortMapper.findList();
	}

	@Override
	public List<BaseNewsCategory> findByName(BaseNewsCategory record) {
		return newsCatagortMapper.findByName(record);
	}

	@Override
	public List<BaseNewsCategory> findByNameExceptSelf(BaseNewsCategory record) {
		return newsCatagortMapper.findByNameExceptSelf(record);
	}

}
