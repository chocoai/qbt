package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.activity.ActivityInfoVo;
import com.qbt.web.pojo.activity.ActivityVo;
import com.qbt.web.pojo.activity.OrderActivity;
import com.qbt.web.support.ActivitySupport;

/**
 *  优惠活动
  * @ClassName: ActivityController
  * @Description: TODO
  * @author share 2016年9月7日
  * @modify share 2016年9月7日
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

	
	@Resource
	private ActivitySupport activitySupport;
	
	/**
	 *  订单活动检查
	  * @Title: checkOrder
	  * @Description: TODO
	  * @author: share 2016年9月7日
	  * @modify: share 2016年9月7日
	  * @param orderId
	  * @return
	 */
	@RequestMapping("/check_order")
	public Result<OrderActivity> checkOrder(String orderId){
		Result<OrderActivity> result = new Result<OrderActivity>();
		try {
			
			result.setDatas(activitySupport.checkOrder(orderId));
		}catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	/**
	 *  活动列表查询
	  * @Title: checkOrder
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @param orderId
	  * @return
	 */
	@RequestMapping("/list")
	public Result<List<ActivityVo>> list(int type){
		Result<List<ActivityVo>> result = new Result<List<ActivityVo>>();
		try {
			result.setDatas(activitySupport.list(type));
		}catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	/**
	 *  活动列表查询
	  * @Title: checkOrder
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @param orderId
	  * @return
	 */
	@RequestMapping("/detail")
	public Result<ActivityInfoVo> detail(int id){
		Result<ActivityInfoVo> result = new Result<ActivityInfoVo>();
		try {
			result.setDatas(activitySupport.detail(id));
		}catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
}
