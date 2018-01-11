package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.VipType;
import com.qbt.service.VipTypeService;
import com.qbt.web.pojo.vipType.VipTypePageReqVo;
import com.qbt.web.pojo.vipType.VipTypeVo;
import com.qbt.web.support.VipTypeSupport;

@Service
public class VipTypeSupportImpl implements VipTypeSupport {

	@Resource
	private VipTypeService vipTypeService;
	
	@Override
	public List<VipTypeVo> findByPage(VipTypePageReqVo reqVo) {
		PageEntity<VipType> pageEntity = BeanUtil.pageConvert(reqVo, VipType.class);
		List<VipType> list = vipTypeService.findByPage(pageEntity);
		List<VipTypeVo> voList = BeanUtil.list2list(list, VipTypeVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public VipTypeVo findById(Integer id) {
		VipType vipType =  vipTypeService.findById(id);
		VipTypeVo vo = BeanUtil.a2b(vipType, VipTypeVo.class);
		return vo;
	}

	@Override
	public void updateStatus(VipTypeVo vo) {
		VipType vipType = BeanUtil.a2b(vo, VipType.class);
		vipTypeService.updateStatus(vipType);
	}

	@Override
	public void add(VipTypeVo vo) {
		VipType condition = new VipType();
		condition.setName(vo.getName());
		List<VipType> qryList = vipTypeService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("会员类型名称已被使用");
		}
		VipType vipType = BeanUtil.a2b(vo, VipType.class);
		vipTypeService.add(vipType);
	}

}
