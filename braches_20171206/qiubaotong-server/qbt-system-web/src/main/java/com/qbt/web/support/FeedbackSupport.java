package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.feedBack.FeedbackPageReqVo;
import com.qbt.web.pojo.feedBack.FeedbackVo;

public interface FeedbackSupport {

	List<FeedbackVo> findByPage(FeedbackPageReqVo reqVo);

}
