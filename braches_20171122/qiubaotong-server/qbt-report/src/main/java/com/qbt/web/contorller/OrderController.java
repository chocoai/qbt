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
import com.qbt.web.pojo.orderPage.OrderPageRequest;
import com.qbt.web.pojo.orderPage.OrderPageResponse;
import com.qbt.web.support.OrderPageSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

/**
 * 订单分页（客服专属）
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/orderPage")
public class OrderController {

	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.order_page}")
	private String orderPage;
	
	@Resource
	private OrderPageSupport orderPageSupport;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderPageResponse>> findByPage(@RequestBody OrderPageRequest req){
		PageResult<List<OrderPageResponse>> result = new PageResult<List<OrderPageResponse>>();
		try {
			result.setDatas(orderPageSupport.findByPage(req));
			result.setPage(req);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, OrderPageRequest req){
		//获得模板路径
        String path = templatePath + orderPage;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "order_page_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "订单查询明细报表_" + currentDay;
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = orderPageSupport.export(sysUser, title, req);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
}
