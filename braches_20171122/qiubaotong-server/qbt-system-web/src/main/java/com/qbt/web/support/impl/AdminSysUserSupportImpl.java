package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RSAUtil;
import com.qbt.common.util.RandomProvider;
import com.qbt.common.util.SHA1Util;
import com.qbt.persistent.entity.SysPlat;
import com.qbt.persistent.entity.SysRole;
import com.qbt.persistent.entity.SysUser;
import com.qbt.persistent.entity.SysUserRole;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.SysPlatService;
import com.qbt.service.SysRoleService;
import com.qbt.service.SysUserRoleService;
import com.qbt.service.SysUserService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.sysRole.AdminSysRoleVO;
import com.qbt.web.pojo.sysuser.AdminSysUserVO;
import com.qbt.web.pojo.sysuser.AdminUserPageReqVo;
import com.qbt.web.pojo.sysuser.UserPassVo;
import com.qbt.web.support.AdminSysUserSupport;

@Service
public class AdminSysUserSupportImpl implements AdminSysUserSupport {
	
	@Value("${globalSalt}")
    public String globalSalt;
	@Value("${rsa.file}")
    private String rsafile;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysUserRoleService sysUserRoleService; 
	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysPlatService sysPlatService;
	@Resource
	private UserWeixinService userWeixinService;
	
	private static final String defaltPwd = "111111";
	
	@Override
	public List<AdminSysUserVO> list() {
		List<SysUser> sysUserList = sysUserService.list();
		List<AdminSysUserVO> adminSysUserVOList = new ArrayList<AdminSysUserVO>();
		AdminSysUserVO adminSysUserVO = null; 
		for (SysUser sysUser : sysUserList) {
			adminSysUserVO = BeanUtil.a2b(sysUser, AdminSysUserVO.class);
			adminSysUserVO.setPassword(null);
			adminSysUserVO.setSalt(null);
			adminSysUserVOList.add(adminSysUserVO);
		}
		return adminSysUserVOList;
	}

	@Override
	public int insert(AdminSysUserVO adminSysUserVO) throws BusinessException{
		String passSalt = RandomProvider.randomAlphanumericToLowerCase(10);
		String password;
		try {
			password = SHA1Util.SHA1Password(defaltPwd, globalSalt, passSalt);
			adminSysUserVO.setPassword(password);
		} catch (Exception e) {
			// try,用error
			throw new BusinessException(ErrorCodeEnum.ERROR_SYS.getCode(), "生成盐失败。");
		}
		SysUser sysUser = new SysUser();
		// 验证邮箱和手机是否重复
		sysUser.setMobile(adminSysUserVO.getMobile());
		List<SysUser> qryList = sysUserService.findByCondition(sysUser);
		if (Checker.isNotEmpty(qryList)) {
			throw new BusinessException("电话号码或邮箱已被使用");
		}
		sysUser.setSalt(passSalt);
		sysUser.setIsValidated(true);
		sysUser.setStatus(1);
		sysUser.setIsSuperUser(false);
		sysUser.setEmail(adminSysUserVO.getEmail());
		sysUser.setMobile(adminSysUserVO.getMobile());
		sysUser.setPassword(adminSysUserVO.getPassword());
		sysUser.setName(adminSysUserVO.getName());
		
		UserWeixin userWeixin = userWeixinService.findByOpenId(adminSysUserVO.getWxOpenId());
		if(userWeixin != null){
			sysUser.setWxUserId(userWeixin.getId());
			sysUser.setWxNickname(userWeixin.getNickname());
			sysUser.setWxOpenId(userWeixin.getOpenid());
		}
		
		sysUserService.insert(sysUser);
		// 校验roleIdList
		List<SysRole> roleList = sysRoleService.findByCondition(new SysRole());
		Map<String,SysRole> roleMap = new HashMap<String,SysRole>();
		for(SysRole role : roleList){
			roleMap.put(String.valueOf(role.getId()), role);
		}
		if (adminSysUserVO.getRoleIdList() != null) {
			for (Integer roleId : adminSysUserVO.getRoleIdList()) {
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setUserId(sysUser.getId());
				sysUserRole.setRoleId(roleId);
				SysRole roleDetail = roleMap.get(String.valueOf(roleId));
				sysUserRole.setPlatId(roleDetail.getPlatId());
				sysUserRole.setPlatName(roleDetail.getPlatName());
				sysUserRoleService.insert(sysUserRole);
			}
			return sysUser.getId();
		} else {
			return 0;
		}
	}
	
	@Override
	public boolean resetPwdByUserId(Integer userId) {
		SysUser user = sysUserService.selectById(userId);
		String password = null;
		try {
			password = SHA1Util.SHA1Password(defaltPwd, globalSalt, user.getSalt());
			user.setPassword(password);
			sysUserService.update(user);
		} catch (Exception e) {
			throw new BusinessException(ErrorCodeEnum.ERROR_SYS.getCode(), "生成盐失败。");
		}
		return true;
	}
	
	@Override
	public boolean updatePasswod(UserPassVo vo, SysUser sysUser) throws Exception{
		String newPassword = null;
		String password = null ;
		// RSA解密
		LogCvt.info("login old pwd:"+vo.getPassword()+",new pwd:"+vo.getNewPassword());
		RSAUtil.getKeyPair(rsafile);
		vo.setPassword(RSAUtil.decrypt(vo.getPassword()));
		vo.setNewPassword(RSAUtil.decrypt(vo.getNewPassword()));
		password = SHA1Util.SHA1Password(vo.getPassword(), globalSalt, sysUser.getSalt());
		newPassword = SHA1Util.SHA1Password(vo.getNewPassword(), globalSalt, sysUser.getSalt());
		
		if(sysUser.getPassword().equals(password)){
			SysUser user = sysUserService.findByMobile(sysUser.getMobile());
			user.setPassword(newPassword);
			sysUserService.update(user);
		}else{
			throw new BusinessException("密码不正确");
		}
		return true;
		
	}
	
	@Override
	public void delete(Integer id) {
		sysUserService.delete(id);
		sysUserRoleService.deleteBySysUserId(id);
	}

	@Override
	public void update(AdminSysUserVO adminSysUserVO) {
		SysUser sysUser = sysUserService.selectById(adminSysUserVO.getId());
		sysUser = BeanUtil.a2b(adminSysUserVO, SysUser.class);
		UserWeixin userWeixin = userWeixinService.findByOpenId(adminSysUserVO.getWxOpenId());
		if(userWeixin != null){
			sysUser.setWxUserId(userWeixin.getId());
			sysUser.setWxNickname(userWeixin.getNickname());
		}
		sysUserService.update(sysUser);
		if(adminSysUserVO.getRoleIdList() != null){
			List<SysRole> roleList = sysRoleService.findByCondition(new SysRole());
			Map<String,SysRole> roleMap = new HashMap<String,SysRole>();
			for(SysRole role : roleList){
				roleMap.put(String.valueOf(role.getId()), role);
			}
			sysUserRoleService.deleteBySysUserId(adminSysUserVO.getId());
			for (Integer roleId : adminSysUserVO.getRoleIdList()) {
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setUserId(adminSysUserVO.getId());
				sysUserRole.setRoleId(roleId);
				SysRole roleDetail = roleMap.get(String.valueOf(roleId));
				sysUserRole.setPlatId(roleDetail.getPlatId());
				sysUserRole.setPlatName(roleDetail.getPlatName());
				sysUserRoleService.insert(sysUserRole);
			}
		}
	}

	@Override
	public List<AdminSysUserVO> findByPage(AdminUserPageReqVo reqVo) {
		PageEntity<SysUser> pageEntity = BeanUtil.pageConvert(reqVo, SysUser.class);
		List<SysUser> list = sysUserService.findByPage(pageEntity);
		List<AdminSysUserVO> voList = BeanUtil.list2list(list, AdminSysUserVO.class);
		for (AdminSysUserVO adminSysUserVO : voList) {
			adminSysUserVO.setPassword(null);
			adminSysUserVO.setSalt(null);
			List<SysUserRole> sysUserRoleList = sysUserRoleService.findListBySysUserId(adminSysUserVO.getId());
			List<Integer> roleIdList = new ArrayList<Integer>();
			for (SysUserRole sysUserRole : sysUserRoleList) {
				roleIdList.add(sysUserRole.getRoleId());
			}
			adminSysUserVO.setRoleIdList(roleIdList);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public List<AdminSysRoleVO> findRoleListById(Integer id) {
		List<SysUserRole> sysUserRoleList = sysUserRoleService.findListBySysUserId(id);
		List<AdminSysRoleVO> adminSysRoleVOList = new ArrayList<AdminSysRoleVO>();
		for (SysUserRole sysUserRole : sysUserRoleList) {
			SysRole sysRole = sysRoleService.get(sysUserRole.getRoleId());
			AdminSysRoleVO adminSysRoleVO = BeanUtil.a2b(sysRole, AdminSysRoleVO.class);
			adminSysRoleVOList.add(adminSysRoleVO);
		}
		return adminSysRoleVOList;
	}

	@Override
	public List<SysPlat> findPlatListById(Integer id) {
		List<SysUserRole> sysUserRoleList = sysUserRoleService.findListBySysUserId(id);
		List<SysPlat> sysPlatList = new ArrayList<SysPlat>();
		for (SysUserRole sysUserRole : sysUserRoleList) {
			SysPlat sysPlat = sysPlatService.get(sysUserRole.getPlatId());
			sysPlatList.add(sysPlat);
		}
		return sysPlatList;
	}

	@Override
	public AdminSysUserVO findById(Integer id) {
		SysUser sysUser = sysUserService.selectById(id);
		AdminSysUserVO adminSysUserVO = BeanUtil.a2b(sysUser, AdminSysUserVO.class);
		return adminSysUserVO;
	}

	@Override
	public List<AdminSysUserVO> listUserByRoleId(int roleId) {
		List<SysUser> sysUserList = sysUserService.listUserByRoleId(roleId);
		List<AdminSysUserVO> adminSysUserVOList = new ArrayList<AdminSysUserVO>();
		AdminSysUserVO adminSysUserVO = null; 
		for (SysUser sysUser : sysUserList) {
			adminSysUserVO = BeanUtil.a2b(sysUser, AdminSysUserVO.class);
			adminSysUserVO.setPassword(null);
			adminSysUserVO.setSalt(null);
			adminSysUserVOList.add(adminSysUserVO);
		}
		return adminSysUserVOList;
	}

}
