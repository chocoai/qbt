package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.SysRoleResource;

public interface SysRoleResourceSupport {

	List<SysRoleResource> listByRoleId(int roleId);

}
