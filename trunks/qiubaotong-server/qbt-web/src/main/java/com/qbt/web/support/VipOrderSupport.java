
 /**
 * @Title: VipOrderSupport.java
 * @Package com.qbt.web.support
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月4日
 * @version V1.0
 **/

package com.qbt.web.support;

import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.persistent.entity.VipPayment;

/**
  * @ClassName: VipOrderSupport
  * @Description: TODO
  * @author chenxiaocong 2016年11月4日
  * @modify chenxiaocong 2016年11月4日
  */

public interface VipOrderSupport {
	
	public VipOrder createVipOrder(VipPayment vipPayment,VipInfo vipInfo);
}
