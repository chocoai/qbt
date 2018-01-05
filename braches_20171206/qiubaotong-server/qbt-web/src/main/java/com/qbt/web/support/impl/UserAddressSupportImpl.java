package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.AddrTypeEnum;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.OutRangeAddress;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.OutRangeAddressService;
import com.qbt.service.UserAddressService;
import com.qbt.util.SignCalculator;
import com.qbt.web.pojo.user.Address;
import com.qbt.web.pojo.user.AddressDto;
import com.qbt.web.support.UserAddressSupport;

/**
 * 地址管理
 * @author share
 *
 */
@Service
public class UserAddressSupportImpl implements UserAddressSupport{

	@Resource
	private  UserAddressService userAddressService;
	@Resource
	private  BaseSfAreaService baseSfAreaService;
	@Resource
	private BaseCourseService baseCourseService;
	
	@Resource
	private OutRangeAddressService outRangeAddressService;
	
	/**
	 * 列表查询
	 */
	@Override
	public List<Address> list(int userId, int labelType) {
		List<Address> addList = new ArrayList<Address>();
		List<UserAddress> addressList = userAddressService.findByUserId(userId, labelType);
		for(UserAddress address : addressList){
			Address add = new Address();
			OutRangeAddress outRangAddress = outRangeAddressService.findByAreaId(address.getAreaId(), address.getAddress());
			if(outRangAddress!=null){
				add.setIsOutRange(true);
			}
			add.setAddress(address.getAddress());
			add.setAreaId(address.getAreaId());
			add.setId(address.getId());
			add.setMobile(address.getMobile());
			add.setName(address.getContact());
			add.setUserId(address.getUserId());
			add.setDef(address.getIsDefault());
			add.setLabelType(address.getLabelType());
			BaseSfArea area = baseSfAreaService.findById(address.getAreaId());
			if(area !=null){
				add.setCityName(area.getTreePath());
				add.setTreeId(area.getTreeId());
			}
			addList.add(add);
		}
		return addList;
	}

	/**
	 * 添加
	 */
	@Override
	public Map<String,String> add(Address address) {
		BaseSfArea area = null;
		if(address.getAreaId() <=0 && address.getCityName()!=null){
			String[] citys = address.getCityName().split(",");
			if(citys.length == 2){
				LogCvt.info("定位地区信息不全");
				String city = citys[1];
				area = baseSfAreaService.findByName(city, true);
			}else if(citys.length == 3){
				String city = citys[1];
				String district = citys[2];
				area = baseSfAreaService.findByDistrict(city,district);
			}
		}else{
			area = baseSfAreaService.findById(address.getAreaId());
		}
		if(area == null){
			LogCvt.error("定位添加地址错误，无法匹配城市名称，请注意："+address.getCityName()+"【用户地址】");
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "地区信息有误，请重新选择");
		}
		address.setAreaId(area.getId());
		
		UserAddress signAddress = new UserAddress();
		signAddress.setUserId(address.getUserId());
		signAddress.setAddress(address.getAddress());
		signAddress.setAreaId(address.getAreaId());
		signAddress.setContact(address.getName());
		signAddress.setMobile(address.getMobile());
		String uuid = SignCalculator.calUserAddressSign(signAddress);
		
		UserAddress query = userAddressService.findByUuid(uuid);
		if(Checker.isNotEmpty(query)){
			LogCvt.info("用户地址已存在");
			Map<String,String> addressMap = new HashMap<String,String>();
			addressMap.put("id", String.valueOf(query.getId()));
			addressMap.put("area_id", String.valueOf(query.getAreaId()));
			return addressMap;
		}
		
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(address.getUserId());
		userAddress.setAddress(address.getAddress());
		userAddress.setAreaId(address.getAreaId());
		userAddress.setContact(address.getName());
		userAddress.setMobile(address.getMobile());
		userAddress.setIsDefault(address.isDef());
		userAddress.setTreePath(area.getTreePath());
		userAddress.setUuid(uuid);
		userAddress.setLabelType(address.getLabelType());
		int id = userAddressService.insert(userAddress);
		Map<String,String> addressMap = new HashMap<String,String>();
		addressMap.put("id", String.valueOf(id));
		addressMap.put("area_id", String.valueOf(userAddress.getAreaId()));
		return addressMap;
	}
	
	/**
	 * 更新
	 */
	@Override
	public boolean update(Address address) {
		BaseSfArea area = null;
		if(address.getAreaId() <=0 && address.getCityName()!=null){
			String[] citys = address.getCityName().split(",");
			if(citys.length == 2){
				LogCvt.info("定位地区信息不全");
				String city = citys[1];
				area = baseSfAreaService.findByName(city, true);
			}else if(citys.length == 3){
				String city = citys[1];
				String district = citys[2];
				area = baseSfAreaService.findByDistrict(city,district);
			}
		}else{
			area = baseSfAreaService.findById(address.getAreaId());
		}
		if(area == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "地区信息有误，请重新选择");
		}
		
		UserAddress signAddress = new UserAddress();
		signAddress.setUserId(address.getUserId());
		signAddress.setAddress(address.getAddress());
		signAddress.setAreaId(address.getAreaId());
		signAddress.setContact(address.getName());
		signAddress.setMobile(address.getMobile());
		String uuid = SignCalculator.calUserAddressSign(signAddress);
		UserAddress query = userAddressService.findById(address.getId());
		int count = userAddressService.exists(query.getId(), uuid);
		if(count > 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地址已存在");
		}
		
		address.setAreaId(area.getId());
		UserAddress userAddr = new UserAddress();
		userAddr.setId(address.getId());
		userAddr.setAddress(address.getAddress());
		userAddr.setAreaId(address.getAreaId());
		userAddr.setContact(address.getName());
		userAddr.setIsDefault(address.isDef());
		userAddr.setMobile(address.getMobile());
		userAddr.setTreePath(area.getTreePath());
		userAddr.setUuid(uuid);
		userAddr.setUserId(address.getUserId());
		userAddr.setLabelType(address.getLabelType());
		userAddressService.update(userAddr);
		return true;
	}
	
	/**
	 * 置顶
	 */
	@Override
	public boolean updateUpdateTime(AddressDto address) {
		UserAddress userAddr = new UserAddress();
		userAddr.setId(address.getId());
		userAddr.setIsDefault(address.isDef());
		userAddr.setUpdateTime(new Date());
		userAddressService.updateUpdateTime(userAddr);
		return true;
	}
	
	/**
	 * 删除
	 */
	@Override
	public boolean delete(int id) {
		return userAddressService.delete(id) > 0;
	}
	
}
