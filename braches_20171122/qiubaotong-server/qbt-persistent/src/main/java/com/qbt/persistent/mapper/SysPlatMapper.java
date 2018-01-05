package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.SysPlat;

public interface SysPlatMapper {
    int insert(SysPlat record);

    int insertSelective(SysPlat record);

    SysPlat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPlat record);

    int updateByPrimaryKey(SysPlat record);

	SysPlat get(int id);

	List<SysPlat> list();
}