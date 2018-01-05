/**
 * Project Name:qbt-report
 * File Name:OrderCostItemController.java
 * Package Name:com.qbt.web.contorller
 * Date:2017年1月19日下午5:44:20
 *
*/

package com.qbt.web.contorller;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderCostItem.ReportCostItemRequest;
import com.qbt.web.pojo.orderCostItem.ReportCostItemVo;
import com.qbt.web.support.OrderCostItemSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

/**
 * ClassName:OrderCostItemController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午5:44:20
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/orderCostItem")
public class OrderCostItemController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.order_cost_item}")
	private String orderCostItem;
	
	@Resource
	private OrderCostItemSupport orderCostItemSupport;
	
	@Resource
	private TokenSupport tokenSupport;
	
	/**
	 * 订单金额明细查询
	 * @param request
	 * @param response
	 * @param req
	 */
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, ReportCostItemRequest req){
		//获得模板路径
        String path = templatePath + orderCostItem;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "order_cost_item_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "费用增减明细_" + currentDay;
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = orderCostItemSupport.export(sysUser, title, req);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public PageResult<List<ReportCostItemVo>> findByPage(@RequestBody ReportCostItemRequest req){
		PageResult<List<ReportCostItemVo>> result = new PageResult<List<ReportCostItemVo>>();
		try {
			result.setDatas(orderCostItemSupport.findByPage(req));
			result.setPage(req);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("费用增减明细报表分页查询异常");
		}
		return result;
	}
}
