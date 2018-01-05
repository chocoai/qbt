/**
 * Project Name:qbt-system-web
 * File Name:OrderAddressRouteController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年3月13日下午4:55:05
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.web.pojo.orderAddressRoute.OrderAddressRoutePageReqVo;
import com.qbt.web.pojo.orderAddressRoute.OrderAddressRoutePageRespVo;
import com.qbt.web.support.OrderAddressRouteSupport;

/**
 * ClassName:OrderAddressRouteController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月13日 下午4:55:05
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/orderAddressRoute")
public class OrderAddressRouteController {
	
	@Resource
	private OrderAddressRouteSupport orderAddressRouteSupport;
	
	@RequestMapping(value = "findByPage")
	public PageResult<List<OrderAddressRoutePageRespVo>> findByPage(@RequestBody OrderAddressRoutePageReqVo reqVo){
		PageResult<List<OrderAddressRoutePageRespVo>> result = new PageResult<List<OrderAddressRoutePageRespVo>>();
		try {
			result.setDatas(orderAddressRouteSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("用户路线分页查询异常");
		}
		return result;
	}
	
}
