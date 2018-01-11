
 /**
 * @Title: FeedBackService.java
 * @Package com.qbt.service
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月14日
 * @version V1.0
 **/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Feedback;

/**
  * @ClassName: FeedBackService
  * @Description: TODO
  * @author win10 2016年8月14日
  * @modify win10 2016年8月14日
  */

public interface FeedbackService {
	
	public int insert(String mobile,String content);

	public List<Feedback> findByPage(PageEntity<Feedback> pageEntity);

	public void insert(Feedback feedback);

}