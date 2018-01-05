package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.BaseTravelAgency;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseTravelAgencyService;
import com.qbt.web.pojo.baseTravelAgency.BaseTravelAgencyPageReqVo;
import com.qbt.web.pojo.baseTravelAgency.BaseTravelAgencyVo;
import com.qbt.web.support.BaseTravelAgencySupport;

@Service
public class BaseTravelAgencySupportImpl implements BaseTravelAgencySupport {

	@Resource
	private BaseTravelAgencyService baseTravelAgencyService;
	@Resource
	private BaseSfAreaService baseSfAreaService;

	@Override
	public List<BaseTravelAgencyVo> findByPage(BaseTravelAgencyPageReqVo reqVo) {
		PageEntity<BaseTravelAgency> pageEntity = BeanUtil.pageConvert(reqVo, BaseTravelAgency.class);
		List<BaseTravelAgency> list = baseTravelAgencyService.findByPage(pageEntity);
		List<BaseTravelAgencyVo> voList = BeanUtil.list2list(list, BaseTravelAgencyVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseTravelAgencyVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseTravelAgency baseTeachCenter = BeanUtil.a2b(vo, BaseTravelAgency.class);
		baseTeachCenter.setTreePath(area.getTreePath());
		baseTravelAgencyService.add(baseTeachCenter);
	}

	@Override
	public void updateById(BaseTravelAgencyVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseTravelAgency baseTeachCenter = BeanUtil.a2b(vo, BaseTravelAgency.class);
		baseTeachCenter.setTreePath(area.getTreePath());
		baseTravelAgencyService.update(baseTeachCenter);
	}

	@Override
	public BaseTravelAgencyVo findById(Integer id) {
		BaseTravelAgency baseTeachCenter = baseTravelAgencyService.findById(id);
		BaseTravelAgencyVo vo = BeanUtil.a2b(baseTeachCenter, BaseTravelAgencyVo.class);
		BaseSfArea area = baseSfAreaService.findById(baseTeachCenter.getAreaId());
		if (Checker.isNotEmpty(area)) {
			vo.setTreeId(area.getTreeId());
		}
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		baseTravelAgencyService.deleteById(id);
	}

}
