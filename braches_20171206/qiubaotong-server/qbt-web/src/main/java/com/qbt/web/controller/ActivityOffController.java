package com.qbt.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.activity.ActivityOrderRequest;
import com.qbt.web.pojo.activity.OrderActivity;
import com.qbt.web.support.ActivitySupport;

/**
 *  满减活动
  * @ClassName: ActivityController
  * @Description: TODO
  * @author share 2016年9月7日
  * @modify share 2016年9月7日
 */
@Controller
@RequestMapping("/activityOff")
public class ActivityOffController {

	
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
	public Result<OrderActivity> checkOrder(@RequestBody ActivityOrderRequest request){
		Result<OrderActivity> result = new Result<OrderActivity>();
		try {
			result.setDatas(activitySupport.checkActivityOff(request));
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
