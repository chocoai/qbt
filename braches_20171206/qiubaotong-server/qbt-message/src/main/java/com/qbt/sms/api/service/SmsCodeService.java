
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
  * @ClassName: SmsCodeService
  * @Description: TODO
  * @author win10 2016年8月11日
  * @modify win10 2016年8月11日
  */

public interface SmsCodeService {
	
		public String getSmsCode(String mobile);
		
		public void checkSmsCode(String mobile,String smsCode,String smsToken);
}
