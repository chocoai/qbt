package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.BossBaseCourse;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseCourseInfo;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseCourseInfoService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.UserAssistantService;
import com.qbt.web.pojo.course.CourseDetailVo;
import com.qbt.web.pojo.course.CoursePageReqVo;
import com.qbt.web.pojo.course.CoursePageRespVo;
import com.qbt.web.support.CourseSupport;

@Service
public class CourseSupportImpl implements CourseSupport {
	
	@Resource
	private BaseCourseService baseCourseService;
	
	@Resource
	private BaseCourseInfoService baseCourseInfoService;
	
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Resource
	private UserAssistantService userAssistantService;
	
	@Override
	public List<CoursePageRespVo> findByPage(CoursePageReqVo reqVo) {
		PageEntity<BaseCourse> pageEntity = BeanUtil.pageConvert(reqVo, BaseCourse.class);
		List<BossBaseCourse> list = baseCourseService.findByPage(pageEntity);
		List<CoursePageRespVo> voList = BeanUtil.list2list(list, CoursePageRespVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public CourseDetailVo findById(Integer id) {
		BaseCourse course = baseCourseService.findById(id);
		BaseCourseInfo courseInfo = baseCourseInfoService.selectByCourseId(id);
		
		CourseDetailVo detail = BeanUtil.a2b(course, CourseDetailVo.class);
		if(Checker.isNotEmpty(courseInfo)){
			BeanUtils.copyProperties(courseInfo, detail);
		}
		
		BaseSfArea area = baseSfAreaService.findById(course.getAreaId());
		if(Checker.isNotEmpty(area)){
			detail.setTreeId(area.getTreeId());
		}
		
		return detail;
	}

	@Override
	public int add(CourseDetailVo reqVo) throws BusinessException {
		//检查球场是否重名
		BaseCourse condition = new BaseCourse();
		condition.setName(reqVo.getName());
		List<BaseCourse> qryList = baseCourseService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "球场名称已被使用");
		}
		
		BaseSfArea area = baseSfAreaService.findById(reqVo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		
		BaseCourse baseCourse = BeanUtil.a2b(reqVo, BaseCourse.class);
		baseCourse.setTreePath(area.getTreePath());
		baseCourse.setIsDelete(false);
		int courseId = baseCourseService.insert(baseCourse);
		
		BaseCourseInfo info = BeanUtil.a2b(reqVo, BaseCourseInfo.class);
		info.setCourseId(courseId);
		baseCourseInfoService.insert(info);
		
		return courseId;
	}

	@Override
	public boolean update(CourseDetailVo vo) throws BusinessException {
		//检查球场是否重名
		BaseCourse query = baseCourseService.findById(vo.getId());
		if(Checker.isNotEmpty(query)){
			if(!query.getName().equals(vo.getName())){
				BaseCourse condition = new BaseCourse();
				condition.setName(vo.getName());
				List<BaseCourse> qryList = baseCourseService.findByCondition(condition);
				if (Checker.isNotEmpty(qryList)) {
					throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "球场名称已被使用");
				}
			}
			
			BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
			if(Checker.isEmpty(area)){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
			}
			
			BaseCourse baseCourse = BeanUtil.a2b(vo, BaseCourse.class);
			baseCourse.setTreePath(area.getTreePath());
			baseCourse.setIsDelete(null);
			int c1 = baseCourseService.updateById(baseCourse);
			
			BaseCourseInfo info = BeanUtil.a2b(vo, BaseCourseInfo.class);
			info.setCourseId(vo.getId());
			int c2 = baseCourseInfoService.updateByCourseId(info);
			return c1 + c2 > 0;
		}
		return false;
	}

	@Override
	public boolean delete(int id, boolean isDelete) {
		int result = 0;
		int hasUserAssitant = userAssistantService.queryAssistantByApply(1, id);
		if(hasUserAssitant>0){
			throw new BusinessException("必须先禁用所属的球包助理");
		}else{
			result = baseCourseService.deleteById(id, isDelete);
			if(isDelete){
				BaseCourseInfo info = new BaseCourseInfo();
				info.setCourseId(id);
				info.setHasAssistant(false);
				baseCourseInfoService.updateByCourseId(info);
			}
		}
		return result > 0;
	}


}
