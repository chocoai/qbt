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
import com.qbt.web.pojo.orderCourse.OrderCourseRequest;
import com.qbt.web.pojo.orderCourse.OrderCourseResponse;
import com.qbt.web.support.OrderCourseSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

@Controller
@RequestMapping("/orderCourse")
public class OrderCourseReportController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.order_course}")
	private String orderCourse;
	
	@Resource
	private OrderCourseSupport orderCourseSupport;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, OrderCourseRequest req){
		//获得模板路径
        String path = templatePath + orderCourse;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "order_course_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "根据球场汇总报表_" + currentDay;
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = orderCourseSupport.export(sysUser, title, req);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderCourseResponse>> findByPage(@RequestBody OrderCourseRequest req){
		PageResult<List<OrderCourseResponse>> result = new PageResult<List<OrderCourseResponse>>();
		try {
			result.setDatas(orderCourseSupport.findByPage(req));
			result.setPage(req);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("根据球场汇总报表分页查询异常");
		}
		return result;
	}
	
}
