package com.qbt.web.contorller;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Paging;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderFirst.OrderFirstRequest;
import com.qbt.web.pojo.orderFirst.OrderFirstResponse;
import com.qbt.web.support.OrderFirstSupport;
import com.qbt.web.support.TokenSupport;
import com.qbt.web.utils.ExportExcelUtils;
import com.qbt.web.utils.ReportUtil;

@Controller
@RequestMapping("/orderFirst")
public class OrderFirstReportController {
	
	@Value("${report.file.path}")
	private String templatePath;
	
	@Value("${report.file.order_first}")
	private String orderFirst;
	
	@Resource
	private TokenSupport tokenSupport;
	
	@Resource
	private OrderFirstSupport orderFirstSupport;
	
	/**
	 * 分页
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderFirstResponse>> findByPage(@RequestBody OrderFirstRequest req){
		PageResult<List<OrderFirstResponse>> result = new PageResult<List<OrderFirstResponse>>();
		try {
			result.setDatas(orderFirstSupport.findByPage(req));
			Paging page = (Paging)req;
			result.setPage(page);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("取包人首单报表分页查询异常");
		}
		return result;
	}
	
	/**
	 * 取包人首单报表接口
	 * @param request
	 * @param response
	 * @param startDate
	 * @param endDate
	 */
	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response
			, @RequestParam(value = "startDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate
			, @RequestParam(value = "endDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate){
		//获得模板路径
        String path = templatePath + orderFirst;
        //准备输出流
        OutputStream os = null;
        try {
        	String fileName = "order_first_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + Constants.XLS_SUFFIX;
        	ReportUtil.initResp(request, response, fileName);
        	
        	String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
        	String title = "取包人首单查询_" + currentDay;
        	SysUser sysUser = tokenSupport.tokenCheck(request.getParameter("token"));
        	OrderFirstRequest req = new OrderFirstRequest();
        	req.setStartDate(startDate);
        	req.setEndDate(endDate);
        	Map<String,Object> beans = orderFirstSupport.export(sysUser, title, req);
            os = response.getOutputStream();
            ExportExcelUtils.exportStudentExcel(beans, path, os);
        } catch (Exception e) {
            LogCvt.error(e.getMessage(), e);
        }
	}
	
}
