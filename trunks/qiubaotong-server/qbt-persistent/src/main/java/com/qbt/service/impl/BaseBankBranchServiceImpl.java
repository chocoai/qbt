package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseBankBranch;
import com.qbt.persistent.mapper.BaseBankBranchMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseBankBranchService;
@Service
public class BaseBankBranchServiceImpl implements BaseBankBranchService{
	
	@Resource
	private BaseBankBranchMapper baseBankBranchMapper; 
	
	@Resource
	private RedisService redisService;
	
	@Override
	public List<BaseBankBranch> findList() {
		return baseBankBranchMapper.findList();
	}

	@Override
	public BaseBankBranch findById(int id) {
		String key = RedisKeyUtil.base_bank_branch_id_key(id);
		BaseBankBranch baseBankBranch = RedisUtil.getByRedis(redisService.getMap(key), BaseBankBranch.class);
		if(Checker.isEmpty(baseBankBranch)){
			baseBankBranch = baseBankBranchMapper.findById(id);
			if(Checker.isNotEmpty(baseBankBranch)){
				redisService.putMap(key, RedisUtil.hashsMap(baseBankBranch));
			}
		}
		return baseBankBranch;
	}

	@Override
	public List<BaseBankBranch> findByPage(PageEntity<BaseBankBranch> pageEntity) {
		return baseBankBranchMapper.findByPage(pageEntity);
	}

	@Override
	public void add(BaseBankBranch baseBankBranch) {
		baseBankBranchMapper.insert(baseBankBranch);
		//更新redis
		String key = RedisKeyUtil.base_bank_branch_id_key(baseBankBranch.getId());
		redisService.putMap(key, RedisUtil.hashsMap(baseBankBranch));
	}

	@Override
	public void udateById(BaseBankBranch baseBankBranch) {
		int result = baseBankBranchMapper.updateById(baseBankBranch);
		if(result > 0 ){
			redisService.del(RedisKeyUtil.base_bank_branch_id_key(baseBankBranch.getId()));
			this.findById(baseBankBranch.getId());
		}
	}

	@Override
	public List<BaseBankBranch> findByCondition(BaseBankBranch condition) {
		return baseBankBranchMapper.findByCondition(condition);
	}

	@Override
	public List<BaseBankBranch> list() {
		return baseBankBranchMapper.list();
	}

	@Override
	public void deleteById(Integer id) {
		baseBankBranchMapper.deleteById(id);
		redisService.del(RedisKeyUtil.base_bank_branch_id_key(id));
	}

	@Override
	public int delete(Integer id, Boolean isDelete) {
		int result = baseBankBranchMapper.delete(id, isDelete);
		if(result > 0 ){
			redisService.del(RedisKeyUtil.base_bank_branch_id_key(id));
			this.findById(id);
		}
		return result;
	}

}
