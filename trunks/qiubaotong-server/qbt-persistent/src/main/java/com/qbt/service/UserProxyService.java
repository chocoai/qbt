/**
 * Project Name:qbt-persistent
 * File Name:UserProxyService.java
 * Package Name:com.qbt.service
 * Date:2017年2月27日上午11:12:55
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.UserProxy;

/**
 * ClassName:UserProxyService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 上午11:12:55
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface UserProxyService {
	
	int insert(UserProxy userProxy);

    UserProxy findById(Integer id);

    int update(UserProxy userProxy);
    
    List<UserProxy> findByProxyUserId(Integer proxUserId);
    
    UserProxy findByUserId(Integer proxUserId, Integer userId);
	
    List<UserProxy> findByKeyword(Integer proxUserId, String keyword);
}
