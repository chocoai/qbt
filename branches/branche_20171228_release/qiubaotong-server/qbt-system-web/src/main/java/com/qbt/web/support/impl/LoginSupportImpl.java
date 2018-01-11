package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RSAUtil;
import com.qbt.common.util.SHA1Util;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.SysUserService;
import com.qbt.web.pojo.login.LoginReqVo;
import com.qbt.web.pojo.login.LoginRespVo;
import com.qbt.web.support.LoginSupport;

@Service
public class LoginSupportImpl implements LoginSupport {
	
	@Value("${globalSalt}")
    private String globalSalt;
	
	@Value("${rsa.file}")
    private String rsafile;
	
	@Resource
	private SysUserService sysUserService;
	
	@Override
	public SysUser tokenCheck(String token) {
		return sysUserService.tokenCheck(token);
	}

	@Override
	public void logout(String token) {
		sysUserService.logout(token);
	}

	@Override
	public LoginRespVo login(LoginReqVo reqVo) throws BusinessException, Exception {
		SysUser sysUser = sysUserService.findByMobile(reqVo.getMobile());
		//查询不到用户
		if(Checker.isEmpty(sysUser)){
			throw new BusinessException(ErrorCodeEnum.ERROR_SYS_USER_NOT_EXST);
		}
		//用户被禁用
		if(1 != sysUser.getStatus()){
			throw new BusinessException(ErrorCodeEnum.ERROR_SYS_USER_IS_DELETE);
		}
		
		// RSA解密
		LogCvt.info("login pwd:"+reqVo.getPwd());
		RSAUtil.getKeyPair(rsafile);
		String pwd = RSAUtil.decrypt(reqVo.getPwd());
		
		//用户密码错误
		String dePwd = SHA1Util.SHA1Password(pwd, globalSalt, sysUser.getSalt());
		if(!StringUtils.equals(sysUser.getPassword(), dePwd)){
			throw new BusinessException(ErrorCodeEnum.ERROR_SYS_USER_PWD);
		}
		
		String token = sysUserService.login(sysUser.getId());
		LoginRespVo vo = new LoginRespVo();
		vo.setUserId(sysUser.getId());
		vo.setName(sysUser.getName());
		vo.setEmail(sysUser.getEmail());
		vo.setMobile(sysUser.getMobile());
		vo.setIsSuperUser(sysUser.getIsSuperUser());
		vo.setIsValidated(sysUser.getIsValidated());
		vo.setStatus(sysUser.getStatus());
		vo.setToken(token);
		List<Integer> platIdList =  sysUserService.getPlatId(reqVo.getMobile());
		if(platIdList != null){
			vo.setPlatIdList(platIdList);
		}
		return vo;
	}

}
