/**
 * Project Name:qbt-web
 * File Name:UserProxyAddressSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年2月27日下午5:08:20
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.persistent.entity.UserProxyAddress;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.UserProxyAddressService;
import com.qbt.util.SignCalculator;
import com.qbt.web.pojo.user.Address;
import com.qbt.web.pojo.user.AddressDto;
import com.qbt.web.support.UserProxyAddressSupport;

/**
 * ClassName:UserProxyAddressSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 下午5:08:20
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class UserProxyAddressSupportImpl implements UserProxyAddressSupport {
	
	@Resource
	private UserProxyAddressService userProxyAddressService;
	
	@Resource
	private  BaseSfAreaService baseSfAreaService;
	
	@Override
	public List<Address> list(UserWeixin proxyUser, Integer userId, Integer labelType) {
		//如果userId为0，则赋值当前销售人员自己
		if(userId == null || userId == 0 ||  userId.equals("0")){
			userId = proxyUser.getId();
		}
		List<UserProxyAddress> list = userProxyAddressService.findByUserId(proxyUser.getId(), userId, labelType);
		List<Address> addressList = new ArrayList<Address>();
		for(UserProxyAddress address : list){
			Address add = new Address();
			add.setId(address.getId());
			add.setAddress(address.getAddress());
			add.setAreaId(address.getAreaId());
			add.setCityName(address.getTreePath());
			add.setMobile(address.getMobile());
			add.setUserId(address.getUserId());
			add.setDef(address.getIsDefault());
			add.setName(address.getContact());
			add.setLabelType(address.getLabelType());
			BaseSfArea area = baseSfAreaService.findById(address.getAreaId());
			if(area !=null){
				add.setCityName(area.getTreePath());
				add.setTreeId(area.getTreeId());
			}
			addressList.add(add);
		}
		return addressList;
	}

	@Override
	public int add(UserWeixin proxyUser, Address address) {
		BaseSfArea area = baseSfAreaService.findById(address.getAreaId());
		if(Checker.isEmpty(area)){
			LogCvt.error("定位添加地址错误，无法匹配城市名称，请注意："+address.getCityName()+"【用户地址】");
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "地区信息有误，请重新选择");
		}
		
		//如果userId为0，则赋值当前销售人员自己
		if(address.getUserId() == 0 ){
			address.setUserId(proxyUser.getId());
		}
		
		UserProxyAddress signAddress = new UserProxyAddress();
		signAddress.setProxyUserId(proxyUser.getId());
		signAddress.setUserId(address.getUserId());
		signAddress.setAddress(address.getAddress());
		signAddress.setAreaId(address.getAreaId());
		signAddress.setContact(address.getName());
		signAddress.setMobile(address.getMobile());
		String uuid = SignCalculator.calUserProxyAddressSign(signAddress);
		UserProxyAddress query = userProxyAddressService.findByUuid(uuid);
		if(Checker.isNotEmpty(query)){
			LogCvt.info("用户地址已存在");
			return query.getId();
		}
		
		UserProxyAddress proxyAddress = new UserProxyAddress();
		proxyAddress.setProxyUserId(proxyUser.getId());
		proxyAddress.setUserId(address.getUserId());
		proxyAddress.setAddress(address.getAddress());
		proxyAddress.setAreaId(address.getAreaId());
		proxyAddress.setContact(address.getName());
		proxyAddress.setIsDefault(address.isDef());
		proxyAddress.setMobile(address.getMobile());
		proxyAddress.setTreePath(area.getTreePath());
		proxyAddress.setUuid(uuid);
		proxyAddress.setLabelType(address.getLabelType());
		int id = userProxyAddressService.insert(proxyAddress);
		return id;
	}

	@Override
	public boolean update(UserWeixin proxyUser, Address address) {
		BaseSfArea area = baseSfAreaService.findById(address.getAreaId());
		if(Checker.isEmpty(area)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "地区信息有误，请重新选择");
		}
		
		UserProxyAddress signAddress = new UserProxyAddress();
		signAddress.setProxyUserId(proxyUser.getId());
		signAddress.setUserId(address.getUserId());
		signAddress.setAddress(address.getAddress());
		signAddress.setAreaId(address.getAreaId());
		signAddress.setContact(address.getName());
		signAddress.setMobile(address.getMobile());
		String uuid = SignCalculator.calUserProxyAddressSign(signAddress);
		UserProxyAddress query = userProxyAddressService.findById(address.getId());
		int count = userProxyAddressService.exists(query.getId(), uuid);
		if(count > 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "该地址已存在");
		}
		
		UserProxyAddress userAddr = new UserProxyAddress();
		userAddr.setId(address.getId());
		userAddr.setAddress(address.getAddress());
		userAddr.setAreaId(address.getAreaId());
		userAddr.setContact(address.getName());
		userAddr.setIsDefault(address.isDef());
		userAddr.setMobile(address.getMobile());
		userAddr.setTreePath(area.getTreePath());
		userAddr.setUuid(uuid);
		userAddr.setLabelType(address.getLabelType());
		userProxyAddressService.update(userAddr);
		return true;
	}

	@Override
	public boolean delete(int id) {
		return userProxyAddressService.delete(id) > 0;
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
		userProxyAddressService.updateUpdateTime(userAddr);
		return true;
	}
	
}
