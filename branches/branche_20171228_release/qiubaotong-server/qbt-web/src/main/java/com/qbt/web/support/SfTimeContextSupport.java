/**
 * Project Name:qbt-web
 * File Name:SfTimeContextSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年7月25日上午11:40:29
 *
*/

package com.qbt.web.support;

import java.util.Date;

/**
 * ClassName:SfTimeContextSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月25日 上午11:40:29
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface SfTimeContextSupport {
	
	/**
	 * 
	 * setSfTimeState:(设置状态).
	 *
	 * @author huangyihao
	 * 2017年7月25日 上午11:42:51
	 *
	 */
	void setSfTimeState(SfTimeStateSupport sfTimeState);
	
	/**
	 * 
	 * ajustDate:(调整查询日期).
	 *
	 * @author huangyihao
	 * 2017年7月25日 上午11:37:04
	 * @param queryDate
	 * @param ajustDate
	 * @return
	 *
	 */
	Date ajustDate(Date queryDate, Date ajustDate);
	
}
