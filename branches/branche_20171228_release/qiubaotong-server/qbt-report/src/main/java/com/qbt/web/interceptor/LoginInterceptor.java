package com.qbt.web.interceptor;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.support.TokenSupport;

public class LoginInterceptor extends HandlerInterceptorAdapter {


	@Resource
	private TokenSupport tokenSupport;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub

		if(handler instanceof HandlerMethod){
			try {
				String token = request.getParameter("token");
				
				if (token == null) {
					respError(response, null);
					return false;
				}
				
				SysUser sysUser = tokenSupport.tokenCheck(token);
				if(sysUser == null){
					throw new BusinessException(ErrorCodeEnum.ERROR_TIMEOUT);
				}
					
				return true;
			} catch (BusinessException e) {
				LogCvt.error(e.getMessage(), e);
				respError(response, e);
				return false;
			} catch (Exception e) {
				LogCvt.error(e.getMessage(), e);
				respError(response, null);
				return false;
			}
		}else{
			return super.preHandle(request, response, handler);
		}
	}
	
	public static void respError(HttpServletResponse response, BusinessException e) throws IOException{
		response.setContentType("application/json");
		String errCode = e == null ? ErrorCodeEnum.ERROR_AUTH.getCode() : e.getCode();
		String errMsg = e == null ? ErrorCodeEnum.ERROR_TIMEOUT.getMsg() : e.getMsg();
		response.getWriter().write("{\"code\":\""+errCode+"\",\"msg\":\""+errMsg+"\"}");
		response.flushBuffer();
	}
	
	
}
