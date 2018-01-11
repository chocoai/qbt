/**
 * Project Name:qbt-system-web
 * File Name:WeixinReplySupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年2月6日下午3:20:30
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.weixinReply.WeixinReplyPageReqVo;
import com.qbt.web.pojo.weixinReply.WeixinReplyVo;

/**
 * ClassName:WeixinReplySupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月6日 下午3:20:30
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface WeixinReplySupport {
	
	public int add(WeixinReplyVo vo);
	
	public List<WeixinReplyVo> findByPage(WeixinReplyPageReqVo reqVo);
	
	public WeixinReplyVo detail(Integer id);
	
	public boolean update(WeixinReplyVo vo);
	
	public boolean updateStatus(WeixinReplyVo vo);
	
	public boolean delete(Integer id);
}
