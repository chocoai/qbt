/**
 * Project Name:qbt-system-web
 * File Name:BagCodeOrderController.java
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

import com.qbt.bussiness.pojo.bagCode.BagCodeOrderPageReq;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.web.pojo.bagCode.BagCodeOrderVo;
import com.qbt.web.support.BagCodeOrderSupport;

/**
 * ClassName:BagCodeOrderController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 上午11:54:55
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/bagCodeOrder")
public class BagCodeOrderController {
	
	@Resource
	private BagCodeOrderSupport bagCodeOrderSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BagCodeOrderVo>> findByPage(@RequestBody BagCodeOrderPageReq pageReq){
		PageResult<List<BagCodeOrderVo>> result = new PageResult<List<BagCodeOrderVo>>();
		try {
			result.setDatas(bagCodeOrderSupport.findByPage(pageReq));
			result.setPage(pageReq);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("包包码使用列表分页查询异常");
		}
		return result;
	}
	
}
