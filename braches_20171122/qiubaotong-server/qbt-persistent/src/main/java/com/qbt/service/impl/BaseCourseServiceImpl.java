package com.qbt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.dto.BossBaseCourse;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.UserCourse;
import com.qbt.persistent.mapper.BaseCourseMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseCourseService;

@Service
public class BaseCourseServiceImpl implements BaseCourseService{
	
	@Resource
	private BaseCourseMapper baseCourseMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public List<BaseCourse> findList(String name,int area_id,float lon,float lat,int status,int isPractice) {
		//return baseCourseMapper.findList(name,area_id, lon, lat,status,isPractice);
		return baseCourseMapper.findListByFirstLetter(name,area_id, lon, lat,status,isPractice);
	}

	@Override
	public BaseCourse findById(Integer id) {
		String key = RedisKeyUtil.base_course_id_key(id);
		BaseCourse baseCourse = 
				RedisUtil.getByRedis(redisService.getMap(key), BaseCourse.class);
		if(Checker.isEmpty(baseCourse)){
			baseCourse = baseCourseMapper.findById(id);
			if(Checker.isNotEmpty(baseCourse)){
				redisService.putMap(key, RedisUtil.hashsMap(baseCourse));
			}
		}
		return baseCourse;
	}


	@Override
	public int insert(BaseCourse baseCourse) {
		baseCourseMapper.insert(baseCourse);
		if(baseCourse.getId() > 0){
			redisService.putMap(RedisKeyUtil.base_course_id_key(baseCourse.getId()), RedisUtil.hashsMap(baseCourse));
		}
		return baseCourse.getId();
	}

	@Override
	public int updateById(BaseCourse baseCourse) {
		if(baseCourse.getId() > 0){
			int count = baseCourseMapper.updateById(baseCourse);
			redisService.del(RedisKeyUtil.base_course_id_key(baseCourse.getId()));
			this.findById(baseCourse.getId());
			return count;
		}
		return 0;
	}

	@Override
	public List<BaseCourse> findByAreaId(Integer areaId) {
		return baseCourseMapper.findByAreaId(areaId);
	}

	@Override
	public int deleteById(int id, boolean isDelete) {
		int count = baseCourseMapper.deleteById(id, isDelete);
		if(count > 0){
			redisService.del(RedisKeyUtil.base_course_id_key(id));
			this.findById(id);
		}
		return count;
	}

	@Override
	public List<BaseCourse> findByCondition(BaseCourse condition) {
		return baseCourseMapper.findByCondition(condition);
	}

	@Override
	public List<BossBaseCourse> findByPage(PageEntity<BaseCourse> pageEntity) {
		return baseCourseMapper.findByPage(pageEntity);
	}

	@Override
	public List<BaseCourse> list() {
		return baseCourseMapper.list();
	}

	@Override
	public List<BaseCourse> findCourseByUserId(int userId,int type) {
		return baseCourseMapper.findCourseByUserId(userId,type);
	}


	@Override
	public List<BaseCourse> findByHotCourse() {
		List<BaseCourse> list = new ArrayList<BaseCourse>();
		String hotCourse = redisService.getString(RedisKeyUtil.base_course_hot);
		if(Checker.isEmpty(hotCourse)){
			list  = baseCourseMapper.findByHotCourse();
			// 重新设置 24小时
			redisService.putExpire(RedisKeyUtil.base_course_hot,JSonUtil.toJSonString(list),86400);
			return list;
		}
		
		@SuppressWarnings("unchecked")
		List<Object> lists = JSonUtil.toObject(hotCourse, List.class);
		for(Object obj : lists){
			list.add(JSonUtil.toObject(JSonUtil.toJSonString(obj), BaseCourse.class));
		}
		
		return list;
	}

	@Override
	public List<UserCourse> findUserCourseByUserId(int userId) {
		// TODO Auto-generated method stub
		return baseCourseMapper.findUserCourseByUserId(userId);
	}
	

}
