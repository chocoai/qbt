package com.qbt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseBank;
import com.qbt.persistent.entity.BaseInsuredTemplate;
import com.qbt.persistent.mapper.BaseInsuredTemplateMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseInsuredTemplateService;

/**
 * 保价模板功能
 * @author share
 *
 */
@Service
public class BaseInsuredTemplateServiceImpl implements BaseInsuredTemplateService {

	@Resource
	private RedisService redisService;
	@Resource
	private BaseInsuredTemplateMapper baseInsuredTemplateMapper;
	
	/**
	 * 查列表
	 * @param pageEntity
	 * @return
	 */
	@Override
	public List<BaseInsuredTemplate> findByPage(PageEntity<BaseInsuredTemplate> pageEntity) {
		return baseInsuredTemplateMapper.findByPage(pageEntity);
	}
	
	/**
	 * 新增
	 */
	@Override
	public void insert(BaseInsuredTemplate template) {
		//若添加有效的把其他的都改为无效，并放到redis里面去,最大值10，最小值1
		//若添加了无效的就不用管他
		// 保存至mysql
		baseInsuredTemplateMapper.insert(template);
		// 入库至redis
		if(template.getState() == 1){
			template = baseInsuredTemplateMapper.findById(template.getId());
			Map<String,String> reidsmap = RedisUtil.hashsMap(template);
			redisService.putMap(RedisKeyUtil.Insured_Template_Valid_Key(), reidsmap);
			baseInsuredTemplateMapper.updateState(template.getId(), 2);
		}
	}
	
	/**
	 * 更新
	 */
	@Override
	public int update(BaseInsuredTemplate template) {
		int result = baseInsuredTemplateMapper.updateById(template);
		if(template.getState() == 1 && result >0){
			template = baseInsuredTemplateMapper.findById(template.getId());
			Map<String,String> reidsmap = RedisUtil.hashsMap(template);
			redisService.putMap(RedisKeyUtil.Insured_Template_Valid_Key(), reidsmap);
			return baseInsuredTemplateMapper.updateState(template.getId(), 2);
		}
		return result;
	}

	@Override
	public BaseInsuredTemplate findById(int id) {
		return baseInsuredTemplateMapper.findById(id);
	}
	
	@Override
	public BaseInsuredTemplate findValid() {
		Map<String,String> redisMap = redisService.getMap(RedisKeyUtil.Insured_Template_Valid_Key());
		BaseInsuredTemplate insuredTemplat = RedisUtil.getByRedis(redisMap, BaseInsuredTemplate.class);
		if(insuredTemplat == null){
			insuredTemplat = baseInsuredTemplateMapper.findValid();
			if(insuredTemplat != null){
				Map<String,String> reidsmap = RedisUtil.hashsMap(insuredTemplat);
				redisService.putMap(RedisKeyUtil.Insured_Template_Valid_Key(), reidsmap);
			}
		}
		return insuredTemplat;
	}

	@Override
	public int updateState(int state, int id) {
		int result = baseInsuredTemplateMapper.updateState(id, state);
		// 入库至redis
		if(state == 1){
			BaseInsuredTemplate template = baseInsuredTemplateMapper.findById(id);
			Map<String,String> reidsmap = RedisUtil.hashsMap(template);
			redisService.putMap(RedisKeyUtil.Insured_Template_Valid_Key(), reidsmap);
			baseInsuredTemplateMapper.updateState(id, 2);
		}
		return result;
	}
	
	@Override
	public void deleteById(Integer id) {
		baseInsuredTemplateMapper.deleteById(id);
	}

	@Override
	public List<BaseBank> findByCondition(BaseInsuredTemplate condition) {
		return baseInsuredTemplateMapper.findByCondition(condition);
	}

}
