/**
 * Project Name:qbt-persistent
 * File Name:OrgGroupUserService.java
 * Package Name:com.qbt.service
 * Date:2017年8月1日下午2:42:59
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.OrgGroupUserDto;
import com.qbt.persistent.entity.OrgGroupUser;

/**
 * ClassName:OrgGroupUserService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午2:42:59
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrgGroupUserService {
	
	int insert(OrgGroupUser orgGroupUser);

    OrgGroupUser selectById(Integer id);

    int updateById(OrgGroupUser orgGroupUser);
	
    List<OrgGroupUser> findByPage(PageEntity<OrgGroupUserDto> pageEntity);
    
    int deleteByBatch(List<Integer> ids);
    
    int insertByBatch(List<OrgGroupUser> users);
    
    int exists(OrgGroupUser orgGroupUser);
    
    int deleteByOrgId(Integer orgId);

    OrgGroupUser findByNameAndMobile(String name, String mobile);
}
