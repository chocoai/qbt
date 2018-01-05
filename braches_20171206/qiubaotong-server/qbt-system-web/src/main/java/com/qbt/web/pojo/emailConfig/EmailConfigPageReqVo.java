/**
 * Project Name:qbt-system-web
 * File Name:EmailConfigPageReqVo.java
 * Package Name:com.qbt.web.pojo.emailConfig
 * Date:2017年10月24日下午2:43:13
 *
*/

package com.qbt.web.pojo.emailConfig;

import com.qbt.common.result.Paging;

/**
 * ClassName:EmailConfigPageReqVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月24日 下午2:43:13
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class EmailConfigPageReqVo extends Paging {
	
	private String name;
	
	private String platform;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
}
