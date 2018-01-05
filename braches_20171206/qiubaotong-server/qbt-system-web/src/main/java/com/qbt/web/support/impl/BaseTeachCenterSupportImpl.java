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
import com.qbt.persistent.entity.BaseTeachCenter;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseTeachCenterService;
import com.qbt.web.pojo.baseTeachCenter.BaseTeachCenterPageReqVo;
import com.qbt.web.pojo.baseTeachCenter.BaseTeachCenterVo;
import com.qbt.web.support.BaseTeachCenterSupport;

@Service
public class BaseTeachCenterSupportImpl implements BaseTeachCenterSupport {

	@Resource
	private BaseTeachCenterService baseTeachCenterService;
	@Resource
	private BaseSfAreaService baseSfAreaService;

	@Override
	public List<BaseTeachCenterVo> findByPage(BaseTeachCenterPageReqVo reqVo) {
		PageEntity<BaseTeachCenter> pageEntity = BeanUtil.pageConvert(reqVo, BaseTeachCenter.class);
		List<BaseTeachCenter> list = baseTeachCenterService.findByPage(pageEntity);
		List<BaseTeachCenterVo> voList = BeanUtil.list2list(list, BaseTeachCenterVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseTeachCenterVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseTeachCenter baseTeachCenter = BeanUtil.a2b(vo, BaseTeachCenter.class);
		baseTeachCenter.setTreePath(area.getTreePath());
		baseTeachCenterService.add(baseTeachCenter);
	}

	@Override
	public void updateById(BaseTeachCenterVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseTeachCenter baseTeachCenter = BeanUtil.a2b(vo, BaseTeachCenter.class);
		baseTeachCenter.setTreePath(area.getTreePath());
		baseTeachCenterService.update(baseTeachCenter);
	}

	@Override
	public BaseTeachCenterVo findById(Integer id) {
		BaseTeachCenter baseTeachCenter = baseTeachCenterService.findById(id);
		BaseTeachCenterVo vo = BeanUtil.a2b(baseTeachCenter, BaseTeachCenterVo.class);
		BaseSfArea area = baseSfAreaService.findById(baseTeachCenter.getAreaId());
		if (Checker.isNotEmpty(area)) {
			vo.setTreeId(area.getTreeId());
		}
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		baseTeachCenterService.deleteById(id);
	}

}
