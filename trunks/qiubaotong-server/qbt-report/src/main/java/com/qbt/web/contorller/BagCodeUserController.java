/**
 * Project Name:qbt-report
 * File Name:BagCodeUserController.java
 * Package Name:com.qbt.web.contorller
 * Date:2017年8月25日下午2:51:51
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

import com.qbt.bussiness.pojo.bagCode.BagCodeUserPageReq;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.support.BagCodeUserSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

/**
 * ClassName:BagCodeUserController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午2:51:51
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/bagCodeUser")
public class BagCodeUserController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.bag_code_user}")
	private String bagCodeUser;
	
	@Resource
	private BagCodeUserSupport bagCodeUserSupport;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, BagCodeUserPageReq pageReq){
		//获得模板路径
        String path = templatePath + bagCodeUser;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "bag_code_user_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "包包码会员列表_" + currentDay;
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = bagCodeUserSupport.export(pageReq, title, sysUser);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
}
