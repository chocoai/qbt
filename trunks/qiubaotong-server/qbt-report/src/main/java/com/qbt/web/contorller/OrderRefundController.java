package com.qbt.web.contorller;

import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderAmount.OrderAmountRequest;
import com.qbt.web.pojo.orderRefund.OrderRefundRequest;
import com.qbt.web.support.OrderRefundSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

/**
 * 退款查询导出
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/orderRefund")
public class OrderRefundController {

	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.order_refund}")
	private String orderRefund;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@Resource
	private OrderRefundSupport orderRefundSupport;
	
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, OrderRefundRequest req){
		//获得模板路径
        String path = templatePath + orderRefund;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "order_refund_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "退款查询_" + currentDay;
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = orderRefundSupport.export(sysUser, title, req);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
}
