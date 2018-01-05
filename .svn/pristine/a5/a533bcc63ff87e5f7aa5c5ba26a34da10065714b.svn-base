package com.qbt.sf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.mapper.BaseSfAreaMapper;

@ContextConfiguration(locations = {"classpath*:context/applicationContext*.xml"}) 
public class UpdateSfAreaSyn extends AbstractJUnit4SpringContextTests {
	
	
	@Resource
	private BaseSfAreaMapper baseSfAreaMapper;
	
	@Test
	public void syn() {
		List<BaseSfArea> areaList =  baseSfAreaMapper.findAll();
		Map<String,String> areaTreePathMap = new HashMap<String, String>();
		Map<String,String> areaTreeIdMap = new HashMap<String, String>();
		for(BaseSfArea area : areaList){
			String parentTreeId = areaTreeIdMap.get(area.getParentId()+"");
			parentTreeId = parentTreeId==null?"":parentTreeId+",";
			
			String parentTreeName = areaTreePathMap.get(area.getParentId()+"");
			parentTreeName = parentTreeName==null?"":parentTreeName+",";
			
			parentTreeId = parentTreeId+area.getId();
			parentTreeName = parentTreeName+area.getName();
			
			area.setTreeId(parentTreeId);
			area.setTreePath(parentTreeName);
			areaTreeIdMap.put(area.getId()+"", area.getTreeId());
			areaTreePathMap.put(area.getId()+"", area.getTreePath());
			
			baseSfAreaMapper.updateById(area);
			
		}
	}

}
