
 /**
 * @Title: VipPyamentSupport.java
 * @Package com.qbt.web.support
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月3日
 * @version V1.0
 **/

package com.qbt.web.support;

import java.util.Map;

import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.VipPayment;
import com.qbt.web.pojo.vip.VipPayRequest;

/**
  * @ClassName: VipPyamentSupport
  * @Description: TODO
  * @author chenxiaocong 2016年11月3日
  * @modify chenxiaocong 2016年11月3日
  */

public interface VipPyamentSupport {

	public Map<String,String> vipPay(VipPayRequest vipPayRequest);
	
	public VipPayment findByUuid(String uuid);
	
	public void updateVipPayment(VipPayment VipPayment,VipInfo vipInfo);
}
