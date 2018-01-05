package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseSfAreaService;
import com.qbt.web.pojo.baseSfArea.BaseSfAreaVo;
import com.qbt.web.support.BaseSfAreaSupport;

@Service
public class BaseSfAreaSupportImpl implements BaseSfAreaSupport{

	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Override
	public void add(BaseSfAreaVo vo) throws BusinessException {
		BaseSfArea condition = new BaseSfArea();
		condition.setName(vo.getName());
		List<BaseSfArea> qryList = baseSfAreaService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("名称已被使用");
		}
		BaseSfArea baseSfArea = BeanUtil.a2b(vo, BaseSfArea.class);
		baseSfAreaService.add(baseSfArea);
	}

	@Override
	public BaseSfAreaVo findById(int id) {
		BaseSfArea baseSfArea = baseSfAreaService.findById(id);
		BaseSfAreaVo vo = BeanUtil.a2b(baseSfArea, BaseSfAreaVo.class);
		return vo;
		
	}

	@Override
	public List<BaseSfAreaVo> findByParentId(int parentId) {
		List<BaseSfArea> baseSfAreaList = baseSfAreaService.findByParentId(parentId, null);
		List<BaseSfAreaVo> voList = BeanUtil.list2list(baseSfAreaList, BaseSfAreaVo.class);
		return voList;
	}

	@Override
	public void update(BaseSfAreaVo vo) throws BusinessException {
		BaseSfArea baseSfArea = BeanUtil.a2b(vo, BaseSfArea.class);
		baseSfAreaService.update(baseSfArea);
	}

	@Override
	public BaseSfAreaVo findByName(String name) {
		BaseSfArea baseSfArea =  baseSfAreaService.findByName(name, null);
		BaseSfAreaVo vo = BeanUtil.a2b(baseSfArea, BaseSfAreaVo.class);
		return vo;
	}

	@Override
	public BaseSfAreaVo findByDistrict(String name, String district) {
		BaseSfArea baseSfArea = baseSfAreaService.findByDistrict(name, district);
		BaseSfAreaVo vo = BeanUtil.a2b(baseSfArea, BaseSfAreaVo.class);
		return vo;
	}

	@Override
	public List<BaseSfAreaVo> findByLevel(int level) {
		List<BaseSfArea> baseSfAreaList =baseSfAreaService.findByLevel(level);
		List<BaseSfAreaVo> voList = BeanUtil.list2list(baseSfAreaList, BaseSfAreaVo.class);
		return voList;
	}

	@Override
	public List<BaseSfAreaVo> findDistrictByParentId(int id) {
		List<BaseSfArea> baseSfAreaList =baseSfAreaService.findDistrictById(id);
		List<BaseSfAreaVo> voList = BeanUtil.list2list(baseSfAreaList, BaseSfAreaVo.class);
		return voList;
	}
	
}
