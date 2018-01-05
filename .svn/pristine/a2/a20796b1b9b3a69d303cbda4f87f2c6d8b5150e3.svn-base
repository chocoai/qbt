/**
 * @Title: xx.java
 * @Package com.froad.iamp.test
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月3日
 * @version V1.0
**/

package com.qbt.sf.api.util;

 /**
  * @ClassName: xx
  * @Description: TODO
  * @author froad-win10 2016年8月3日
  * @modify froad-win10 2016年8月3日
 */

import java.util.ArrayList;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  
  
import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;  
import org.apache.http.ParseException;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.client.methods.HttpUriRequest;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.protocol.HTTP;  
import org.apache.http.util.EntityUtils;

import com.qbt.common.logback.LogCvt;  
  
/**
  * @ClassName: HttpXmlClient
  * @Description: post xml
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
public class HttpXmlClient {  
      
	
	/**
	  * @Title: post
	  * @Description: TODO
	  * @author: win10 2016年8月5日
	  * @modify: win10 2016年8月5日
	  * @param url
	  * @param params
	  * @return
	 */
    public static String post(String url, Map<String, String> params)throws Exception{ 
        DefaultHttpClient httpclient = new DefaultHttpClient();  
        String body = null;  
        try{
        	HttpPost post = postForm(url, params);  
        	body = invoke(httpclient, post); 
        }catch(Exception ex){
        	throw ex;
        }finally{
        	httpclient.getConnectionManager().shutdown();  
        }
        return body;  
    }  
    
      
    public static String get(String url)throws Exception{  
        DefaultHttpClient httpclient = new DefaultHttpClient();  
        String body = null;  
        try{
        HttpGet get = new HttpGet(url);  
        body = invoke(httpclient, get);  
        }catch(Exception ex){
        	throw ex;
        }finally{
        	httpclient.getConnectionManager().shutdown();  
        }
        return body;  
    }  
          
      
    private static String invoke(DefaultHttpClient httpclient,HttpUriRequest httpost)throws Exception {  
        HttpResponse response = httpclient.execute(httpost);  
        HttpEntity entity = response.getEntity();  
        String body = EntityUtils.toString(entity);  
        LogCvt.info("response sf-express content->"+body);
        return body;  
    }  
    
  
    @SuppressWarnings("deprecation")
	private static HttpPost postForm(String url, Map<String, String> params)throws Exception{  
        HttpPost httpost = new HttpPost(url); 
        List<NameValuePair> nvps = new ArrayList <NameValuePair>();  
        Set<String> keySet = params.keySet();  
        
        StringBuffer sb=new StringBuffer();
        for(String key : keySet) {
        	sb.append(key).append(":").append(params.get(key));
            nvps.add(new BasicNameValuePair(key, params.get(key)));  
        }  
        LogCvt.info("request sf-express content->"+sb.toString());
        
        httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));  
        return httpost;  
    }  
}  
