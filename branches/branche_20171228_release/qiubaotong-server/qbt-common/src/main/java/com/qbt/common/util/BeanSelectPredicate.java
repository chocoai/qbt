package com.qbt.common.util;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.util.Assert;

public class BeanSelectPredicate implements Predicate{
	private String property;
	private Object value;
	
	public BeanSelectPredicate(String property, Object value) {
		this.property = property;
		this.value = value;
	}
	

	public boolean evaluate(Object object) {
		try {  
            Object beanPropertyValue = null;  
            if (property.indexOf(".") > 0) {  
            	beanPropertyValue = PropertyUtils.getNestedProperty(object, property);  
            } else {  
            	beanPropertyValue = PropertyUtils.getProperty(object, property);  
            }  
            if (beanPropertyValue == null) {  
                return false;  
            }  
            if (!value.getClass().equals(beanPropertyValue.getClass())) {  
                throw new RuntimeException();  
            }  
            return compareBeanProperty(beanPropertyValue, value);  
        } catch (Exception e) {  
        	e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());  
        }  
	}
	
	private boolean compareBeanProperty(Object beanPropertyValue, Object value) {
		Assert.notNull(beanPropertyValue);
		Assert.notNull(value);
		
		String typeStr = value.getClass().toString();
		if(typeStr.endsWith("byte") || typeStr.endsWith("Byte")){
			if(Byte.parseByte(beanPropertyValue.toString()) == Byte.parseByte(value.toString())) {
				return true;
			} else {
				return false;
			}
		} else if(typeStr.endsWith("short") || typeStr.endsWith("Short")){
			if(Short.parseShort(beanPropertyValue.toString()) == Short.parseShort(value.toString())) {
				return true;
			} else {
				return false;
			}
		} else if(typeStr.endsWith("int") || typeStr.endsWith("Integer")) {
			if(Integer.parseInt(beanPropertyValue.toString()) == Integer.parseInt(value.toString())) {
				return true;
			} else {
				return false;
			}
		} else if(typeStr.endsWith("long") || typeStr.endsWith("Long")) {
			if(Long.parseLong(beanPropertyValue.toString()) == Long.parseLong(value.toString())) {
				return true;
			} else {
				return false;
			}
		} else if(typeStr.endsWith("float") || typeStr.endsWith("Float")) {
			if(Float.parseFloat(beanPropertyValue.toString()) == Float.parseFloat(value.toString())) {
				return true;
			} else {
				return false;
			}
		} else if(typeStr.endsWith("double") || typeStr.endsWith("Double")) {
			if(Double.parseDouble(beanPropertyValue.toString()) == Double.parseDouble(value.toString())) {
				return true;
			} else {
				return false;
			}
		} else if(typeStr.endsWith("boolean") || typeStr.endsWith("Boolean")) {
			if(Boolean.parseBoolean(beanPropertyValue.toString()) == Boolean.parseBoolean(value.toString())) {
				return true;
			} else {
				return false;
			}
		} else if(typeStr.endsWith("char") || typeStr.endsWith("Character")) {
			if(beanPropertyValue.toString().equals(value.toString())) {
				return true;
			} else {
				return false;
			}
		} else {
			if(beanPropertyValue.equals(value)) {
				return true;
			} else {
				return false;
			}
		}
	}
}

