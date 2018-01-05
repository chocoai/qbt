package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseSfTime;
import com.qbt.service.BaseSfTimeService;
import com.qbt.web.pojo.baseSfTime.BaseSfTimePageReqVo;
import com.qbt.web.pojo.baseSfTime.BaseSfTimeVo;
import com.qbt.web.support.BaseSfTimeSupport;

@Service
public class BaseSfTimeSupportImpl implements BaseSfTimeSupport {

	@Resource
	private BaseSfTimeService baseSfTimeService;
	
	@Override
	public List<BaseSfTimeVo> findByPage(BaseSfTimePageReqVo reqVo) {
		PageEntity<BaseSfTime> pageEntity = BeanUtil.pageConvert(reqVo, BaseSfTime.class);
		List<BaseSfTime> list = baseSfTimeService.findByPage(pageEntity);
		List<BaseSfTimeVo> voList = BeanUtil.list2list(list, BaseSfTimeVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void add(BaseSfTimeVo vo) throws BusinessException {
		BaseSfTime condition = new BaseSfTime();
		condition.setName(vo.getName());
		List<BaseSfTime> qryList = baseSfTimeService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("名称已被使用");
		}
		BaseSfTime baseSfTime = BeanUtil.a2b(vo, BaseSfTime.class);
		baseSfTimeService.insert(baseSfTime);
	}

	@Override
	public void updateById(BaseSfTimeVo vo) throws BusinessException {
		BaseSfTime temp = baseSfTimeService.findById(vo.getId());
		if(!temp.getName().equals(vo.getName())){
			BaseSfTime condition = new BaseSfTime();
			condition.setName(vo.getName());
			List<BaseSfTime> qryList = baseSfTimeService.findByCondition(condition);
			if(Checker.isNotEmpty(qryList)){
				throw new BusinessException("名称已被使用");
			}
		}
		BaseSfTime baseSfTime = BeanUtil.a2b(vo, BaseSfTime.class);
		baseSfTimeService.updateById(baseSfTime);
	}

	@Override
	public BaseSfTimeVo findById(Integer id) {
		BaseSfTime baseSfTime =  baseSfTimeService.findById(id);
		BaseSfTimeVo vo = BeanUtil.a2b(baseSfTime, BaseSfTimeVo.class);
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		baseSfTimeService.deleteById(id);
	}
	
	
}
