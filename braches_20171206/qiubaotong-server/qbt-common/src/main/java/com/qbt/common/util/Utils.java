package com.qbt.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/**
 * @author Jimmy Shan
 * 工具类
 */
public class Utils {
	
	/**
	 * @param str
	 * @return
	 * 是否是数字 整数
	 */
	public static boolean isNumeric(String str) {
		for(int i=str.length();--i>=0;){
			int chr=str.charAt(i);
			if(chr<48 || chr>57){
				return false;
			}	
		}
		return true;
	}
	
	/**
	 * @param str
	 * @return
	 * 判断不为空
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null && str.trim().length()>0){
			return true;
		}
		
		return false;
	}
	

    /**
     * @param d
     * @return
     * 数字格式，不保留小数，格式：####
     */
    public static String formatNumberByNoDecimal2(double d) {
        String s = "";
        String pattern = "####";
        try{
          DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance();
          nf.applyPattern(pattern);
          s = nf.format(d);
        }catch(Exception e){
          e.printStackTrace();
        }
        return s;
    }
    
    
    /**
     * @param d
     * @return
     * 数字格式，不保留小数，格式：#,###
     */
    public static String formatNumberByNoDecimal(double d){
        String s = "";
        String pattern = "#,###";
        try{
          DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance();
          nf.applyPattern(pattern);
          s = nf.format(d);
        }catch(Exception e){
          e.printStackTrace();
        }
        return s;
    }
    
    /**
     * @param d
     * @return
     * 数字格式，保留2位小数，格式：#,###.##
     */
    public static String formatNumberByDecimal(double d){
    	String pattern = "#,###.##";
        String s = "";
        try{
          DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance();
          nf.applyPattern(pattern);
          nf.setMinimumFractionDigits(2);   
          s = nf.format(d);
        }catch(Exception e){
          e.printStackTrace();
        }
        return s;
    }
    
    /**
     * @param d 金额 单位：分
     * @param type 类型 CNY人民币  USD美元  EUR日元
     * @param showType 返回金额显示格式 1####  2#,###  3#,###.##
     * @return
     */
    public static String formatCurrency(double d, String type, int showType) {
    	if("CNY".equals(type)){
    		//人民币
    		double amt = d / 100;
    		if(showType==1){
    			return formatNumberByNoDecimal2(amt);
    		}else if(showType==2){
    			return formatNumberByNoDecimal(amt);
    		}else if(showType==3){
    			return formatNumberByDecimal(amt);
    		}
    	}
    	
    	return null;
    }
    
    
    
    /**
     * @param d  金额
     * @param type 货币类型
     * @return
     * 货币格式
     */
	public static String formatCurrency(double d,String type){
		if("CNY".equals(type)){
		   return formatCNYCurrency(d);//人民币
		}
		if("USD".equals(type)){
		   return formatUSDCurrency(d);//美元
		}
		if("EUR".equals(type)){
		   return formatEURCurrency(d);//日元
		}
		return null;
	}
    
    /**
     * @param d
     * @return
     * 人民币 金额 格式
     */
	public static String formatCNYCurrency(double d){
		String s = "";
		
		try{
			DecimalFormat nf = (DecimalFormat)NumberFormat.getCurrencyInstance(Locale.CHINA); 
			s = nf.format(d);
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * @param d
	 * @return
	 * 美元 金额 格式
	 */
	public static String formatUSDCurrency(double d){
		String s = "";
		
		try{
			DecimalFormat nf = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
			s = nf.format(d);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return s;
	}
    
	/**
	 * @param d
	 * @return
	 * 日元 金额 格式
	 */
	public static String formatEURCurrency(double d){
		String s = "";
		
		try{
			DecimalFormat nf = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.UK); 
			s = nf.format(d);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	/**
	 * @param num
	 * @return
	 * 获取指定位数的随机数
	 */
	public static String getRandomNumber(int num) {
		Random r = new Random();
		String[] code = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String str = "";
		for(int i=0;i<num;i++){
			str += code[r.nextInt(code.length-1)];
		}
		
		return str;
	}
	
	
	/**
	 * @param info 待截断字符
	 * @param flg 标识 1.卡号或电子账户  2.身份证 3.手机号 4.姓名 5.显示最后4位
	 * @return
	 * 截断 字段 信息
	 */
	public static String hiddenPersonInfo(String info, int flg) {
		if(info==null || "".equals(info)){
			return null;
		}
		
		if(flg==1){
			//卡号截断
			return info.substring(0, 4) + "****" + info.substring(info.length()-4);
		}else if(flg==2){
			//身份证截断
			return info.substring(0, 4) + "****" + info.substring(info.length()-3);
		}else if(flg==3){
			//手机号截断
			return info.substring(0, 3) + "****" + info.substring(info.length()-3);
		}else if(flg==4){
			//姓名
			return "**" + info.substring(info.length()-1);
		}else if(flg==5){
			//末尾4位
			return info.substring(info.length()-4);
		}else{
			return null;
		}
	}
	
	
    /**
     * @return
     * 生成唯一键
     */
    public static String createUUID(){
        UUID uuid = java.util.UUID.randomUUID();
        String uu= uuid.toString().replaceAll("-", "");
        return uu;
    }
    
    
    /**
     * @param filePath
     * @return
     * 读取文件内容
     */
    public static String getFileContents(String filePath, String charset) {
    	StringBuffer sb = new StringBuffer();
    	File file = null;
    	InputStreamReader fr = null;
    	BufferedReader br = null;
    	
    	try {
			file = new File(filePath);
			fr = new InputStreamReader(new FileInputStream(file), charset);
			br = new BufferedReader(fr);
			while(br.ready()){
				sb.append(br.readLine().trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null){
					br.close();
					br = null;
				}
				if(fr!=null){
					fr.close();
					fr = null;
				}
				if(file!=null){
					file = null;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    	
    	return sb.toString();
    }
	
	
	public static void main(String[] args) {
		String s = formatCurrency(5000000, "CNY");
		System.out.println(s);
	}
	
	
}