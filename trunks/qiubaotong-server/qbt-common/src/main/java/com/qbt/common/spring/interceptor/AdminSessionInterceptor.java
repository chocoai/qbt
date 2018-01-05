package com.qbt.common.spring.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qbt.common.spring.util.SessionUtils;

public class AdminSessionInterceptor extends HandlerInterceptorAdapter {


	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
	    return super.preHandle(request, response, handler);
	}
	
	
}
