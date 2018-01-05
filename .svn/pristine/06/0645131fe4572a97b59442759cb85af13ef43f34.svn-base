
 /**
 * @Title: SHA1Util.java
 * @Package com.qbt.common.util
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月9日
 * @version V1.0
 **/

package com.qbt.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.qbt.common.logback.LogCvt;

/**
  * @ClassName: SHA1Util
  * @Description: TODO
  * @author win10 2016年8月9日
  * @modify win10 2016年8月9日
  */

public class SHA1Util {
	
	/**
	  * @Title: SHA1Password
	  * @Description: 密码加密
	  * @author: win10 2016年8月9日
	  * @modify: win10 2016年8月9日
	  * @param passWord
	  * @param globalSalt
	  * @param privateSalt
	  * @return
	  * @throws Exception
	 */
	public static String SHA1Password(String passWord,String globalSalt,String privateSalt)throws Exception{
		StringBuffer strH1=new StringBuffer();
		//password+globalSalt-->SHA-1;
		String ha1=SHA1(strH1.append(passWord).append(globalSalt).toString());
		strH1=new StringBuffer();
		//ha1+privateSalt-->SHA-2
		String ha2=SHA1(strH1.append(ha1).append(privateSalt).toString());
		
		return ha2;
		
	}
	
	public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (Exception e) {
        	LogCvt.error(e.getMessage(), e);
        }
        return null;
    }
	
	public static String getSha1(String str){
        if (null == str || 0 == str.length())
            return null;
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	

	public static void main(String[] args) throws Exception {
	    //密码   +salt.
	    //'7cf509a752af56e74103010780264121701afa36','23f02d701cad11e6a98d00163e002fe5'
	    //'7cf509a752af56e74103010780264121701afa36'

	   String xx= SHA1("laizheqiqiubaotong"+"PToCFwodOrnb1FVzoe1AhoryFS28dI2f");
	   System.out.println(SHA1(xx+"23f02d701cad11e6a98d00163e002fe5"));
	   
	   System.out.println(SHA1Password("laizheqiqiubaotong","PToCFwodOrnb1FVzoe1AhoryFS28dI2f","23f02d701cad11e6a98d00163e002fe5"));
	   
	}

}
