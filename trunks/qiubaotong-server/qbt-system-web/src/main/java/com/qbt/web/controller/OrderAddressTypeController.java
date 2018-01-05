/**
 * Project Name:qbt-system-web
 * File Name:OrderAddressTypeController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年3月13日下午3:03:00
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
import com.qbt.web.pojo.orderAddressType.OrderAddressTypePageReqVo;
import com.qbt.web.pojo.orderAddressType.OrderAddressTypePageRespVo;
import com.qbt.web.support.OrderAddressTypeSupport;

/**
 * ClassName:OrderAddressTypeController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月13日 下午3:03:00
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/orderAddressType")
public class OrderAddressTypeController {
	
	@Resource
	private OrderAddressTypeSupport orderAddressTypeSupport;
	
	@RequestMapping(value = "findByPage")
	public PageResult<List<OrderAddressTypePageRespVo>> findByPage(@RequestBody OrderAddressTypePageReqVo reqVo){
		PageResult<List<OrderAddressTypePageRespVo>> result = new PageResult<List<OrderAddressTypePageRespVo>>();
		try {
			result.setDatas(orderAddressTypeSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("用户地址分页查询异常");
		}
		return result;
	}
	
}
