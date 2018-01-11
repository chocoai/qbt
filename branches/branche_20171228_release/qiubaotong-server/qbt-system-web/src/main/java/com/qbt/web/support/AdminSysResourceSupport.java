package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.persistent.entity.SysResource;
import com.qbt.web.pojo.sysResource.AdminSysResourceVO;
import com.qbt.web.pojo.sysResource.SysResourcePageReqVo;

public interface AdminSysResourceSupport {
	
	public List<AdminSysResourceVO> list();

	public void delete(Integer id);

	public void insert(AdminSysResourceVO vo) throws BusinessException;

	public void update(SysResource sysRecource);

	public List<AdminSysResourceVO> findByPage(SysResourcePageReqVo reqVo);

	public List<AdminSysResourceVO> listByUserId(Integer userId, Integer platId);
	            
}
