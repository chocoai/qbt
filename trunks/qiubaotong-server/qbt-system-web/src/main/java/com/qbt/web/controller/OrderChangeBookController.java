package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.web.pojo.orderChangeBook.OrderChangeBookPageReqVo;
import com.qbt.web.pojo.orderChangeBook.OrderChangeBookVo;
import com.qbt.web.support.OrderChangeBookSupport;

@Controller
@RequestMapping("orderChangeBook")
public class OrderChangeBookController {

	@Resource
	private OrderChangeBookSupport orderChangeBookSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderChangeBookVo>> findByPage(@RequestBody OrderChangeBookPageReqVo reqVo){
		PageResult<List<OrderChangeBookVo>> result = new PageResult<List<OrderChangeBookVo>>();
		try {
			result.setDatas(orderChangeBookSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "订单改变记录分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
