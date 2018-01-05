package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipInfo;

public interface VipInfoMapper {
	
    int insert(VipInfo vipInfo);

    VipInfo selectById(@Param("id")Integer id);

    int updateById(VipInfo vipInfo);

    List<VipInfo> selectByOpenId(@Param("openId")String openId);
    
    List<VipInfo> findByPage(PageEntity<VipInfo> pageEntity);
    
    List<VipInfo> selectByMobile(@Param("mobile")String mobile);

	int updateMobile(VipInfo vipInfo);

	int updateUserName(VipInfo vipInfo);

	int updateUsedOrder(VipInfo vipInfo);

	VipInfo findBestByOpenId(String openId);
	
	int updateImg(VipInfo vipInfo);
	
	List<VipInfo> selectByImageIds(@Param("imageIds")List<Integer> imageIds);

	List<VipInfo> findByUserId(int userId);
	
	List<String> findAllVipNo();
}