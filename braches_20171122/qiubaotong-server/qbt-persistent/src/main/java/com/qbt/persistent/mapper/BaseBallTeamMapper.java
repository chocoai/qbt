package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBallTeam;

public interface BaseBallTeamMapper {
    int insert(BaseBallTeam record);

    int insertSelective(BaseBallTeam record);

    BaseBallTeam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseBallTeam record);

    int updateByPrimaryKey(BaseBallTeam record);

	List<BaseBallTeam> findByPage(PageEntity<BaseBallTeam> pageEntity);

	BaseBallTeam findById(Integer id);

	void deleteById(Integer id);
}