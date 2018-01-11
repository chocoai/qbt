package com.geling.msg.config;

import java.util.HashMap;
import java.util.Map;


public class MessagePool {
	

	private static Map<String,WechatServiceConfig> serviceWechatMap = new HashMap<String, WechatServiceConfig>();
	
	private static Map<String,String> serviceSmsMap = new HashMap<String, String>();
	
	
	private static String  template_url;
	
	private static String  acess_token_url;
	
	/**
	 *  加载启动服务
	  * @Title: loadService
	  * @Description: TODO
	  * @author: share 2015年4月29日
	  * @modify: share 2015年4月29日
	  * @param @param services    
	  * @return void    
	  * @throws
	 */
	public static void loadWechatService(XmlWechat services){
		
		acess_token_url = services.getAcess_token_url();
				
		template_url = services.getTemplate_url();
				
		for(WechatServiceConfig cfg : services.getConfig()){
			serviceWechatMap.put(cfg.getSysid(), cfg);
		}
	}
	
	
	public static void loadSmsService(XmlSms services){
		
		for(SmsServiceConfig cfg : services.getConfig()){
			serviceSmsMap.put(cfg.getTid(), cfg.getTcontent());
		}
	}
	
	/**
	 * getter method 
	 * @Title: getServiceWechatMap
	 * @return the serviceWechatMap
	 */
	
	public static Map<String, WechatServiceConfig> getServiceWechatMap() {
		return serviceWechatMap;
	}






	
	/**
	* setter method
	* @param serviceWechatMap the serviceWechatMap to set
	*/
	
	public static void setServiceWechatMap(Map<String, WechatServiceConfig> serviceWechatMap) {
		MessagePool.serviceWechatMap = serviceWechatMap;
	}






	/**
	 * getter method 
	 * @Title: getTemplate_url
	 * @return the template_url
	 */
	
	public static String getTemplate_url() {
		return template_url;
	}


	
	/**
	* setter method
	* @param template_url the template_url to set
	*/
	
	public static void setTemplate_url(String template_url) {
		MessagePool.template_url = template_url;
	}


	
	/**
	 * getter method 
	 * @Title: getAcess_token_url
	 * @return the acess_token_url
	 */
	
	public static String getAcess_token_url() {
		return acess_token_url;
	}


	
	/**
	* setter method
	* @param acess_token_url the acess_token_url to set
	*/
	
	public static void setAcess_token_url(String acess_token_url) {
		MessagePool.acess_token_url = acess_token_url;
	}

	
	/**
	 * getter method 
	 * @Title: getServiceSmsMap
	 * @return the serviceSmsMap
	 */
	
	public static Map<String, String> getServiceSmsMap() {
		return serviceSmsMap;
	}

	
	/**
	* setter method
	* @param serviceSmsMap the serviceSmsMap to set
	*/
	
	public static void setServiceSmsMap(Map<String, String> serviceSmsMap) {
		MessagePool.serviceSmsMap = serviceSmsMap;
	}
	
	
}

