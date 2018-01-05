package com.qbt.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.persistent.entity.OrgGroupAmountConfig;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.assistant.AssistantLoginResp;
import com.qbt.web.pojo.base.BaseInsuredTemplateVo;
import com.qbt.web.pojo.base.ReciveTime;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.order.OrderOrgRequest;
import com.qbt.web.pojo.order.OrderOrgVo;
import com.qbt.web.pojo.saleUser.SaleUserVo;
import com.qbt.web.pojo.weixin.PopRequestVo;
import com.qbt.web.pojo.weixin.PopResponseVo;
import com.qbt.web.support.BasePopUpSupport;
import com.qbt.web.support.InsureTemplateSupport;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderSupport;
import com.qbt.web.support.OrgGroupAmountConfigSupport;
import com.qbt.web.support.OrgGroupUserSupport;
import com.qbt.web.support.SaleUserSupport;

/**
 * 用户登录接口
 * @author share
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@Resource
	private LoginSupport loginSupport;
	@Resource
	private InsureTemplateSupport insureTemplateSupport;
	@Resource
	private OrderSupport orderSupport;
	@Resource
	private BasePopUpSupport basePopUpSupport;
	@Resource
	private SaleUserSupport saleUserSupport;
	@Resource
	private OrgGroupUserSupport orgGroupUserSupport;
	@Resource
	private OrgGroupAmountConfigSupport orgGroupAmountConfigSupport;
	
	/**
	 *  登录
	 * @param code
	 * @param lon
	 * @param lat
	 * @return
	 */
	@RequestMapping("/login")
	public Result<String> login(String code,String lon,String lat){
		return loginSupport.login(code, lat, lon);
	}
	
	
	/**
	 *  球包助理登录
	 * @param code
	 * @param lon
	 * @param lat
	 * @return
	 */
	@RequestMapping("/assistant_login")
	public Result<AssistantLoginResp> assistantLogin(HttpServletRequest request,String code,String lon,String lat){
		Result<AssistantLoginResp> result=new Result<AssistantLoginResp>();
		String token = request.getHeader("token");
		String openid = null;
		if(!StringUtil.isEmpty(token) && !"null".equalsIgnoreCase(token)){
			LogCvt.info("assistant token:"+token);
			openid = loginSupport.checkToken(token);
			if(openid == null){
				LogCvt.info("微信授权过期，请重新授权...");
				result.setCode(ErrorCodeEnum.ERROR_AUTH.getCode());
				result.setMsg("微信授权过期，请重新授权");
				return result;
			}
		}else{
			//插入用户信息 
			Result<String> rst=loginSupport.login(code, lat, lon);
			if(!rst.getCode().equals(ErrorCodeEnum.ERROR_SUCCESS.getCode())){
				result.setCode(rst.getCode());
				result.setMsg(rst.getMsg());
				return result;
			}
			token 			= rst.getDatas();
			openid			= loginSupport.checkToken(token);
		}
		
		//查询助理表
		UserWeixin userWeixin	= loginSupport.findByOpenId(openid);
		UserAssistant user  	= loginSupport.checkUserIsAssistant(userWeixin.getId());
		AssistantLoginResp resp = new AssistantLoginResp();
		resp.setToken(token);
		if(user == null){
			resp.setStatus(0);
			resp.setMemo("无记录");
		}else{
			resp.setStatus(user.getStatus());
			resp.setMemo(user.getMemo());
			resp.setApplyId(user.getApplyId() == null ? 0 : user.getApplyId());
			resp.setApplyName(user.getApplyName());
			int applyType = user.getApplyType();
			if(applyType == 1 || applyType == 2){
				applyType = 1;
			}else if(applyType == 3){
				applyType = 3;
			}else if(applyType == 4){
				applyType = 5;
			}else if(applyType == 5){
				applyType = 2;
			}
			resp.setApplyType(applyType);
		}
		// 检查用户是否属于销售人员
		SaleUserVo saleUser = saleUserSupport.detail(userWeixin.getId());
		if(Checker.isNotEmpty(saleUser) && saleUser.getApplyStatus() == 2 && saleUser.getStatus() == 2){
			//审核通过且无效
			resp.setSalesmanStatus(4);
		}else if(Checker.isNotEmpty(saleUser)) {
			resp.setSalesmanStatus(saleUser.getApplyStatus());
		}
		result.setDatas(resp);
		return result;
	}

	/**
	 * 预约时间
	 * @return
	 */
	@RequestMapping("/time")
	public Result<List<ReciveTime>> time(){
		Result<List<ReciveTime>> result = new Result<List<ReciveTime>>();
		List<ReciveTime> list = new ArrayList<ReciveTime>();
		Date now = new Date();
		for(int i = 0; i < 10;i++){
			Date date = DateUtil.calDateOfDay(i);
			int days = (int)DateUtil.getDiffDay( now, date);
			String datestr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_01);
			String fix = "";
			switch (days) {
			case 0:
				fix = "今天 ";
				break;
			case 1:
				fix = "明天 ";
				break;
			case 2:
				fix = "后天 ";
				break;
			}
			List<String> dates = DateUtil.getTimes(date,now);
			if(!dates.isEmpty()){
				ReciveTime reciveTime = new ReciveTime();
				reciveTime.setDay(datestr);
				reciveTime.setPrefix(fix);
				reciveTime.setItems(dates);
				list.add(reciveTime);
			}
		}
		result.setDatas(list);
		return result;
	}
	
	/**
	 * 默认预约时间接口
	 * @return
	 */
	@RequestMapping("/default_time")
	public Result<String> default_time(){
		Result<String> result = new Result<String>();
		Date now = new Date();
		for(int i = 0; i <= 1;i++){
			Date date = DateUtil.calDateOfDay(i);
			String datestr = DateUtil.formatDate(date, DateUtil.DATE_FORMAT_01);
			List<String> dates = DateUtil.getTimes(date,now);
			if(!dates.isEmpty()){
				result.setDatas(datestr+" "+dates.get(0));
				break;
			}
		}
		return result;
	}

	/**
	 * 保价金额计算
	 * @param price
	 * @return
	 */
	@RequestMapping("/insure")
	public Result<Double> insure(double price){
		Result<Double> result = new Result<Double>();
		try {
			result.setDatas(insureTemplateSupport.insureValidPrice(price, 1));
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
			LogCvt.error(e.getMessage(),e);
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	
	/**
	 *  保价费配置查询
	  * @Title: query_insured
	  * @Description: TODO
	  * @author: share 2016年12月29日
	  * @modify: share 2016年12月29日
	  * @return
	 */
	@RequestMapping("/query_insured")
	public Result<BaseInsuredTemplateVo> query_insured(){
		Result<BaseInsuredTemplateVo> result = new Result<BaseInsuredTemplateVo>();
		try {
			BaseInsuredTemplateVo datas = insureTemplateSupport.queryTemplate();
			 Result<Double> resultData = insure(datas.getMin());
			datas.setInsuredPrice(resultData.getDatas());
			result.setDatas(datas);
		}catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
			LogCvt.error(e.getMessage(), e);
		}catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(), e);
		}
		return result;
	}
	
	/**
	 *  路由查询
	  * @Title: query_keyword
	  * @Description: TODO
	  * @author: share 2016年8月25日
	  * @modify: share 2016年8月25日
	  * @param keyword
	  * @return
	 */
	@RequestMapping("/query_keyword")
	public Result<OrderDetail> query_keyword(String keyword){
		Result<OrderDetail> result = new Result<OrderDetail>();
		try {
			if(StringUtil.isEmpty(keyword)){
				result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
				result.setMsg("关键词不能为空");
				return result;
			}
			result.setDatas(orderSupport.queryKeyword(keyword));
			
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
			LogCvt.error(e.getMessage(),e);
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	/**
	 *  提示弹框查询
	  * @Title: pop
	  * @Description: TODO
	  * @author: share 2017年1月17日
	  * @modify: share 2017年1月17日
	  * @param vo
	  * @return
	 */
	@RequestMapping("/pop")
	public Result<List<PopResponseVo>> pop(@RequestBody PopRequestVo vo){
		Result<List<PopResponseVo>> result = new Result<List<PopResponseVo>>();
		try {
			
			result.setDatas(basePopUpSupport.query(vo));
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
			LogCvt.error(e.getMessage(),e);
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/insure_origin")
	public Result<Double> insure_origin(double price){
		Result<Double> result = new Result<Double>();
		try {
			result.setDatas(insureTemplateSupport.insureValidPrice(price, 2));
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
			LogCvt.error(e.getMessage(),e);
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	/**
	 * 寄件人为群机构
	 * @param price
	 * @return
	 */
	@RequestMapping("/jContactIsOrg")
	public Result<OrderOrgVo> jContactIsOrg(@RequestBody OrderOrgRequest orderOrgRequest){
		Result<OrderOrgVo> result = new Result<OrderOrgVo>();
		try {
			result.setDatas(orgGroupUserSupport.jContactIsOrg(orderOrgRequest.getjContact(), orderOrgRequest.getjMobile()));
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
			LogCvt.error(e.getMessage(),e);
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	/**
	 * 相应的机构群优惠配置
	 * @param type
	 * @return
	 */
	@RequestMapping("/suitableOrgGroupAmountConfig")
	public Result<OrgGroupAmountConfig> suitableOrgGroupAmountConfig(Double amount, Integer orgId){
		Result<OrgGroupAmountConfig> result = new Result<OrgGroupAmountConfig>();
		try {
			result.setDatas(orgGroupAmountConfigSupport.suitableOrgGroupAmountConfig(amount, orgId ));
		}catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
}
