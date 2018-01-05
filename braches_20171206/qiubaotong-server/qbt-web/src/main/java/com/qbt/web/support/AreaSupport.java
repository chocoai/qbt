package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.base.Area;

public interface AreaSupport {

	public Area findById(int id);
	
	public List<Area> findBySuperId(int superId);
	
	public Area findByName(String name);
	
	public List<Area> findByLevel(int level);
	
	public List<Area> findByLevelCourse(int level);
	
	public boolean isOutRangeArea(Integer areaId,String address);
}
