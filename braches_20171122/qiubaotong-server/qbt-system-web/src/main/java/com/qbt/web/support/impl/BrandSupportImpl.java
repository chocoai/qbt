package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.BossBaseBrand;
import com.qbt.persistent.entity.BaseBrand;
import com.qbt.service.BaseBrandService;
import com.qbt.web.pojo.brand.BrandPageReqVo;
import com.qbt.web.pojo.brand.BrandVo;
import com.qbt.web.support.BrandSupport;

@Service
public class BrandSupportImpl implements BrandSupport {
	
	@Resource
	private BaseBrandService baseBrandService;
	
	@Override
	public int add(BrandVo vo) throws BusinessException {
		//查询是否有重复球包牌号码或芯片编码
		int bcount = baseBrandService.isExist(vo.getBagNo(), null);
		if(bcount > 0){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "球包牌号码已被使用");
		}
		int rcount = baseBrandService.isExist(null, vo.getRfidNo());
		if(rcount > 0){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "芯片编码已被使用");
		}
		
		BaseBrand baseBrand = BeanUtil.a2b(vo, BaseBrand.class);
		return baseBrandService.insert(baseBrand);
	}

	@Override
	public boolean update(BrandVo vo) throws BusinessException {
		//查询是否有重复球包牌号码或芯片编码
		BaseBrand query = baseBrandService.selectById(vo.getId());
		if(Checker.isNotEmpty(query)){
			if(!query.getBagNo().equals(vo.getBagNo())){
				int bcount = baseBrandService.isExist(vo.getBagNo(), null);
				if(bcount > 0){
					throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "球包牌号码已被使用");
				}
			}
			if(!query.getRfidNo().equals(vo.getRfidNo())){
				int rcount = baseBrandService.isExist(null, vo.getRfidNo());
				if(rcount > 0){
					throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "芯片编码已被使用");
				}
			}
			
			BaseBrand baseBrand = BeanUtil.a2b(vo, BaseBrand.class);
			int c = baseBrandService.updateById(baseBrand);
			return c > 0;
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return baseBrandService.deleteById(id) > 0;
	}

	@Override
	public BrandVo findById(Integer id) {
		BaseBrand baseBrand = baseBrandService.selectById(id);
		BrandVo vo  = BeanUtil.a2b(baseBrand, BrandVo.class);
		return vo;
	}

	@Override
	public List<BrandVo> findByPage(BrandPageReqVo reqVo) {
		PageEntity<BossBaseBrand> pageEntity = BeanUtil.pageConvert(reqVo, BossBaseBrand.class);
		List<BossBaseBrand> list = baseBrandService.findByPage(pageEntity);
		List<BrandVo> voList = BeanUtil.list2list(list, BrandVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
