package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SfNotifyConfig;

public interface SfNotifyConfigService {
	
	/**
	 * 分页查询
	 * @param pageEntity
	 * @return
	 */
	List<SfNotifyConfig> findByPage(PageEntity<SfNotifyConfig> pageEntity);
	
	/**
	 * 新增活动
	 * @param urgent
	 * @return
	 */
	int insert(SfNotifyConfig urgent);
	
	
	int deleteById(Integer id);
	
	boolean isDisabledNotify(String orderNumber);
}
