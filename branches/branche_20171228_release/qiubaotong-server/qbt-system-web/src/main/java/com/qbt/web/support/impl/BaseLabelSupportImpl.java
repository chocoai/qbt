package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseLabel;
import com.qbt.persistent.entity.BaseUserLabel;
import com.qbt.service.BaseLabelService;
import com.qbt.service.BaseUserLabelService;
import com.qbt.web.pojo.baseLabel.BaseLabelVO;
import com.qbt.web.pojo.baseUserLabel.UserLabelVO;
import com.qbt.web.support.BaseLabelSupport;

@Service
public class BaseLabelSupportImpl implements BaseLabelSupport {

	@Resource
	private BaseLabelService baseLabelService;
	@Resource
	private BaseUserLabelService baseUserLabelService;

	@Override
	public List<BaseLabelVO> list() {
		List<BaseLabel> baseLabeList = baseLabelService.list();
		List<BaseLabelVO> voList = BeanUtil.list2list(baseLabeList, BaseLabelVO.class);
		Map<Integer, BaseLabelVO> map = new TreeMap<Integer, BaseLabelVO>();
		for (BaseLabelVO v : voList) {
			map.put(v.getId(), v);
		}
		f1(map);
		List<BaseLabelVO> VoList2 = new ArrayList<BaseLabelVO>();
		for (Integer k : map.keySet()) {
			BaseLabelVO v = map.get(k);
			VoList2.add(v);
		}

		return VoList2;
	}

	// 处理返回结果是树状结构的map
	private static void f1(Map<Integer, BaseLabelVO> map) {
		for (Integer k : map.keySet()) {
			BaseLabelVO v = map.get(k);
			if (v.getSuperId() == 0) {
				// superId==0则是父级，越过不用处理
				continue;
			}
			BaseLabelVO superVo = map.get(v.getSuperId());
			List<BaseLabelVO> list = null;
			if (superVo != null) {
				list = superVo.getItem() == null ? new ArrayList<BaseLabelVO>() : superVo.getItem();
				list.add(v);
				superVo.setItem(list);
			}
		}

		Iterator<Entry<Integer, BaseLabelVO>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, BaseLabelVO> entry = it.next();
			BaseLabelVO v = entry.getValue();
			if (v.getSuperId() != 0) {
				it.remove();
			}
		}

	}

	@Override
	public void addUserLabel(UserLabelVO userVO) {
		baseUserLabelService.deleteByUser(userVO.getUserType(), userVO.getUserId());
		List<Integer> labelIdList = userVO.getLabelIdList();
		List<BaseUserLabel> configs = new ArrayList<BaseUserLabel>();
		if (Checker.isNotEmpty(labelIdList)) {
			for (Integer labelId : labelIdList) {
				BaseUserLabel baseUserLabel = new BaseUserLabel();
				baseUserLabel.setLabelId(labelId);
				baseUserLabel.setMobile(userVO.getMobile());
				baseUserLabel.setUserId(userVO.getUserId());
				baseUserLabel.setUserType(userVO.getUserType());
				configs.add(baseUserLabel);
			}
			//批量插入
			baseUserLabelService.insertByBatch(configs);
		}
		//自定义标签
		List<String> contentList =  userVO.getContentList();
		List<BaseUserLabel> configs2 = new ArrayList<BaseUserLabel>();
		if(Checker.isNotEmpty(contentList)){
			for (String content : contentList) {
				BaseUserLabel baseUserLabel = new BaseUserLabel();
				baseUserLabel.setLabelId(0);
				baseUserLabel.setMobile(userVO.getMobile());
				baseUserLabel.setContent(content);
				baseUserLabel.setUserId(userVO.getUserId());
				baseUserLabel.setUserType(userVO.getUserType());
				configs2.add(baseUserLabel);
			}
			baseUserLabelService.insertByBatch(configs2);
		}
				
	}

	@Override
	public List<Integer> findByUser(Integer userType, Integer userId) {
		List<BaseUserLabel> configs = baseUserLabelService.findByUser(userType, userId);
		List<Integer> labelIdList = new ArrayList<Integer>();
		if (configs != null) {
			for (BaseUserLabel baseUserLabel : configs) {
				labelIdList.add(baseUserLabel.getLabelId());
			}
		}
		return labelIdList;
	}
	
	@Override
	public List<String> findContentByUser(Integer userType, Integer userId) {
		List<BaseUserLabel> configs = baseUserLabelService.findContentByUser(userType, userId);
		List<String> labelContentList = new ArrayList<String>();
		if (configs != null) {
			for (BaseUserLabel baseUserLabel : configs) {
				labelContentList.add(baseUserLabel.getContent());
			}
		}
		return labelContentList;
	}

}
