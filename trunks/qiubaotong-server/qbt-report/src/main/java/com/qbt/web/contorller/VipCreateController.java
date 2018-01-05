/**
 * Project Name:qbt-report
 * File Name:VipCreateController.java
 * Package Name:com.qbt.web.contorller
 * Date:2017年1月4日下午1:57:23
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
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.support.VipCreateSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

/**
 * ClassName:VipCreateController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 下午1:57:23
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/vipCreate")
public class VipCreateController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.vip_create_info}")
	private String vipCreateInfo;
	
	@Resource
	private VipCreateSupport vipCreateSupport;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response
							, @RequestParam(value = "vipCreateId")Integer vipCreateId){
		//获得模板路径
        String path = templatePath + vipCreateInfo;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "vip_create_info_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String, Object> beans = vipCreateSupport.exportVipCreateInfo(vipCreateId, sysUser);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
}
