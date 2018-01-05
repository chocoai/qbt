package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBank;
import com.qbt.persistent.entity.BaseInsuredTemplate;

public interface BaseInsuredTemplateService {

	/**
	 * 添加
	 * @param user
	 */
	public void insert(BaseInsuredTemplate template);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public BaseInsuredTemplate findById(int id);
	
	
	/**
	 * 更新
	 * @param address
	 * @return
	 */
	public int update(BaseInsuredTemplate template);
	
	/**
	 * findByLevel
	 * @param level
	 * @return
	 */
	public BaseInsuredTemplate findValid();
	
	/**
	 * 更新状态
	 * @param state
	 * @param id
	 * @return
	 */
	public int updateState(int state,int id);
	
	/**
	 * 删除
	 * @param id
	 */
	void deleteById(Integer id);

	List<BaseInsuredTemplate> findByPage(PageEntity<BaseInsuredTemplate> pageEntity);

	public List<BaseBank> findByCondition(BaseInsuredTemplate condition);
	
}
