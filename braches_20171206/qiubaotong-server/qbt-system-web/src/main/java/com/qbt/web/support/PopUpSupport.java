/**
 * Project Name:qbt-system-web
 * File Name:PopUpSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年1月17日上午10:00:56
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.popUp.PopUpDetailVo;
import com.qbt.web.pojo.popUp.PopUpPageReqVo;
import com.qbt.web.pojo.popUp.PopUpVo;

/**
 * ClassName:PopUpSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月17日 上午10:00:56
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface PopUpSupport {
	
	List<PopUpVo> findByPage(PopUpPageReqVo reqVo);
	
	PopUpDetailVo detail(Integer id);
	
	boolean add(PopUpDetailVo vo);
	
	boolean update(PopUpDetailVo vo);
	
	boolean delete(Integer id);
	
	boolean updateStatus(PopUpVo vo);
}
