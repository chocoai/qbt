/**
 * Project Name:qbt-system-web
 * File Name:OrderAddressRouteSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年3月13日下午4:40:31
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.orderAddressRoute.OrderAddressRoutePageReqVo;
import com.qbt.web.pojo.orderAddressRoute.OrderAddressRoutePageRespVo;

/**
 * ClassName:OrderAddressRouteSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月13日 下午4:40:31
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrderAddressRouteSupport {
	
	List<OrderAddressRoutePageRespVo> findByPage(OrderAddressRoutePageReqVo reqVo);
	
}
