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
import com.qbt.web.pojo.orderArea.OrderAreaRequest;
import com.qbt.web.pojo.orderArea.OrderAreaResponse;
import com.qbt.web.support.OrderAreaSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

@Controller
@RequestMapping("/orderArea")
public class OrderAreaReportController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.order_area}")
	private String orderArea;
	
	@Resource
	private OrderAreaSupport orderAreaSupport;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, OrderAreaRequest req){
		//获得模板路径
        String path = templatePath + orderArea;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "order_area_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "根据地域汇总报表_" + currentDay;
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = orderAreaSupport.export(sysUser, title, req);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderAreaResponse>> findByPage(@RequestBody OrderAreaRequest req){
		PageResult<List<OrderAreaResponse>> result = new PageResult<List<OrderAreaResponse>>();
		try {
			result.setDatas(orderAreaSupport.findByPage(req));
			result.setPage(req);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("根据地域汇总报表分页查询异常");
		}
		return result;
	}
	
}
