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
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.activity.ActivityRequest;
import com.qbt.web.pojo.activity.ActivityResponse;
import com.qbt.web.support.ActivitySupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

@Controller
@RequestMapping("/activity")
public class ActivityReportController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.activity_coupon}")
	private String activityCoupon;
	
	@Value("${report.file.activity_count}")
	private String activityAcount;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@Resource
	private ActivitySupport activitySupport;
	
	@RequestMapping(value = "/coupon")
	public void exportCoupon(HttpServletRequest request, HttpServletResponse response
							, @RequestParam(value = "activityId")Integer activityId){
		//获得模板路径
        String path = templatePath + activityCoupon;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "activity_coupon_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = activitySupport.exportCoupon(activityId, sysUser);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
	/**
	 *  现金券活动报表统计
	  * @Title: orderDetail
	  * @Description: TODO
	  * @author: share 2016年9月26日
	  * @modify: share 2016年9月26日
	  * @param request
	  * @param response
	  * @param activityId
	 */
	@RequestMapping(value = "/exportActivity")
	public void exportActivity(HttpServletRequest request, HttpServletResponse response, ActivityRequest activity){
		//获得模板路径
        String path = templatePath + activityAcount;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "activity_acount_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = activitySupport.exportActivity(activity, sysUser);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
	/**
	 *  现金券查询分页
	  * @Title: findByPage
	  * @Description: TODO
	  * @author: share 2016年9月26日
	  * @modify: share 2016年9月26日
	  * @param activity
	  * @return
	 */
	@RequestMapping(value = "/activityFindByPage", method = RequestMethod.POST)
	public PageResult<List<ActivityResponse>> findByPage(@RequestBody ActivityRequest activity){
		PageResult<List<ActivityResponse>> result = new PageResult<List<ActivityResponse>>();
		try {
			result.setDatas(activitySupport.findByPage(activity));
			result.setPage(activity);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("现金券报表分页查询异常");
		}
		return result;
	}
	
}
