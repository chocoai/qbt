/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * yuxin
 */
package com.qbt.common.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qbt.common.logback.LogCvt;

/**
 * [文件名称]<br>
 * StringUtil <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-8 ver1.00 创建 yuxin <br>
 * 
 * @author yuxin
 * @version 1.00
 */
public class StringUtil {

    /**
     * 隐藏构造函数
     */
    private StringUtil() {

    }

    /**
     * String null-->""
     * 
     * @param value 传入的字符串
     * @return String null-->""
     */
    public static String nvl(String value) {
	if (value == null) {
	    return "";
	} else {
	    return value.trim();
	}
    }

    /**
     * @param value
     *            字符串
     * @return String ""-->null
     * 
     */
    public static String nvlNull(String value) {
	if (value == null || "".equals(value.trim())) {
	    return null;
	} else {
	    return value.trim();
	}
    }

    /**
     * 两个字符串比较
     * 
     * @param s1
     *            字符串1
     * @param s2
     *            字符串2
     * @return 如果两个字符串相同返回true，否则返回false
     * 
     */
    public static boolean isEqual(String s1, String s2) {
	if (s1 == null && s2 == null) {
	    // 两个字符串都是null，返回true
	    return true;
	}
	if (s1 == null) {
	    return false;
	}
	if (s2 == null) {
	    return false;
	}
	return s1.equals(s2);
    }

    /**
     * 判断字符串是否为null或者空串
     * 
     * @param value 传入的字符串
     * @return 如果为null或者空串，返回true，否则返回false
     */
    public static boolean isEmpty(String value) {
	if (value == null || "".equals(value.trim())) {
	    return true;
	} else {
	    return false;
	}
    }
    
    /**
     * 返回加密的银行账号作显示
     * @param memberBankAcct
     * @return
     */
    public static String getMemberBankAcctAlias(String memberBankAcct) {
    	int l = memberBankAcct.length();
		return "********"+memberBankAcct.substring(l-4);
	}

    public static String toColName(String proName){
    	StringBuffer msb = new StringBuffer();
    	char[] mchars = proName.toCharArray();
    	int code;
    	for (int i = 0; i < mchars.length; i++) {
    		code = proName.codePointAt(i);
    		if(code>=65&&code<=90){
    			msb.append('_');
    		}
    		msb.append(mchars[i]);
		}
    	return msb.toString().toUpperCase();
    }

    public static String readFile(InputStream in){
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append(temp+"\r\n");
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (null != br) {
				try {
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
    
    /**
     * 理财账户信息姓名加密后显示
     * 规则：只显示最后一个汉字，前面所有汉字以*代替
     * @param realname 真实姓名
     * @return 加密后姓名
     */
    public static String desMemberRealName(String realname){
    	int l = realname.length();
    	StringBuffer bf = new StringBuffer(20);
    	for(int i=0;i<l-1;i++){
    		bf.append("*");
    	}
    	bf.append(realname.substring(l-1));
    	return bf.toString();
    }
    
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    
    public static String left_fill(int num,int length){
    	String numbers = String.valueOf(num);
    	if(numbers.length() < length)numbers="";
    	while(numbers.length() < length){
    		numbers += "0"+num;
    	}
    	return numbers;
    }
    
    /** 
     * 手机号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8,7][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  
    /** 
     * 电话号码验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isPhone(String str) {   
        Pattern p1 = null,p2 = null;  
        Matcher m = null;  
        boolean b = false;    
        p1 = Pattern.compile("^[0][1-9]{2,3}-{0,1}[0-9]{5,10}$");  // 验证带区号的  
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的  
        if(str.length() >9)  
        {   m = p1.matcher(str);  
            b = m.matches();    
        }else{  
            m = p2.matcher(str);  
            b = m.matches();   
        }    
        return b;  
    }
    
    public static boolean isTelOrPhone(String str){
    	Pattern p1 = Pattern.compile("(^(0[0-9]{2,3}-?)?[0-9]{7,8}$)|(^1[\\d]{10}$)");
    	Matcher m = p1.matcher(str);  
        return m.matches();   
    	
    }
    

	public static String convertCharset(String xml, String charset, String to) {
		// TODO Auto-generated method stub
		try {
			return new String(xml.toString().getBytes(charset), to);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			LogCvt.debug(e.getMessage(), e);
		}
		return xml;
	}
	
	
	public static String urlencode(String str){
		try {
			return java.net.URLEncoder.encode(str,   "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			LogCvt.error(e.getMessage(), e);
		}
		return "";
	}
	
	public static String urldecode(String str){
		try {
			return java.net.URLDecoder.decode(str,   "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			LogCvt.error(e.getMessage(), e);
		}
		return "";
	}
	
	
	public static void main(String[] args) {
		String ss = "18688151354";
		System.out.println(isTelOrPhone(ss));
	}
}
