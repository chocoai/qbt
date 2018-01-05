/**
 * Project Name:qbt-system-web
 * File Name:VipCreateController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年1月4日下午1:33:55
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.vipCreate.VipCreateGenerate;
import com.qbt.web.pojo.vipCreate.VipCreatePageReqVo;
import com.qbt.web.pojo.vipCreate.VipCreateVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.VipCreateSupport;

/**
 * ClassName:VipCreateController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 下午1:33:55
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/vipCreate")
public class VipCreateController {
	
	@Resource
	private VipCreateSupport vipCreateSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping("/generate")
	public Result<Boolean> generate(HttpServletRequest request, @RequestBody VipCreateGenerate createGenerate){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(createGenerate);
			
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(vipCreateSupport.generateVipCard(createGenerate, sysUser));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("生成实体卡异常");
		}
		return result;
	}
	
	@RequestMapping("/findByPage")
	public PageResult<List<VipCreateVo>> findByPage(@RequestBody VipCreatePageReqVo reqVo){
		PageResult<List<VipCreateVo>> result = new PageResult<List<VipCreateVo>>();
		try {
			result.setDatas(vipCreateSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("生成实体卡记录分页查询异常");
		}
		return result;
	}
	
}
