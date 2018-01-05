package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseBallTeam.BaseBallTeamPageReqVo;
import com.qbt.web.pojo.baseBallTeam.BaseBallTeamVo;

public interface BaseBallTeamSupport {

	List<BaseBallTeamVo> findByPage(BaseBallTeamPageReqVo reqVo);

	void add(BaseBallTeamVo vo);

	void updateById(BaseBallTeamVo vo);

	BaseBallTeamVo findById(Integer id);

	void deleteById(Integer id);

}
