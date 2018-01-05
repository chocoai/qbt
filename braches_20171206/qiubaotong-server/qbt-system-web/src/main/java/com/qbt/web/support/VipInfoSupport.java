/**
 * Project Name:qbt-system-web
 * File Name:VipInfoSupport.java
 * Package Name:com.qbt.web.support
 * Date:2016年11月3日下午5:39:26
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.userImage.UserImageAppointVo;
import com.qbt.web.pojo.vipInfo.ActivateRequest;
import com.qbt.web.pojo.vipInfo.VipInfoPageReqVo;
import com.qbt.web.pojo.vipInfo.VipInfoVo;
import com.qbt.web.pojo.vipInfo.VipUserModifyRequest;

/**
 * ClassName:VipInfoSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月3日 下午5:39:26
 * @author   haungyihao
 * @version  
 * @see 	 
 */
public interface VipInfoSupport {
	
	/**
	 * 
	 * findByPage:(vip会员分页查询).
	 *
	 * @author haungyihao
	 * 2016年11月3日 下午5:44:58
	 * @param reqVo
	 * @return
	 *
	 */
	List<VipInfoVo> findByPage(VipInfoPageReqVo reqVo);
	
	/**
	 * 
	 * detail:(vip会员信息详情).
	 *
	 * @author haungyihao
	 * 2016年11月4日 上午11:39:40
	 * @param id
	 * @return
	 *
	 */
	VipInfoVo detail(Integer id);
	
	/**
	 * 
	 * updateStatus:(启用/禁用vip会员).
	 *
	 * @author haungyihao
	 * 2016年11月3日 下午5:51:59
	 * @param id
	 * @param status 1-正常 2-禁用
	 * @return
	 *
	 */
	boolean updateStatus(Integer id, Integer status);
	
	
	boolean addVipInfo(VipInfoVo vipInfoVo);

	/**
	 *  会员卡激活
	  * @Title: activate
	  * @Description: TODO
	  * @author: share 2017年1月5日
	  * @modify: share 2017年1月5日
	  * @param req
	 */
	void activate(ActivateRequest req);

	/**
	 *  修改手机号或用户名
	  * @Title: modify
	  * @Description: TODO
	  * @author: share 2017年1月5日
	  * @modify: share 2017年1月5日
	  * @param req
	 */
	void modify(VipUserModifyRequest req);
	
	/**
	 * 更新指定球包图片
	 * @Title: updateAppointImage
	 * @author: wuwang 2017年1月11日
	 * @param vo
	 */
	void updateAppointImage(UserImageAppointVo vo);

	
	/**
	 * 绑定微信用户
	 * @Title: updateUserWeixin
	 * @author: wuwang 2017年1月12日
	 * @param userId
	 */
	void updateUserWeixin(Integer userId, Integer id);

	/**
	 * 删除指定球包图片
	 * @author: wuwang 2017年1月12日
	 * @param id
	 */
	void deleteAppointImage(Integer id);

}
