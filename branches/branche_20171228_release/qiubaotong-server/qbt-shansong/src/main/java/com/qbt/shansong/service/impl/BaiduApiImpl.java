/**
 * Project Name:qbt-shansong
 * File Name:BaiduApiImpl.java
 * Package Name:com.qbt.shansong.service.impl
 * Date:2017年2月23日下午2:12:14
 *
*/

package com.qbt.shansong.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.exception.BaseException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.HttpClientUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.shansong.entity.BaiduResponse;
import com.qbt.shansong.entity.baidumap.GeocoderResult;
import com.qbt.shansong.service.BaiduApi;

/**
 * ClassName:BaiduApiImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午2:12:14
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BaiduApiImpl implements BaiduApi {
	
	@Value("${baidu_map_url}")
	private String baidu_map_url;
	
	@Value("${baidu_map_ak}")
	private String baidu_map_ak;
	
	@Override
	public BaiduResponse<GeocoderResult> queryLocation(String address) {
		String url = baidu_map_url.replace("{address}", StringUtil.urlencode(address)).replace("{ak}", baidu_map_ak);
		String responseStr = HttpClientUtil.httpGet(url);
		LogCvt.info("百度地图查询返回数据: " + responseStr);
		BaiduResponse<GeocoderResult> response = JSonUtil.toObject(responseStr, BaiduResponse.class);
		GeocoderResult result = null;
		if(response.getStatus() == 0){
			result = BeanUtil.a2b(response.getResult(), GeocoderResult.class);
			response.setResult(result);
		}
		return response;
	}
	
}
