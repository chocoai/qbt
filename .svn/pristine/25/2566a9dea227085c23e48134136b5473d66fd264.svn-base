/**
 * Project Name:qbt-system-web
 * File Name:BagCodeUserController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年8月25日上午11:54:55
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.bussiness.pojo.bagCode.BagCodeUserPageReq;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.web.pojo.bagCode.BagCodeUserVo;
import com.qbt.web.support.BagCodeUserSupport;

/**
 * ClassName:BagCodeUserController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 上午11:54:55
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/bagCodeUser")
public class BagCodeUserController {
	
	@Resource
	private BagCodeUserSupport bagCodeUserSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BagCodeUserVo>> findByPage(@RequestBody BagCodeUserPageReq pageReq){
		PageResult<List<BagCodeUserVo>> result = new PageResult<List<BagCodeUserVo>>();
		try {
			result.setDatas(bagCodeUserSupport.findByPage(pageReq));
			result.setPage(pageReq);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("包包码用户分页查询异常");
		}
		return result;
	}
	
}
