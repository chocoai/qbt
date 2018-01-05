/**
 * Project Name:qbt-shansong
 * File Name:BaiduApi.java
 * Package Name:com.qbt.shansong.service
 * Date:2017年2月23日下午1:54:20
 *
*/

package com.qbt.shansong.service;

import com.qbt.shansong.entity.BaiduResponse;
import com.qbt.shansong.entity.baidumap.GeocoderResult;

/**
 * ClassName:BaiduApi
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午1:54:20
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BaiduApi {
	
	/**
	 * 
	 * queryLocation:(查询地址坐标).
	 *
	 * @author huangyihao
	 * 2017年2月23日 下午2:11:30
	 * @param address
	 * @return
	 *
	 */
	public BaiduResponse<GeocoderResult> queryLocation(String address);
	
}
