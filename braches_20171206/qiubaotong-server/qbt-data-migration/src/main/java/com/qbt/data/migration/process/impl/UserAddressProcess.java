package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.MD5Util;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.enums.TableTypes;
import com.qbt.data.migration.pgsql.entity.Address;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.data.migration.utils.DataCacheUtil;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.DataMigration;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.DataMigrationService;
import com.qbt.service.UserAddressService;

public class UserAddressProcess extends AbstractProcess {
	
	private Map<Integer, Integer> userMap = new HashMap<Integer, Integer>();
	
	public UserAddressProcess(String name, ProcessServiceConfig config) {
		super(name, config);
	}

	@Override
	public void before() {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		// 清除历史ID兑换数据
		dataMigrationService.delete(TableTypes.user_address.getType());
		//微信用户id map
		List<DataMigration> userList = dataMigrationService.findByType(TableTypes.User_Weixin.getType());
		if(Checker.isNotEmpty(userList)){
			for(DataMigration d : userList){
				userMap.put(d.getOldId(), d.getNewId());
			}
		}
	}

	@Override
	public void process() throws Exception {
		DataMigrationService dataMigrationService = SpringContextHolder.getBean("dataMigrationServiceImpl");
		UserAddressService userAddressService = SpringContextHolder.getBean("userAddressServiceImpl");
		BaseSfAreaService baseSfAreaService = SpringContextHolder.getBean("baseSfAreaServiceImpl");
		
		Set<String> uuidSet = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel, rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			LogCvt.info(json);
			Address address = JSonUtil.toObject(json, Address.class);
			
			UserAddress userAddress = new UserAddress();
			//地区查询
			BaseSfArea area = null;
			
			sb.delete(0, sb.length());
			sb.append(address.getProvince().trim()).append(",").append(address.getCity().replace("市", "").trim()).append(",").append(address.getCounty());
			String treePath = sb.toString();
			area = DataCacheUtil.getBaseSfAreaMap(treePath);
			// 匹配最后一个区和县名字不一致情况
			if(Checker.isEmpty(area)){
				treePath = treePath.substring(0, treePath.length()-1);
				area = DataCacheUtil.getBaseSfAreaMap(treePath);
			}
			// 如果还匹配不上退到市级信息，查第一个区信息
			if(Checker.isEmpty(area)){
				treePath = treePath.substring(0, treePath.lastIndexOf(","));
				area = DataCacheUtil.getBaseSfAreaMap(treePath);
				if(area != null){
			          List<BaseSfArea> childs = baseSfAreaService.findByParentId(area.getId(), null);
			          if(Checker.isNotEmpty(childs)){
			            area = childs.get(0);//市级取第一个地区
			          }
				}else{
					LogCvt.error("无法匹配市信息："+treePath);
				}
			}
			
			if(Checker.isNotEmpty(area)){
				userAddress.setAreaId(area.getId());
				userAddress.setTreePath(area.getTreePath());
			}else{
				LogCvt.error("旧表address id[" + address.getId() + "]找不到对应地区, 旧地区[" + sb + "]");
				userAddress.setAreaId(0);
				userAddress.setTreePath(sb.toString());
			}
			//微信用户查询
			if(Checker.isNotEmpty(address.getUser_id())){
				if(userMap.containsKey(address.getUser_id().intValue())){
					userAddress.setUserId(userMap.get(address.getUser_id().intValue()));
				}else{
					LogCvt.error("旧表address id[" + address.getId() + "] 找不到对应微信用户ID, 旧微信用户ID[" + address.getUser_id() + "]");
					continue;
				}
			}else{
				continue;
			}
			userAddress.setMobile(address.getMobile());
			userAddress.setContact(address.getContact());
			userAddress.setAddress(address.getAddress());
			userAddress.setIsDefault(address.getIs_default());
			String uuid = MD5Util.MD5(userAddress.getUserId() + userAddress.getAreaId() + userAddress.getAddress() + userAddress.getContact() + userAddress.getMobile());
			if(!uuidSet.add(uuid)){
				continue;
			}
			userAddress.setUuid(uuid);
			int newId = userAddressService.insert(userAddress);
			
			DataMigration data = new DataMigration();
			data.setOldId(address.getId());
			data.setNewId(newId);
			data.setType(TableTypes.user_address.getType());
			dataMigrationService.insert(data);
		}
		
	}
	
}
