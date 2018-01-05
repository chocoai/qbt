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
import com.qbt.web.pojo.bill.BillPageReqVo;
import com.qbt.web.pojo.orderPage.OrderPageRequest;
import com.qbt.web.support.BillSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

@Controller
@RequestMapping("/billExport")
public class BillExportController {
	
	@Resource
	private BillSupport support;
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.bill}")
	private String orderPage;
	
	
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, BillPageReqVo req){
		//获得模板路径
        String path = templatePath + orderPage;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "order_page_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "发票详情报表_" + currentDay;
        	Map<String,Object> beans = support.export(title, req);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
}
