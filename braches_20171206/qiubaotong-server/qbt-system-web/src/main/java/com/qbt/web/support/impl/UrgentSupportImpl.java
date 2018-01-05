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
import com.qbt.persistent.entity.Urgent;
import com.qbt.service.UrgentService;
import com.qbt.web.pojo.urgent.UrgentAddReqVo;
import com.qbt.web.pojo.urgent.UrgentPageReqVo;
import com.qbt.web.pojo.urgent.UrgentVo;
import com.qbt.web.support.UrgentSupport;

@Service
public class UrgentSupportImpl implements UrgentSupport {
	
	@Resource
	private UrgentService urgentService;
	
	@Override
	public List<UrgentVo> findByPage(UrgentPageReqVo reqVo) {
		PageEntity<Urgent> pageEntity = BeanUtil.pageConvert(reqVo, Urgent.class);
		
		List<Urgent> list = urgentService.findByPage(pageEntity);
		List<UrgentVo> voList = new ArrayList<UrgentVo>();
		for(Urgent act : list){
			UrgentVo vo = BeanUtil.a2b(act, UrgentVo.class);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public UrgentVo findById(Integer id) {
		Urgent activity = urgentService.findById(id);
		UrgentVo vo = BeanUtil.a2b(activity, UrgentVo.class);
		return vo;
	}

	@Override
	public int add(UrgentAddReqVo vo) {
		Urgent urgent = BeanUtil.a2b(vo, Urgent.class);
		
		List<Urgent> existedUrgents = getExistedUrgent(vo);
		if(existedUrgents != null && existedUrgents.size()>0) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "已存在加急数据");
		}
		
		int activityId = urgentService.insert(urgent);
		return activityId;
	}

	private List<Urgent> getExistedUrgent(UrgentVo vo) {
		Urgent searchCondition = new Urgent();
		searchCondition.setFromProvince(vo.getFromProvince());
		searchCondition.setFromCity(vo.getFromCity());
		searchCondition.setToProvince(vo.getToProvince());
		searchCondition.setToCity(vo.getToCity());
		
		List<Urgent> existedUrgents = urgentService.findByCondition(searchCondition);
		return existedUrgents;
	}

	@Override
	public boolean update(UrgentVo vo) {
		
		List<Urgent> existedUrgents = getExistedUrgent(vo);
		if (existedUrgents != null && existedUrgents.size() > 0 && 
				existedUrgents.get(0).getId() != vo.getId()) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "已存在加急数据");
		}
		
		Urgent urgent = urgentService.findById(vo.getId());
		if(Checker.isEmpty(urgent)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效数据");
		}
		urgent.setName(vo.getName());
		urgent.setDescription(vo.getDescription());
		urgent.setFromProvince(vo.getFromProvince());
		urgent.setFromCity(vo.getFromCity());
		urgent.setToProvince(vo.getToProvince());
		urgent.setToCity(vo.getToCity());
		urgent.setOperator(vo.getOperator());
		
		return urgentService.update(urgent) > 0;
	}

	@Override
	public List<Urgent> findByCondition(UrgentVo vo) {
		Urgent urgent = BeanUtil.a2b(vo, Urgent.class);
		List<Urgent> urgentList = urgentService.findByCondition(urgent);
		return urgentList;
	}

	@Override
	public int deleteById(Integer id) {
		return urgentService.deleteById(id);
	}

	
}
