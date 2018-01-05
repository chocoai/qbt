/**
 * Project Name:qbt-web
 * File Name:BaseAdvertController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年10月11日上午10:46:14
 *
*/

package com.qbt.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.baseAdvert.BaseAdvertVo;
import com.qbt.web.support.BaseAdvertSupport;

/**
 * ClassName:BaseAdvertController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月11日 上午10:46:14
 * @author   wuwang
 * @version  
 * @see 	 
 */

@Controller
@RequestMapping("/baseAdvert")
public class BaseAdvertController {

	@Resource
	private BaseAdvertSupport baseAdvertSupport;
	
	@RequestMapping("/listByCode")
	public Result<BaseAdvertVo> listByCode(String code, Integer flatType){
		Result<BaseAdvertVo> result = new Result<BaseAdvertVo>();
		try {
			result.setDatas(baseAdvertSupport.listByCode(code, flatType));
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
