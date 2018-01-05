package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserKf;

public interface UserKfService {

	int insert(UserKf userKf);

	UserKf selectById(Integer id);

	int updateById(UserKf userKf);

	int delete(Integer id);
	
	List<UserKf> findByType(int type);
	
	List<UserKf> findByPage(PageEntity<UserKf> pageEntity);

	List<UserKf> findByCondition(UserKf condition);
}
