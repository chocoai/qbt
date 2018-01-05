/**
 * Project Name:qbt-system-web
 * File Name:UserImageSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年1月11日下午2:16:52
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.userImage.UserImageVo;

/**
 * ClassName:UserImageSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 下午2:16:52
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface UserImageSupport {
	
	List<UserImageVo> list(Integer userId, Integer type);
	
	int add(UserImageVo vo);
	
	boolean delete(List<Integer> ids);
	
}
