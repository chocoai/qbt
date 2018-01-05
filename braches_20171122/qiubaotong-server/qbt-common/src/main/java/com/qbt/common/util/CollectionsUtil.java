package com.qbt.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
/**
 * Collections utils
 * @author kevin
 *
 */
public final class CollectionsUtil {

	/**
     * 分割List
     * @param list 待分割的list
     * @param pageSize 每段list的大小
     * @return List<<List<T>>
     */
    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int listSize = list.size(); 
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray = new ArrayList<List<T>>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<T>(); 
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j)); 
                }
                if ((j + 1) == ((j + 1) * pageSize)) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }
    
    /**
     * 字符串按分割符转换成list
     * @param str
     * @param regex
     * @return
     */
    public static List<String> strToList(String str, String regex){
    	List<String> list = new ArrayList<String>();
    	if(Checker.isEmpty(str)){
    		return list;
    	}
    	String[] array = str.split(regex);
    	
    	for(String s : array){
    		list.add(s);
    	}
    	return list;
    }
    
    /**
     * 字符串按逗号分割转换成list
     * @param str
     * @return
     */
    public static List<String> strToList(String str){
    	return strToList(str, ",");
    }
    
    
    public static String listToStr(Collection<String> list, String regex){
    	return StringUtils.join(list, regex);
    }
    
}
