/**
 * Project Name:qbt-system-web
 * File Name:SunDaySfTimeState.java
 * Package Name:com.qbt.web.state.impl
 * Date:2017年4月6日下午3:18:45
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
 * ClassName:SunDaySfTimeState
 * Reason:	 TODO ADD REASON.
 * Date:     2017年4月6日 下午3:18:45
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("sunDaySfTimeState")
public class SunDaySfTimeStateSupportImpl implements SfTimeStateSupport {
	
	@Resource(name = "mondaySfTimeState")
	private SfTimeStateSupport mondaySfTimeState;
	
	@Override
	public Date ajustDate(SfTimeContextSupport contextSupport, Date queryDate, Date ajustDate) {
		Date sDate = ajustDate == null ? queryDate : ajustDate;
		if(Calendar.SUNDAY == DateUtil.getWeek(sDate)){
			contextSupport.setSfTimeState(mondaySfTimeState);
			return contextSupport.ajustDate(queryDate, DateUtils.addDays(sDate, 1));
		}
		return sDate;
	}

}
