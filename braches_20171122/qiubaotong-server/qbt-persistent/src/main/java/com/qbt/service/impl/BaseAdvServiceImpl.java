package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.BaseAdv;
import com.qbt.persistent.mapper.BaseAdvMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseAdvService;

@Service
public class BaseAdvServiceImpl implements BaseAdvService {

	@Resource
	private RedisService redisService;
	@Resource
	private BaseAdvMapper baseAdvMapper;
	
	@Override
	public void add(BaseAdv baseAdv) {
		baseAdvMapper.insert(baseAdv);
		redisService.del(RedisKeyUtil.BaseAdv_T_P_Redis_Key(baseAdv.getType(),baseAdv.getPosition()));
    	this.list(baseAdv.getType(), baseAdv.getPosition());
	}

	@Override
	public List<BaseAdv> findByCondition(BaseAdv condition) {
		// TODO Auto-generated method stub
		return baseAdvMapper.findByCondition(condition);
	}

	@Override
	public int delete(BaseAdv baseAdv) {
		int count =  baseAdvMapper.delete(baseAdv.getId());
    	redisService.del(RedisKeyUtil.BaseAdv_T_P_Redis_Key(baseAdv.getType(),baseAdv.getPosition()));
    	this.list(baseAdv.getType(), baseAdv.getPosition());
		return count;
	}

	@Override
	public int updateById(BaseAdv baseAdv) {
		// TODO Auto-generated method stub
		BaseAdv bs = this.findById(baseAdv.getId());
		int count = baseAdvMapper.updateByPrimaryKey(baseAdv);
		//旧
		redisService.del(RedisKeyUtil.BaseAdv_T_P_Redis_Key(bs.getType(),bs.getPosition()));
		this.list(bs.getType(), bs.getPosition());
		
		//新
		if((!baseAdv.getType().equals(bs.getType()))||(!baseAdv.getPosition().equals(bs.getPosition()))){
			redisService.del(RedisKeyUtil.BaseAdv_T_P_Redis_Key(baseAdv.getType(),baseAdv.getPosition()));
			this.list(baseAdv.getType(), baseAdv.getPosition());
		}
		return count;
	}

	@Override
	public List<BaseAdv> findByPage(PageEntity<BaseAdv> pageEntity) {
		return baseAdvMapper.findByPage(pageEntity);
	}

	@Override
	public List<BaseAdv> list(String type, String position) {
		//从redis拿了为空就从sql拿重新补到redis里面去
		String strList = redisService.getString(RedisKeyUtil.BaseAdv_T_P_Redis_Key(type, position));
		List<BaseAdv> baseAdvList = JSON.parseArray(strList, BaseAdv.class);
		if(Checker.isEmpty(baseAdvList)){
			baseAdvList = baseAdvMapper.list(type, position);
			if(Checker.isNotEmpty(baseAdvList)){
				String listString = JSonUtil.toJSonString(baseAdvList);
				redisService.set(RedisKeyUtil.BaseAdv_T_P_Redis_Key(type, position), listString);
			}
		}
		return baseAdvList;
	}

	@Override
	public BaseAdv findById(Integer id) {
		return baseAdvMapper.findById(id);
	}

}
