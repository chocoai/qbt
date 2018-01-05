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
import com.qbt.common.result.Result;
import com.qbt.web.pojo.vipOrder.VipOrderPageReqVo;
import com.qbt.web.pojo.vipOrder.VipOrderVo;
import com.qbt.web.support.VipOrderSupport;

/**
 * 会员购卡购买记录模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("vipOrder")
public class VipOrderController {

	@Resource
	private VipOrderSupport vipOrderSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<VipOrderVo>> findByPage(@RequestBody VipOrderPageReqVo reqVo){
		PageResult<List<VipOrderVo>> result = new PageResult<List<VipOrderVo>>();
		try {
			result.setDatas(vipOrderSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "会员购卡购买记录分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<VipOrderVo> findById(Integer id){
		Result<VipOrderVo> result = new Result<VipOrderVo>();
		VipOrderVo vipOrderVo = null;
		try {
			vipOrderVo = vipOrderSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "会员购卡购买记录详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(vipOrderVo);
		return result;
	}
	
	/**
	 * booss下单，金额结算，将未收款改为已收款，流水更新为支付成功
	  * @Title: upOrderSettlement
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月5日
	  * @modify: chenxiaocong 2016年11月5日
	  * @return
	 */
	@RequestMapping(value = "upSettlement")
	public Result<Boolean> upOrderSettlement(Integer id){
		Result<Boolean> result = new Result<Boolean>();
//		VipOrderVo vipOrderVo = null;
		try {
			result.setDatas(vipOrderSupport.upOrderSettlement(id));
		} catch (Exception e) {
			String errMsg = "会员购卡购买确认收款异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		return result;
	}
}
