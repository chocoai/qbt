/**
 * Project Name:qbt-system-web
 * File Name:VipOrderInfoController.java
 * Package Name:com.qbt.web.controller
 * Date:2016年11月4日下午3:34:51
 *
*/

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
import com.qbt.web.pojo.vipOrderInfo.VipOrderInfoPageReqVo;
import com.qbt.web.pojo.vipOrderInfo.VipOrderInfoVo;
import com.qbt.web.support.VipOrderInfoSupport;

/**
 * 会员订单管理
 * ClassName:VipOrderInfoController
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月4日 下午3:34:51
 * @author   haungyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/vipOrderInfo")
public class VipOrderInfoController {
	
	@Resource
	private VipOrderInfoSupport vipOrderInfoSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<VipOrderInfoVo>> findByPage(@RequestBody VipOrderInfoPageReqVo reqVo){
		PageResult<List<VipOrderInfoVo>> result = new PageResult<List<VipOrderInfoVo>>();
		try {
			result.setDatas(vipOrderInfoSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "会员订单分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
