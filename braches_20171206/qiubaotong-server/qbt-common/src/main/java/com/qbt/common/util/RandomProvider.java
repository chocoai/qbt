package com.qbt.common.util;

import org.apache.commons.lang.RandomStringUtils;


public class RandomProvider {
	
	private static char[] digits={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	private static char[] vip_digits={'0','1','2','3','5','6','7','8','9'};
	
	private static char[] salesman_code_digits={'0','1','2','4','3','5','6','7','8','9'};
	
	//除去"o", “i", "z"
	private static char[] capital={'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T', 'U','V','W','X','Y'};
	
	//优惠码6位大写字母与数字随机组合
	private static char[] couponCodeActivityCode={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T', 'U','V','W','X','Y','Z'};
	
	//26个大写字母
	private static char[] capitalAll={'A','B','C','D','E','F','G','H','i','J','K','L','M','N','O','P','Q','R','S','T', 'U','V','W','X','Y','Z'};
	
	//产生随机密码
	public static String randomAlphanumericToLowerCase(int len){
		return RandomStringUtils.randomAlphanumeric(len).toLowerCase();
	}

	public static String randomAlphanumericToUpperCase(int len){
		return RandomStringUtils.randomAlphanumeric(len).toUpperCase();
	}
	
	public static String randomAlphanumeric(int len){
		return RandomStringUtils.randomAlphanumeric(len).toLowerCase();
	}

	public static String randomNumeric(int len){
		return RandomStringUtils.randomNumeric(len);
	}
	
	public static String random(int len){
		return RandomStringUtils.random(len,digits);
	}
	
	
	public static String randomVip(int len){
		return RandomStringUtils.random(len,vip_digits);
	}
	
	public static String randomSalesmanCode(int len){
		return RandomStringUtils.random(len,salesman_code_digits);
	}

	public static String randomSaleQrcode(int len){
		return RandomStringUtils.random(len,capital);
	}
	
	public static String randomCouponCodeActivityCode(int len){
		return RandomStringUtils.random(len,couponCodeActivityCode);
	}
	
	public static String randomChannelQrcode(int len){
		return RandomStringUtils.random(len,capitalAll);
	}
	
	public static void main(String[] args) {
		System.out.println(random(6));
	}
}
