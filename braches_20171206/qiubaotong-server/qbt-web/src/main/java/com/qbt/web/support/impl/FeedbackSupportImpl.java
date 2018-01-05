package com.qbt.web.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.Feedback;
import com.qbt.service.FeedbackService;
import com.qbt.web.pojo.feedback.FeedbackVO;
import com.qbt.web.support.FeedbackSupport;

@Service
public class FeedbackSupportImpl implements FeedbackSupport{

	@Resource
	private FeedbackService feedbackService;
	
	@Override
	public void insert(FeedbackVO vo) {
		Feedback feedback = BeanUtil.a2b(vo, Feedback.class);
		feedbackService.insert(feedback);
	}

}
