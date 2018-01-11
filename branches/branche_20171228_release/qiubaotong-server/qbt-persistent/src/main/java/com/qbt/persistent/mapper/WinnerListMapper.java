package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.WinnerList;

public interface WinnerListMapper {
	void insert(WinnerList winnerList);
	void update(WinnerList winnerList);
	List<WinnerList> findByPage(PageEntity<WinnerList> pageEntity);
	
	
}
