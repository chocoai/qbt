/*   
* Copyright © 2008 F-Road All Rights Reserved.
*  
* This software is the confidential and proprietary information of   
* Founder. You shall not disclose such Confidential Information   
* and shall use it only in accordance with the terms of the agreements   
* you entered into with Founder.   
*   
*/

/**
 * 
 * @Title: MerchantAccountLogic.java
 * @Package com.froad.util
 * @see: 属性拷贝类 
 * @author f-road
 * @date 2015年3月29日
 */
package com.qbt.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qbt.common.entity.BaseDiffEnum;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ExpressTypeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Paging;


/**    
 * <p>Title: BeanUtil.java</p>    
 * <p>Description: 描述 </p>   
 * @author vania      
 * @version 1.0    
 * @created 2015年3月29日 下午9:44:51   
 */   
public class BeanUtil {
	
	/**
	 *  Object to Object
	  * @Title: a2b
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param src
	  * @param destClasz
	  * @return
	 */
	public static <T> T a2b(Object src,Class<T> destClasz){
		try {
			String srcJson = JSonUtil.toJSonString(src);
			return JSonUtil.toObject(srcJson, destClasz);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return null;
	}
	
	/**
	 *  List to List
	  * @Title: list2list
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param srcList
	  * @param destClasz
	  * @return
	 */
	public static <T,E> List<T> list2list(List<E> srcList,Class<T> destClasz){
		try {
			List<T> destList = new ArrayList<T>();
			if(srcList == null || srcList.isEmpty()){
				return destList;                 
			}
			for(E src : srcList){
				destList.add(a2b(src, destClasz));
			}
			return destList;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return null;
	}
	
	/**
	 *  A to B from A different value
	  * @Title: a2bDiff
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param src 
	  * @param dest
	  * @param clasz
	  * @return
	 */
	public static <T>T a2bDiff(Object src, Object dest, Class<T> clasz){
		try {
			String srcJson = JSonUtil.toJSonString(src);
			String destJson = JSonUtil.toJSonString(dest);
			JSONObject srcObject = JSON.parseObject(srcJson);
			JSONObject destObject = JSON.parseObject(destJson);
			
			int diffCount = 0;
			JSONObject targetObjct = new JSONObject();
			for(String key : srcObject.keySet()){
				if(!srcObject.get(key).equals(destObject.get(key))){
					targetObjct.put(key, srcObject.get(key));
					diffCount ++;
				}
			}
			targetObjct.put("diffCount", diffCount);
			String targetJson = targetObjct.toJSONString();
			LogCvt.info("A to B different value:"+targetJson);
			return JSonUtil.toObject(targetJson, clasz);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return null;
	}
	
	public static String a2bDiffStr(Object src, Object dest, Map<String, String> filedValueMap, Map<String, BaseDiffEnum> filedEnumMap) {
		StringBuilder sb = new StringBuilder();
		try {
			String srcJson = JSonUtil.toJSonString(src);
			String destJson = JSonUtil.toJSonString(dest);
			JSONObject srcObject = JSON.parseObject(srcJson);
			JSONObject destObject = JSON.parseObject(destJson);
			
			JSONObject targetObjct = new JSONObject();
			for(String key : srcObject.keySet()){
				if(!srcObject.get(key).equals(destObject.get(key)) && filedValueMap.containsKey(key)){
					targetObjct.put(key, srcObject.get(key));
					if(filedEnumMap.containsKey(key)) {
						sb.append("[").append(filedValueMap.get(key)).append("]").append("修改前:").append(filedEnumMap.get(key).getBefor()).append("|修改后:").append(filedEnumMap.get(key).getAfter()).append("\n");
					}else {
						sb.append("[").append(filedValueMap.get(key)).append("]").append("修改前:").append(destObject.get(key)).append("|修改后:").append(srcObject.get(key)).append("\n");
					}
				}
			}
			return sb.toString();
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return null;
	}
	
	
	public static <T> PageEntity<T> pageConvert(Paging paging, Class<T> clazz){
		T condition = a2b(paging, clazz);
		PageEntity<T> pageEntity = new PageEntity<T>();
		pageEntity.setCondition(condition);
		pageEntity.setPageNumber(paging.getPageNo());
		pageEntity.setPageSize(paging.getPageSize());
		pageEntity.setOrderByColumn(paging.getOrderByColumn());
		pageEntity.setOrderByType(paging.getOrderByType());
		return pageEntity;
		
	}
	
}
