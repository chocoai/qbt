/**
 * Project Name:qbt-web
 * File Name:UserImageSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年1月11日上午11:20:24
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.userImage.UserImageDeleteRequest;
import com.qbt.web.pojo.userImage.UserImageVo;

/**
 * ClassName:UserImageSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 上午11:20:24
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface UserImageSupport {
	
	UserImageVo add(Integer userId, String pic, Integer type);
	
	List<UserImageVo> list(Integer userId, Integer type);
	
	boolean delete(UserImageDeleteRequest req);
}
