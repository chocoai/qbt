
 /**
 * @Title: AssistanService.java
 * @Package com.qbt.web.support
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月18日
 * @version V1.0
 **/

package com.qbt.web.support;

import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.assistant.Assistant;

	/**
	  * @ClassName: AssistanService
	  * @Description: TODO
	  * @author win10 2016年8月18日
	  * @modify win10 2016年8月18日
	  */
public interface AssistantService {

	public void insertOrUpdateAssistant(UserWeixin userWeixin,Assistant assistant);
	
	public boolean checkIsPartner(Integer userId);
}
