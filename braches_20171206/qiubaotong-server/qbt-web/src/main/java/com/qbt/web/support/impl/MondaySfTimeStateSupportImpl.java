/**
 * Project Name:qbt-system-web
 * File Name:MondaySfTimeState.java
 * Package Name:com.qbt.web.state.impl
 * Date:2017年4月6日下午3:20:08
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
 * ClassName:MondaySfTimeState
 * Reason:	 TODO ADD REASON.
 * Date:     2017年4月6日 下午3:20:08
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("mondaySfTimeState")
public class MondaySfTimeStateSupportImpl implements SfTimeStateSupport {
	
	@Resource
	private BaseSfTimeService baseSfTimeService;
	
	@Override
	public Date ajustDate(SfTimeContextSupport contextSupport, Date queryDate, Date ajustDate) {
		Date mDate = ajustDate == null ? queryDate : ajustDate;
		BaseSfTime sfTime = baseSfTimeService.findByDate(mDate);
		if(Calendar.MONDAY == DateUtil.getWeek(mDate) && sfTime != null){
			return queryDate;
		}
		return ajustDate;
	}

}
