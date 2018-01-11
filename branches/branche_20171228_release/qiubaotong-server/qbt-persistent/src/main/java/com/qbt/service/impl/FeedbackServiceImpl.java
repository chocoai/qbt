
 /**
 * @Title: FeedbackServiceImpl.java
 * @Package com.qbt.service.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月14日
 * @version V1.0
 **/

package com.qbt.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Feedback;
import com.qbt.persistent.mapper.FeedbackMapper;
import com.qbt.service.FeedbackService;

/**
  * @ClassName: FeedbackServiceImpl
  * @Description: TODO
  * @author win10 2016年8月14日
  * @modify win10 2016年8月14日
  */


@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Resource
	private FeedbackMapper feedbackMapper;
	/**
	 * @Title: insert
	 * @Description: TODO
	 * @author: win10 2016年8月14日
	 * @modify: win10 2016年8月14日
	 * @param back
	 * @return
	 * @see com.qbt.service.FeedbackService#insert(com.qbt.persistent.entity.Feedback)
	 */

	@Override
	public int insert(String mobile,String content) {
		Feedback back=new Feedback();
		
		back.setContent(content);
		back.setCreateTime(new Date());
		back.setMobile(mobile);
		
		return feedbackMapper.insert(back);
	}
	@Override
	public List<Feedback> findByPage(PageEntity<Feedback> pageEntity) {
		// TODO Auto-generated method stub
		return feedbackMapper.findByPage(pageEntity);
	}
	@Override
	public void insert(Feedback feedback) {
		// TODO Auto-generated method stub
		feedbackMapper.insert(feedback);
	}

}
