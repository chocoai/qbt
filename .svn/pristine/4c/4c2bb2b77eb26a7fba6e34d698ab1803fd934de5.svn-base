package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BaseNewsDto;
import com.qbt.persistent.entity.BaseNews;

public interface BaseNewsService {

	void add(BaseNews baseNews);

	List<BaseNews> findByPage(PageEntity<BaseNewsDto> pageEntity);

	void update(BaseNews baseNews);

	BaseNews findById(Integer id);

	void updateStatus(Integer id, int status);

	void delete(Integer id);

	List<BaseNews> list(Integer categoryId);

	BaseNews findByIdOfficial(Integer id);

	void updateReadTimesById(int id, int readTimes);

	List<BaseNews> findByPageOfficial(PageEntity<BaseNewsDto> pageEntity);

	List<BaseNews> listGroupByCategoryId();

}
