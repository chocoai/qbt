package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.BaseWorkshop;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseWorkshopService;
import com.qbt.web.pojo.baseWorkShop.BaseWorkshopPageReqVo;
import com.qbt.web.pojo.baseWorkShop.BaseWorkshopVo;
import com.qbt.web.support.BaseWorkshopSupport;

@Service
public class BaseWorkshopSupportImpl implements BaseWorkshopSupport {

	@Resource
	private BaseWorkshopService baseWorkshopService;
	@Resource
	private BaseCourseService baseCourseService;
	@Resource
	private BaseSfAreaService baseSfAreaService;

	@Override
	public List<BaseWorkshopVo> findByPage(BaseWorkshopPageReqVo reqVo) {
		PageEntity<BaseWorkshop> pageEntity = BeanUtil.pageConvert(reqVo, BaseWorkshop.class);
		List<BaseWorkshop> list = baseWorkshopService.findByPage(pageEntity);
		List<BaseWorkshopVo> voList = new ArrayList<BaseWorkshopVo>();
		if (Checker.isNotEmpty(list)) {
			BaseWorkshopVo vo = null;
			for (BaseWorkshop bw : list) {
				vo = BeanUtil.a2b(bw, BaseWorkshopVo.class);
				BaseCourse baseCourse = baseCourseService.findById(vo.getCourseId());
				if (baseCourse != null) {
					vo.setNearestCourse(baseCourse.getName());
					vo.setCourseAddress(baseCourse.getTreePath() + baseCourse.getAddress());
				}
				voList.add(vo);
			}
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseWorkshopVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseWorkshop baseWorkshop = BeanUtil.a2b(vo, BaseWorkshop.class);
		baseWorkshop.setTreePath(area.getTreePath());
		baseWorkshopService.add(baseWorkshop);
	}

	@Override
	public void updateById(BaseWorkshopVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseWorkshop baseWorkshop = BeanUtil.a2b(vo, BaseWorkshop.class);
		baseWorkshop.setTreePath(area.getTreePath());
		baseWorkshopService.update(baseWorkshop);
	}

	@Override
	public BaseWorkshopVo findById(Integer id) {
		BaseWorkshop baseWorkshop = baseWorkshopService.findById(id);
		BaseWorkshopVo vo = BeanUtil.a2b(baseWorkshop, BaseWorkshopVo.class);
		BaseCourse baseCourse = baseCourseService.findById(baseWorkshop.getCourseId());
		if (baseCourse != null) {
			vo.setCourseName(baseCourse.getName());
			vo.setCourseAddress(baseCourse.getTreePath() + baseCourse.getAddress());
		}

		BaseSfArea area = baseSfAreaService.findById(baseWorkshop.getAreaId());
		if (Checker.isNotEmpty(area)) {
			vo.setTreeId(area.getTreeId());
		}
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		baseWorkshopService.deleteById(id);
	}

}
