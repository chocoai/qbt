package com.geling.msg.util;

import java.security.MessageDigest;

public class Md5 {
	
	public Md5() {
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	public static String byteArrayToString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));// 若使用本函数转换则可得到加密结果�??16进制表示，即数字字母混合的形�??
			// resultSb.append(byteToNumString(b[i]));//使用本函数则返回加密结果�??10进制数字字串，即全数字形�??
		}
		return resultSb.toString();
	}



	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToString(md.digest(resultString.getBytes("utf-8")));
		} catch (Exception ex) {

		}
		return resultString;
	}
	
}