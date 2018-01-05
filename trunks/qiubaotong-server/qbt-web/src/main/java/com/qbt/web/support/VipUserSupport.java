
 /**
 * @Title: VipUserSupport.java
 * @Package com.qbt.web.support
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater Administrator 2016年11月3日
 * @version V1.0
 **/

package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.VipPayment;
import com.qbt.persistent.entity.VipType;
import com.qbt.web.pojo.vip.ActivateRequest;
import com.qbt.web.pojo.vip.VipTypeVo;
import com.qbt.web.pojo.vip.VipUser;
import com.qbt.web.pojo.vip.VipUserModifyImgRequest;
import com.qbt.web.pojo.vip.VipUserModifyRequest;

/**
 * 
  * @ClassName: VipUserSupport
  * @Description: TODO
  * @author chenxiaocong 2016年11月3日
  * @modify chenxiaocong 2016年11月3日
 */
public interface VipUserSupport {

	public List<VipUser> findByOpenId(String openId);
	
	public List<VipTypeVo> getVipTypeByStaus(int status);
	
	public VipInfo addVipInfo(VipPayment vipPayment);
	
	public VipType findVipType();
	
	public VipType findVipType(int id);
	
	public void modify(VipUserModifyRequest req);

	public void activate(ActivateRequest req);
	
	public VipUser detail(Integer id);
	
	public boolean modifyImg(VipUserModifyImgRequest req);
}
