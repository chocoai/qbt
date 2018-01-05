package com.qbt.common.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController<T>{

	protected T form;
	protected Long id; //表单唯一值
	protected Long[] ids;//表单ID数据值值
	protected Page page;//表单分页对象
	protected String message;//表单操作提示语
	protected String returnUrl;//跳转URL
	
	protected String tipUri = "admin/tip.jsp";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public Page getPage() {
		return page;
	}

	/**
	 *  搜索实体vo对象，转换为map对象
	  * @Title: voToMap
	  * @Description: TODO
	  * @author: froad-zjz 2013-7-29
	  * @modify: froad-zjz 2013-7-29
	  * @param @param vo
	  * @param @return
	  * @param @throws Exception    
	  * @return Map<String,Object>    
	  * @throws
	 */
	public Map<String,Object> voToMap(T vo) throws Exception{
		Map<String,Object> conditionMap = new HashMap<String, Object>();
		
		Class<? extends Object> clazz = vo.getClass();
		Method[] methods = clazz.getMethods();//实体内部所有方法
		Field[] fields = clazz.getDeclaredFields();//获取内部所有的字段
		Field[] superFields = clazz.getSuperclass().getDeclaredFields();//获取父类内部所有的字段
		
		Map<String,String> methodMap = new HashMap<String, String>();
		for(Method method : methods){
			String methodName = method.getName();//实体方法字段名称
			methodMap.put(methodName.toLowerCase(), methodName) ;
		}
		
		for(Field field: fields){
			String fieldName = field.getName();//实体字段名称
			Object value = clazz.getMethod(methodMap.get("get"+fieldName.toLowerCase())).invoke(vo);
			conditionMap.put(fieldName, value);
		}
		
		for(Field field: superFields){
			String fieldName = field.getName();//实体字段名称
			Object value = clazz.getMethod(methodMap.get("get"+fieldName.toLowerCase())).invoke(vo);
			conditionMap.put(fieldName, value);
		}
		return conditionMap;
	}
	
	/**
	 *  绑定分页对象进行分页数据值的填充
	  * @Title: initBindPage
	  * @Description: TODO
	  * @author: froad-zjz 2013-7-29
	  * @modify: froad-zjz 2013-7-29
	  * @param @param binder    
	  * @return void    
	  * @throws
	 */
	@InitBinder("page") 
	public void initBindPage(WebDataBinder binder){
		  binder.setFieldDefaultPrefix("page.");//别名前缀
	}
	
}
