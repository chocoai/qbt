package com.qbt.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.qbt.common.logback.LogCvt;

public class HttpClientUtil {

	public static String httpGet(String url){
		HttpClient client = new DefaultHttpClient();
		try {
	        HttpPost post = new HttpPost(url);
	        HttpResponse res = client.execute(post);
	 
	        BufferedReader br = new BufferedReader(new InputStreamReader(res.getEntity().getContent(), "UTF-8"));
	        StringBuffer sb = new StringBuffer();
	        String line = null;
	        while ((line =br.readLine()) != null) {
	            sb.append(line);
	        }
	        return sb.toString();
	       
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}finally{
			 client.getConnectionManager().shutdown();
		}
		return null;
		
	}
	
	public static String httpPost(String url,String body){
		HttpClient client = new DefaultHttpClient();
		try {
	        HttpPost post = new HttpPost(url);
	        StringEntity str = new StringEntity(body, "UTF-8");
	        post.setEntity(str);
	        HttpResponse res = client.execute(post);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(res.getEntity().getContent(), "UTF-8"));
	        StringBuffer sb = new StringBuffer();
	        String line = null;
	        while ((line =br.readLine()) != null) {
	            sb.append(line);
	        }
	        LogCvt.debug("http response body:"+sb.toString());
	        return sb.toString();
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}finally{
			 client.getConnectionManager().shutdown();
		}
		return null;
		
	}
}
