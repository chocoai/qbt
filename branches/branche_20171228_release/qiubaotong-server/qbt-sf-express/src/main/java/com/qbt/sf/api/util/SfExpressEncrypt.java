package com.qbt.sf.api.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

import com.qbt.common.logback.LogCvt;

public class SfExpressEncrypt {

	
	/**
	  * @Title: md5EncryptAndBase64
	  * @Description: 接入 BSP 前，顺丰 BSP 系统管理员会为每个接入客户分配一个“密钥”，以下把密钥简称为 checkword。 
					     按以下逻辑生成校验码： 
						1 先把 XML 报文与 checkword 前后连接。 
						2 把连接后的字符串做 MD5 编码。 
						3 把 MD5 编码后的数据进行 Base64 编码，此时编码后的字符串即为校验码。 
	  * @author: win10 2016年8月4日
	  * @modify: win10 2016年8月4日
	  * @param xml
	  * @param Checkword
	  * @return
	 */
	public static String md5EncryptAndBase64(String xml,String checkWord) {
		try {
			String encryptStr=new StringBuffer().append(xml).append(checkWord).toString();
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(encryptStr.getBytes("utf8"));
			
			String verifyCode=new String(Base64.encodeBase64(md5.digest()));
			
			return verifyCode;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			throw new RuntimeException(e);

		}
	}

 

}
