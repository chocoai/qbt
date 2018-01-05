package com.qbt.persistent.entity;

import java.util.List;

import com.qbt.common.entity.BaseEntity;

public class BaseWeixinReply extends BaseEntity {
	
    private Integer type;

    private String keyword;

    private String content;

    private Integer status;
    
    private List<WeixinReplyArticle> articles;

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
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public List<WeixinReplyArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<WeixinReplyArticle> articles) {
		this.articles = articles;
	}
    
}