/**
 * Project Name:qbt-web
 * File Name:SfTimeSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年7月25日上午11:36:51
 *
*/

package com.qbt.web.support;

import java.util.Date;

/**
 * ClassName:SfTimeSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月25日 上午11:36:51
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface SfTimeStateSupport {
	
	/**
	 * 
	 * ajustDate:(调整查询日期).
	 *
	 * @author huangyihao
	 * 2017年7月25日 上午11:37:04
	 * @param contextSupport
	 * @param queryDate
	 * @param ajustDate
	 * @return
	 *
	 */
	Date ajustDate(SfTimeContextSupport contextSupport, Date queryDate, Date ajustDate);
	
}
