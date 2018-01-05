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
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.OutRangeAddress;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.OutRangeAddressService;
import com.qbt.web.pojo.outRangeAddress.OutRangeAddressPageReqVo;
import com.qbt.web.pojo.outRangeAddress.OutRangeAddressVO;
import com.qbt.web.support.OutRangeAddressSupport;

@Service
public class OutRangeAddressSupportImpl implements OutRangeAddressSupport{

	@Resource
	private OutRangeAddressService outRangeAddressService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Override
	public List<OutRangeAddressVO> findByPage(OutRangeAddressPageReqVo reqVo) {
		PageEntity<OutRangeAddress> pageEntity = BeanUtil.pageConvert(reqVo, OutRangeAddress.class);
		List<OutRangeAddress> list = outRangeAddressService.findByPage(pageEntity);
		List<OutRangeAddressVO> voList = new ArrayList<OutRangeAddressVO>();
		if(Checker.isNotEmpty(list)){
			OutRangeAddressVO vo = null;
			for(OutRangeAddress sr : list){
				vo = BeanUtil.a2b(sr, OutRangeAddressVO.class);
				if(Checker.isNotEmpty(sr.getAddress())){
					vo.setAddressArr(sr.getAddress().split(","));
				}
				BaseSfArea area = baseSfAreaService.findById(sr.getAreaId());
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
	public void insert(OutRangeAddressVO vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		OutRangeAddress condition = new OutRangeAddress();
		if(Checker.isNotEmpty(vo.getAreaId())){
			condition.setAreaId(vo.getAreaId());
			List<OutRangeAddress> qryList = outRangeAddressService.findByCondition(condition);
			if(Checker.isNotEmpty(qryList)){
				throw new BusinessException("省市区不可重复");
			}
		}
		OutRangeAddress outRangeAddress = new OutRangeAddress();
		outRangeAddress.setAreaId(vo.getAreaId());
		outRangeAddress.setTreePath(area.getTreePath());
		outRangeAddress.setOutRangePrice(vo.getOutRangePrice());
		outRangeAddress.setOutRangeTime(vo.getOutRangeTime());
		outRangeAddress.setRemark(vo.getRemark());
		String[] addressArr = vo.getAddressArr();
		String addressStr= "";
		if(Checker.isNotEmpty(addressArr)){
			for (String address : addressArr) {
				addressStr = addressStr + address + ",";
			}
			addressStr = addressStr.substring(0, addressStr.length()-1);
			outRangeAddress.setAddress(addressStr);
			outRangeAddress.setOutRangeTime(vo.getOutRangeTime());
		}
		outRangeAddressService.insert(outRangeAddress);
	}

	@Override
	public OutRangeAddressVO findById(Integer id) {
		OutRangeAddress outRangeAddress =  outRangeAddressService.findById(id);
		OutRangeAddressVO vo = BeanUtil.a2b(outRangeAddress, OutRangeAddressVO.class);
		if(Checker.isNotEmpty(outRangeAddress.getAddress())){
			vo.setAddressArr(outRangeAddress.getAddress().split(","));
		}
		BaseSfArea area = baseSfAreaService.findById(outRangeAddress.getAreaId());
		if(Checker.isNotEmpty(area)){
			vo.setTreeId(area.getTreeId());
		}
		return vo;
	}

	@Override
	public void deleteById(Integer id) {
		outRangeAddressService.deleteById(id);
	}

	@Override
	public void updateById(OutRangeAddressVO vo) {
		BaseSfArea area = baseSfAreaService.findById(vo.getAreaId());
		if(Checker.isEmpty(area)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "地区不存在");
		}
		OutRangeAddress outRangeAddressOld = outRangeAddressService.findById(vo.getId());
		if(!vo.getAreaId().equals(outRangeAddressOld.getAreaId())){
			OutRangeAddress condition = new OutRangeAddress();
			if(Checker.isNotEmpty(vo.getAreaId())){
				condition.setAreaId(vo.getAreaId());
				List<OutRangeAddress> qryList = outRangeAddressService.findByCondition(condition);
				if(Checker.isNotEmpty(qryList)){
					throw new BusinessException("省市区不可重复");
				}
			}
		}
		OutRangeAddress outRangeAddress = BeanUtil.a2b(vo, OutRangeAddress.class);
		outRangeAddress.setTreePath(area.getTreePath());

		String[] addressArr = vo.getAddressArr();
		String addressStr= "";
		if(Checker.isNotEmpty(addressArr)){
			for (String address : addressArr) {
				addressStr = addressStr + address + ",";
			}
			addressStr = addressStr.substring(0, addressStr.length()-1);
			outRangeAddress.setAddress(addressStr);
		}else{
			outRangeAddress.setAddress("");
		}
		outRangeAddressService.updateById(outRangeAddress);	
	}
	
}
