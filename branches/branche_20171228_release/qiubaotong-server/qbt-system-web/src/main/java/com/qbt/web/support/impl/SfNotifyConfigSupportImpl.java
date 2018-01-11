package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.SfNotifyConfig;
import com.qbt.service.SfNotifyConfigService;
import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigAddReqVo;
import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigPageReqVo;
import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigVo;
import com.qbt.web.support.SfNotifyConfigSupport;

@Service
public class SfNotifyConfigSupportImpl implements SfNotifyConfigSupport {
	
	@Resource
	private SfNotifyConfigService notifyService;
	
	@Override
	public List<SfNotifyConfigVo> findByPage(SfNotifyConfigPageReqVo reqVo) {
		PageEntity<SfNotifyConfig> pageEntity = BeanUtil.pageConvert(reqVo, SfNotifyConfig.class);
		
		List<SfNotifyConfig> list = notifyService.findByPage(pageEntity);
		List<SfNotifyConfigVo> voList = new ArrayList<SfNotifyConfigVo>();
		for(SfNotifyConfig act : list){
			SfNotifyConfigVo vo = BeanUtil.a2b(act, SfNotifyConfigVo.class);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public int add(SfNotifyConfigAddReqVo vo) {
		SfNotifyConfig urgent = BeanUtil.a2b(vo, SfNotifyConfig.class);
		
		if(notifyService.isDisabledNotify(vo.getOrderNumber())) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "已存在通知数据");
		}
		
		int activityId = notifyService.insert(urgent);
		return activityId;
	}

	@Override
	public int deleteById(Integer id) {
		return notifyService.deleteById(id);
	}
}
