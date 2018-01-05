package com.qbt.common.spring.util;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.qbt.common.spring.enmus.ClientTypeEnum;

@Service
public class SessionUtils{
	
	public static final String CLIENT_TYPE 			= "_client";
	public static final String OS_TYPE 				= "_os";
	
	  public static ClientTypeEnum getClientType(){
	    Object ct = getAttribute("_client");
	    if ((ct != null) && ((ct instanceof ClientTypeEnum))) {
	      return (ClientTypeEnum)ct;
	    }
	    return ClientTypeEnum.TOUCH;
	  }
	
	  public static void setClientType(ClientTypeEnum clientType){
	    setAttribute("_client", clientType == null ? ClientTypeEnum.TOUCH : clientType);
	  }
	
	  /**
	   *  request 作用域中获取信息
	    * @Title: getAttributeAsString
	    * @Description: TODO
	    * @author: share 2014年10月11日
	    * @modify: share 2014年10月11日
	    * @param @param key
	    * @param @return    
	    * @return String    
	    * @throws
	   */
	  public static String getAttributeAsString(String key) {
	    Object obj = getAttribute(key);
	    return obj == null ? null : String.valueOf(getAttribute(key));
	  }
	
	  public static Object getAttribute(String key) {
	    return RequestContextHolder.currentRequestAttributes().getAttribute(key, RequestAttributes.SCOPE_SESSION);
	  }
	
	  public static void setAttribute(String key, Object value)
	  {
	    RequestContextHolder.currentRequestAttributes().setAttribute(key, value, RequestAttributes.SCOPE_SESSION);
	  }
	  
	  public static Object getGlobalAttribute(String key) {
		    return RequestContextHolder.currentRequestAttributes().getAttribute(key, RequestAttributes.SCOPE_GLOBAL_SESSION);
	  }
	  
	  public static void setGlobalAttribute(String key, Object value)
	  {
	    RequestContextHolder.currentRequestAttributes().setAttribute(key, value, RequestAttributes.SCOPE_GLOBAL_SESSION );
	  }
	  
  
	
}