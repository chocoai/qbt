package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseCourseSfSite;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseCourseSfSiteService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.web.pojo.baseCourseSfSite.BaseCourseSfSiteReqVo;
import com.qbt.web.pojo.baseCourseSfSite.BaseCourseSfSiteVo;
import com.qbt.web.support.BaseCourseSfSiteSupport;

@Service
public class BaseCourseSfSiteSupportImpl implements BaseCourseSfSiteSupport{

	@Resource
	private BaseCourseSfSiteService baseCourseSfSiteService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Override
	public List<BaseCourseSfSiteVo> findByPage(BaseCourseSfSiteReqVo reqVo) {
		PageEntity<BaseCourseSfSite> pageEntity = BeanUtil.pageConvert(reqVo, BaseCourseSfSite.class);
		List<BaseCourseSfSite> list = baseCourseSfSiteService.findByPage(pageEntity);
		List<BaseCourseSfSiteVo> voList = BeanUtil.list2list(list, BaseCourseSfSiteVo.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseCourseSfSiteVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseCourseSfSite baseCourseSfSite = BeanUtil.a2b(vo, BaseCourseSfSite.class);
		baseCourseSfSite.setTreePath(area.getTreePath());
		baseCourseSfSiteService.add(baseCourseSfSite);
	}

	@Override
	public void updateById(BaseCourseSfSiteVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseCourseSfSite baseCourseSfSite = BeanUtil.a2b(vo, BaseCourseSfSite.class);
		baseCourseSfSite.setTreePath(area.getTreePath());
		baseCourseSfSiteService.update(baseCourseSfSite);
	}

	@Override
	public BaseCourseSfSiteVo findById(Integer id) {
		BaseCourseSfSite baseCourseSfSite =  baseCourseSfSiteService.findById(id);
		BaseCourseSfSiteVo vo = BeanUtil.a2b(baseCourseSfSite, BaseCourseSfSiteVo.class);
		BaseSfArea area = baseSfAreaService.findById(baseCourseSfSite.getAreaId());
		if(Checker.isNotEmpty(area)){
			vo.setTreeId(area.getTreeId());
		}
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		baseCourseSfSiteService.deleteById(id);
	}

}
