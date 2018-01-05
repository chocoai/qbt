package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.dto.SaleQrcodeCreateInfoDto;
import com.qbt.persistent.entity.SaleQrcodeCreateInfo;
import com.qbt.persistent.entity.SaleQrcodeInfo;
import com.qbt.redis.RedisService;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.CommonService;
import com.qbt.service.SaleQrcodeCreateInfoService;
import com.qbt.service.SaleQrcodeInfoService;
import com.qbt.web.pojo.saleQrcodeCreateInfo.SaleQrcodeCreateInfoPageReqVo;
import com.qbt.web.pojo.saleQrcodeCreateInfo.SaleQrcodeCreateInfoVo;
import com.qbt.web.support.SaleQrcodeCreateInfoSupport;
import com.qbt.wechat.api.WechatApi;

@Service
public class SaleQrcodeCreateInfoSupportImpl implements SaleQrcodeCreateInfoSupport{

	@Resource
	private SaleQrcodeCreateInfoService saleQrcodeCreateInfoService;
	
	@Resource
	private RedisService redisService;
	
	@Resource
	private SaleQrcodeInfoService saleQrcodeInfoService;
	
	@Resource
	private WechatCommonSupport commonSupport;
	
	@Resource
	private CommonService commonService;
	
	@Resource
	private WechatApi wechatApi;
	
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Value("${qrcode_image_url}")
	private String qrcode_image_url;
	
	@Override
	public void add(SaleQrcodeCreateInfoVo vo) throws BusinessException{
		SaleQrcodeCreateInfo condition = new SaleQrcodeCreateInfo();
		if(Checker.isNotEmpty(vo.getName())){
			condition.setName(vo.getName());
			List<SaleQrcodeCreateInfo> qryList = saleQrcodeCreateInfoService.findByCondition(condition);
			if(Checker.isNotEmpty(qryList)){
				throw new BusinessException("生成批次名称已被使用");
			}
		}
		if(vo.getCreateType() == 2){
			Integer autoMaxNameNumber =  saleQrcodeCreateInfoService.getAutoMaxNawmeNumber();
			vo.setName("系统生成" + (++autoMaxNameNumber));
			vo.setNumber(300);
			vo.setCompany("");
			vo.setType(1);
			vo.setTypeValue(0.0);
			vo.setSubscribeValue(0.0);
			vo.setFirstType(1);
			vo.setFirstTypeValue(0.0);
			vo.setOrderDayType(1);
			vo.setOrderDayValue(0);
		}
		
		SaleQrcodeCreateInfo saleQrcodeCreateInfo = BeanUtil.a2b(vo, SaleQrcodeCreateInfo.class);
		saleQrcodeCreateInfo.setApplyNumber(0);
		saleQrcodeCreateInfoService.insert(saleQrcodeCreateInfo);
		List<SaleQrcodeInfo> saleQrcodeInfoList = new ArrayList<SaleQrcodeInfo>();
		String saleQrcodeCreateMaxInfo = RedisKeyUtil.sale_qrcode_create_max_info_key();
		String salesmanCodeMaxNum = redisService.get(saleQrcodeCreateMaxInfo);
		if(Checker.isEmpty(salesmanCodeMaxNum)) salesmanCodeMaxNum = "0";
		Integer salesmanCodeMaxNumInt =  Integer.valueOf(salesmanCodeMaxNum).intValue();
		String[] requestUrls = new String[vo.getNumber()];
		String sceneStr = null;
		String salesmanCodeStr = null;
		
		for(int i=0;i<vo.getNumber();i++){
			SaleQrcodeInfo saleQrcodeInfo = new SaleQrcodeInfo();
			salesmanCodeMaxNumInt=salesmanCodeMaxNumInt+1;
			salesmanCodeStr = commonService.createQrcodeCapital(salesmanCodeMaxNumInt);
			saleQrcodeInfo.setSalesmanCode(salesmanCodeStr);
			saleQrcodeInfo.setApplyStatus(0);
			saleQrcodeInfo.setCompany(vo.getCompany());
			
	        String accessToken = commonSupport.getAccessToken();
	        sceneStr = salesmanCodeStr;
	        String ticket = wechatApi.getTicket(accessToken, sceneStr);
	        
			saleQrcodeInfo.setTicket(ticket);
			
			saleQrcodeInfo.setType(vo.getType());
			saleQrcodeInfo.setTypeValue(vo.getTypeValue());
			saleQrcodeInfo.setSubscribeValue(vo.getSubscribeValue());
			saleQrcodeInfo.setQrcodeCreateInfoId(saleQrcodeCreateInfo.getId());
			
			saleQrcodeInfo.setQrcodeCreateInfoName(vo.getName());
			saleQrcodeInfo.setFirstType(vo.getFirstType());
			saleQrcodeInfo.setFirstTypeValue(vo.getFirstTypeValue());
			saleQrcodeInfo.setOrderDayType(vo.getOrderDayType());
			saleQrcodeInfo.setOrderDayValue(vo.getOrderDayValue());
			
			saleQrcodeInfoList.add(saleQrcodeInfo);
			requestUrls[i] = qrcode_image_url+ticket;
		}
		
		List<String> salesmanCodeArray = new ArrayList<String>();
		for(SaleQrcodeInfo infos : saleQrcodeInfoList){
			salesmanCodeArray.add(infos.getSalesmanCode());
		}
		
		//系统生成时，把销售二维码号存进redis
		if(vo.getCreateType() == 2){
			redisService.putList(RedisKeyUtil.salesman_code_key(), salesmanCodeArray);
		}
		
		String[] remoteFiles = fileuploadScpService.httpImageDownToScp(requestUrls, "qrcode_"+saleQrcodeCreateInfo.getId(), salesmanCodeArray, true);
		int i = 0;
		for(SaleQrcodeInfo infos : saleQrcodeInfoList){
			infos.setQrcode(remoteFiles[i]);
			i++;
		}
		
		saleQrcodeInfoService.insertByBatch(saleQrcodeInfoList);
		//先拿redis里面有没有，再拿数据库的最大值
		redisService.del(saleQrcodeCreateMaxInfo);
		redisService.set(saleQrcodeCreateMaxInfo, String.valueOf(saleQrcodeInfoService.getMaxId()));
	}
	
	@Override
	public List<SaleQrcodeCreateInfoVo> findByPage(SaleQrcodeCreateInfoPageReqVo reqVo) {
		PageEntity<SaleQrcodeCreateInfoDto> pageEntity = BeanUtil.pageConvert(reqVo, SaleQrcodeCreateInfoDto.class);
		List<SaleQrcodeCreateInfo> list = saleQrcodeCreateInfoService.findByPage(pageEntity);
		List<SaleQrcodeCreateInfoVo> voList = BeanUtil.list2list(list, SaleQrcodeCreateInfoVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
