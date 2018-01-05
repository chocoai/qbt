
 /**
 * @Title: FeedBackController.java
 * @Package com.qbt.web.controller
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月14日
 * @version V1.0
 **/

package com.qbt.web.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.result.Result;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.feedback.FeedbackVO;
import com.qbt.web.support.FeedbackSupport;
import com.qbt.web.support.LoginSupport;

/**
  * @ClassName: FeedBackController
  * @Description: 投诉和建议
  * @author win10 2016年8月14日
  * @modify win10 2016年8月14日
  */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Resource
	private FeedbackSupport feedbackSupport;
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public Result<String> getCode(HttpServletRequest request,@RequestBody FeedbackVO vo){
		Result<String> result=new Result<String>();
		String openid = String.valueOf(request.getAttribute("openid"));
        UserWeixin user = loginSupport.findByOpenId(openid);
        vo.setUserId(user.getId());
        vo.setUserNickname(user.getNickname());
		feedbackSupport.insert(vo);
		return result;
		
	}

}
