/**
 * Project Name:qbt-web
 * File Name:VipOrderConfirmVo.java
 * Package Name:com.qbt.web.pojo.vip
 * Date:2017年4月11日下午1:29:18
 *
*/

package com.qbt.web.pojo.vip;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:VipOrderConfirmVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年4月11日 下午1:29:18
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class VipOrderConfirmVo {
	
	private Boolean isVip = false;
	
	private List<VipInfoVo> vipInfos = new ArrayList<VipInfoVo>();

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	public List<VipInfoVo> getVipInfos() {
		return vipInfos;
	}

	public void setVipInfos(List<VipInfoVo> vipInfos) {
		this.vipInfos = vipInfos;
	}
	
}
