package com.qbt.web.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.logback.LogCvt;
import com.qbt.web.support.WechatSupoort;
import com.qbt.wechat.api.WechatApi;
import com.qbt.wechat.entity.WeChat;

/**
 *  微信开发者模式接入
  * @ClassName: WechatController
  * @Description: TODO
  * @author share 2017年2月6日
  * @modify share 2017年2月6日
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {

	@Resource
	private WechatApi wehcatApi;
	@Resource
	private WechatSupoort wechatSupoort;
	
	
	@RequestMapping(method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	public void valid(WeChat weChat, PrintWriter out){
        String echostr = weChat.getEchostr();// 随机字符串  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (wehcatApi.checkSignature(weChat)) {  
            out.print(echostr);  
        } else {  
            LogCvt.info("不是微信服务器发来的请求,请小心!");  
        }  
        out.flush();  
        out.close();  
	}
	
	
	/**
	 * 扫一扫
	 * @param request
	 * @param response
	 */
	@RequestMapping(method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public void dispose(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out = null;  
		String respMessage = "";
		try {
			/* 消息的接收、处理、响应 */  
	        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
	        request.setCharacterEncoding("UTF-8");  
	        response.setCharacterEncoding("UTF-8");  
	  
	        /** 读取接收到的xml消息 */  
	        StringBuffer sb = new StringBuffer();  
	        InputStream is = request.getInputStream();  
	        InputStreamReader isr = new InputStreamReader(is, "UTF-8");  
	        BufferedReader br = new BufferedReader(isr);  
	        String s = "";  
	        while ((s = br.readLine()) != null) {  
	            sb.append(s);  
	        }  
	        String xml = sb.toString(); //次即为接收到微信端发送过来的xml数据  
	        LogCvt.info(">>Xml请求数据:"+xml);
	        // 调用核心业务类接收消息、处理消息  
	        respMessage = wechatSupoort.processRequest(xml);  
	        LogCvt.info(">>Xml响应数据:"+respMessage);
	        // 响应消息  
	        out = response.getWriter();  
	        out.print(respMessage);  
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		} finally{
			if(out !=null)
				out.close();  
		}
		
	}
	
}
