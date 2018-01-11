/**
 * Project Name:qbt-system-web
 * File Name:BagCodePartnerSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年8月25日上午11:30:20
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.BagCodePartnerDto;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.BagCodePartner;
import com.qbt.service.ActivityService;
import com.qbt.service.BagCodePartnerService;
import com.qbt.web.pojo.bagCode.BagCodePartnerPageReq;
import com.qbt.web.pojo.bagCode.BagCodePartnerVo;
import com.qbt.web.support.BagCodePartnerSupport;

/**
 * ClassName:BagCodePartnerSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 上午11:30:20
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BagCodePartnerSupportImpl implements BagCodePartnerSupport {
	
	@Resource
	private BagCodePartnerService bagCodePartnerService;
	
	@Resource
	private ActivityService activityService;
	
	@Override
	public List<BagCodePartnerVo> findByPage(BagCodePartnerPageReq pageReq) {
		PageEntity<BagCodePartnerDto> pageEntity = BeanUtil.pageConvert(pageReq, BagCodePartnerDto.class);
		List<BagCodePartner> list = bagCodePartnerService.findByPage(pageEntity);
		List<BagCodePartnerVo> voList = BeanUtil.list2list(list, BagCodePartnerVo.class);
		pageReq.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public BagCodePartnerVo detail(Integer id) {
		BagCodePartner partner = bagCodePartnerService.selectById(id);
		BagCodePartnerVo vo = BeanUtil.a2b(partner, BagCodePartnerVo.class);
		return vo;
	}

	@Override
	public int add(BagCodePartnerVo vo) {
		//检查合作社名称和包包码是否重复
		BagCodePartner partner = BeanUtil.a2b(vo, BagCodePartner.class);
		int count = bagCodePartnerService.exists(partner);
		if(count > 0) {
			throw new BusinessException("合作社名称或包包码已存在");
		}
		//检查活动是否存在
		Activity activity = activityService.findById(vo.getActivityId());
		if(Checker.isEmpty(activity)) {
			throw new BusinessException("活动不存在");
		}
		partner.setActivityName(activity.getName());
		partner.setStatus(1);//状态 1-可用 2-禁用
		return bagCodePartnerService.insert(partner);
	}

	@Override
	public boolean update(BagCodePartnerVo vo) {
		//检查合作社名称和包包码是否重复
		BagCodePartner partner = BeanUtil.a2b(vo, BagCodePartner.class);
		int count = bagCodePartnerService.exists(partner);
		if (count > 0) {
			throw new BusinessException("合作社名称或包包码已存在");
		}
		// 检查活动是否存在
		Activity activity = activityService.findById(vo.getActivityId());
		if (Checker.isEmpty(activity)) {
			throw new BusinessException("活动不存在");
		}
		partner.setActivityName(activity.getName());
		return bagCodePartnerService.updateById(partner) > 0;
	}

}
