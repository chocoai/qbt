
/**
 *
 */
package com.qbt.sms.api.service;

import java.util.HashMap;

public interface SmsSendService {
	
	public HashMap<String,Object> sendSms(String[] mobile ,String templateId,String[] params);
	
}
