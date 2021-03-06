/**
 * Project Name:qbt-web
 * File Name:BaseAdvertVo.java
 * Package Name:com.qbt.web.pojo.baseAdvert
 * Date:2017年10月11日上午10:52:00
 *
*/

package com.qbt.web.pojo.baseAdvert;

import java.util.List;

/**
 * ClassName:BaseAdvertVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月11日 上午10:52:00
 * @author   wuwang
 * @version  
 * @see 	 
 */
public class BaseAdvertVo {
	
	 private String code;
	
	 //类型（1PC，2微信）
	 private Integer flatType;
	 
	 //展开类型(1本页展开，2新页展开)
	 private Integer openType;
	 
	 private List<BaseAdvertImageVo> imageVoList;

	public Integer getFlatType() {
		return flatType;
	}

	public void setFlatType(Integer flatType) {
		this.flatType = flatType;
	}

	public Integer getOpenType() {
		return openType;
	}

	public void setOpenType(Integer openType) {
		this.openType = openType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<BaseAdvertImageVo> getImageVoList() {
		return imageVoList;
	}

	public void setImageVoList(List<BaseAdvertImageVo> imageVoList) {
		this.imageVoList = imageVoList;
	}

}
