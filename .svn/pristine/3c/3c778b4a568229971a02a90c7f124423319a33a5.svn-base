/**
 * Project Name:qbt-web
 * File Name:SfTimeContextSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年7月25日上午11:50:46
 *
*/

package com.qbt.web.support.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.qbt.web.support.SfTimeContextSupport;
import com.qbt.web.support.SfTimeStateSupport;

/**
 * ClassName:SfTimeContextSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月25日 上午11:50:46
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class SfTimeContextSupportImpl implements SfTimeContextSupport {
	
	private SfTimeStateSupport sfTimeState;
	
	@Override
	public void setSfTimeState(SfTimeStateSupport sfTimeState) {
		this.sfTimeState = sfTimeState;
	}

	@Override
	public Date ajustDate(Date queryDate, Date ajustDate) {
		if(sfTimeState != null && queryDate != null) {
			return sfTimeState.ajustDate(this, queryDate, ajustDate);
		}
		return null;
	}

}
