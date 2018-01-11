package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.SysResource;
import com.qbt.service.SysResourceService;
import com.qbt.web.pojo.sysResource.AdminSysResourceVO;
import com.qbt.web.pojo.sysResource.SysResourcePageReqVo;
import com.qbt.web.support.AdminSysResourceSupport;

@Service
public class AdminSysResourceSupportImpl implements AdminSysResourceSupport{

	@Resource
	private SysResourceService sysResourceService;
	
	@Override
	public List<AdminSysResourceVO> list() {
		List<SysResource> sysResourceList = sysResourceService.list();
		List<AdminSysResourceVO> voList = BeanUtil.list2list(sysResourceList, AdminSysResourceVO.class);
		 Map<Integer, AdminSysResourceVO> map = new TreeMap<Integer, AdminSysResourceVO>();
		    for(AdminSysResourceVO v : voList){
		      map.put(v.getId(), v);
		    }
		    f2(map);
		    List<AdminSysResourceVO> VoList2 = new ArrayList<AdminSysResourceVO>();
		    for(Integer k : map.keySet()){
			      AdminSysResourceVO v = map.get(k);
			      VoList2.add(v);
			      }
		    
		    return VoList2;
	}

	@Override
	public void delete(Integer id) {
		sysResourceService.delete(id);
		List<SysResource> sysResourceList = sysResourceService.getSysResourceListById(id);
		for (SysResource sysResource : sysResourceList) {
			sysResourceService.delete(sysResource.getId());
			List<SysResource> sysResourceListThree = sysResourceService.getSysResourceListById(sysResource.getId());
			for (SysResource sysResource2 : sysResourceListThree) {
				sysResourceService.delete(sysResource2.getId());
			}
		}
	}

	@Override
	public void insert(AdminSysResourceVO vo) throws BusinessException{
		SysResource condition = new SysResource();
		condition.setName(vo.getName());
		List<SysResource> qryList = sysResourceService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("名称已被使用");
		}
		SysResource sysResource = BeanUtil.a2b(vo, SysResource.class);
		sysResource.setPlatId(1);
		sysResource.setType(1);
		sysResource.setStatus(1);
		sysResourceService.intsert(sysResource);		
	}
	
	@Override
	public void update(SysResource sysResource) {
		SysResource sysResource2 = sysResourceService.get(sysResource.getId());
		sysResource2.setName(sysResource.getName());
		sysResource2.setUrl(sysResource.getUrl());
		sysResource2.setIoc(sysResource.getIoc());
		sysResourceService.update(sysResource2);
	}

	@Override
	public List<AdminSysResourceVO> findByPage(SysResourcePageReqVo reqVo) {
		PageEntity<SysResource> pageEntity = BeanUtil.pageConvert(reqVo, SysResource.class);
		List<SysResource> list = sysResourceService.findByPage(pageEntity);
		List<AdminSysResourceVO> voList = BeanUtil.list2list(list, AdminSysResourceVO.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public List<AdminSysResourceVO> listByUserId(Integer userId, Integer platId) {
		List<SysResource>  sysResourceList =  sysResourceService.listByUserId(userId,platId);
		List<AdminSysResourceVO>  VoList = BeanUtil.list2list(sysResourceList, AdminSysResourceVO.class);
		  Map<Integer, AdminSysResourceVO> map = new TreeMap<Integer, AdminSysResourceVO>();
		    for(AdminSysResourceVO v : VoList){
		      map.put(v.getId(), v);
		    }
		    f1(map);
		    
		    List<AdminSysResourceVO> VoList2 = new ArrayList<AdminSysResourceVO>();
		    for(Integer k : map.keySet()){
			      AdminSysResourceVO v = map.get(k);
			      VoList2.add(v);
			      }
		    
		    return VoList2;
		
	}
	
	//处理返回结果是树状结构的map
	  private static void f1(Map<Integer, AdminSysResourceVO> map){
	    for(Integer k : map.keySet()){
	      AdminSysResourceVO v = map.get(k);
	      if(v.getSuperId() == 0){
	    	//superId==0则是父级，越过不用处理
	        continue;
	      }
	      AdminSysResourceVO superVo = map.get(v.getSuperId());
	      List<AdminSysResourceVO> list = null;
	      if(superVo != null){
	        list = superVo.getItem() == null ? new ArrayList<AdminSysResourceVO>() : superVo.getItem();
	        list.add(v);
	        superVo.setItem(list);
	      }
	    }
	    
	    Iterator<Entry<Integer, AdminSysResourceVO>> it = map.entrySet().iterator();
	    while(it.hasNext()){
	      Map.Entry<Integer, AdminSysResourceVO> entry=it.next();
	      AdminSysResourceVO v = entry.getValue();
	      if(v.getSuperId() != 0){
	        it.remove();
	      }
	    }
	    
	  }
	  
	  //返回没有树状结构的map
	  private static void f2(Map<Integer, AdminSysResourceVO> map){
		  for(Integer k : map.keySet()){
		      AdminSysResourceVO v = map.get(k);
		      if(v.getSuperId() == 0){
		    	//superId==0则是父级，越过不用处理
		        continue;
		      }
		      AdminSysResourceVO superVo = map.get(v.getSuperId());
		      List<AdminSysResourceVO> list = null;
		      if(superVo != null){
		        list = superVo.getItem() == null ? new ArrayList<AdminSysResourceVO>() : superVo.getItem();
		        list.add(v);
		        superVo.setItem(list);
		      }
		    }
		  }
	  
	 
	
}

