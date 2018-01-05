package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.LogTypeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseNewSfPrice;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.BaseSfPrice;
import com.qbt.persistent.entity.OutRangeAddress;
import com.qbt.persistent.entity.SysLogs;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseNewSfPriceService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseSfPriceService;
import com.qbt.service.OutRangeAddressService;
import com.qbt.service.SysLogsService;
import com.qbt.sf.api.bean.RespErr;
import com.qbt.sf.api.bean.delivertm.Address;
import com.qbt.sf.api.bean.delivertm.DeliverTmReq;
import com.qbt.sf.api.bean.delivertm.DeliverTmReqBody;
import com.qbt.sf.api.bean.delivertm.DeliverTmReqDeliver;
import com.qbt.sf.api.bean.delivertm.DeliverTmResp;
import com.qbt.sf.api.bean.delivertm.DeliverTmRespDeliver;
import com.qbt.sf.api.bean.website.DeliverReq;
import com.qbt.sf.api.bean.website.DeliverResp;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.web.pojo.base.Area;
import com.qbt.web.pojo.sf.DeliverRequest;
import com.qbt.web.pojo.sf.DeliverResponse;
import com.qbt.web.pojo.sf.DeliverV2Response;
import com.qbt.web.pojo.urgent.UrgentPageReqVo;
import com.qbt.web.pojo.urgent.UrgentVo;
import com.qbt.web.support.AreaSupport;
import com.qbt.web.support.SfExpressSupport;
import com.qbt.web.support.SfTimeContextSupport;
import com.qbt.web.support.SfTimeStateSupport;
import com.qbt.web.support.UrgentSupport;

@Service
public class SfExpressSupportImpl implements SfExpressSupport {

	@Resource
	private BaseSfAreaService baseSfAreaService;
	@Resource
	private BaseSfPriceService baseSfPriceService;
	@Resource
	private SFExpressApiService sfExpressApiService;
	@Resource
	private BaseCourseService baseCourseService;
	@Resource
	private SysLogsService sysLogsService;
	@Resource
	private SfTimeContextSupport sfTimeContextSupport;
	@Resource
	private BaseNewSfPriceService baseNewSfPriceService;
	@Resource(name = "nightSfTimeState")
	private SfTimeStateSupport sfTimeState;
	@Resource
	private OutRangeAddressService outRangeAdressService;
	
	@Resource
	private AreaSupport areaSupport;
	@Resource
	private UrgentSupport urgentSupport;
	
	/**
	 * 查询顺丰预计到达时间
	  * @Title: query_sf_expect_recive_time
	  * @Description: TODO
	  * @author: share 2016年8月10日
	  * @modify: share 2016年8月10日
	  * @param request
	  * @return
	  * @see com.qbt.web.support.SfExpressSupport#query_sf_expect_recive_time(com.qbt.web.pojo.sf.DeliverRequest)
	 */
	@Override
	public List<DeliverResponse> query_sf_expect_recive_time(DeliverRequest request) {
		List<DeliverResponse> responseList = new ArrayList<DeliverResponse>();
		
		if((request.getSrc_province() == null && request.getSrc_city() == null && request.getSrc_district() == null) && request.getSrc_area_id() == 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "请求寄件地址信息不能为空");
		}
		
		if((request.getDest_province() == null && request.getDest_city() == null && request.getDest_district() == null) && request.getDest_area_id() ==0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "请求收件地址信息不能为空");
		}
		
		// 结果模型，1-官网，2-BPS
		int resultMode = 1;
		// 填充地区信息
		contactRequestAreaInfo(request);
		// 获取调整日期请求
		String consigneTime = request.getConsigned_time();
		consigneTime = consigneTime.length() > 20 ? consigneTime.substring(0,16)+":00" : consigneTime;
		Date consignedDate = DateUtil.str2Date(consigneTime, DateUtil.DATE_TIME_FORMAT_01);
		sfTimeContextSupport.setSfTimeState(sfTimeState);
		Date ajustDate = sfTimeContextSupport.ajustDate(consignedDate, null);
		int diffSecond = 0;
		if(ajustDate != null && ajustDate.compareTo(consignedDate) != 0){
			// 时效差
			//周五17点以后时效也按周六日时效一样处理
			ajustDate = fillDateTime(consignedDate, ajustDate);
			Date ajustNight = DateUtil.ajustNight(consignedDate);
			diffSecond = DateUtil.isNight(consignedDate) 
					? (isWeekend(ajustNight) ? (int)DateUtil.getDiffSecond(ajustDate, ajustNight) : diffSecond) 
					: (int)DateUtil.getDiffSecond(ajustDate, consignedDate);
			request.setConsigned_time(DateUtil.formatDateTime(ajustDate));
		}
		// 查询官网
		List<DeliverResp> deliverWebsiteList = sendSfWebSite(request);
		List<DeliverTmRespDeliver> deliverList = null;
		// 发送顺丰BPS
		if(deliverWebsiteList == null || deliverWebsiteList.isEmpty()){
			DeliverTmResp resp = sendSfBps(request);
			deliverList= resp.getBody().getDeliverTm();
			resultMode = 2;
		}
		
		if(resultMode == 2 && (deliverList == null || deliverList.isEmpty())){
			String desc = JSonUtil.toJSonString(request)+">官网无查询可选择记录，BPS接口查询无可选择记录【BPS接口】";
			recordLogs(desc);
			LogCvt.error(desc);
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
		}
		
		// 计算保价金额
		double sfprice_value_1 = 0;
		double sfprice_value_2 = 0;
		double sfprice_value_5 = 0;
		BaseSfPrice sfprice = selectSfPrice(request);
		if(sfprice == null){
			if(resultMode == 2){
				String desc = JSonUtil.toJSonString(request)+">官网查询无可选择记录，BPS接口可查询有可选记录，但配置项无价格配置【BPS接口】";
				recordLogs(desc);
				LogCvt.error(desc);
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
			}
		}else{
			// 1-次日达 2-隔日达 5-次午达
			sfprice_value_1 = sfprice.getCiriQbtPrice().doubleValue();
			sfprice_value_2 = sfprice.getGeriQbtPrice().doubleValue();
			sfprice_value_5 = sfprice.getCichenQbtPrice().doubleValue();
		}
		
		// 球场信息
		BaseCourse jCourse = request.getSrc_course_id() > 0 ? baseCourseService.findById(request.getSrc_course_id()) : null;
		BaseCourse dCourse = request.getDest_course_id() > 0 ? baseCourseService.findById(request.getDest_course_id()) : null;
		
		//地址信息
	    OutRangeAddress jAddress = outRangeAdressService.findByAreaId(request.getSrc_area_id(), request.getSrc_address());
	    OutRangeAddress dAddress = outRangeAdressService.findByAreaId(request.getDest_area_id(), request.getDest_address());
	    
	    request.setConsigned_time(consigneTime);
		// 官网查询
		if(resultMode == 1){
			for(DeliverResp deliver : deliverWebsiteList){
				// 对比时效差计算正常时效
				deliver.setDeliverTime(DateUtil.calDateOfSecond(deliver.getDeliverTime(), diffSecond, DateUtil.DATE_TIME_FORMAT_04));
				deliver.setAddTime(DateUtil.calDateOfSecond(deliver.getAddTime(), diffSecond, DateUtil.DATE_TIME_FORMAT_04));
				
				DeliverResponse response = new DeliverResponse();
				response.setBusiness_type(deliver.getBusinessType());
				response.setBusiness_type_desc(deliver.getLimitTypeName());
				//偏远球场增加时效
				String deliverTime = calOutRangeTime(deliver.getDeliverTime()+":00", jCourse, dCourse,jAddress,dAddress);
				String addTime = calOutRangeTime(deliver.getAddTime()+":00", jCourse, dCourse,jAddress,dAddress);
				response.setDeliver_time(deliverTime+","+addTime);
				String type = deliver.getBusinessType();
				if("1".equals(type)){
					if(sfprice_value_1 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getLimitTypeName()+">DB无价格配置，取顺丰价格>"+deliver.getFreight()+"【顺丰官网】";
						recordLogs(desc);
						LogCvt.error(desc);
						response.setSf_price(calOutRangePrice(sfprice(deliver.getFreight(), type), jCourse, dCourse,jAddress,dAddress));
					}else{
						response.setSf_price(calOutRangePrice(sfprice_value_1, jCourse, dCourse,jAddress,dAddress));
					}
					
				}else if("2".equals(type)){
					if(sfprice_value_2 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getLimitTypeName()+">DB无价格配置，取顺丰价格>"+deliver.getFreight()+"【顺丰官网】";
						recordLogs(desc);
						LogCvt.error(desc);
						response.setSf_price(calOutRangePrice(sfprice(deliver.getFreight(), type), jCourse, dCourse,jAddress,dAddress));
					}else{
						response.setSf_price(calOutRangePrice(sfprice_value_2, jCourse, dCourse,jAddress,dAddress));
					}
					
				}else if("5".equals(type)){
					if(sfprice_value_5 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getLimitTypeName()+">DB无价格配置，取顺丰价格>"+deliver.getFreight()+"【顺丰官网】";
						recordLogs(desc);
						LogCvt.error(desc);
						response.setSf_price(calOutRangePrice(sfprice(deliver.getFreight(), type), jCourse, dCourse,jAddress,dAddress));
					}else{
						response.setSf_price(calOutRangePrice(sfprice_value_5, jCourse, dCourse,jAddress,dAddress));
					}
				}else{
					continue;
				}
				responseList.add(response);
			}
		// BPS查询结果
		}else if(resultMode == 2){
			for(DeliverTmRespDeliver deliver : deliverList){
				
				DeliverResponse response = new DeliverResponse();
				response.setBusiness_type(deliver.getBusiness_type());
				response.setBusiness_type_desc(deliver.getBusiness_type_desc());
				
				String[] deliverTimes = deliver.getDeliver_time().split(",");
				// 对比时效差计算正常时效
				String ajustStartTime = DateUtil.calDateOfSecond(deliverTimes[0], diffSecond, DateUtil.DATE_TIME_FORMAT_01);
				String ajustEndTime = DateUtil.calDateOfSecond(deliverTimes[1], diffSecond, DateUtil.DATE_TIME_FORMAT_01);
				
				//偏远球场增加时效
				String startTime = calOutRangeTime(ajustStartTime, jCourse, dCourse,jAddress,dAddress);
				String endTime = calOutRangeTime(ajustEndTime, jCourse, dCourse,jAddress,dAddress);
				response.setDeliver_time(startTime+","+endTime);
				if("1".equals(deliver.getBusiness_type())){
					if(sfprice_value_1 < 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getBusiness_type_desc()+">DB无价格配置，过滤次数据【BPS接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					
					response.setSf_price(calOutRangePrice(sfprice_value_1, jCourse, dCourse,jAddress,dAddress));
				}else if("2".equals(deliver.getBusiness_type())){
					if(sfprice_value_2 < 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getBusiness_type_desc()+">DB无价格配置，过滤次数据【BPS接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					response.setSf_price(calOutRangePrice(sfprice_value_2, jCourse, dCourse,jAddress,dAddress));
				}else if("5".equals(deliver.getBusiness_type())){
					if(sfprice_value_5 < 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getBusiness_type_desc()+">DB无价格配置，过滤次数据【BPS接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					response.setSf_price(calOutRangePrice(sfprice_value_5, jCourse, dCourse,jAddress,dAddress));
				}else{
					continue;
				}
				responseList.add(response);
			}
		}
		if(responseList.isEmpty()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
		}
		return responseList;
			
	}

	private void recordLogs(String desc) {
		SysLogs sysLogs = new SysLogs();
		sysLogs.setStatus(1);
		sysLogs.setType(LogTypeEnum.wechat.getCode());
		sysLogs.setMemo(desc);
		sysLogsService.insert(sysLogs);
	}

	private List<DeliverResp> sendSfWebSite(DeliverRequest request) {
		String consigneTime = request.getConsigned_time();
		consigneTime = consigneTime.length() > 20 ? consigneTime.substring(0,16)+":00" : consigneTime;
		DeliverReq deliverReq = new DeliverReq();
		deliverReq.setSrcAreaId(request.getSrc_area_id());
		deliverReq.setDestAreaId(request.getDest_area_id());
		deliverReq.setSrcCode(request.getSrc_code());
		deliverReq.setDestCode(request.getDest_code());
		deliverReq.setTime(consigneTime);
		List<DeliverResp> deliverWebsiteList = null;
		try {
			deliverWebsiteList = sfExpressApiService.deliverTmServiceBySfWebSite(deliverReq);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		return deliverWebsiteList;
	}

	private BaseSfPrice selectSfPrice(DeliverRequest request) {
		BaseSfPrice price = new BaseSfPrice();
		price.setStartProvince(request.getSrc_province());
		price.setStartCity(request.getSrc_city());
		price.setEndProvince(request.getDest_province());
		price.setEndCity(request.getDest_city());
		BaseSfPrice sfprice = baseSfPriceService.findByCityName(price);
		return sfprice;
	}

	private DeliverTmResp sendSfBps(DeliverRequest request) {
		// 计算顺丰预计到达时间
		DeliverTmReq req = new DeliverTmReq();
		
		DeliverTmReqBody body = new DeliverTmReqBody();
		DeliverTmReqDeliver deliverTmRequest = new DeliverTmReqDeliver();
		String consigneTime = request.getConsigned_time();
		consigneTime = consigneTime.length() > 20 ? consigneTime.substring(0,16)+":00" : consigneTime;
		deliverTmRequest.setConsigned_time(consigneTime);
		deliverTmRequest.setWeight(request.getWeight());
		
		Address srcAddress = new Address();
		srcAddress.setAddress(request.getSrc_address());
		srcAddress.setProvince(request.getSrc_province());
		srcAddress.setCity(request.getSrc_city());
		srcAddress.setDistrict(request.getSrc_district());
		deliverTmRequest.setSrcAddress(srcAddress);
		
		Address destAddress = new Address();
		destAddress.setAddress(request.getDest_address());
		destAddress.setProvince(request.getDest_province());
		destAddress.setCity(request.getDest_city());
		destAddress.setDistrict(request.getDest_district());
		deliverTmRequest.setDestAddress(destAddress);
		
		body.setDeliverTmRequest(deliverTmRequest);
		req.setBody(body);
		DeliverTmResp resp = null;
				
		try {
			resp = sfExpressApiService.deliverTmService(req);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		
		RespErr err = resp.getError();
		if(err != null && err.getCode()!=""){
			throw new WechatException(err.getCode(), "该地区请电话联系客服下单");
		}
		return resp;
	}

	private void contactRequestAreaInfo(DeliverRequest request) {
		if(request.getSrc_area_id() > 0){
			BaseSfArea area = baseSfAreaService.findById(request.getSrc_area_id());
			request.setSrc_code(area.getCode());
			String[] citys = area.getTreePath().split(",");
			String[] cityIds = area.getTreeId().split(",");
			if(citys.length == 3){
				request.setSrc_province(citys[0]);
				request.setSrc_city(getCityName(cityIds[1]));
				request.setSrc_district(citys[2]);
			}else if(citys.length == 2){
				request.setSrc_province(citys[0]);
				request.setSrc_city(getCityName(cityIds[1]));
			}
		}
		
		if(request.getDest_area_id() > 0){
			BaseSfArea area = baseSfAreaService.findById(request.getDest_area_id());
			request.setDest_code(area.getCode());
			String[] citys = area.getTreePath().split(",");
			String[] cityIds = area.getTreeId().split(",");
			if(citys.length == 3){
				request.setDest_province(citys[0]);
				request.setDest_city(getCityName(cityIds[1]));
				request.setDest_district(citys[2]);
			}else if(citys.length == 2){
				request.setDest_province(citys[0]);
				request.setDest_city(getCityName(cityIds[1]));
			}
		}
	}

	/**
	 *  获取城市名称
	  * @Title: getCityName
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @param orgName
	  * @param areaId
	  * @return
	 */
	private String getCityName(String areaId){
		BaseSfArea area  = baseSfAreaService.findById(Integer.parseInt(areaId));
		return area.getFullName();
	}
	
	
	/**
	  * 顺丰次晨价格+30元尾数靠9，顺丰次日价格+20元尾数靠9，顺丰隔日价格+20元尾数靠9
	  * @Title: sfprice
	  * @Description: TODO
	  * @author: share 2016年8月23日
	  * @modify: share 2016年8月23日
	  * @param price
	  * @param type 1-次日达 2-隔日达 5-次午达
	  * @return
	 */
	private double sfprice(double price,String type){
		double addprice = 0;
		if("1".equalsIgnoreCase(type)){
			addprice = 20;
		}else if("2".equalsIgnoreCase(type)){
			addprice = 20;
		}else if("5".equalsIgnoreCase(type)){
			addprice = 30;
		}else{
			return price;
		}
			
		price = Arith.mul(Arith.add(price, addprice),100);
		String priceStr = String.valueOf((int)price);
		int num = Integer.parseInt(priceStr.substring(priceStr.length()-3, priceStr.length()));
		int fixvalue = 900 - num;
		price = price + fixvalue;
		return Arith.div(price,100,2);
		
	}

	/**
	 *  计算金额
	  * @Title: query_sf_expect_price
	  * @Description: TODO
	  * @author: share 2016年8月24日
	  * @modify: share 2016年8月24日
	  * @param request
	  * @return
	  * @see com.qbt.web.support.SfExpressSupport#query_sf_expect_price(com.qbt.web.pojo.sf.DeliverRequest)
	 */
	@Override
	public double query_sf_expect_price(DeliverRequest request) {
		String businessType = request.getBusiness_type();
		// 结果模型，1-官网，2-BPS
		int resultMode = 1;
		// 填充地区信息
		contactRequestAreaInfo(request);
		// 获取调整日期请求
		String consigneTime = request.getConsigned_time();
		consigneTime = consigneTime.length() > 20 ? consigneTime.substring(0,16)+":00" : consigneTime;
		Date consignedDate = DateUtil.str2Date(consigneTime, DateUtil.DATE_TIME_FORMAT_01);
		sfTimeContextSupport.setSfTimeState(sfTimeState);
		Date ajustDate = sfTimeContextSupport.ajustDate(consignedDate, null);
		if(ajustDate != null && ajustDate.compareTo(consignedDate) != 0){
			// 时效差
			ajustDate = fillDateTime(consignedDate, ajustDate);
			request.setConsigned_time(DateUtil.formatDateTime(ajustDate));
		}
		// 查询官网
		List<DeliverResp> deliverWebsiteList = sendSfWebSite(request);
		List<DeliverTmRespDeliver> deliverList = null;
		// 发送顺丰BPS
		if(deliverWebsiteList == null || deliverWebsiteList.isEmpty()){
			DeliverTmResp resp = sendSfBps(request);
			deliverList= resp.getBody().getDeliverTm();
			resultMode = 2;
		}
		
		if(resultMode == 2 && (deliverList == null || deliverList.isEmpty())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
		}
		
		// 计算保价金额
		double sfprice_value_1 = 0;
		double sfprice_value_2 = 0;
		double sfprice_value_5 = 0;
		BaseSfPrice sfprice = selectSfPrice(request);
		LogCvt.debug("下单计算运费："+JSonUtil.toJSonString(sfprice));
		if(sfprice == null){
			if(resultMode == 2){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
			}
		}else{
			// 1-次日达 2-隔日达 5-次午达
			sfprice_value_1 = sfprice.getCiriQbtPrice().doubleValue();
			sfprice_value_2 = sfprice.getGeriQbtPrice().doubleValue();
			sfprice_value_5 = sfprice.getCichenQbtPrice().doubleValue();
		}
		
		// 球场信息
		BaseCourse jCourse = request.getSrc_course_id() > 0 ? baseCourseService.findById(request.getSrc_course_id()) : null;
		BaseCourse dCourse = request.getDest_course_id() > 0 ? baseCourseService.findById(request.getDest_course_id()) : null;
		
		//地址信息
	    OutRangeAddress jAddress = outRangeAdressService.findByAreaId(request.getSrc_area_id(), request.getSrc_address());
	    OutRangeAddress dAddress = outRangeAdressService.findByAreaId(request.getDest_area_id(), request.getDest_address());
		
	    request.setConsigned_time(consigneTime);
		// 官网查询
		if(resultMode == 1){
			for(DeliverResp deliver : deliverWebsiteList){
				String type = deliver.getBusinessType();
				if(businessType.equals(type)){
					if("1".equals(businessType)){
						if(sfprice_value_1 <= 0){
							return calOutRangePrice(sfprice(deliver.getFreight(), type), jCourse, dCourse,jAddress,dAddress);
						}else{
							return calOutRangePrice(sfprice_value_1, jCourse, dCourse,jAddress,dAddress);
						}
					}else if("2".equals(businessType)){
						if(sfprice_value_2 <= 0){
							return calOutRangePrice(sfprice(deliver.getFreight(), type), jCourse, dCourse,jAddress,dAddress);
						}else{
							return calOutRangePrice(sfprice_value_2, jCourse, dCourse,jAddress,dAddress);
						}
					}else if("5".equals(businessType)){
						if(sfprice_value_5 <= 0){
							return calOutRangePrice(sfprice(deliver.getFreight(), type), jCourse, dCourse,jAddress,dAddress);
						}else{
							return calOutRangePrice(sfprice_value_5, jCourse, dCourse,jAddress,dAddress);
						}
					}
				}
			}
		// BPS查询结果
		}else if(resultMode == 2){
			for(DeliverTmRespDeliver deliver : deliverList){
				if(businessType.equals(deliver.getBusiness_type())){
					if("1".equals(businessType)){
						if(sfprice_value_1 < 0){
							continue;
						}
						return calOutRangePrice(sfprice_value_1, jCourse, dCourse,jAddress,dAddress);
					}else if("2".equals(businessType)){
						if(sfprice_value_2 < 0){
							continue;
						}
						return calOutRangePrice(sfprice_value_2, jCourse, dCourse,jAddress,dAddress);
					}else if("5".equals(businessType)){
						if(sfprice_value_5 < 0){
							continue;
						}
						return calOutRangePrice(sfprice_value_5, jCourse, dCourse,jAddress,dAddress);
					}
				}
			}
		}
		return 0;
	}
	
	/**
	 * 计算偏远球场时效
	 * @param time
	 * @param jCourse
	 * @param dCourse
	 * @return
	 */
	private String calOutRangeTime(String time, BaseCourse jCourse, BaseCourse dCourse,OutRangeAddress jAdress,OutRangeAddress dAdress){
		/**
		 * 预计到达时间计算：每次增加按0.5天描述。（注：第二天指的是以顺丰预计到达时间为当天为基准的第二天）
		 * a)增加0.5天的情况：
		 * i.如果顺丰预计到达时间为当天早上6点到中午12点区间的，则最终预计到达时间为当天18点。
		 * ii.如果顺丰预计到达时间为当天中午12点到下午14点区间的，则最终预计到达时间为当天20点。
		 * iii.如果顺丰预计到达时间为当天下午14点到第二天早上6点区间的，则最终预计到达时间为第二天的中午12点。
		 * b)增加1天的情况：
		 * i.增加24小时，比如顺丰预计到达时间为中午12点，最终预计到达时间为第二天中午12点；顺丰预计到达时间为晚上18点，则最终预计到达时间为第二天晚上18点。
		 * c)增加超过1天的情况
		 * i.如为整天（如1天，2天，3天。。。n天），则在顺丰预计到达时间基础上增加24*n天，算出最终预计到达时间。
		 * ii.如为非整天的情况（如1.5天，2.5天，3.5天。。。n.5天），则先按照整天（n天）计算24*n天增加时效，在这个基础上，按照增加0.5天的情况规则增加时效，算出最终预计到达时间。
		 */
		if(Checker.isEmpty(time)){
			return "";
		}
		Date calTime = DateUtil.str2Date(time, DateUtil.DATE_TIME_FORMAT_01);
		//取件
		if(Checker.isNotEmpty(jCourse) && jCourse.getIsOutRange()){
			int jDay = (int)Math.floor(jCourse.getOutRangeTime());
			// 整数天
			calTime = DateUtils.addDays(calTime, jDay);
			// 0.5天
			calTime = calHalfDay(calTime, jCourse.getOutRangeTime(), jDay);
		}else if(Checker.isNotEmpty(jAdress)){
			int jDay = (int)Math.floor(jAdress.getOutRangeTime());
			// 整数天
			calTime = DateUtils.addDays(calTime, jDay);
			// 0.5天
			calTime = calHalfDay(calTime, jAdress.getOutRangeTime(), jDay);
		}
		//收件
		if(Checker.isNotEmpty(dCourse) && dCourse.getIsOutRange()){
			int dDay = (int)Math.floor(dCourse.getOutRangeTime());
			// 整数天
			calTime = DateUtils.addDays(calTime, dDay);
			// 0.5天
			calTime = calHalfDay(calTime, dCourse.getOutRangeTime(), dDay);
		}else if(Checker.isNotEmpty(dAdress)){
			int jDay = (int)Math.floor(dAdress.getOutRangeTime());
			// 整数天
			calTime = DateUtils.addDays(calTime, jDay);
			// 0.5天
			calTime = calHalfDay(calTime, dAdress.getOutRangeTime(), jDay);
		}
		return DateUtil.formatDate(calTime, DateUtil.DATE_TIME_FORMAT_01);
	}
	
	/**
	 * 计算0.5天的预计到达时间
	 * @param time
	 * @param outRangeTime
	 * @param day
	 * @return
	 */
	private Date calHalfDay(Date time, double outRangeTime, int day){
		if(outRangeTime - day != 0){
			int hour = DateUtil.getHour(time);
			if(hour >= 6 && hour <= 12){
				time = DateUtils.setHours(time, 18);
				time = DateUtils.setMinutes(time, 0);
				time = DateUtils.setSeconds(time, 0);
			}else if(hour >= 12 && hour <= 14){
				time = DateUtils.setHours(time, 20);
				time = DateUtils.setMinutes(time, 0);
				time = DateUtils.setSeconds(time, 0);
			}else{
				time = DateUtils.addDays(time, 1);
				time = DateUtils.setHours(time, 12);
				time = DateUtils.setMinutes(time, 0);
				time = DateUtils.setSeconds(time, 0);
			}
		}
		return time;
	}
	
	/**
	 * 计算偏远球场价格
	 * @param price
	 * @param jCourse
	 * @param dCourse
	 * @return
	 */
	private double calOutRangePrice(double price, BaseCourse jCourse, BaseCourse dCourse,OutRangeAddress jAdress,OutRangeAddress dAdress){
		// 判断寄件地区是否偏远
		if(Checker.isNotEmpty(jCourse) && jCourse.getIsOutRange()){
			price += jCourse.getOutRangePrice();
		}else if(Checker.isNotEmpty(jAdress)){
			price += jAdress.getOutRangePrice();
		}
		// 判断收件地区是否偏远
		if(Checker.isNotEmpty(dCourse) && dCourse.getIsOutRange()){
			price += dCourse.getOutRangePrice();
		}else if(Checker.isNotEmpty(dAdress)){
			price += dAdress.getOutRangePrice();
		}
		return price;
	}
	
	/**
	 * 
	 * fillDateTime:(填充日期信息).
	 *
	 * @author huangyihao
	 * 2017年4月6日 下午4:50:38
	 * @param sourceDate
	 * @param targetDate
	 * @return
	 *
	 */
	private Date fillDateTime(Date sourceDate, Date targetDate){
		if(sourceDate != null && targetDate != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(targetDate);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			if(hour == 0 && minute == 0 && second == 0) {
				calendar.set(Calendar.HOUR_OF_DAY, DateUtil.getHour(sourceDate));
				calendar.set(Calendar.MINUTE, DateUtil.getMinute(sourceDate));
				calendar.set(Calendar.SECOND, DateUtil.getSecond(sourceDate));
			}
			return calendar.getTime();
		}
		return null;
	}

	@Override
	public List<DeliverV2Response> query_sf_expect_recive_time_v2(DeliverRequest request) {
		List<DeliverV2Response> responseList = new ArrayList<DeliverV2Response>();
		
		if((request.getSrc_province() == null && request.getSrc_city() == null && request.getSrc_district() == null) && request.getSrc_area_id() == 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "请求寄件地址信息不能为空");
		}
		
		if((request.getDest_province() == null && request.getDest_city() == null && request.getDest_district() == null) && request.getDest_area_id() ==0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "请求收件地址信息不能为空");
		}
		
		// 结果模型，1-官网，2-BPS
		int resultMode = 1;
		// 填充地区信息
		contactRequestAreaInfo(request);
		// 获取调整日期请求
		String consigneTime = request.getConsigned_time();
		consigneTime = consigneTime.length() > 20 ? consigneTime.substring(0,16)+":00" : consigneTime;
		Date consignedDate = DateUtil.str2Date(consigneTime, DateUtil.DATE_TIME_FORMAT_01);
		sfTimeContextSupport.setSfTimeState(sfTimeState);
		Date ajustDate = sfTimeContextSupport.ajustDate(consignedDate, null);
		int diffSecond = 0;
		if(ajustDate != null && ajustDate.compareTo(consignedDate) != 0){
			// 时效差
			//周五17点以后时效也按周六日时效一样处理
			ajustDate = fillDateTime(consignedDate, ajustDate);
			Date ajustNight = DateUtil.ajustNight(consignedDate);
			diffSecond = DateUtil.isNight(consignedDate) 
					? (isWeekend(ajustNight) ? (int)DateUtil.getDiffSecond(ajustDate, ajustNight) : diffSecond) 
					: (int)DateUtil.getDiffSecond(ajustDate, consignedDate);
			request.setConsigned_time(DateUtil.formatDateTime(ajustDate));
		}
		// 查询官网
		List<DeliverResp> deliverWebsiteList = sendSfWebSite(request);
		List<DeliverTmRespDeliver> deliverList = null;
		// 发送顺丰BPS
		if(deliverWebsiteList == null || deliverWebsiteList.isEmpty()){
			DeliverTmResp resp = sendSfBps(request);
			deliverList= resp.getBody().getDeliverTm();
			resultMode = 2;
		}
		
		if(resultMode == 2 && (deliverList == null || deliverList.isEmpty())){
			String desc = JSonUtil.toJSonString(request)+">官网无查询可选择记录，BPS接口查询无可选择记录【BPS接口】";
			recordLogs(desc);
			LogCvt.error(desc);
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
		}
		
		// 计算保价金额
		double sfprice_value_1 = 0;
		double yhprice_value_1 = 0;
		double sfprice_value_2 = 0;
		double yhprice_value_2 = 0;
		double sfprice_value_5 = 0;
		double yhprice_value_5 = 0;
		BaseNewSfPrice sfprice = baseNewSfPriceService.findByArea(request.getSrc_province(), request.getDest_province());
		if(sfprice == null){
			if(resultMode == 2){
				String desc = JSonUtil.toJSonString(request)+">官网查询无可选择记录，BPS接口可查询有可选记录，但配置项无价格配置【BPS接口】";
				recordLogs(desc);
				LogCvt.error(desc);
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
			}
		}else{
			// 1-次日达 2-隔日达 5-次午达
			sfprice_value_1 = sfprice.getCiriQbtPrice();
			yhprice_value_1 = sfprice.getCiriFavourablePrice();
			sfprice_value_2 = sfprice.getGeriQbtPrice();
			yhprice_value_2 = sfprice.getGeriFavourablePrice();
			sfprice_value_5 = sfprice.getCichenQbtPrice();
			yhprice_value_5 = sfprice.getCichenFavourablePrice();
		}
		
		// 球场信息
		BaseCourse jCourse = request.getSrc_course_id() > 0 ? baseCourseService.findById(request.getSrc_course_id()) : null;
		BaseCourse dCourse = request.getDest_course_id() > 0 ? baseCourseService.findById(request.getDest_course_id()) : null;
		//地址信息
	    OutRangeAddress jAddress = outRangeAdressService.findByAreaId(request.getSrc_area_id(), request.getSrc_address());
	    OutRangeAddress dAddress = outRangeAdressService.findByAreaId(request.getDest_area_id(), request.getDest_address());
	    request.setConsigned_time(consigneTime);
		// 官网查询
		if(resultMode == 1){
			for(DeliverResp deliver : deliverWebsiteList){
				// 对比时效差计算正常时效
				deliver.setDeliverTime(DateUtil.calDateOfSecond(deliver.getDeliverTime(), diffSecond, DateUtil.DATE_TIME_FORMAT_04));
				deliver.setAddTime(DateUtil.calDateOfSecond(deliver.getAddTime(), diffSecond, DateUtil.DATE_TIME_FORMAT_04));
				
				DeliverV2Response response = new DeliverV2Response();
				response.setBusiness_type(deliver.getBusinessType());
				response.setBusiness_type_desc(deliver.getLimitTypeName());
				//偏远球场增加时效
				String deliverTime = calOutRangeTime(deliver.getDeliverTime()+":00", jCourse, dCourse,jAddress,dAddress);
				String addTime = calOutRangeTime(deliver.getAddTime()+":00", jCourse, dCourse,jAddress,dAddress);
				response.setDeliver_time(deliverTime+","+addTime);
				String type = deliver.getBusinessType();
				if("1".equals(type)){
					if(sfprice_value_1 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getLimitTypeName()+">DB无价格配置，过滤次数据【顺丰官网时效接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					response.setSf_price(calOutRangePrice(yhprice_value_1, jCourse, dCourse,jAddress,dAddress));
					response.setOrigin_price(calOutRangePrice(sfprice_value_1, jCourse, dCourse,jAddress,dAddress));
				}else if("2".equals(type)){
					if(sfprice_value_2 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getLimitTypeName()+">DB无价格配置，过滤次数据【顺丰官网时效接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					response.setSf_price(calOutRangePrice(yhprice_value_2, jCourse, dCourse,jAddress,dAddress));
					response.setOrigin_price(calOutRangePrice(sfprice_value_2, jCourse, dCourse,jAddress,dAddress));
				}else if("5".equals(type)){
					if(sfprice_value_5 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getLimitTypeName()+">DB无价格配置，过滤次数据【顺丰官网时效接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					response.setSf_price(calOutRangePrice(yhprice_value_5, jCourse, dCourse,jAddress,dAddress));
					response.setOrigin_price(calOutRangePrice(sfprice_value_5, jCourse, dCourse,jAddress,dAddress));
				}else{
					continue;
				}
				response.setOut_range_price(calOutRangePrice(0, jCourse, dCourse,jAddress,dAddress));
				responseList.add(response);
			}
		// BPS查询结果
		}else if(resultMode == 2){
			for(DeliverTmRespDeliver deliver : deliverList){
				
				DeliverV2Response response = new DeliverV2Response();
				response.setBusiness_type(deliver.getBusiness_type());
				response.setBusiness_type_desc(deliver.getBusiness_type_desc());
				
				String[] deliverTimes = deliver.getDeliver_time().split(",");
				// 对比时效差计算正常时效
				String ajustStartTime = DateUtil.calDateOfSecond(deliverTimes[0], diffSecond, DateUtil.DATE_TIME_FORMAT_01);
				String ajustEndTime = DateUtil.calDateOfSecond(deliverTimes[1], diffSecond, DateUtil.DATE_TIME_FORMAT_01);
				
				//偏远球场增加时效
				String startTime = calOutRangeTime(ajustStartTime, jCourse, dCourse,jAddress,dAddress);
				String endTime = calOutRangeTime(ajustEndTime, jCourse, dCourse,jAddress,dAddress);
				response.setDeliver_time(startTime+","+endTime);
				if("1".equals(deliver.getBusiness_type())){
					if(sfprice_value_1 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getBusiness_type_desc()+">DB无价格配置，过滤次数据【BPS接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					response.setSf_price(calOutRangePrice(yhprice_value_1, jCourse, dCourse,jAddress,dAddress));
					response.setOrigin_price(calOutRangePrice(sfprice_value_1, jCourse, dCourse,jAddress,dAddress));
				}else if("2".equals(deliver.getBusiness_type())){
					if(sfprice_value_2 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getBusiness_type_desc()+">DB无价格配置，过滤次数据【BPS接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					response.setSf_price(calOutRangePrice(yhprice_value_2, jCourse, dCourse,jAddress,dAddress));
					response.setOrigin_price(calOutRangePrice(sfprice_value_2, jCourse, dCourse,jAddress,dAddress));
				}else if("5".equals(deliver.getBusiness_type())){
					if(sfprice_value_5 <= 0){
						String desc = JSonUtil.toJSonString(request)+">"+deliver.getBusiness_type_desc()+">DB无价格配置，过滤次数据【BPS接口】";
						recordLogs(desc);
						LogCvt.error(desc);
						continue;
					}
					response.setSf_price(calOutRangePrice(yhprice_value_5, jCourse, dCourse,jAddress,dAddress));
					response.setOrigin_price(calOutRangePrice(sfprice_value_5, jCourse, dCourse,jAddress,dAddress));
				}else{
					continue;
				}
				response.setOut_range_price(calOutRangePrice(0, jCourse, dCourse,jAddress,dAddress));
				responseList.add(response);
			}
		}
		
		if(responseList.isEmpty()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
		}
		return responseList;
	}
	
	/**
	 * 根据加急逻辑增加加急时间
	 * @param request
	 * @param times
	 */
	private void addUrgentDateTime(DeliverRequest request, List<DeliverV2Response> times) {
		Area fromArea = areaSupport.findById(Integer.valueOf(request.getSrc_area_id()));
		Area toArea = areaSupport.findById(Integer.valueOf(request.getDest_area_id()));
		
		UrgentPageReqVo reqCityVo = new UrgentPageReqVo();
		reqCityVo.setFromCity(fromArea.getSuperId()+"");
		reqCityVo.setToCity(toArea.getSuperId()+"");		
		
		List<UrgentVo> urgentVos = urgentSupport.findByPage(reqCityVo);
		if(urgentVos != null && urgentVos.size()>0) {
			UrgentVo urgentVo = urgentVos.get(0);
			
			// 获取快件的价格
			DeliverV2Response deliverTime = null;
			if (times != null) {
				for(DeliverV2Response response: times) {
					if(response.getBusiness_type().equals("1")) {
						deliverTime = response;
					}
				}
			}
			
			if(deliverTime != null) {
				DeliverV2Response urgentTime = new DeliverV2Response();
				urgentTime.setBusiness_type("3");
				urgentTime.setBusiness_type_desc("顺丰重货");
				urgentTime.setOrigin_price(deliverTime.getOrigin_price() + urgentVo.getPrice());
				urgentTime.setOut_range_price(deliverTime.getOut_range_price());
				urgentTime.setSf_price(deliverTime.getSf_price() + urgentVo.getPrice());
				
				String consigneTime = request.getConsigned_time();
				consigneTime = consigneTime.length() > 20 ? consigneTime.substring(0,16)+":00" : consigneTime;
				Date consignedDate = DateUtil.str2Date(consigneTime, DateUtil.DATE_TIME_FORMAT_01);
				
				// 判断取件时间是否是17点以后
				if(DateUtil.isNight(consignedDate)) {
					// 调整为第二天的9点
					consignedDate = DateUtil.ajustNight(consignedDate);
				}

				// 快件送达时间是取件时间的24小时以后
				consignedDate = DateUtils.addDays(consignedDate, 1);
				String consignedDateStr = DateUtil.formatDateTime(consignedDate);
				String urgentDeliverTime = consignedDateStr +","+ consignedDateStr;
				urgentTime.setDeliver_time(urgentDeliverTime);
				
				// 如果快件的到达时间早于加急的到达时间，就不需要加急的数据了
				if(deliverTime.getDeliver_time().indexOf(",")>0) {
					Date deliverDate = DateUtil.str2Date(deliverTime.getDeliver_time().split(",")[1],
							DateUtil.DATE_TIME_FORMAT_01);
					
					if(!deliverDate.before(consignedDate)) {
						times.add(0, urgentTime);	
					}
				}else {
					times.add(0, urgentTime);
				}
			}
			
		}
	}

	@Override
	public double query_sf_expect_price_v2(DeliverRequest request) {
		String businessType = request.getBusiness_type();
		// 加急的话就是快件
		if("3".equals(businessType)) {
			businessType = "1";
		}
		// 结果模型，1-官网，2-BPS
		int resultMode = 1;
		// 填充地区信息
		contactRequestAreaInfo(request);
		// 获取调整日期请求
		String consigneTime = request.getConsigned_time();
		consigneTime = consigneTime.length() > 20 ? consigneTime.substring(0,16)+":00" : consigneTime;
		Date consignedDate = DateUtil.str2Date(consigneTime, DateUtil.DATE_TIME_FORMAT_01);
		sfTimeContextSupport.setSfTimeState(sfTimeState);
		Date ajustDate = sfTimeContextSupport.ajustDate(consignedDate, null);
		if(ajustDate != null && ajustDate.compareTo(consignedDate) != 0){
			// 时效差
			ajustDate = fillDateTime(consignedDate, ajustDate);
			request.setConsigned_time(DateUtil.formatDateTime(ajustDate));
		}
		// 查询官网
		List<DeliverResp> deliverWebsiteList = sendSfWebSite(request);
		List<DeliverTmRespDeliver> deliverList = null;
		// 发送顺丰BPS
		if(deliverWebsiteList == null || deliverWebsiteList.isEmpty()){
			DeliverTmResp resp = sendSfBps(request);
			deliverList= resp.getBody().getDeliverTm();
			resultMode = 2;
		}
		
		if(resultMode == 2 && (deliverList == null || deliverList.isEmpty())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
		}
		
		// 计算保价金额
		double sfprice_value_1 = 0;
		double yhprice_value_1 = 0;
		double sfprice_value_2 = 0;
		double yhprice_value_2 = 0;
		double sfprice_value_5 = 0;
		double yhprice_value_5 = 0;
		BaseNewSfPrice sfprice = baseNewSfPriceService.findByArea(request.getSrc_province(), request.getDest_province());
		LogCvt.debug("下单计算运费："+JSonUtil.toJSonString(sfprice));
		if(sfprice == null){
			if(resultMode == 2){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地区请电话联系客服下单");
			}
		}else{
			// 1-次日达 2-隔日达 5-次午达
			sfprice_value_1 = sfprice.getCiriQbtPrice();
			yhprice_value_1 = sfprice.getCiriFavourablePrice();
			sfprice_value_2 = sfprice.getGeriQbtPrice();
			yhprice_value_2 = sfprice.getGeriFavourablePrice();
			sfprice_value_5 = sfprice.getCichenQbtPrice();
			yhprice_value_5 = sfprice.getCichenFavourablePrice();
		}
		
		// 球场信息
		BaseCourse jCourse = request.getSrc_course_id() > 0 ? baseCourseService.findById(request.getSrc_course_id()) : null;
		BaseCourse dCourse = request.getDest_course_id() > 0 ? baseCourseService.findById(request.getDest_course_id()) : null;
		//地址信息
	    OutRangeAddress jAddress = outRangeAdressService.findByAreaId(request.getSrc_area_id(), request.getSrc_address());
	    OutRangeAddress dAddress = outRangeAdressService.findByAreaId(request.getDest_area_id(), request.getDest_address());
	    request.setConsigned_time(consigneTime);
		// 官网查询
		if(resultMode == 1){
			for(DeliverResp deliver : deliverWebsiteList){
				String type = deliver.getBusinessType();
				
				if(businessType.equals(type)){
					if("1".equals(businessType)){
						if(sfprice_value_1 <= 0){
							continue;
						}
						return calOutRangePrice(yhprice_value_1, jCourse, dCourse,jAddress,dAddress);
					}else if("2".equals(businessType)){
						if(sfprice_value_2 <= 0){
							continue;
						}
						return calOutRangePrice(yhprice_value_2, jCourse, dCourse,jAddress,dAddress);
					}else if("5".equals(businessType)){
						if(sfprice_value_5 <= 0){
							continue;
						}
						return calOutRangePrice(yhprice_value_5, jCourse, dCourse,jAddress,dAddress);
					}
				}
			}
		// BPS查询结果
		}else if(resultMode == 2){
			for(DeliverTmRespDeliver deliver : deliverList){
				if(businessType.equals(deliver.getBusiness_type())){
					if("1".equals(businessType)){
						if(sfprice_value_1 <= 0){
							continue;
						}
						return calOutRangePrice(yhprice_value_1, jCourse, dCourse,jAddress,dAddress);
					}else if("2".equals(businessType)){
						if(sfprice_value_2 <= 0){
							continue;
						}
						return calOutRangePrice(yhprice_value_2, jCourse, dCourse,jAddress,dAddress);
					}else if("5".equals(businessType)){
						if(sfprice_value_5 <= 0){
							continue;
						}
						return calOutRangePrice(yhprice_value_5, jCourse, dCourse,jAddress,dAddress);
					}
				}
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * isWeekend:(判断日期是否是周末(周六,周日)).
	 *
	 * @author huangyihao
	 * 2017年8月18日 下午5:02:46
	 * @param date
	 * @return
	 *
	 */
	private boolean isWeekend(Date date) {
		int week = DateUtil.getWeek(date);
		return week == Calendar.SATURDAY
				|| week == Calendar.SUNDAY;
	}
	
}
