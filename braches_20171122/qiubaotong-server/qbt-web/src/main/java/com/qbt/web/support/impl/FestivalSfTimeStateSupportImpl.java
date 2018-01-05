/**
 * Project Name:qbt-system-web
 * File Name:FestivalSfTimeState.java
 * Package Name:com.qbt.web.state.impl
 * Date:2017年4月6日下午3:17:43
 *
*/

package com.qbt.web.support.impl;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.BaseSfTime;
import com.qbt.service.BaseSfTimeService;
import com.qbt.web.support.SfTimeContextSupport;
import com.qbt.web.support.SfTimeStateSupport;

/**
 * ClassName:FestivalSfTimeState
 * Reason:	 TODO ADD REASON.
 * Date:     2017年4月6日 下午3:17:43
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("festivalSfTimeState")
public class FestivalSfTimeStateSupportImpl implements SfTimeStateSupport {
	
	@Resource
	private BaseSfTimeService baseSfTimeService;
	
	@Resource(name = "sunDaySfTimeState")
	private SfTimeStateSupport sunDaySfTimeState;
	
	@Resource(name = "saturdaySfTimeState")
	private SfTimeStateSupport saturdaySfTimeState;
	
	@Override
	public Date ajustDate(SfTimeContextSupport contextSupport, Date queryDate, Date ajustDate) {
		Date fDate = ajustDate == null ? queryDate : ajustDate;
		BaseSfTime sfTime = baseSfTimeService.findByDate(fDate);
		if(sfTime == null){
			if(Calendar.SATURDAY == DateUtil.getWeek(fDate)) {
				contextSupport.setSfTimeState(saturdaySfTimeState);
				return contextSupport.ajustDate(queryDate, ajustDate);
			}else if(Calendar.SUNDAY == DateUtil.getWeek(fDate)) {
				contextSupport.setSfTimeState(sunDaySfTimeState);
				return contextSupport.ajustDate(queryDate, ajustDate);
			}
			return fDate;
		}else{
			if(DateUtil.getDiffDay(fDate, sfTime.getAdjustDate()) == 0 && Calendar.SATURDAY != DateUtil.getWeek(fDate)){
				return sfTime.getReferenceDate();
			}
			return fDate;
		}
	}
	
}
