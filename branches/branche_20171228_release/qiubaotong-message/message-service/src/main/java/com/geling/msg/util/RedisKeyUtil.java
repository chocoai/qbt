package com.geling.msg.util;

public class RedisKeyUtil {

	/**
	 * 微信Accesstoke  Redis
	 */
	private static String Access_token_Redis_key = "weixin:appid:access_token_{0}";
	private static String Access_token_Redis_lock_key = "weixin:appid:access_token_lock_{0}";
	public static String access_token_Redis_key(String sysId){
		return Access_token_Redis_key.replace("{0}", sysId);
	}
	public static String access_token_Redis_lock_key(String sysId){
		return Access_token_Redis_lock_key.replace("{0}", sysId);
	}
	
}
