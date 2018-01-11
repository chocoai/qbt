package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Activity;

public interface ActivityMapper {
	
    int insert(Activity record);

    Activity selectById(Integer id);

    int updateById(Activity record);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<Activity> findByPage(PageEntity<Activity> pageEntity);
    
    /**
     * 根据条件查询
     * @param activity
     * @return
     */
    List<Activity> findByCondition(Activity activity);
    
    /**
     * 根据活动名称或者暗号查询
     * @param activity
     * @return
     */
    int isExist(@Param("name")String name, @Param("code")String code);
    
    List<Activity> findCurrentCouponActivity(@Param("type")Integer type);
}