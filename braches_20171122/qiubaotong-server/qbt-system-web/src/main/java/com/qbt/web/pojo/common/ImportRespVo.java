/**
 * Project Name:qbt-system-web
 * File Name:ImportRespVo.java
 * Package Name:com.qbt.web.pojo.common
 * Date:2017年8月2日上午11:21:11
 *
*/

package com.qbt.web.pojo.common;
/**
 * ClassName:ImportRespVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月2日 上午11:21:11
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class ImportRespVo {
	
	private int totalCount;
	
	private int succCount;
	
	private int failCount;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getSuccCount() {
		return succCount;
	}

	public void setSuccCount(int succCount) {
		this.succCount = succCount;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	
}
