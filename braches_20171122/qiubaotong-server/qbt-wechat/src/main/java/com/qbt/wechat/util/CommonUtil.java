package com.qbt.wechat.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Md5;
public class CommonUtil {

	public static String CreateNoncestr(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < length; i++) {
			Random rd = new Random();
			res += chars.indexOf(rd.nextInt(chars.length() - 1));
		}
		return res;
	}

	public static String CreateNoncestr() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < 16; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}
	

	public static String GetMD5Sign(HashMap<String, String> bizObj,String AppKey){
		HashMap<String, String> bizParameters = new HashMap<String, String>();

		List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(
				bizObj.entrySet());

		Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1,
					Map.Entry<String, String> o2) {
				return (o1.getKey()).toString().compareTo(o2.getKey());
			}
		});

		for (int i = 0; i < infoIds.size(); i++) {
			Map.Entry<String, String> item = infoIds.get(i);
			if (item.getKey() != "") {
				bizParameters.put(item.getKey(), item.getValue()+"");
			}
		}
		String bizString = CommonUtil.FormatBizQueryParaMap(bizParameters,false)+"&key="+AppKey;

		LogCvt.info("bizString"+bizString);
		return Md5.MD5Encode(bizString).toUpperCase();
	}
	

	public static String FormatQueryParaMap(HashMap<String, String> parameters){

		String buff = "";
		try {
			List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(
					parameters.entrySet());

			Collections.sort(infoIds,
					new Comparator<Map.Entry<String, String>>() {
						public int compare(Map.Entry<String, String> o1,
								Map.Entry<String, String> o2) {
							return (o1.getKey()).toString().compareTo(
									o2.getKey());
						}
					});

			for (int i = 0; i < infoIds.size(); i++) {
				Map.Entry<String, String> item = infoIds.get(i);
				if (item.getKey() != "") {
					buff += item.getKey() + "="
							+ URLEncoder.encode(item.getValue(), "utf-8") + "&";
				}
			}
			if (buff.isEmpty() == false) {
				buff = buff.substring(0, buff.length() - 1);
			}
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}

		return buff;
	}

	public static String FormatBizQueryParaMap(HashMap<String, String> paraMap,boolean urlencode) {

		String buff = "";
		try {
			List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(
					paraMap.entrySet());

			Collections.sort(infoIds,
					new Comparator<Map.Entry<String, String>>() {
						public int compare(Map.Entry<String, String> o1,
								Map.Entry<String, String> o2) {
							return (o1.getKey()).toString().compareTo(
									o2.getKey());
						}
					});

			for (int i = 0; i < infoIds.size(); i++) {
				Map.Entry<String, String> item = infoIds.get(i);
				//System.out.println(item.getKey());
				if (item.getKey() != "" && !item.getValue().equals("")) {
					
					String key = item.getKey();
					String val = item.getValue()+"";
					if (urlencode) {
						val = URLEncoder.encode(val, "utf-8");

					}
					buff += key + "=" + val + "&";

				}
			}

			if (buff.isEmpty() == false) {
				buff = buff.substring(0, buff.length() - 1);
			}
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return buff;
	}
	
	
	public static void main(String[] args) {
		String str = "appid=wx2d7660d6cb2d7eca&body=185920099排期在线购票&mch_id=1308819301&nonce_str=nolKrvn0uFvQdsd7&notify_url=http://pay.zyhxdyc.com/testzhhlg/comm/wechat_pay_bak.jhtml&openid=oa7BYxBNii0Mih_Vt3ulsVnk4ylE&out_trade_no=302206362&spbill_create_ip=14.17.37.69&time_expire=1461594642000&time_start=1461593742000&total_fee=45.0&trade_type=JSAPI&key=87bf87cadf934893b550aff0d4c1fb5c";
		System.out.println(Md5.MD5Encode(str).toUpperCase());
	}
}
