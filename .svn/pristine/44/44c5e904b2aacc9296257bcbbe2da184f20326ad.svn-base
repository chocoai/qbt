/**
 * Project Name:qbt-persistent
 * File Name:BaseAdvertService.java
 * Package Name:com.qbt.service
 * Date:2017年10月10日上午10:19:06
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseAdvert;

/**
 * ClassName:BaseAdvertService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月10日 上午10:19:06
 * @author   wuwang
 * @version  
 * @see 	 
 */
public interface BaseAdvertService {

	List<BaseAdvert> findByPage(PageEntity<BaseAdvert> pageEntity);

	void updateStatus(Integer id, int status);

	BaseAdvert findById(Integer id);

	void udateById(BaseAdvert baseAdv);

	BaseAdvert listByCode(String code, Integer flatType);

}
