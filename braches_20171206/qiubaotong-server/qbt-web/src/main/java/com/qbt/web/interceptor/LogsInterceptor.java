package com.qbt.web.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qbt.common.logback.LogCvt;

public class LogsInterceptor extends HandlerInterceptorAdapter {

	
	private long begtime = 0l;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Thread.currentThread().setName(request.getSession().getId());
		begtime = System.currentTimeMillis();
		LogCvt.info("接收请求:"+request.getRequestURL());
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) throws Exception {
		if(ex != null){
			LogCvt.error(ex.getMessage(), ex);
		}
		LogCvt.info("完成请求["+(System.currentTimeMillis()-begtime)+"ms]:"+request.getRequestURL());
		super.afterCompletion(request, response, handler, ex);
	}
	
	
}
