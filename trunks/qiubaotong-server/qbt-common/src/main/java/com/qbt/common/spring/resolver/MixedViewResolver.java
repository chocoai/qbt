package com.qbt.common.spring.resolver;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

public class MixedViewResolver implements ViewResolver{

	private Map<String, ViewResolver> resolvers;
	
	private static final String REDIRECT_URL_PREFIX = "redirect:";
	private static final String FORWARD_URL_PREFIX = "forward:";
	
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		
		 // Check for special "redirect:" prefix.  
		  if (viewName.startsWith(REDIRECT_URL_PREFIX)) {  
		    String redirectUrl = viewName.substring(REDIRECT_URL_PREFIX.length());  
		    return new RedirectView(redirectUrl, true);  
		  }  
		  // Check for special "forward:" prefix.  
		  if (viewName.startsWith(FORWARD_URL_PREFIX)) {  
		    String forwardUrl = viewName.substring(FORWARD_URL_PREFIX.length());  
		    return new InternalResourceView(forwardUrl);  
		  }  
		
		int n = viewName.lastIndexOf("."); // 获取 
		String suffix = "jsp";
        // viewName(modelAndView中的名字)看其有没有下划线 
		if (n == (-1)){
			if(!viewName.contains("redirect")){
				return null; // 没有则直接返回空 
			}
		}else{
			// 有的话截取下划线后面的字符串 这里一般是jsp,ftl,vm与配置文件中的<entry key="ftl">的key匹配 
			suffix = viewName.substring(n + 1);
			// 取下划线前面的部分 那时真正的资源名.比如我们要使用hello.jsp 那viewName就应该是hello_jsp 
			viewName = viewName.substring(0, n);
		}
		
		// 根据下划线后面的字符串去获取托管的视图解析类对象 
		ViewResolver resolver = resolvers.get(suffix); 
		
		if (resolver != null) 
			return resolver.resolveViewName(viewName, locale); 
		return null; 
	}
	
	
	public Map<String, ViewResolver> getResolvers() { 
        return resolvers; 
    } 
 
    public void setResolvers(Map<String, ViewResolver> resolvers) { 
        this.resolvers = resolvers; 
    } 

}

