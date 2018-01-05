
 /**
 * @Title: SmsSendTest.java
 * @Package com.qbt.sms.test
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月9日
 * @version V1.0
 **/

package com.qbt.sms.test;

import org.junit.Test;

import com.qbt.sms.api.service.SmsSendService;
import com.qbt.sms.api.service.impl.SmsSendServiceImpl;

/**
  * @ClassName: SmsSendTest
  * @Description: TODO
  * @author win10 2016年8月9日
  * @modify win10 2016年8月9日
  */

public class SmsSendTest {
	
	@Test
	public void smsSend() throws Exception{
		SmsSendService smsSend=new SmsSendServiceImpl();
		
		System.out.println(smsSend.sendSms(new String[]{"13928071915"}, "86638", new String[]{"测试1","测试2","测试3","测试4","测试5"}));
		
	}

}
