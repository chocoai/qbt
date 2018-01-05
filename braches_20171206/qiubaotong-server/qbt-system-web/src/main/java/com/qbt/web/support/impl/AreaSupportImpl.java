package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseArea;
import com.qbt.service.BaseAreaService;
import com.qbt.web.pojo.base.Area;
import com.qbt.web.support.AreaSupport;

@Service
public class AreaSupportImpl implements AreaSupport {

	@Resource
	private BaseAreaService areaService;
	
	@Override
	public Area findById(int id) {
		// TODO Auto-generated method stub
		BaseArea baseArea = areaService.findById(id);
		Area area = contactArea2(baseArea);
		return area;
	}

	@Override
	public List<Area> findBySuperId(int superId) {
		// TODO Auto-generated method stub
		List<BaseArea> baseAreaList = areaService.findBySuperId(superId);
		List<Area> areaList = new ArrayList<Area>();
		for(BaseArea baseArea : baseAreaList){
			Area area = contactArea(baseArea);
			areaList.add(area);
		}
		return areaList;
	}
	
	
	@Override
	public Area findByName(String name) {
		// TODO Auto-generated method stub
		BaseArea baseArea = areaService.findByName(name);
		Area area = contactArea(baseArea);
		return area;
	}

	@Override
	public List<Area> findByLevel(int level) {
		// TODO Auto-generated method stub
		List<BaseArea> baseAreaList = areaService.findByLevel(level);
		List<Area>  areaList = new ArrayList<Area>();
		
		List<String>  level1List = new ArrayList<String>();
		Map<String,List<String>>  level2ListMap = new HashMap<String, List<String>>();
		for(BaseArea baseArea : baseAreaList){
			level = baseArea.getLevel();
			int superId = baseArea.getSuperId();
			String[] treeIds = baseArea.getTreeId().split(",");
			switch (level) {
				case 1:
					areaList.add(contactArea(baseArea));
					level1List.add(String.valueOf(baseArea.getId()));
					break;
				case 2:
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
				case 3:
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


	private Area contactArea(BaseArea baseArea) {
		Area area = new Area();
		area.setId(baseArea.getId());
		area.setLevel(baseArea.getLevel());
		area.setName(baseArea.getName());
		area.setSuperId(baseArea.getSuperId());
		return area;
	}
	

	private Area contactArea2(BaseArea baseArea) {
		Area area = new Area();
		area.setId(baseArea.getId());
		area.setLevel(baseArea.getLevel());
		area.setName(baseArea.getName());
		area.setSuperId(baseArea.getSuperId());
		area.setTreePath(baseArea.getTreePath());
		return area;
	}
	
}
