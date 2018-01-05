package com.qbt.common.enums;

import java.util.HashMap;
import java.util.Map;

import com.qbt.common.logback.LogCvt;

public class JapaneseSmsTemplate {

	private static Map<String,String> japaneseMap = new HashMap<String,String>();
	
	static{
		japaneseMap.put("112387","ご注文、ありがとうございます。配達員は予約さている時間帯にゴルフバックを受け取りに行きます。伝票番号：{1}，注文時間：{2}，受取予定時間：{3}，依頼人：{4}，受取人：{5}，予定到達時間：{6}。航空運送規定により、液体物、ゲル状物（乳液、クリーム類、マジックペンなど）、磁気を帯びる物、リチューム電池を含まれる物、ライター、マーチ及び現金類は運送禁止となっているため、上記の物をバックから必ず取り出して下さい。なお、安全検査のため、バックをロックしないて下さい。ご協力、ありがとうございます。");
		japaneseMap.put("112388","貴方様のゴルフバックは間もなく配送となります。伝票番号：{1}；注文時間：{2}；予定受取時間：{3}；発送人：{4}；受取人：{5}；予定到達時間：{6}。お楽しみに！");
		japaneseMap.put("112400","貴方様の注文は取り消されました。伝票番号：{1}，予定受取時間：{2}，発送人：{3}，受取人：{4}，予定到達時間：{5}。");
		japaneseMap.put("112395","貴方様のゴルフバックも{1}受取ました，これから配送します。伝票番号：{2}，出発地：{3}，目的地：{4}。球包通はお共にします！");
		japaneseMap.put("113080","貴方様のゴルフバックも{1}に到着しました。");
		japaneseMap.put("112397","貴方様の伝票番号{1}の配送は既に{2}に出発しました。出発地：{3}，目的地：{4}，予想到達時間：{5}。球包通はお共にします！");
	}
	
	public static String[] getSmsTemplate(String code,String ... msg){
		try {
			String content = japaneseMap.get(code);
			for(int i = 1 ; i <= msg.length;i++){
				content = content.replace("{"+i+"}", msg[i-1]);
			}
			return new String[]{content,"021-6237-2245 or 135-8572-7217"};
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return null;
	}
	
}
