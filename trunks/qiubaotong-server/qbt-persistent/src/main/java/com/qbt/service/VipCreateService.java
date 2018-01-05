/**
 * Project Name:qbt-persistent
 * File Name:VipCreateService.java
 * Package Name:com.qbt.service
 * Date:2017年1月4日上午10:31:46
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipCreate;

/**
 * ClassName:VipCreateService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 上午10:31:46
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface VipCreateService {
	
	int insert(VipCreate vipCreate);
	
	VipCreate findById(Integer id);
	
	int updateById(VipCreate vipCreate);
	
	List<VipCreate> findByPage(PageEntity<VipCreate> pageEntity);
	
	int exist(String name);
}
