package com.geling.msg.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.geling.msg.logback.LogCvt;



public class HttpsClient {

	
	public static String httpsPost(String url){
		HttpClient client = new DefaultHttpClient();
		try {
	        client = WebClientDevWrapper.wrapClient(client);
	 
	        HttpPost post = new HttpPost(url);
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
	
	public static String httpsPost(String url,String body){
		HttpClient client = new DefaultHttpClient();
		try {
	        client = WebClientDevWrapper.wrapClient(client);
	 
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
