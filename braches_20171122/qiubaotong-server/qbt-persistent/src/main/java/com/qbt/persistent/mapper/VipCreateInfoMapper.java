package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipCreateInfo;

public interface VipCreateInfoMapper {
	
    int insert(VipCreateInfo record);

    VipCreateInfo selectById(Integer id);

    int updateById(VipCreateInfo record);
    
    int insertBatch(@Param("infos")List<VipCreateInfo> infos);
    
    List<VipCreateInfo> findByPage(PageEntity<VipCreateInfo> pageEntity);

	VipCreateInfo findByVipNo(@Param("vipNo")String vipNo, @Param("random")String random);

	int updateActivate(@Param("vipNo")String vipNo, @Param("random")String random, @Param("activateMethod")int activateMethod);
    
	int updateBatch(VipCreateInfo record);
	
	List<VipCreateInfo> selectByIds(@Param("ids")List<Integer> ids);
	
	List<String> findAllVipNo();
}