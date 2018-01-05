/**
 * Project Name:qbt-system-web
 * File Name:OrderCostItemController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年1月19日下午3:17:51
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderCostItem.OrderCostItemPageReqVo;
import com.qbt.web.pojo.orderCostItem.OrderCostItemVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderCostItemSupport;

/**
 * ClassName:OrderCostItemController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午3:17:51
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/orderCostItem")
public class OrderCostItemController {
	
	@Resource
	private OrderCostItemSupport orderCostItemSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage")
	public PageResult<List<OrderCostItemVo>> findByPage(@RequestBody OrderCostItemPageReqVo reqVo){
		PageResult<List<OrderCostItemVo>> result = new PageResult<List<OrderCostItemVo>>();
		try {
			result.setDatas(orderCostItemSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单增加项目分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Boolean> add(HttpServletRequest request, @RequestBody OrderCostItemVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(vo);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setSysUserId(sysUser.getId());
			vo.setSysUserName(sysUser.getName());
			vo.setSysUserMobile(sysUser.getMobile());
			result.setDatas(orderCostItemSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("新增订单增加项目异常");
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(orderCostItemSupport.delete(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("删除订单增加项目异常");
		}
		return result;
	}
	
}
