package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BaseNewsDto;
import com.qbt.persistent.entity.BaseNews;

public interface BaseNewsMapper {

	void insert(BaseNews baseNews);

	List<BaseNews> findByPage(PageEntity<BaseNewsDto> pageEntity);

	void updateByPrimaryKeySelective(BaseNews baseNews);

	BaseNews findById(Integer id);

	void updateStatus(@Param("id")Integer id, @Param("status")int status);

	void deleteById(Integer id);

	List<BaseNews> list(@Param("categoryId")Integer categoryId);

	void updateReadTimesById(@Param("id")int id, @Param("readTimes")int readTimes);

	List<BaseNews> findByPageOfficial(PageEntity<BaseNewsDto> pageEntity);

	List<BaseNews> listGroupByCategoryId();

}
