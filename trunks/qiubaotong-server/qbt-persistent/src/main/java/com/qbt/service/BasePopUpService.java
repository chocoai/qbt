/**
 * Project Name:qbt-persistent
 * File Name:BasePopUpService.java
 * Package Name:com.qbt.service
 * Date:2017年1月16日下午4:42:25
 *
*/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BasePopUp;

/**
 * ClassName:BasePopUpService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月16日 下午4:42:25
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BasePopUpService {
	
	int insert(BasePopUp basePopUp);

    BasePopUp findById(Integer id);

    int updateById(BasePopUp basePopUp);
    
    int deleteById(Integer id);
    
    List<BasePopUp> findByPage(PageEntity<BasePopUp> pageEntity);

	List<BasePopUp> query(BasePopUp popUp); 
}
