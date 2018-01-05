package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseCourseInfo;
import com.qbt.persistent.mapper.BaseCourseInfoMapper;
import com.qbt.service.BaseCourseInfoService;

@Service
public class BaseCourseInfoServiceImpl implements BaseCourseInfoService {
	
	@Resource
	private BaseCourseInfoMapper baseCourseInfoMapper;
	
	@Override
	public int insert(BaseCourseInfo info) {
		baseCourseInfoMapper.insert(info);
		return info.getCourseId();
	}

	@Override
	public BaseCourseInfo selectByCourseId(Integer courseId) {
		return baseCourseInfoMapper.selectByCourseId(courseId);
	}

	@Override
	public int updateByCourseId(BaseCourseInfo info) {
		if(info.getCourseId() != null && info.getCourseId() > 0){
			return baseCourseInfoMapper.updateByCourseId(info);
		}
		return 0;
	}

	@Override
	public int deleteByCourseId(Integer courseId) {
		return baseCourseInfoMapper.deleteByCourseId(courseId);
	}

	@Override
	public BaseCourseInfo findByQyCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		return baseCourseInfoMapper.findByQyCourseId(courseId);
	}

}
