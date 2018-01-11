/**
 * Project Name:qbt-system-web
 * File Name:WeixinReplySupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年2月6日下午3:27:49
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.persistent.entity.BaseWeixinReply;
import com.qbt.service.BaseWeixinReplyService;
import com.qbt.web.pojo.weixinReply.WeixinReplyPageReqVo;
import com.qbt.web.pojo.weixinReply.WeixinReplyVo;
import com.qbt.web.support.WeixinReplySupport;

/**
 * ClassName:WeixinReplySupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月6日 下午3:27:49
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class WeixinReplySupportImpl implements WeixinReplySupport {
	
	@Resource
	private BaseWeixinReplyService baseWeixinReplyService;
	
	@Override
	public int add(WeixinReplyVo vo) {
		BaseWeixinReply reply = BeanUtil.a2b(vo, BaseWeixinReply.class);
		if(vo.getType() == 2){
			//图文类型, 转换图文对象信息
			reply.setContent(JSonUtil.toJSonString(vo.getArticles()));
		}
		reply.setStatus(1);
		return baseWeixinReplyService.insert(reply);
	}

	@Override
	public List<WeixinReplyVo> findByPage(WeixinReplyPageReqVo reqVo) {
		PageEntity<BaseWeixinReply> pageEntity = BeanUtil.pageConvert(reqVo, BaseWeixinReply.class);
		List<BaseWeixinReply> list = baseWeixinReplyService.findByPage(pageEntity);
		List<WeixinReplyVo> voList = BeanUtil.list2list(list, WeixinReplyVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public WeixinReplyVo detail(Integer id) {
		WeixinReplyVo vo = new WeixinReplyVo();
		BaseWeixinReply reply = baseWeixinReplyService.findById(id);
		if(Checker.isNotEmpty(reply)){
			vo = BeanUtil.a2b(reply, WeixinReplyVo.class);
		}
		return vo;
	}

	@Override
	public boolean update(WeixinReplyVo vo) {
		BaseWeixinReply dbReply = baseWeixinReplyService.findById(vo.getId());
		if(Checker.isEmpty(dbReply)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效微信回复信息");
		}
		
		BaseWeixinReply reply = BeanUtil.a2b(vo, BaseWeixinReply.class);
		if(vo.getType() == 2){
			//图文类型, 转换图文对象信息
			reply.setContent(JSonUtil.toJSonString(vo.getArticles()));
		}
		
		return baseWeixinReplyService.updateById(reply) > 0;
	}

	@Override
	public boolean updateStatus(WeixinReplyVo vo) {
		BaseWeixinReply dbReply = baseWeixinReplyService.findById(vo.getId());
		if(Checker.isEmpty(dbReply)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效微信回复信息");
		}
		
		BaseWeixinReply reply = new BaseWeixinReply();
		reply.setId(vo.getId());
		reply.setStatus(vo.getStatus());
		
		return baseWeixinReplyService.updateById(reply) > 0;
	}

	@Override
	public boolean delete(Integer id) {
		return baseWeixinReplyService.deleteById(id) > 0;
	}

}
