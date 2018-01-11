/**
 * Project Name:qbt-system-web
 * File Name:WeixinReplyVo.java
 * Package Name:com.qbt.web.pojo.weixinReply
 * Date:2017年2月6日下午3:09:48
 *
*/

package com.qbt.web.pojo.weixinReply;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * ClassName:WeixinReplyVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月6日 下午3:09:48
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class WeixinReplyVo {
	
	private int id;
	
	private Date createTime;
	
	@NotNull(message = "类型不能为空")
	private Integer type;

	@NotNull(message = "关键字不能为空")
    private String keyword;

    private String content;
    
    private List<ArticleVo> articles;

    private Integer status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ArticleVo> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleVo> articles) {
		this.articles = articles;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
