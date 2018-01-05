/**
 * Project Name:qbt-system-web
 * File Name:PopUpDetailVo.java
 * Package Name:com.qbt.web.pojo.popUp
 * Date:2017年1月17日上午10:23:19
 *
*/

package com.qbt.web.pojo.popUp;

import java.util.List;

/**
 * ClassName:PopUpDetailVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月17日 上午10:23:19
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class PopUpDetailVo extends PopUpVo {
	
	private List<PopUpConfigVo> configs;

	public List<PopUpConfigVo> getConfigs() {
		return configs;
	}

	public void setConfigs(List<PopUpConfigVo> configs) {
		this.configs = configs;
	}
	
}
