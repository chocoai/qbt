package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BaseSfExpressLogDto;
import com.qbt.persistent.entity.BaseSfExpressLog;

/**
 * ClassName:BaseSfExpressLogService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月6日 下午6:08:25
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BaseSfExpressLogService {
	
	int insert(BaseSfExpressLog baseSfExpressLog);

    BaseSfExpressLog findById(Integer id);

    int updateById(BaseSfExpressLog baseSfExpressLog);
    
    List<BaseSfExpressLog> findByPage(PageEntity<BaseSfExpressLogDto> pageEntity);
    
    int deleteByDay(int day);
}
