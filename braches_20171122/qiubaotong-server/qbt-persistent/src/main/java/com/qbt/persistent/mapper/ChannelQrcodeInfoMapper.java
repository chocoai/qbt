package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ChannelQrcodeInfo;

public interface ChannelQrcodeInfoMapper {
	
    int insert(ChannelQrcodeInfo record);

    ChannelQrcodeInfo findById(Integer id);

    int updateById(ChannelQrcodeInfo record);

	List<ChannelQrcodeInfo> findByPage(PageEntity<ChannelQrcodeInfo> pageEntity);

	void updateStatus(@Param("id")Integer id, @Param("status")int status);

	ChannelQrcodeInfo findByChannelQrcodeCode(String channelQrcodeCode);
	
	List<String> findAllChannelQrcodeCode();
	
}