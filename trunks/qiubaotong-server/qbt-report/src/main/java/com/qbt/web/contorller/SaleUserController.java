/**
 * Project Name:qbt-report
 * File Name:SaleUserController.java
 * Package Name:com.qbt.web.contorller
 * Date:2017年2月8日下午1:55:47
 *
*/

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
import com.qbt.web.pojo.saleUser.SaleUserExportRequest;
import com.qbt.web.support.SaleUserSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

/**
 * ClassName:SaleUserController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 下午1:55:47
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/saleUser")
public class SaleUserController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.sale_user}")
	private String saleUserFile;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@Resource
	private SaleUserSupport saleUserSupport;
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response
							, SaleUserExportRequest req){
		//获得模板路径
        String path = templatePath + saleUserFile;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "sale_user_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String, Object> beans = saleUserSupport.exportSaleUser(req, sysUser);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
	
	
	
	
	
}
