/**
 * Project Name:qbt-web
 * File Name:SaturdaySfTimeStateSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年8月14日下午5:40:08
 *
*/

package com.qbt.web.support.impl;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.util.DateUtil;
import com.qbt.web.support.SfTimeContextSupport;
import com.qbt.web.support.SfTimeStateSupport;

/**
 * ClassName:SaturdaySfTimeStateSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月14日 下午5:40:08
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("saturdaySfTimeState")
public class SaturdaySfTimeStateSupportImpl implements SfTimeStateSupport {
	
	@Resource(name = "mondaySfTimeState")
	private SfTimeStateSupport mondaySfTimeState;
	
	@Override
	public Date ajustDate(SfTimeContextSupport contextSupport, Date queryDate, Date ajustDate) {
		Date sDate = ajustDate == null ? queryDate : ajustDate;
		if(Calendar.SATURDAY == DateUtil.getWeek(sDate)){
			contextSupport.setSfTimeState(mondaySfTimeState);
			return contextSupport.ajustDate(queryDate, DateUtils.addDays(sDate, 2));
		}
		return sDate;
	}

}
