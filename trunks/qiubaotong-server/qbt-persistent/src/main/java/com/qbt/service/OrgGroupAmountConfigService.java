/**
 * Project Name:qbt-persistent
 * File Name:OrgGroupAmountConfigService.java
 * Package Name:com.qbt.service
 * Date:2017年8月1日下午2:45:09
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.OrgGroupAmountConfig;

/**
 * ClassName:OrgGroupAmountConfigService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午2:45:09
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrgGroupAmountConfigService {
	
	int insert(OrgGroupAmountConfig orgGroupAmountConfig);

    OrgGroupAmountConfig selectById(Integer id);

    int updateById(OrgGroupAmountConfig orgGroupAmountConfig);
    
    List<OrgGroupAmountConfig> selectByOrgId(Integer orgId);
    
    int deleteByOrgId(Integer orgId);
    
    int insertByBatch(List<OrgGroupAmountConfig> configs);

	List<OrgGroupAmountConfig> list();

	/**
	 * 获取适合的配置项
	 * @param totalAmount
	 * @return
	 */
	OrgGroupAmountConfig selectProperAmountConfig(Double sfPrice, Integer orgId);

}
