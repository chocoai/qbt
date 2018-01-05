/**
 * Project Name:qbt-persistent
 * File Name:BasePopUpConfigService.java
 * Package Name:com.qbt.service
 * Date:2017年1月16日下午4:45:06
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.BasePopUpConfig;

/**
 * ClassName:BasePopUpConfigService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月16日 下午4:45:06
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BasePopUpConfigService {
	
	int insert(BasePopUpConfig basePopUpConfig);

    BasePopUpConfig findById(Integer id);
    
    int insertBatch(List<BasePopUpConfig> configs);
    
    int deleteByPopUpId(Integer popUpId);
    
    List<BasePopUpConfig> findByPopUpId(Integer popUpId);
    
}
