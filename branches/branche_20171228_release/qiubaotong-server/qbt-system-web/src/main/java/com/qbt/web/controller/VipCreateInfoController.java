/**
 * Project Name:qbt-system-web
 * File Name:VipCreateInfoController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年1月5日上午11:24:07
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
import com.qbt.common.result.Result;
import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoPageReqVo;
import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoUpdateBatch;
import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoVo;
import com.qbt.web.support.VipCreateInfoSupport;

/**
 * ClassName:VipCreateInfoController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月5日 上午11:24:07
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/vipCreateInfo")
public class VipCreateInfoController {
	
	@Resource
	private VipCreateInfoSupport vipCreateInfoSupport;
	
	@RequestMapping("/findByPage")
	public PageResult<List<VipCreateInfoVo>> findByPage(@RequestBody VipCreateInfoPageReqVo reqVo){
		PageResult<List<VipCreateInfoVo>> result = new PageResult<List<VipCreateInfoVo>>();
		try {
			result.setDatas(vipCreateInfoSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("生成实体卡详情记录分页查询异常");
		}
		return result;
	}
	
	@RequestMapping("/updateBatch")
	public Result<Boolean> updateBatch(@RequestBody VipCreateInfoUpdateBatch updateBatch){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(vipCreateInfoSupport.updateBatch(updateBatch));;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("生成实体卡详情记录批量更新异常");
		}
		return result;
	}
	
}
