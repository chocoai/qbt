/**
 * Project Name:qbt-persistent
 * File Name:BaseWeixinReplyServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年2月6日下午2:51:02
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.JSonUtil;
import com.qbt.persistent.entity.BaseWeixinReply;
import com.qbt.persistent.entity.WeixinReplyArticle;
import com.qbt.persistent.mapper.BaseWeixinReplyMapper;
import com.qbt.service.BaseWeixinReplyService;

/**
 * ClassName:BaseWeixinReplyServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月6日 下午2:51:02
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BaseWeixinReplyServiceImpl implements BaseWeixinReplyService {
	
	@Resource
	private BaseWeixinReplyMapper baseWeixinReplyMapper;
	
	@Override
	public int insert(BaseWeixinReply reply) {
		baseWeixinReplyMapper.insert(reply);
		return reply.getId();
	}

	@Override
	public BaseWeixinReply findById(Integer id) {
		BaseWeixinReply reply = baseWeixinReplyMapper.selectById(id);
		contentToArticle(reply);
		return reply;
	}

	@Override
	public int updateById(BaseWeixinReply reply) {
		return baseWeixinReplyMapper.updateById(reply);
	}

	@Override
	public int deleteById(Integer id) {
		return baseWeixinReplyMapper.deleteById(id);
	}

	@Override
	public List<BaseWeixinReply> findByPage(PageEntity<BaseWeixinReply> pageEntity) {
		List<BaseWeixinReply> list = baseWeixinReplyMapper.findByPage(pageEntity);
		for(BaseWeixinReply reply : list){
			contentToArticle(reply);
		}
		return list;
	}
	
	private void contentToArticle(BaseWeixinReply reply){
		if(reply != null && reply.getType() != null && reply.getType() == 2){
			reply.setArticles(JSonUtil.toArray(reply.getContent(), WeixinReplyArticle.class));
			reply.setContent(null);
		}
	}
	
	@Override
	public BaseWeixinReply findByKeyWord(String content) {
		BaseWeixinReply reply = baseWeixinReplyMapper.findByKeyWord(content);
		contentToArticle(reply);
		return reply;
	}

}
