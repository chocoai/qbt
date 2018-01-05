/**
 * Project Name:qbt-persistent
 * File Name:UserImageService.java
 * Package Name:com.qbt.service
 * Date:2017年1月11日上午11:05:13
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.UserImage;

/**
 * ClassName:UserImageService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 上午11:05:13
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface UserImageService {
	
	int insert(UserImage userImage);

    UserImage findById(Integer id);

    int deleteById(Integer id);
    
    List<UserImage> findByUserId(Integer userId, Integer type);
    
    int deleteByIds(List<Integer> ids);
    
    List<UserImage> findByIds(List<Integer> ids);
}
