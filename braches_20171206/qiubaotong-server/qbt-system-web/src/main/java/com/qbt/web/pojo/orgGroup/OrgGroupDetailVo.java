/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupDetailVo.java
 * Package Name:com.qbt.web.pojo.orgGroup
 * Date:2017年8月1日下午5:46:09
 *
*/

package com.qbt.web.pojo.orgGroup;
/**
 * ClassName:OrgGroupDetailVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午5:46:09
 * @author   huangyihao
 * @version  
 * @see 	 
 */

import java.util.List;

public class OrgGroupDetailVo extends OrgGroupVo {
	
	private String startDateStr;
	
	private String endDateStr;
	
	private List<OrgGroupAmountConfigVo> amountConfigs;

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	public List<OrgGroupAmountConfigVo> getAmountConfigs() {
		return amountConfigs;
	}

	public void setAmountConfigs(List<OrgGroupAmountConfigVo> amountConfigs) {
		this.amountConfigs = amountConfigs;
	}
	
}
