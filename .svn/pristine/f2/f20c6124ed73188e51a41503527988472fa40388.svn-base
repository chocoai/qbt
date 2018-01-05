/**
 * Project Name:qbt-persistent
 * File Name:BaseSfTimeService.java
 * Package Name:com.qbt.service
 * Date:2017年4月6日上午10:11:51
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import java.util.Date;

import com.qbt.persistent.entity.BaseSfTime;

/**
 * ClassName:BaseSfTimeService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年4月6日 上午10:11:51
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BaseSfTimeService {
	
	int insert(BaseSfTime baseSfTime);

    BaseSfTime findById(Integer id);

    int updateById(BaseSfTime baseSfTime);

	List<BaseSfTime> findByPage(PageEntity<BaseSfTime> pageEntity);

    BaseSfTime findByDate(Date date);

	void deleteById(Integer id);

	List<BaseSfTime> findByCondition(BaseSfTime condition);

}
