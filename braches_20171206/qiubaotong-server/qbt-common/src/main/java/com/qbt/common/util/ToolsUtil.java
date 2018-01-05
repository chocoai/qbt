package com.qbt.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class ToolsUtil {

	public static String getUUID() {
		return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getUID(String... prefix) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String name = sdf.format(new Date());
		if(prefix != null && prefix.length>0){
			return prefix[0]+"_"+name;
		}
		return name;
	}
	
	public static String creatOrderId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String name = sdf.format(new Date());
		return name + RandomProvider.randomNumeric(4);
	}
	
	public static String creatSn(int userId) {
		
		return String.valueOf(userId) + RandomProvider.randomNumeric(6);
	}
	
	/**
	 *  创建No
	  * @Title: createOrder
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @param prefix
	  * @param type
	  * @param num
	  * @return
	 */
	public static String createNo(String prefix,String yyymmdd,String type,long num) {
		return prefix+yyymmdd+type+StringUtils.leftPad(String.valueOf(num), 8, '0');
	}
	
	public static String createOrderNo(String prefix,String yyymmdd,long num) {
		return prefix+yyymmdd+StringUtils.leftPad(String.valueOf(num), 3, '0')+RandomProvider.randomNumeric(2);
	}

	public static String getFileSavePath(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String name = sdf.format(new Date());
		String fileUploadPath = "/"+name;
		return fileUploadPath;
	}
	
	public static String getUploadFilePath(HttpServletRequest request){
		 String uploadPath =  request.getSession().getServletContext().getRealPath("/upload"); 
		 return uploadPath;
	}
	
	
	
	
	public static void deleteFile(String filePath){
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
	}
	
	public static String hideName(String name){
		String names = "";
		if(name!=null && name.length()==2){
		  names = "*" + name.substring(name.length()-1,name.length());
		}else if(name!=null && name.length()>2){
			names = name.substring(0, 1)+ "****" + name.substring(name.length()-1,name.length());
		}else{
			return name+"*";
		}
		return names;
	}
	
	public static String hideMobile(String mobile){
		if(mobile != null && mobile.length()>=7){
			return mobile.substring(0,3)+"****"+mobile.substring(mobile.length()-4);
		}
		return mobile;
	}
}