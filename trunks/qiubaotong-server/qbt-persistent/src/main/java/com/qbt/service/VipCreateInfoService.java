/**
 * Project Name:qbt-persistent
 * File Name:VipCreateInfoService.java
 * Package Name:com.qbt.service
 * Date:2017年1月4日上午10:58:30
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipCreateInfo;

/**
 * ClassName:VipCreateInfoService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 上午10:58:30
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface VipCreateInfoService {
	
	int insert(VipCreateInfo vipCreateInfo);

    VipCreateInfo findById(Integer id);

    int updateById(VipCreateInfo vipCreateInfo);
    
    int insertBatch(List<VipCreateInfo> infos);
    
    List<VipCreateInfo> findByPage(PageEntity<VipCreateInfo> pageEntity);
    
    VipCreateInfo findByVipNo(String vipNo,String random);
    
    int updateActivate(String vipNo,String random,int activateMethod);
	
    int updateBatch(VipCreateInfo vipCreateInfo);
    
    List<VipCreateInfo> findByIds(List<Integer> ids);
    
    List<String> findAllVipNo();
}
