package com.qbt.util;

import java.security.MessageDigest;
import java.util.Random;

public class CodeUtil {
	
	/**
	 * 生成一个8位的暗码
	 * @author andy.li
	 * @return
	 */
	public static String getCode()
	{
	    String data="abcdefghejklmnopqrstuvwxyzABCDEFGHEJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer buff = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i<8; i++) {
		int index = random.nextInt(62);
		String str = data.substring(index, index+1);
		buff.append(str);
		}
		return buff.toString();
	}
	
	/**
	 * 生成一个6位随机数的MD5加密QrCode
	 * @author andy.li
	 * @return
	 */
	public static String GetQRCode()
	{
		String result="";
		StringBuffer sb=new StringBuffer();
		int temp_num;
		for(int i=0;i<6;i++)
		{
			temp_num=(int)(Math.random()*10);
			sb.append(temp_num);
		}
		try {
			result = toMD5(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * MD5加密
	 * @param origin
	 * @return
	 * @throws Exception
	 */
	public static String toMD5(String origin) throws Exception {

		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] results = digest.digest(origin.getBytes());
		String md5String = toHex(results);

		return md5String;
	}
	
	public static String toHex(byte[] results) {
		if (results == null)
			return null;

		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < results.length; i++) {
			int hi = (results[i] >> 4) & 0x0f;
			int lo = results[i] & 0x0f;
			hexString.append(Character.forDigit(hi, 16)).append(
					Character.forDigit(lo, 16));
		}

		return hexString.toString();
	}
	
}
