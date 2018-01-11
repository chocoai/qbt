/**
 * Project Name:qbt-web
 * File Name:NightSfTimeStateSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年7月26日上午10:39:39
 *
*/

package com.qbt.web.support.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.DateUtil;
import com.qbt.web.support.SfTimeContextSupport;
import com.qbt.web.support.SfTimeStateSupport;

/**
 * ClassName:NightSfTimeStateSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月26日 上午10:39:39
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("nightSfTimeState")
public class NightSfTimeStateSupportImpl implements SfTimeStateSupport {
	
	@Resource(name = "festivalSfTimeState")
	private SfTimeStateSupport festivalSfTimeState;
	
	@Override
	public Date ajustDate(SfTimeContextSupport contextSupport, Date queryDate, Date ajustDate) {
		//下单时取包时间选择17点以后，送达时效从第二天上午9点开始算起
		Date nDay = ajustDate == null ? queryDate : ajustDate;
		Date newDate = DateUtil.ajustNight(nDay);
		contextSupport.setSfTimeState(festivalSfTimeState);
		return contextSupport.ajustDate(queryDate, newDate);
	}
	
}
