package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.OrgGroupUserDto;
import com.qbt.persistent.entity.OrgGroupUser;

public interface OrgGroupUserMapper {
	
    int insert(OrgGroupUser orgGroupUser);

    OrgGroupUser selectById(Integer id);

    int updateById(OrgGroupUser orgGroupUser);
    
    List<OrgGroupUser> findByPage(PageEntity<OrgGroupUserDto> pageEntity);
    
    int deleteByBatch(@Param("ids")List<Integer> ids);
    
    int insertByBatch(@Param("users")List<OrgGroupUser> users);
    
    int exists(OrgGroupUser orgGroupUser);
    
    int deleteByOrgId(@Param("orgId")Integer orgId);

    OrgGroupUser findByNameAndMobile(@Param("name")String name, @Param("mobile")String mobile);
}