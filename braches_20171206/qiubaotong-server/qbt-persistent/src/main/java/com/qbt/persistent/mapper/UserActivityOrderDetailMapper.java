package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityOrderDetail;
import com.qbt.persistent.entity.UserActivityPackage;

public interface UserActivityOrderDetailMapper {
	
    int insert(UserActivityOrderDetail record);

    UserActivityOrderDetail selectById(Integer id);

    int updateById(UserActivityOrderDetail record);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<UserActivityOrderDetail> findByPage(PageEntity<UserActivityOrderDetail> pageEntity);
    
    List<UserActivityPackage> findlistUsed(@Param("userId")int userId,@Param("sysdatetime")String sysdatetime);
    
    List<UserActivityPackage> findlistNotActive(int userId);
}