/**
 * Project Name:qbt-system-web
 * File Name:OrderAddressTypeSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年3月13日下午2:39:58
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.orderAddressType.OrderAddressTypePageReqVo;
import com.qbt.web.pojo.orderAddressType.OrderAddressTypePageRespVo;

/**
 * ClassName:OrderAddressTypeSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月13日 下午2:39:58
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrderAddressTypeSupport {
	
	List<OrderAddressTypePageRespVo> findByPage(OrderAddressTypePageReqVo reqVo);
	
}
