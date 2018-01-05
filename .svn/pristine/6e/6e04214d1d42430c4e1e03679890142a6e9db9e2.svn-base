package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.Feedback;
import com.qbt.service.FeedbackService;
import com.qbt.web.pojo.feedBack.FeedbackPageReqVo;
import com.qbt.web.pojo.feedBack.FeedbackVo;
import com.qbt.web.support.FeedbackSupport;

@Service
public class FeedbackSupportImpl implements FeedbackSupport{

	@Resource
	private FeedbackService feedbackService;
	
	@Override
	public List<FeedbackVo> findByPage(FeedbackPageReqVo reqVo) {
		PageEntity<Feedback> pageEntity = BeanUtil.pageConvert(reqVo, Feedback.class);
		List<Feedback> list = feedbackService.findByPage(pageEntity);
		List<FeedbackVo> voList = BeanUtil.list2list(list, FeedbackVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
