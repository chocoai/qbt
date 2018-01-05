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
import com.qbt.web.pojo.saleWeixinSubcripbeInfo.SaleWeixinSubcripbeInfoRequest;
import com.qbt.web.support.SaleWeixinSubcripbeInfoSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

@Controller
@RequestMapping("/saleWeixinSubcripbeInfo")
public class SaleWeixinSubcripbeInfoController {

	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.sale_weixin_subcripbe_info}")
	private String saleWeixinSubcripbeInfo;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@Resource
	private SaleWeixinSubcripbeInfoSupport saleWeixinSubcripbeInfoSupport;
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, SaleWeixinSubcripbeInfoRequest req){
		//获得模板路径
        String path = templatePath + saleWeixinSubcripbeInfo;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "sale_weixin_subcripbe_info_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_03);
        	String title = "关注奖金总汇";
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = saleWeixinSubcripbeInfoSupport.export(sysUser, title, req, currentDay);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
}
