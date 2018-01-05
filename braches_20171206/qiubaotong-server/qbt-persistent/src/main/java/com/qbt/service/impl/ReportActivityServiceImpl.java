package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.ReportActivity;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.mapper.ReportActivityMapper;
import com.qbt.service.ReportActivityService;

/**
 *  现金券报表服务
  * @ClassName: ReportActivityServiceImpl
  * @Description: TODO
  * @author share 2016年9月26日
  * @modify share 2016年9月26日
 */
@Service
public class ReportActivityServiceImpl implements ReportActivityService {

	@Resource
	private ReportActivityMapper reportActivityMapper;
	
	@Override
	public List<ReportActivity> findByPage(PageEntity<Activity> pageEntity) {
		return reportActivityMapper.findByPage(pageEntity);
	}

	@Override
	public List<ReportActivity> findAll(Activity activity) {
		return reportActivityMapper.findAll(activity);
	}

}
