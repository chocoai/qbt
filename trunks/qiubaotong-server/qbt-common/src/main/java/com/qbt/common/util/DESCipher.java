/**
 * File: DESCipher.java
 * Description: DES进行加密解密操作, 采用对称算法
 * Copyright 2010 GamaxPay. All rights reserved
 *  
 */
package com.qbt.common.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.qbt.common.logback.LogCvt;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/**
 * DES进行加密解密操作
 * 方法：createSecretKey 创建密钥
 * 		 encrypt 加密
 * 		 decrypt 解密
 * @author jacky
 *
 */
public class DESCipher {

	/**
	 *采用的加密算法为DES
	 */
	private static final String algorithm = "DES";

	private static DESCipher des = new DESCipher();
	
	private DESCipher(){		
	}

	public static DESCipher getInstance(){
		return des;
	}
	
	/**
	 * 用密钥产生对象按照指定的算法生成密钥
	 * @param algorithm  采用的加密算法
	 * @return			 生成的密钥,用来加解密
	 */
	public static SecretKey createSecretKey(String algorithm) {  
		// 声明KeyGenerator对象  
		KeyGenerator keygen;  
		// 声明 密钥对象  
		SecretKey deskey = null;  		         
		try {  
			// 返回生成指定算法的秘密密钥的 KeyGenerator 对象  
			keygen = KeyGenerator.getInstance(algorithm);  
			// 生成一个密钥  
			deskey = keygen.generateKey();  
		} catch (NoSuchAlgorithmException e) {  
			LogCvt.error("非法摘要算法", e);
			throw new RuntimeException(e);
		}  
		return deskey;  
	}
	
	/**
	 * 对内容进行DES加密
	 * @param info	要加密的内容
	 * @return		被加密后的内容
	 */
	public static String encrypt(SecretKey key, String info) {  
		SecureRandom sr = new SecureRandom();  
		// 定义要生成的密文  
		byte[] cipherByte = null;  
		try {  
			// 得到加密/解密器  
			Cipher c1 = Cipher.getInstance("DES/ECB/PKCS5Padding");  
			// 用指定的密钥和模式初始化Cipher对象  
			// 参数:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)  
			c1.init(Cipher.ENCRYPT_MODE, key, sr);  
			// 对要加密的内容进行编码处理,  
			cipherByte = c1.doFinal(info.getBytes("UTF-8"));  
			
		} catch (Exception e) {  
			LogCvt.error("DES 加密失败", e);
			throw new RuntimeException(e); 
		}  
		// 返回密文的十六进制形式  
		return new String(Base64.encode(cipherByte));  
		//return BytesHexTransform.bytesToHexString(cipherByte);
	}  
	
	public static String decrypt(SecretKey key, String hexString){ 
		// 加密随机数生成器 (RNG)  
		SecureRandom sr = new SecureRandom();  
		byte[] cipherByte = null;  
		String decryptcontent = "";
		try {  
			// 得到加密/解密器  
			Cipher c1 = Cipher.getInstance("DES/ECB/PKCS5Padding");  
			// 用指定的密钥和模式初始化Cipher对象  
			c1.init(Cipher.DECRYPT_MODE, key, sr);  
			// 对要解密的内容进行解密处理  
			//cipherByte = c1.doFinal(BytesHexTransform.hexToByte(hexString));  
			cipherByte = c1.doFinal(Base64.decode(hexString));  
			decryptcontent = new String(cipherByte, "UTF-8");  
		} catch (Exception e) {  
			LogCvt.error("DES 解密失败", e);
			throw new RuntimeException(e); 
		}  		
		return decryptcontent;
	}
	
	
	
	public static void main(String[] args) throws JSONException {
		SecretKey sk = createSecretKey(algorithm);
		ObjectToFileHelper.writeObjectFile("merchant_secretkey.key",sk);
		sk = (SecretKey)ObjectToFileHelper.readFromFile("merchant_secretkey.key",1);
		JSONArray ja = new JSONArray();
		ja.add("ice_foxno.5@54545.com");
		ja.add(System.currentTimeMillis());
		String enRes = encrypt(sk,ja.toString());
		System.out.println(enRes);
		//sk = createSecretKey(algorithm);
		String deRes = decrypt(sk,enRes);
		System.out.println(deRes);
		JSONArray jsa = JSONArray.parseArray(deRes);
		jsa.add(jsa);
		System.out.println(jsa.get(0));
		System.out.println(new Date((Long)jsa.get(1)));
	}
}

