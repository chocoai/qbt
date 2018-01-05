package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.MD5Util;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.UserAddressService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.userAddress.UserAddressPageReqVo;
import com.qbt.web.pojo.userAddress.UserAddressVo;
import com.qbt.web.support.UserAddressSupport;

@Service
public class UserAddressSupportImpl implements UserAddressSupport {

	@Resource
	private UserAddressService userAddressService;
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Override
	public List<UserAddressVo> findByPage(UserAddressPageReqVo reqVo) {
		UserAddress condition = new UserAddress();
		condition.setUserId(reqVo.getUserId());
		PageEntity<UserAddress> pageEntity = BeanUtil.pageConvert(reqVo, UserAddress.class);
		List<UserAddress> list = userAddressService.findByPage(pageEntity);
		List<UserAddressVo> voList = new ArrayList<UserAddressVo>();
		if(Checker.isNotEmpty(list)){
			UserAddressVo vo = null;
			for(UserAddress ua : list){
				vo = BeanUtil.a2b(ua, UserAddressVo.class);
				
				//拿到省市区
				String treePath = ua.getTreePath();
				String[] addressArray = treePath.split(","); 
				if(addressArray[0]!=null&&addressArray[0]!=""){
					vo.setProvice(addressArray[0]);
				}
				if(addressArray[1]!=null&&addressArray[1]!=""){
					vo.setCity(addressArray[1]);
				}
				if(addressArray[2]!=null&&addressArray[2]!=""){
					vo.setDistrict(addressArray[2]);
				}
				BaseSfArea area = baseSfAreaService.findById(ua.getAreaId());
				if(Checker.isNotEmpty(area)){
					vo.setTreeId(area.getTreeId());
				}
				voList.add(vo);
			}
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public int add(UserAddressVo vo) throws BusinessException {
		String uuid = MD5Util.MD5("" +vo.getUserId() + vo.getAreaId() + vo.getAddress() + vo.getContact() + vo.getMobile());
		UserAddress query = userAddressService.findByUuid(uuid);
		if(Checker.isNotEmpty(query)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "该地址已存在");
		}
		UserAddress ua = BeanUtil.a2b(vo, UserAddress.class);
		ua.setUuid(uuid);
		int id = userAddressService.insert(ua);
		return id;
	}

	@Override
	public List<UserAddressVo> findListByUserId(UserAddressPageReqVo reqVo) {
		PageEntity<UserAddress> pageEntity = new PageEntity<UserAddress>();
		pageEntity.setPageNumber(reqVo.getPageNo());
		pageEntity.setPageSize(reqVo.getPageSize());
		//拿到省市区
		//UserWeixin userWeixin = userWeixinService.findDetail(reqVo.getUserWeixinId());
		
		List<UserAddress> list = userAddressService.findByUserId(reqVo.getUserId(), null);
		List<UserAddressVo> voList = new ArrayList<UserAddressVo>();
		
		if(Checker.isNotEmpty(list)){
			UserAddressVo vo = null;
			for(UserAddress ua : list){
				vo = BeanUtil.a2b(ua, UserAddressVo.class);
				
				String treePath = ua.getTreePath();
				String[] addressArray = treePath.split(","); 
				if(addressArray[0]!=null&&addressArray[0]!=""){
					vo.setProvice(addressArray[0]);
				}
				if(addressArray[1]!=null&&addressArray[1]!=""){
					vo.setCity(addressArray[1]);
				}
				if(addressArray[2]!=null&&addressArray[2]!=""){
					vo.setDistrict(addressArray[2]);
				}
				voList.add(vo);
			}
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}
	
}
