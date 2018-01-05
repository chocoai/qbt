package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SfNotifyConfig;
import com.qbt.persistent.mapper.SfNotifyConfigMapper;
import com.qbt.service.SfNotifyConfigService;

@Service
public class SfNotifyConfigServiceImpl implements SfNotifyConfigService {
	
	@Resource
	private SfNotifyConfigMapper sfNotifyConfigMapper;
	
	@Override
	public List<SfNotifyConfig> findByPage(PageEntity<SfNotifyConfig> pageEntity) {
		return sfNotifyConfigMapper.findByPage(pageEntity);
	}

	@Override
	public int insert(SfNotifyConfig sfNotifyConfig) {
		sfNotifyConfigMapper.insert(sfNotifyConfig);
		return sfNotifyConfig.getId();
	}

	@Override
	public int deleteById(Integer id) {
		return sfNotifyConfigMapper.deleteById(id);
	}

	@Override
	public boolean isDisabledNotify(String orderNumber) {		
		
		List<SfNotifyConfig> notifys = sfNotifyConfigMapper.findByOrderNumber(orderNumber);
		
		if(notifys != null && notifys.size()>0) {
			return true;
		}
		
		return false;
	}

}
