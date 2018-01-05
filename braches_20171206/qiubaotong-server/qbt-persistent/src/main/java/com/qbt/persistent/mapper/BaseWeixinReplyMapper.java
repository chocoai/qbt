package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseWeixinReply;

public interface BaseWeixinReplyMapper {
	
    int insert(BaseWeixinReply record);

    BaseWeixinReply selectById(Integer id);

    int updateById(BaseWeixinReply record);
    
    int deleteById(Integer id);
    
    List<BaseWeixinReply> findByPage(PageEntity<BaseWeixinReply> pageEntity);

	BaseWeixinReply findByKeyWord(String keyWord);
}