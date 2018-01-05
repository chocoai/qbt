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
import com.qbt.web.pojo.salebusiness.SaleOrderResponse;
import com.qbt.web.pojo.salebusiness.SaleReqPage;
import com.qbt.web.pojo.salebusiness.SaleSubcripbeResponse;
import com.qbt.web.support.SalerBusinessSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

/**
 * 退款查询导出
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/sale")
public class SaleController {

	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.sale_order_info_report}")
	private String saleOrderInfo;
	
	@Value("${report.file.sale_subcripbe_info_report}")
	private String saleSubcripbeInfo;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@Resource
	private SalerBusinessSupport salerBusinessSupport;
	
	
	@RequestMapping(value = "/order/findByPage", method = RequestMethod.POST)
	public PageResult<List<SaleOrderResponse>> findByPage(@RequestBody SaleReqPage req){
		PageResult<List<SaleOrderResponse>> result = new PageResult<List<SaleOrderResponse>>();
		try {
			result.setDatas(salerBusinessSupport.findOrderByPage(req));
			result.setPage(req);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单明细报表分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "/order/export")
	public void orderExport(HttpServletRequest request, HttpServletResponse response, SaleReqPage req){
		//获得模板路径
        String path = templatePath + saleOrderInfo;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "sale_order_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = salerBusinessSupport.exportSaleOrder(req, sysUser);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
	@RequestMapping(value = "/subcripbe/findByPage", method = RequestMethod.POST)
	public PageResult<List<SaleSubcripbeResponse>> findSubcripbeByPage(@RequestBody SaleReqPage req){
		PageResult<List<SaleSubcripbeResponse>> result = new PageResult<List<SaleSubcripbeResponse>>();
		try {
			result.setDatas(salerBusinessSupport.findSubcripbeByPage(req));
			result.setPage(req);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单明细报表分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "/subcripbe/export")
	public void subcripbeExport(HttpServletRequest request, HttpServletResponse response, SaleReqPage req){
		//获得模板路径
        String path = templatePath + saleSubcripbeInfo;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "sale_subcripbe_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = salerBusinessSupport.exportSaleSubcripbe(req, sysUser);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
}
