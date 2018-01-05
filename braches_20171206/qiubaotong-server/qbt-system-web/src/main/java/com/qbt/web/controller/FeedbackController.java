package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.web.pojo.feedBack.FeedbackPageReqVo;
import com.qbt.web.pojo.feedBack.FeedbackVo;
import com.qbt.web.support.FeedbackSupport;

@Controller
@RequestMapping("feedBack")
public class FeedbackController {

	@Resource
	private FeedbackSupport feedBackSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<FeedbackVo>> findByPage(@RequestBody FeedbackPageReqVo reqVo){
		PageResult<List<FeedbackVo>> result = new PageResult<List<FeedbackVo>>();
		try {
			result.setDatas(feedBackSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "投诉建议分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
