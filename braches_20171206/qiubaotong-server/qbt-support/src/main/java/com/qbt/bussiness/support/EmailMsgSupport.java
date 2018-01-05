/**
 * Project Name:qbt-support
 * File Name:EmailMsgSupport.java
 * Package Name:com.qbt.bussiness.support
 * Date:2017年8月2日下午4:11:13
 *
*/

package com.qbt.bussiness.support;

import com.qbt.persistent.entity.OrderChangeBook;
import com.qbt.persistent.entity.OrderInfo;

/**
 * ClassName:EmailMsgSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月2日 下午4:11:13
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface EmailMsgSupport {
	
	void orderPaySuccNotify(OrderInfo orderInfo);
	
	void orderCancleNotify(OrderInfo orderInfo);
	
	void orderModifyNotify(OrderInfo orderInfo,OrderChangeBook book);
}
