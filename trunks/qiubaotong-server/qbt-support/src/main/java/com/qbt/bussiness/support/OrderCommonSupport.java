/**
 * Project Name:qbt-support
 * File Name:OrderCommonSupport.java
 * Package Name:com.qbt.bussiness.support
 * Date:2017年8月21日下午1:51:22
 *
*/

package com.qbt.bussiness.support;

import java.util.List;

/**
 * ClassName:OrderCommonSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月21日 下午1:51:22
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrderCommonSupport {
	
	/**
	 * 
	 * closeBigOrder:(检查是否关闭大订单).
	 *
	 * @author huangyihao
	 * 2017年8月21日 下午1:51:53
	 * @param superOrderIds 大订单id集合
	 *
	 */
	void closeBigOrder(List<Integer> superOrderIds);
	
}
