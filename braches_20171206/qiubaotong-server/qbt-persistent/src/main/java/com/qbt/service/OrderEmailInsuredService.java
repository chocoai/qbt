/**
 * Project Name:qbt-persistent
 * File Name:OrderEmailInsuredService.java
 * Package Name:com.qbt.service
 * Date:2017年10月19日下午5:29:39
 *
*/

package com.qbt.service;

import com.qbt.persistent.entity.OrderEmailInsured;

/**
 * ClassName:OrderEmailInsuredService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月19日 下午5:29:39
 * @author   wuwang
 * @version  
 * @see 	 
 */
public interface OrderEmailInsuredService {

	OrderEmailInsured findByMinMaxAndOrderEmailId(Double insuredValue, int orderEmailId);

}
