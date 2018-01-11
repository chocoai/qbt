/**
 * Project Name:qbt-persistent
 * File Name:UserProxyAddressService.java
 * Package Name:com.qbt.service
 * Date:2017年2月27日下午4:26:56
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.persistent.entity.UserProxyAddress;

/**
 * ClassName:UserProxyAddressService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 下午4:26:56
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface UserProxyAddressService {
	
	int insert(UserProxyAddress address);

    UserProxyAddress findById(Integer id);

    int update(UserProxyAddress address);
    
    int delete(Integer id);
    
    List<UserProxyAddress> findByPage(PageEntity<UserProxyAddress> pageEntity);
    
    List<UserProxyAddress> findByUserId(Integer proxyUserId, Integer userId, Integer labelType);
    
	UserProxyAddress findByUuid(String uuid);
	
	int exists(Integer id, String uuid);

	public int updateUpdateTime(UserAddress userAddr);
}
