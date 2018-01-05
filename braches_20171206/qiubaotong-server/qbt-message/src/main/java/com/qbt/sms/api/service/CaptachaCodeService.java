
 /**
 * @Title: SmsCodeService.java
 * @Package com.qbt.sms.api.service
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月11日
 * @version V1.0
 **/

package com.qbt.sms.api.service;


/**
 *  图片验证码存储
  * @ClassName: CaptachaCodeService
  * @Description: TODO
  * @author share 2017年3月2日
  * @modify share 2017年3月2日
 */
public interface CaptachaCodeService {
	
		public String saveCaptachaCode(String codeText);
		
		public void checkCaptachaCode(String code,String token);
}
