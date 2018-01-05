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
import com.qbt.web.pojo.orderactivitybook.OrderActivityBookPageReqVo;
import com.qbt.web.pojo.orderactivitybook.OrderActivityBookVo;
import com.qbt.web.support.OrderActivityBookSupport;

/**
 *订单活动
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/orderActivityBook")
public class OrderActivityBookController {

	@Resource
	private OrderActivityBookSupport orderActivityBookSupport;
	
	/**
	 * 分页
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderActivityBookVo>> findByPage(@RequestBody OrderActivityBookPageReqVo reqVo){
		PageResult<List<OrderActivityBookVo>> result = new PageResult<List<OrderActivityBookVo>>();
		try {
			result.setDatas(orderActivityBookSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "银行网点分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
