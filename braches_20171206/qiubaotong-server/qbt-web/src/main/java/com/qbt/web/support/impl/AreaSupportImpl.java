package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.OutRangeAddress;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.OutRangeAddressService;
import com.qbt.web.pojo.base.Area;
import com.qbt.web.support.AreaSupport;

@Service
public class AreaSupportImpl implements AreaSupport {

	@Resource
	private BaseSfAreaService areaSfService;
	@Resource
	private OutRangeAddressService outRangeAddressService;
	
	@Override
	public Area findById(int id) {
		BaseSfArea baseArea = areaSfService.findById(id);
		Area area = contactArea2(baseArea);
		return area;
	}

	@Override
	public List<Area> findBySuperId(int superId) {
		List<BaseSfArea> baseAreaList = areaSfService.findByParentId(superId, true);
		List<Area> areaList = new ArrayList<Area>();
		for(BaseSfArea baseArea : baseAreaList){
			Area area = contactArea(baseArea);
			areaList.add(area);
		}
		baseAreaList = null;
		return areaList;
	}
	
	
	@Override
	public Area findByName(String name) {
		BaseSfArea baseArea = areaSfService.findByName(name, true);
		Area area = contactArea(baseArea);
		return area;
	}

	@Override
	public List<Area> findByLevel(int level) {
		List<BaseSfArea> baseAreaList = areaSfService.findByLevel(level);
		List<Area>  areaList = new ArrayList<Area>();
		
		List<String>  level1List = new ArrayList<String>();
		Map<String,List<String>>  level2ListMap = new HashMap<String, List<String>>();
		for(BaseSfArea baseArea : baseAreaList){
			level = baseArea.getLevel();
			int superId = baseArea.getParentId();
			String[] treeIds = baseArea.getTreeId().split(",");
			switch (level) {
				case 2:
					areaList.add(contactArea(baseArea));
					level1List.add(String.valueOf(baseArea.getId()));
					break;
				case 3:
					int index = level1List.indexOf(String.valueOf(superId));
					List<Area> itemList = areaList.get(index).getItems();
					itemList.add(contactArea(baseArea));
					if(level2ListMap.containsKey(String.valueOf(superId))){
						level2ListMap.get(String.valueOf(superId)).add(String.valueOf(baseArea.getId()));
					}else{
						List<String> value = new ArrayList<String>();
						value.add(String.valueOf(baseArea.getId()));
						level2ListMap.put(String.valueOf(superId), value);
					}
					break;
				case 4:
					index = level1List.indexOf(treeIds[0]);
					int index2 = level2ListMap.get(treeIds[0]).indexOf(treeIds[1]);
					List<Area> item2List = areaList.get(index).getItems().get(index2).getItems();
					item2List.add(contactArea(baseArea));
					break;
			}
		}
		level1List =null;level2ListMap=null;baseAreaList=null;
		return areaList;
	}


	private Area contactArea(BaseSfArea baseArea) {
		if(baseArea == null){
			return null;
		}
		Area area = new Area();
		area.setId(baseArea.getId());
		area.setLevel(baseArea.getLevel());
		area.setName(baseArea.getName());
		area.setSuperId(baseArea.getParentId());
		return area;
	}
	

	private Area contactArea2(BaseSfArea baseArea) {
		Area area = new Area();
		area.setId(baseArea.getId());
		area.setLevel(baseArea.getLevel());
		area.setName(baseArea.getName());
		area.setSuperId(baseArea.getParentId());
		area.setTreePath(baseArea.getTreePath());
		return area;
	}

	@Override
	public List<Area> findByLevelCourse(int level) {
		List<BaseSfArea> baseAreaList = areaSfService.findByLevelCourse(level);
		List<Area>  areaList = new ArrayList<Area>();
		
		List<String>  level1List = new ArrayList<String>();
		Map<String,List<String>>  level2ListMap = new HashMap<String, List<String>>();
		for(BaseSfArea baseArea : baseAreaList){
			level = baseArea.getLevel();
			int superId = baseArea.getParentId();
			String[] treeIds = baseArea.getTreeId().split(",");
			switch (level) {
				case 2:
					areaList.add(contactArea(baseArea));
					level1List.add(String.valueOf(baseArea.getId()));
					break;
				case 3:
					int index = level1List.indexOf(String.valueOf(superId));
					List<Area> itemList = areaList.get(index).getItems();
					itemList.add(contactArea(baseArea));
					if(level2ListMap.containsKey(String.valueOf(superId))){
						level2ListMap.get(String.valueOf(superId)).add(String.valueOf(baseArea.getId()));
					}else{
						List<String> value = new ArrayList<String>();
						value.add(String.valueOf(baseArea.getId()));
						level2ListMap.put(String.valueOf(superId), value);
					}
					break;
				case 4:
					index = level1List.indexOf(treeIds[0]);
					int index2 = level2ListMap.get(treeIds[0]).indexOf(treeIds[1]);
					List<Area> item2List = areaList.get(index).getItems().get(index2).getItems();
					item2List.add(contactArea(baseArea));
					break;
			}
		}
		level1List =null;level2ListMap=null;baseAreaList=null;
		return areaList;
	}
	
	public boolean isOutRangeArea(Integer areaId,String address){
		OutRangeAddress jAddress = outRangeAddressService.findByAreaId(areaId, address);
		if (jAddress==null) {
			return false;
		}else{
			return true;
		}
	}
}
