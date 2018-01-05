/**
 * Project Name:qbt-persistent
 * File Name:OrgGroupService.java
 * Package Name:com.qbt.service
 * Date:2017年8月1日下午2:39:36
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrgGroup;

/**
 * ClassName:OrgGroupService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午2:39:36
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrgGroupService {
	
	int insert(OrgGroup orgGroup);

    OrgGroup selectById(Integer id);

    int updateById(OrgGroup orgGroup);
    
    List<OrgGroup> findByPage(PageEntity<OrgGroup> pageEntity);
    
    int exists(OrgGroup orgGroup);
    
    int deleteById(Integer id);
    
    List<OrgGroup> list();

}
