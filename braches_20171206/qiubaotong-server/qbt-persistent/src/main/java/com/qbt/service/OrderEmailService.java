/**
 * Project Name:qbt-persistent
 * File Name:OrderEmailService.java
 * Package Name:com.qbt.service
 * Date:2017年10月19日下午5:20:40
 *
*/

package com.qbt.service;

import com.qbt.persistent.entity.OrderEmail;

/**
 * ClassName:OrderEmailService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月19日 下午5:20:40
 * @author   wuwang
 * @version  
 * @see 	 
 */
public interface OrderEmailService {

	OrderEmail findByCode(String code);

}
