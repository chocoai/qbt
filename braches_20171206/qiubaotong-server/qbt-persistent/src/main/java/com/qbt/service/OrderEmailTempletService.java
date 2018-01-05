/**
 * Project Name:qbt-persistent
 * File Name:OrderEmailTempletService.java
 * Package Name:com.qbt.service
 * Date:2017年10月24日下午2:46:56
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.OrderEmailTemplet;

/**
 * ClassName:OrderEmailTempletService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月24日 下午2:46:56
 * @author   wuwang
 * @version  
 * @see 	 
 */
public interface OrderEmailTempletService {

	List<OrderEmailTemplet> findByOrderEmailInsuredId(int orderEmailInsuredId);

}
