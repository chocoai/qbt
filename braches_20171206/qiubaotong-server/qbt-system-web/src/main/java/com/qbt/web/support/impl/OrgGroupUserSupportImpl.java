/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupUserSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年8月2日上午10:42:50
 *
*/

package com.qbt.web.support.impl;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.ExcelUtil;
import com.qbt.common.util.FileUploadUtils;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.dto.OrgGroupUserDto;
import com.qbt.persistent.entity.OrgGroup;
import com.qbt.persistent.entity.OrgGroupUser;
import com.qbt.persistent.entity.SysUser;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.OrgGroupService;
import com.qbt.service.OrgGroupUserService;
import com.qbt.web.pojo.common.ImportRespVo;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserImportReq;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserPageReq;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserVo;
import com.qbt.web.support.OrgGroupUserSupport;

/**
 * ClassName:OrgGroupUserSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月2日 上午10:42:50
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrgGroupUserSupportImpl implements OrgGroupUserSupport {
	
	@Resource
	private OrgGroupUserService orgGroupUserService;
	
	@Resource
	private OrgGroupService orgGroupService;
	
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Override
	public List<OrgGroupUserVo> findByPage(OrgGroupUserPageReq reqVo) {
		PageEntity<OrgGroupUserDto> pageEntity = BeanUtil.pageConvert(reqVo, OrgGroupUserDto.class);
		List<OrgGroupUser> list = orgGroupUserService.findByPage(pageEntity);
		List<OrgGroupUserVo> voList = BeanUtil.list2list(list, OrgGroupUserVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public OrgGroupUserVo detail(Integer id) {
		OrgGroupUser user = orgGroupUserService.selectById(id);
		OrgGroupUserVo vo = BeanUtil.a2b(user, OrgGroupUserVo.class);
		return vo;
	}

	@Override
	public int add(OrgGroupUserVo vo, SysUser sysUser) {
		OrgGroupUser user = BeanUtil.a2b(vo, OrgGroupUser.class);
		int existsCount = orgGroupUserService.exists(user);
		if(existsCount > 0) {
			throw new BusinessException("用户已存在");
		}
		OrgGroup org = orgGroupService.selectById(vo.getOrgId());
		if(Checker.isEmpty(org)) {
			throw new BusinessException("机构不存在");
		}
		user.setStatus(1);
		user.setOrgName(org.getName());
		user.setOperatorId(sysUser.getId());
		user.setOperatorName(sysUser.getName());
		int result = orgGroupUserService.insert(user);
		return result;
	}

	@Override
	public boolean update(OrgGroupUserVo vo, SysUser sysUser) {
		OrgGroupUser user = BeanUtil.a2b(vo, OrgGroupUser.class);
		int existsCount = orgGroupUserService.exists(user);
		if(existsCount > 0) {
			throw new BusinessException("用户已存在");
		}
		user.setOperatorId(sysUser.getId());
		user.setOperatorName(sysUser.getName());
		int result = orgGroupUserService.updateById(user);
		return result > 0;
	}

	@Override
	public boolean delete(List<Integer> ids) {
		return orgGroupUserService.deleteByBatch(ids) > 0;
	}

	@Override
	public ImportRespVo importFile(OrgGroupUserImportReq importReq, SysUser sysUser) throws Exception {
		ImportRespVo respVo = new ImportRespVo();
		String localFile = null;
		int totalCount = 0;
		int succCount = 0;
		int failCount = 0;
		
		OrgGroup org = orgGroupService.selectById(importReq.getOrgId());
		if(Checker.isEmpty(org)) {
			throw new BusinessException("机构不存在");
		}
		try {
			localFile = fileuploadScpService.excelDownloadFromScp(importReq.getExcel());
			
			// 解析excel文件
			ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
			ExcelUtil.setNf(new DecimalFormat("0"));
			result = ExcelUtil.readExcel(new File(localFile));
			
			List<OrgGroupUser> userList = new ArrayList<OrgGroupUser>();
			if(Checker.isNotEmpty(result)){
				totalCount = result.size() - 1;//第一行是标题
				for(int i = 1; i < result.size(); i++){
					ArrayList<Object> data = result.get(i);
					// 记录转对象储存
					OrgGroupUserVo vo = dataToRecord(data, org);
					try {
						// 数据校验
						VlidationUtil.validate(vo);
						OrgGroupUser user = BeanUtil.a2b(vo, OrgGroupUser.class);
						if(StringUtils.isBlank(vo.getName())||StringUtils.isBlank(vo.getMobile())){
							continue;
						}
						int existsCount = orgGroupUserService.exists(user);
						if(existsCount > 0) {
							throw new BusinessException("第" + i +"条用户已存在");
						}
						user.setStatus(1);
						user.setOperatorId(sysUser.getId());
						user.setOperatorName(sysUser.getName());
						userList.add(user);
					} catch (ValidationException e) {
						failCount++;
						continue;
					} catch (BusinessException e) {
						failCount++;
						continue;
					}
				}
				succCount = userList.size();
				if(Checker.isNotEmpty(userList)) {
					orgGroupUserService.insertByBatch(userList);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if(localFile != null){
				FileUploadUtils.delFiles(localFile);
			}
		}
		respVo.setTotalCount(totalCount);
		respVo.setSuccCount(succCount);
		respVo.setFailCount(failCount);
		return respVo;
	}

	private OrgGroupUserVo dataToRecord(ArrayList<Object> data, OrgGroup org) {
		OrgGroupUserVo vo = new OrgGroupUserVo();
		for(int i = 0; i < data.size(); i++){
			switch (i) {
			case 0:
				//姓名
				vo.setName(data.get(i).toString());
				break;
			case 1:
				//手机号
				vo.setMobile(data.get(i).toString());
				break;
			default:
				break;
			}
		}
		vo.setOrgId(org.getId());
		vo.setOrgName(org.getName());
		return vo;
	}
	
	
	
}
