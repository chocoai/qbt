package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.SettleModeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseLanguage;
import com.qbt.persistent.entity.BasePartner;
import com.qbt.persistent.entity.BasePartnerLanguage;
import com.qbt.persistent.entity.BaseSettmtAmountConfig;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.BaseLanguageService;
import com.qbt.service.BasePartnerLanguageService;
import com.qbt.service.BasePartnerService;
import com.qbt.service.BaseSettmtAmountConfigService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.UserAsApService;
import com.qbt.service.UserAssistantService;
import com.qbt.web.pojo.basePartner.BasePartnerPageReqVo;
import com.qbt.web.pojo.basePartner.BasePartnerVO;
import com.qbt.web.support.BasePartnerSupport;

@Service
public class BasePartnerSupportImpl implements BasePartnerSupport {

	@Resource
	private BasePartnerService basePartnerService;
	@Resource
	private BasePartnerLanguageService basePartnerLanguageService;
	@Resource
	private BaseLanguageService baseLanguageService;
	@Resource
	private BaseSettmtAmountConfigService baseSettmtAmountConfigService;
	@Resource
	private UserAsApService userAsApService; 
	@Resource
	private BaseSfAreaService baseSfAreaService;
	@Resource
	private UserAssistantService userAssistantService;
	
	
	@Override
	public void insert(BasePartnerVO vo) {
		BasePartner condition = new BasePartner();
		condition.setName(vo.getName());
		List<BasePartner> qryList = basePartnerService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("合作社名称已被使用");
		}
		BasePartner basePartner = BeanUtil.a2b(vo, BasePartner.class);
		basePartner.setStatus(1);
		basePartnerService.insert(basePartner);
		
		//插入合作社语言关系表
		List<Integer> languageIdList = vo.getLanguageIdList();
		List<BasePartnerLanguage> basePtnerLanguageList = new ArrayList<BasePartnerLanguage>();
		if(languageIdList!=null){
			for (Integer languageId : languageIdList) {
				BaseLanguage bl =  baseLanguageService.findById(languageId);
				BasePartnerLanguage basePartnerLanguage = new BasePartnerLanguage();
				basePartnerLanguage.setPartnerlId(basePartner.getId());
				basePartnerLanguage.setLanguageId(languageId);
				basePartnerLanguage.setName(bl.getName());
				basePartnerLanguage.setEname(bl.getEname());
				basePtnerLanguageList.add(basePartnerLanguage);
			}
			basePartnerLanguageService.insert(basePtnerLanguageList);
		}
		
		List<BaseSettmtAmountConfig> baseSettmtAmountConfigList = new ArrayList<BaseSettmtAmountConfig>();
		//插入总金额结算模式配置表
		if(SettleModeEnum.advanced_mode.getCode() == vo.getSettleMode()){
			for(BaseSettmtAmountConfig bsac:vo.getBsacList()){
				bsac.setPartnerlId(basePartner.getId());
				baseSettmtAmountConfigList.add(bsac);
			}
			baseSettmtAmountConfigService.insertByBatch(baseSettmtAmountConfigList);
		}
		
	}

	@Override
	public List<BasePartnerVO> findByPage(BasePartnerPageReqVo reqVo) {
		PageEntity<BasePartner> pageEntity = BeanUtil.pageConvert(reqVo, BasePartner.class);
		List<BasePartner> list = basePartnerService.findByPage(pageEntity);
		List<BasePartnerVO> voList = BeanUtil.list2list(list, BasePartnerVO.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public void update(BasePartnerVO vo) {
		BasePartner basePartner = BeanUtil.a2b(vo, BasePartner.class);
		basePartnerService.update(basePartner);
		//删掉原来的合作社语言关系表数据
		basePartnerLanguageService.deleteByPartnerlId(vo.getId());
		List<Integer> languageIdList = vo.getLanguageIdList();
		List<BasePartnerLanguage> basePtnerLanguageList = new ArrayList<BasePartnerLanguage>();
		for (Integer languageId : languageIdList) {
			BaseLanguage bl =  baseLanguageService.findById(languageId);
			BasePartnerLanguage basePartnerLanguage = new BasePartnerLanguage();
			basePartnerLanguage.setPartnerlId(vo.getId());
			basePartnerLanguage.setLanguageId(languageId);
			basePartnerLanguage.setName(bl.getName());
			basePartnerLanguage.setEname(bl.getEname());
			basePtnerLanguageList.add(basePartnerLanguage);
		}
		//插入新合作社语言关系表
		basePartnerLanguageService.insert(basePtnerLanguageList);
		//删掉原来总金额结算模式配置表
		baseSettmtAmountConfigService.deleteByPartnerlId(basePartner.getId());
		List<BaseSettmtAmountConfig> baseSettmtAmountConfigList = new ArrayList<BaseSettmtAmountConfig>();
		if(SettleModeEnum.advanced_mode.getCode() == vo.getSettleMode()){
			for(BaseSettmtAmountConfig bsac:vo.getBsacList()){
				bsac.setPartnerlId(basePartner.getId());
				baseSettmtAmountConfigList.add(bsac);
			}
			//插入新总金额结算模式配置表
			baseSettmtAmountConfigService.insertByBatch(baseSettmtAmountConfigList);
		}
		
	}

	@Override
	public BasePartnerVO findById(Integer id) {
		BasePartner basePartner = basePartnerService.findById(id);
		BasePartnerVO basePartnerVO = BeanUtil.a2b(basePartner, BasePartnerVO.class);
		List<BasePartnerLanguage> basePartnerLanguageList = basePartnerLanguageService.listByPartnerlId(id);
		List<Integer> languageIdList = new ArrayList<Integer>();
		for (BasePartnerLanguage basePartnerLanguage : basePartnerLanguageList) {
			languageIdList.add(basePartnerLanguage.getLanguageId());
		}
		basePartnerVO.setLanguageIdList(languageIdList);
		List<BaseSettmtAmountConfig> BaseSettmtAmountConfigList =  baseSettmtAmountConfigService.findByPartnerlId(id);
		basePartnerVO.setBsacList(BaseSettmtAmountConfigList);
		BaseSfArea baseSfArea = baseSfAreaService.findById(basePartner.getAreaId());
		if(baseSfArea != null){
			basePartnerVO.setTreeId(baseSfArea.getTreeId());
		}
		return basePartnerVO;	
	}

	@Override
	public void updateStatus(Integer id,int status) {
		int hasUserAssitant = userAssistantService.queryAssistantByApply(8, id);
		if(hasUserAssitant>0){
			throw new BusinessException("必须先禁用所属的球包助理");
		}else{
			basePartnerService.updateStatus(id,status);
		}
		
	}

}
