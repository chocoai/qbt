package com.qbt.common.spring.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.qbt.common.logback.LogCvt;

public class MySimpleMappingExceptionResolver extends SimpleMappingExceptionResolver{
  
  /**
   *  全局异常处理
    * @Title: doResolveException
    * @Description: TODO
    * @author: share 2014年10月11日
    * @modify: share 2014年10月11日
    * @param @param request
    * @param @param response
    * @param @param handler
    * @param @param ex
    * @param @return
    * @throws
    * @see org.springframework.web.servlet.handler.SimpleMappingExceptionResolver#doResolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
   */
  protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
  {
    LogCvt.error("Spring 全局异常捕获:", ex);

    return null;
  }

}