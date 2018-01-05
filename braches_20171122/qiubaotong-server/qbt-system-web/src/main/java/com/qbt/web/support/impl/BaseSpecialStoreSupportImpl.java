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
import com.qbt.persistent.entity.BaseSpecialStore;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseSpecialStoreService;
import com.qbt.web.pojo.baseSpecialStore.BaseSpecialStorePageReqVo;
import com.qbt.web.pojo.baseSpecialStore.BaseSpecialStoreVo;
import com.qbt.web.support.BaseSpecialStoreSupport;

@Service
public class BaseSpecialStoreSupportImpl implements BaseSpecialStoreSupport {

	@Resource
	private BaseSpecialStoreService baseSpecialStoreService;
	@Resource
	private BaseSfAreaService baseSfAreaService;

	@Override
	public List<BaseSpecialStoreVo> findByPage(BaseSpecialStorePageReqVo reqVo) {
		PageEntity<BaseSpecialStore> pageEntity = BeanUtil.pageConvert(reqVo, BaseSpecialStore.class);
		List<BaseSpecialStore> list = baseSpecialStoreService.findByPage(pageEntity);
		List<BaseSpecialStoreVo> voList = BeanUtil.list2list(list, BaseSpecialStoreVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseSpecialStoreVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseSpecialStore baseSpecialStore = BeanUtil.a2b(vo, BaseSpecialStore.class);
		baseSpecialStore.setTreePath(area.getTreePath());
		baseSpecialStoreService.add(baseSpecialStore);
	}

	@Override
	public void updateById(BaseSpecialStoreVo vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if (Checker.isEmpty(area)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		BaseSpecialStore baseSpecialStore = BeanUtil.a2b(vo, BaseSpecialStore.class);
		baseSpecialStore.setTreePath(area.getTreePath());
		baseSpecialStoreService.update(baseSpecialStore);
	}

	@Override
	public BaseSpecialStoreVo findById(Integer id) {
		BaseSpecialStore baseTeachCenter = baseSpecialStoreService.findById(id);
		BaseSpecialStoreVo vo = BeanUtil.a2b(baseTeachCenter, BaseSpecialStoreVo.class);
		BaseSfArea area = baseSfAreaService.findById(baseTeachCenter.getAreaId());
		if (Checker.isNotEmpty(area)) {
			vo.setTreeId(area.getTreeId());
		}
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		baseSpecialStoreService.deleteById(id);
	}

}
