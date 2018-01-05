package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserActivityPackage;

public interface UserActivityPackageMapper {
	
    int insert(UserActivityPackage record);

    UserActivityPackage selectById(Integer id);

    int updateById(UserActivityPackage record);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<UserActivityPackage> findByPage(PageEntity<UserActivityPackage> pageEntity);
    
    Object findOrderDetailIdByPackageId(int packageId);
    
}