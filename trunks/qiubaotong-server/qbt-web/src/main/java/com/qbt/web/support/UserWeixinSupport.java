
 /**
 * @Title: UserWeixinSupport.java
 * @Package com.qbt.web.support
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年4月11日
 * @version V1.0
 **/

package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.user.Contacts;
import com.qbt.web.pojo.user.UserCourseVo;

/**
  * @ClassName: UserWeixinSupport
  * @Description: TODO
  * @author chenxiaocong 2017年4月11日
  * @modify chenxiaocong 2017年4月11日
  */

public interface UserWeixinSupport {

	List<Contacts> findOldContactsByUserId(int userId);
	
	List<UserCourseVo> findCourseByUserId(int userId);

	void deleteOldContactsById(Integer userId, Integer id) throws BusinessException;
	
}
