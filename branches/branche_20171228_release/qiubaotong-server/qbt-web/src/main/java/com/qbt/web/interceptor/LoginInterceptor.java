package com.qbt.web.interceptor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qbt.common.logback.LogCvt;
import com.qbt.web.support.LoginSupport;

public class LoginInterceptor extends HandlerInterceptorAdapter {


	@Resource
	private LoginSupport LoginSupport;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String token = request.getHeader("token");
		String openid = LoginSupport.checkToken(token);
		if(openid == null){
			LogCvt.info("微信授权过期，请重新授权...");
			response.setContentType("application/json");
			response.setStatus(200);
			response.getWriter().write("{\"code\":\"0001\",\"msg\":\"请从公众号重新登入\"}");
			response.flushBuffer();
			return false;
		}
		request.setAttribute("openid", openid);
		return true;
	}
	
	
}
