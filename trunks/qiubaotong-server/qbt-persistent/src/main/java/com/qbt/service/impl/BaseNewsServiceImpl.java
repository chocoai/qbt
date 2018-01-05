package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.dto.BaseNewsDto;
import com.qbt.persistent.entity.BaseNews;
import com.qbt.persistent.mapper.BaseNewsMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseNewsService;

@Service
public class BaseNewsServiceImpl implements BaseNewsService {

	@Resource
	private BaseNewsMapper baseNewsMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public void add(BaseNews baseNews) {
		// TODO Auto-generated method stub
		baseNewsMapper.insert(baseNews);
	}

	@Override
	public List<BaseNews> findByPage(PageEntity<BaseNewsDto> pageEntity) {
		// TODO Auto-generated method stub
		return baseNewsMapper.findByPage(pageEntity);
	}

	@Override
	public void update(BaseNews baseNews) {
		// TODO Auto-generated method stub
		baseNewsMapper.updateByPrimaryKeySelective(baseNews);
	}

	@Override
	public BaseNews findById(Integer id) {
		// TODO Auto-generated method stub
		return baseNewsMapper.findById(id);
	}

	@Override
	public void updateStatus(Integer id, int status) {
		// TODO Auto-generated method stub
		baseNewsMapper.updateStatus(id, status);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		baseNewsMapper.deleteById(id);
	}

	@Override
	public List<BaseNews> list(Integer categoryId) {
		// TODO Auto-generated method stub
		return baseNewsMapper.list(categoryId);
	}

	@Override
	public BaseNews findByIdOfficial(Integer id) {
		// TODO Auto-generated method stub
		String key = RedisKeyUtil.base_news_id_key(id);	
		String readTimesStr = redisService.get(key);
		BaseNews baseNews = baseNewsMapper.findById(id);
		if(Checker.isEmpty(readTimesStr)){
			redisService.putString(key, String.valueOf(baseNews.getReadTimes()));
			//直接更新redis的key对应值
			Long readTime = redisService.incr(key);
			baseNews.setReadTimes(Integer.parseInt(String.valueOf(readTime)));
		}else{
			Long readTime = redisService.incr(key);
			baseNews.setReadTimes(Integer.parseInt(String.valueOf(readTime)));
			/*Integer readTimes = Integer.parseInt(readTimesStr);
			redisService.putString(key, String.valueOf(readTimes+1));*/
		}
		return baseNews;
	}

	@Override
	public void updateReadTimesById(int id, int readTimes) {
		// TODO Auto-generated method stub
		baseNewsMapper.updateReadTimesById(id, readTimes);
	}

	@Override
	public List<BaseNews> findByPageOfficial(PageEntity<BaseNewsDto> pageEntity) {
		// TODO Auto-generated method stub
		return baseNewsMapper.findByPageOfficial(pageEntity);
	}

	@Override
	public List<BaseNews> listGroupByCategoryId() {
		// TODO Auto-generated method stub
		return baseNewsMapper.listGroupByCategoryId();
	}

}
