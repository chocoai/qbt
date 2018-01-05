/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupUserImportReq.java
 * Package Name:com.qbt.web.pojo.orgGroupUser
 * Date:2017年8月2日上午11:15:47
 *
*/

package com.qbt.web.pojo.orgGroupUser;

import javax.validation.constraints.NotNull;

/**
 * ClassName:OrgGroupUserImportReq
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月2日 上午11:15:47
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrgGroupUserImportReq {
	
	@NotNull(message = "机构id不能为空")
	private Integer orgId;
	
	@NotNull(message = "文件不能为空")
	private String excel;

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getExcel() {
		return excel;
	}

	public void setExcel(String excel) {
		this.excel = excel;
	}

}
