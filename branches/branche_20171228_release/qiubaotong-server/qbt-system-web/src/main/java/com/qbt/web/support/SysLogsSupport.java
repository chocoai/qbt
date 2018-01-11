package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.sysLogs.SysLogsPageReqVo;
import com.qbt.web.pojo.sysLogs.SysLogsVo;

public interface SysLogsSupport {

	public void delete(Integer id);

	public void insert(SysLogsVo vo);

	public void updateById(SysLogsVo vo);

	public List<SysLogsVo> findByPage(SysLogsPageReqVo reqVo);
}
