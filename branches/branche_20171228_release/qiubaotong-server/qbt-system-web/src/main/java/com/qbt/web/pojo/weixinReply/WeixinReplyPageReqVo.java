/**
 * Project Name:qbt-system-web
 * File Name:WeixinReplyPageReqVo.java
 * Package Name:com.qbt.web.pojo.weixinReply
 * Date:2017年2月6日下午3:14:31
 *
*/

package com.qbt.web.pojo.weixinReply;

import com.qbt.common.result.Paging;

/**
 * ClassName:WeixinReplyPageReqVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月6日 下午3:14:31
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class WeixinReplyPageReqVo extends Paging {
	
	private Integer type;
	
	private String keyword;
	
	private Integer status;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
