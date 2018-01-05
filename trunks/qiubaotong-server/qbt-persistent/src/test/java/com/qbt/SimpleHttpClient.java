package com.qbt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.qbt.common.logback.LogCvt;

public class SimpleHttpClient {

	public static String httpGet(String url){
		DefaultHttpClient client = new DefaultHttpClient();
		try {
	 
	        HttpGet post = new HttpGet(url);
	        HttpResponse res = client.execute(post);
	 
	        BufferedReader br = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
	        StringBuffer sb = new StringBuffer();
	        String line = null;
	        while ((line =br.readLine()) != null) {
	            sb.append(line);
	        }
	        return sb.toString();
	       
		} catch (Exception e) {
			// TODO: handle exception
			LogCvt.error(e.getMessage(),e);
		}finally{
			 client.getConnectionManager().shutdown();
		}
		return null;
		
	}
	
	public static String httpPost(String url,String body){
		DefaultHttpClient client = new DefaultHttpClient();
		try {
	 
	        HttpPost post = new HttpPost(url);
	        StringEntity str = new StringEntity(body);
	        post.setEntity(str);
	        HttpResponse res = client.execute(post);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
	        StringBuffer sb = new StringBuffer();
	        String line = null;
	        while ((line =br.readLine()) != null) {
	            sb.append(line);
	        }
	        return sb.toString();
	       
		} catch (Exception e) {
			// TODO: handle exception
			LogCvt.error(e.getMessage(),e);
		}finally{
			 client.getConnectionManager().shutdown();
		}
		return null;
		
	}
}
