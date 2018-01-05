/**
 * Project Name:qbt-persistent
 * File Name:BaseNewSfPriceService.java
 * Package Name:com.qbt.service
 * Date:2017年6月6日下午3:06:27
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseNewSfPrice;

/**
 * ClassName:BaseNewSfPriceService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年6月6日 下午3:06:27
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BaseNewSfPriceService {
	
	public int insert(BaseNewSfPrice sfPrice);
	
	public int update(BaseNewSfPrice price);
	
	public BaseNewSfPrice findById(Integer id);
	
	public List<BaseNewSfPrice> findByPage(PageEntity<BaseNewSfPrice> pageEntity);
	
	public BaseNewSfPrice findByArea(String startArea, String endArea);

	public void delete(Integer id);
	
}
