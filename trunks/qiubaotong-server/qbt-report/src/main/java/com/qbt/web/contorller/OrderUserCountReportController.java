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
import com.qbt.web.pojo.userOrderCount.UserOrderCountRequest;
import com.qbt.web.pojo.userOrderCount.UserOrderCountResponse;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.support.UserOrderCountSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

/**
 *  用户下单订单统计
  * @ClassName: OrderUserCountReportController
  * @Description: TODO
  * @author share 2016年9月26日
  * @modify share 2016年9月26日
 */
@Controller
@RequestMapping("/orderUserCount")
public class OrderUserCountReportController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.user_order_count}")
	private String userOrderCount;
	
	@Resource
	private UserOrderCountSupport userOrderCountSupport;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response, UserOrderCountRequest req){
		//获得模板路径
        String path = templatePath + userOrderCount;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "user_order_count_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "用户累计使用次数统计报表_" + currentDay;
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	Map<String,Object> beans = userOrderCountSupport.export(sysUser, req);
        	beans.put("title", title);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public PageResult<List<UserOrderCountResponse>> findByPage(@RequestBody UserOrderCountRequest req){
		PageResult<List<UserOrderCountResponse>> result = new PageResult<List<UserOrderCountResponse>>();
		try {
			result.setDatas(userOrderCountSupport.findByPage(req));
			result.setPage(req);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("用户订单统计报表分页查询异常");
		}
		return result;
	}
	
}
