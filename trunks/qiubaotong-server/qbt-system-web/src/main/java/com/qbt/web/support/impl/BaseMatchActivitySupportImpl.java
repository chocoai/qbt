package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseMatchActivity;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.BaseTeachCenter;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseMatchActivityService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseTeachCenterService;
import com.qbt.web.pojo.baseMatchActivity.BaseMatchActivityPageReqVo;
import com.qbt.web.pojo.baseMatchActivity.BaseMatchActivityVo;
import com.qbt.web.support.BaseMatchActivitySupport;

@Service
public class BaseMatchActivitySupportImpl implements BaseMatchActivitySupport{

	@Resource
	private BaseMatchActivityService baseMatchActivityService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	@Resource
	private BaseCourseService baseCourseService;
	@Resource
	private BaseTeachCenterService baseTeachCenterService;
	
	@Override
	public List<BaseMatchActivityVo> findByPage(BaseMatchActivityPageReqVo reqVo) {
		PageEntity<BaseMatchActivity> pageEntity = BeanUtil.pageConvert(reqVo, BaseMatchActivity.class);
		
		List<BaseMatchActivity> list = baseMatchActivityService.findByPage(pageEntity);
		List<BaseMatchActivityVo> voList = BeanUtil.list2list(list, BaseMatchActivityVo.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseMatchActivityVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseMatchActivity baseMatchActivity = BeanUtil.a2b(vo, BaseMatchActivity.class);
		baseMatchActivity.setTreePath(area.getTreePath());
		baseMatchActivityService.add(baseMatchActivity);
	}

	@Override
	public void updateById(BaseMatchActivityVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseMatchActivity baseMatchActivity = BeanUtil.a2b(vo, BaseMatchActivity.class);
		baseMatchActivity.setTreePath(area.getTreePath());
		baseMatchActivityService.update(baseMatchActivity);
	}

	@Override
	public BaseMatchActivityVo findById(Integer id) {
		BaseMatchActivity baseMatchActivity =  baseMatchActivityService.findById(id);
		BaseMatchActivityVo vo = BeanUtil.a2b(baseMatchActivity, BaseMatchActivityVo.class);
		BaseSfArea area = baseSfAreaService.findById(baseMatchActivity.getAreaId());
		if(Checker.isNotEmpty(area)){
			vo.setTreeId(area.getTreeId());
		}
		if(baseMatchActivity.getType() == 1){
			BaseCourse baseCourse = baseCourseService.findById(baseMatchActivity.getCourseid());
			if(baseCourse != null){
				vo.setCourseName(baseCourse.getName());
			}
		}else if(baseMatchActivity.getType() == 2){
			BaseTeachCenter baseTeachCenter = baseTeachCenterService.findById(baseMatchActivity.getCourseid());
			if(baseTeachCenter != null){
				vo.setCourseName(baseTeachCenter.getName());
			}
		}
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		baseMatchActivityService.deleteById(id);
	}

}
