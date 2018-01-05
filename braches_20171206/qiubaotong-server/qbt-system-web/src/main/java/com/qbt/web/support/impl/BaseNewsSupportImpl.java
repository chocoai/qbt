package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.dto.BaseNewsDto;
import com.qbt.persistent.entity.BaseNews;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseNewsService;
import com.qbt.web.pojo.baseNews.BaseNewsCategoryVo;
import com.qbt.web.pojo.baseNews.BaseNewsOfficialVo;
import com.qbt.web.pojo.baseNews.BaseNewsPageReqVo;
import com.qbt.web.pojo.baseNews.BaseNewsVo;
import com.qbt.web.support.BaseNewsSupport;

@Service
public class BaseNewsSupportImpl implements BaseNewsSupport {

	@Resource
	private BaseNewsService baseNewsService; 
	
	@Resource
	private RedisService redisService;
	
	@Override
	public void add(BaseNewsVo vo) {
		BaseNews baseNews = BeanUtil.a2b(vo, BaseNews.class);
		baseNews.setReadTimes(0);
		baseNews.setStatus(1);
		//阅读数100到200随机数
		int rand = 0; 
		double frand = 0;
		frand=Math.random()*100+100;
		rand=(int)frand;
		baseNews.setReadTimes(rand);
		baseNewsService.add(baseNews);
	}

	@Override
	public List<BaseNewsVo> findByPage(BaseNewsPageReqVo reqVo) {
		PageEntity<BaseNewsDto> pageEntity = BeanUtil.pageConvert(reqVo, BaseNewsDto.class);
		List<BaseNews> list = baseNewsService.findByPage(pageEntity);
		List<BaseNewsVo> voList = BeanUtil.list2list(list, BaseNewsVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void update(BaseNewsVo vo) {
		BaseNews baseNews = BeanUtil.a2b(vo, BaseNews.class);
		baseNewsService.update(baseNews);
	}

	@Override
	public BaseNewsVo findById(Integer id) {
		BaseNews baseNews = baseNewsService.findById(id);
		BaseNewsVo baseNewsVo = BeanUtil.a2b(baseNews, BaseNewsVo.class);
		return baseNewsVo;
	}

	@Override
	public void updateStatus(Integer id, int status) {
		baseNewsService.updateStatus(id,status);
	}

	@Override
	public void delete(Integer id) {
		baseNewsService.delete(id);
	}

	@Override
	public List<BaseNewsVo> list(Integer categoryId) {
		List<BaseNews> list = baseNewsService.list(categoryId);
		List<BaseNewsVo> voList = BeanUtil.list2list(list, BaseNewsVo.class);
		return voList;
	}

	@Override
	public BaseNewsVo findByIdOfficial(Integer id) {
		BaseNews baseNews = baseNewsService.findByIdOfficial(id);
		BaseNewsVo baseNewsVo = BeanUtil.a2b(baseNews, BaseNewsVo.class);
		return baseNewsVo;
	}
	
	@Override
	public void updateReadTimes() {
		String key = null;
		String readTimesStr = null;
		List<BaseNews> baseNewsList = baseNewsService.list(0);
		for (BaseNews baseNews : baseNewsList) {
			key = RedisKeyUtil.base_news_id_key(baseNews.getId());
			readTimesStr = redisService.get(key);
			if(Checker.isEmpty(readTimesStr)){
				readTimesStr = String.valueOf(baseNews.getReadTimes());
			}
			baseNewsService.updateReadTimesById(baseNews.getId(), Integer.parseInt(readTimesStr));
		}
		
		
	}

	@Override
	public List<BaseNewsOfficialVo> findByPageOfficial(BaseNewsPageReqVo reqVo) {
		PageEntity<BaseNewsDto> pageEntity = BeanUtil.pageConvert(reqVo, BaseNewsDto.class);
		List<BaseNews> list = baseNewsService.findByPageOfficial(pageEntity);
		List<BaseNewsOfficialVo> voList = BeanUtil.list2list(list, BaseNewsOfficialVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public List<BaseNewsCategoryVo> listGroupByCategoryId() {
		List<BaseNews> list = baseNewsService.listGroupByCategoryId();
		List<BaseNewsCategoryVo> voList = BeanUtil.list2list(list, BaseNewsCategoryVo.class);
		return voList;
	}

}
