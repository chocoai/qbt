package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleUserDto;
import com.qbt.persistent.entity.SaleUser;

public interface SaleUserMapper {
	
    int insert(SaleUser record);

    SaleUser findById(Integer id);
    
    SaleUser findByCode(@Param("code")String code);

    int updateById(SaleUser record);
    
    SaleUser findByUserId(@Param("userId")Integer userId);
    
    List<SaleUserDto> findByPage(PageEntity<SaleUserDto> pageEntity);
    
    int updateForBoss(SaleUser record);
    
    int udpateBatch(SaleUserDto dto);
    
    int existCode(@Param("userId")Integer userId, @Param("code")String code);
    
    int updateForWechatApply(SaleUser record);
    
    int auditSaleUser(SaleUser record);

    List<SaleUser> listByApplyStatus(Integer applyStatus);
}