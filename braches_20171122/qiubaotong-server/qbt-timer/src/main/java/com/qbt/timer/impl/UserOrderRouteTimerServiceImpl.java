
 /**
  * 微信用户详情查询增加路线
 * @Title: WechatUserRouteTimeServiceImpl.java
 * @Package com.qbt.timer.impl
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月10日
 * @version V1.0
 **/

package com.qbt.timer.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Md5;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.OrderAddressRoute;
import com.qbt.persistent.entity.OrderAddressType;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.UserOrderAddress;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.OrderAddressRouteService;
import com.qbt.service.OrderAddressTypeService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.UserOrderAddressService;
import com.qbt.timer.TimerService;

/**
  * @ClassName: WechatUserRouteTimeServiceImpl
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */
@Service("userOrderRouteTimerService")
public class UserOrderRouteTimerServiceImpl extends TimerService {

	@Resource
	private OrderAddressTypeService orderAddressTypeService;
	@Resource
	private OrderAddressRouteService orderAddressRouteService;
	@Resource
	private UserOrderAddressService userOrderAddressService;
	@Resource
	private OrderInfoService orderInfoService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		
		LogCvt.info("用户地址统计开始===========");
		
		//循环获取前一天的时间，批处理可以补跑
		//String date = DateUtil.dateStrCalculate(DateUtil.getCurrentDate(), -1);
		String date = DateUtil.dateStrCalculate(DateUtil.getCurrentDate(), -1);
		//获取用户下单地址表最后的统计的时间
		String  addressDate =  orderAddressTypeService.findMaxDate();
		//获取用户下单路线最后的时间
		String routeDate =  orderAddressRouteService.findMaxDate();
		
		String orderDate = null ;
		String countDate = null;
		//时间比较
		if(Checker.isEmpty(addressDate) || Checker.isEmpty(routeDate)){
			//获取最早的订单时间
			orderDate = orderInfoService.findOrderMinDate();
			countDate = orderDate;
		}
		
		if(!Checker.isEmpty(addressDate) && DateUtil.compareDate(date,addressDate,DateUtil.DATE_FORMAT_01)){
			
			if(countDate==null || DateUtil.compareDate(countDate,addressDate,DateUtil.DATE_FORMAT_01)){
				countDate = DateUtil.dateStrCalculate(addressDate, 1);
			}
				
		}
		if(!Checker.isEmpty(routeDate) && DateUtil.compareDate(date,routeDate,DateUtil.DATE_FORMAT_01)){
			
			if(countDate==null || DateUtil.compareDate(countDate,routeDate,DateUtil.DATE_FORMAT_01)){
				countDate = DateUtil.dateStrCalculate(routeDate, 1);
			}
			
		}
		/*if(!Checker.isEmpty(contactDate) && DateUtil.compareDate(date,contactDate,DateUtil.DATE_FORMAT_01)){
			
			if(countDate==null || DateUtil.compareDate(countDate,contactDate,DateUtil.DATE_FORMAT_01)){
				countDate = DateUtil.dateStrCalculate(contactDate, 1);
			}
				
		}*/
		
		
		if(countDate==null){
			LogCvt.info("用户地址统计结束===========");
			return;
		}
		LogCvt.info("统计时间："+countDate+" -- "+date);
		//按照最早的开始循环时间
		do{
			
			//获取数据
			List<OrderInfo> orderInfoList = orderInfoService.findByCountDate(countDate);

			LogCvt.info("统计时间："+countDate+" -- 统计条数: "+(orderInfoList==null?0:orderInfoList.size()));
			
			if(orderInfoList!=null && orderInfoList.size()>0){
				//入库
				BaseSfArea zg = baseSfAreaService.findByName("中国",null);
				for(OrderInfo info : orderInfoList){
					
					BaseSfArea j_area = baseSfAreaService.findById(info.getjAreaId());
					if(j_area==null){
						continue;
					}
					BaseSfArea d_area = baseSfAreaService.findById(info.getdAreaId());
					if(d_area==null){
						continue;
					}
					
					String[] j_area_all = j_area.getTreeId().split(",");
					String[] j_area_name_all = j_area.getTreePath().split(",");
					String[] d_area_all = d_area.getTreeId().split(",");
					String[] d_area_name_all = d_area.getTreePath().split(",");
					
					int user_id = info.getUserId();
					
					int country_area_id = zg.getId();
					String country_area_name = zg.getName();
					//寄
					int j_addr_type = info.getjAddrType();
					int j_province_area_id = Integer.parseInt(j_area_all[0]);
					String j_province_area_name = j_area_name_all[0];
					int  j_city_area_id = Integer.parseInt(j_area_all[1]);
					String j_city_area_name = j_area_name_all[1];
					int j_district_area_id = Integer.parseInt(j_area_all[2]);
					String j_district_area_name = j_area_name_all[2];
					String j_tree_path = info.getjTreePath();
					int j_addr_id = info.getjAddrId();
					String j_addr_name = info.getjAddrName();
					String j_address = info.getjAddress();
					String j_contact = info.getjContact();
					String j_mobile = info.getjMobile();
					
					String j_uuid =Md5.MD5Encode(""+user_id+j_addr_type
							+j_district_area_id+j_addr_id
							+j_address+j_contact+j_mobile);
					//md5(user_id+addr_type+district_area_id+addr_id+address+contact+mobile)		
					//收
					int d_addr_type = info.getdAddrType();
					int d_province_area_id = Integer.parseInt(d_area_all[0]);
					String d_province_area_name = d_area_name_all[0];
					int d_city_area_id = Integer.parseInt(d_area_all[1]);
					String d_city_area_name = d_area_name_all[1];
					int d_district_area_id = Integer.parseInt(d_area_all[2]);
					String d_district_area_name = d_area_name_all[2];
					String d_tree_path = info.getdTreePath();
					int d_addr_id = info.getdAddrId();
					String d_addr_name = info.getdAddrName();
					String d_address = info.getdAddress();
					String d_contact = info.getdContact();
					String d_mobile = info.getdMobile();
					String d_uuid = Md5.MD5Encode(""+user_id+d_addr_type
							+d_district_area_id+d_addr_id
							+d_address+d_contact+d_mobile);

					UserOrderAddress j_uoa = userOrderAddressService.findByUuid(j_uuid);
					if( j_uoa == null ){
						j_uoa = new UserOrderAddress();
						
						j_uoa.setUserId(user_id);
						j_uoa.setAddrType(j_addr_type);
						j_uoa.setCountryAreaId(country_area_id);
						j_uoa.setCountryAreaName(country_area_name);
						j_uoa.setProvinceAreaId(j_province_area_id);
						j_uoa.setProvinceAreaName(j_province_area_name);
						j_uoa.setCityAreaId(j_city_area_id);
						j_uoa.setCityAreaName(j_city_area_name);
						j_uoa.setDistrictAreaId(j_district_area_id);
						j_uoa.setDistrictAreaName(j_district_area_name);
						j_uoa.setTreePath(j_tree_path);
						j_uoa.setAddrId(j_addr_id);
						j_uoa.setAddrName(j_addr_name);
						j_uoa.setAddress(j_address);
						j_uoa.setContact(j_contact);
						j_uoa.setMobile(j_mobile);
						j_uoa.setUuid(j_uuid);
						
						userOrderAddressService.insert(j_uoa);
					}
					UserOrderAddress d_uoa = userOrderAddressService.findByUuid(d_uuid);
					if( d_uoa == null ){
						
						d_uoa = new UserOrderAddress();
						
						d_uoa.setUserId(user_id);
						d_uoa.setAddrType(d_addr_type);
						d_uoa.setCountryAreaId(country_area_id);
						d_uoa.setCountryAreaName(country_area_name);
						d_uoa.setProvinceAreaId(d_province_area_id);
						d_uoa.setProvinceAreaName(d_province_area_name);
						d_uoa.setCityAreaId(d_city_area_id);
						d_uoa.setCityAreaName(d_city_area_name);
						d_uoa.setDistrictAreaId(d_district_area_id);
						d_uoa.setDistrictAreaName(d_district_area_name);
						d_uoa.setTreePath(d_tree_path);
						d_uoa.setAddrId(d_addr_id);
						d_uoa.setAddrName(d_addr_name);
						d_uoa.setAddress(d_address);
						d_uoa.setContact(d_contact);
						d_uoa.setMobile(d_mobile);
						d_uoa.setUuid(d_uuid);
						
						userOrderAddressService.insert(d_uoa);
					}
					
					/*//订单表  跑P user_order_contact
					String juuid = Md5.MD5Encode(""+info.getUserId()+info.getjContact()+info.getjMobile());
					//寄
					UserOrderContact j_uoc = userOrderContactService.findByUuid(juuid);
					if(j_uoc == null){
						j_uoc = new UserOrderContact();
						j_uoc.setUserId(user_id);
						j_uoc.setContact(j_contact);
						j_uoc.setMobile(j_mobile);
						j_uoc.setUuid(juuid);//
						userOrderContactService.insert(j_uoc);
					}
					
					String duuid = Md5.MD5Encode(""+info.getUserId()+info.getdContact()+info.getdMobile());
					//收
					UserOrderContact d_uoc = userOrderContactService.findByUuid(duuid);
					if(d_uoc == null){
						d_uoc = new UserOrderContact();
						d_uoc.setUserId(user_id);
						d_uoc.setContact(d_contact);
						d_uoc.setMobile(d_mobile);
						d_uoc.setUuid(duuid);//
						userOrderContactService.insert(d_uoc);
					}*/
					
					if(Checker.isEmpty(addressDate) || DateUtil.compareDate(countDate,addressDate,DateUtil.DATE_FORMAT_01)){
						
						//寄
						OrderAddressType oat = new OrderAddressType();
						oat.setCreateTime(new Date());
						oat.setOrderId(info.getId());
						oat.setOrderTime(info.getPayTime());
						oat.setUserOrderAddressId(j_uoa.getId());
						oat.setUserOrderAddressUuid(j_uuid);
						oat.setType(1);
						
						orderAddressTypeService.insert(oat);
						
						//收
						oat = new OrderAddressType();
						oat.setCreateTime(new Date());
						oat.setOrderId(info.getId());
						oat.setOrderTime(info.getPayTime());
						oat.setUserOrderAddressId(d_uoa.getId());
						oat.setUserOrderAddressUuid(d_uuid);
						oat.setType(2);
						
						orderAddressTypeService.insert(oat);
						
					}
					if(Checker.isEmpty(routeDate) || DateUtil.compareDate(countDate,routeDate,DateUtil.DATE_FORMAT_01)){
						
						OrderAddressRoute oar = new OrderAddressRoute();
						
						oar.setCreateTime(new Date());
						oar.setOrderId(info.getId());
						oar.setOrderTime(info.getPayTime());
						oar.setjUserOrderAddressId(j_uoa.getId());
						oar.setjUserOrderAddressUuid(j_uoa.getUuid());
						oar.setdUserOrderAddressId(d_uoa.getId());
						oar.setdUserOrderAddressUuid(d_uoa.getUuid());
						
						orderAddressRouteService.insert(oar);
					}
				
				}
			}
			countDate = DateUtil.dateStrCalculate(countDate,1);
			
		}while(!DateUtil.compareDate(countDate,date,DateUtil.DATE_FORMAT_01));
		
		
		LogCvt.info("用户地址统计结束===========");
		
	}

}
