/**
 * Project Name:qbt-persistent
 * File Name:BaseWeixinReplyService.java
 * Package Name:com.qbt.service
 * Date:2017年2月6日下午2:49:33
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseWeixinReply;

/**
 * ClassName:BaseWeixinReplyService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月6日 下午2:49:33
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BaseWeixinReplyService {
	
	public int insert(BaseWeixinReply reply);
	
	public BaseWeixinReply findById(Integer id);

	public int updateById(BaseWeixinReply reply);
	    
	public int deleteById(Integer id);
	    
	public List<BaseWeixinReply> findByPage(PageEntity<BaseWeixinReply> pageEntity);

	public BaseWeixinReply findByKeyWord(String content);
	
}
