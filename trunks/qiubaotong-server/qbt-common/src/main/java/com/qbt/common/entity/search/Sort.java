/**
 * Project Name:qbt-common
 * File Name:Sort.java
 * Package Name:com.qbt.common.entity
 * Date:2017年3月9日下午5:44:12
 *
*/

package com.qbt.common.entity.search;

import com.qbt.common.enums.SortType;

/**
 * ClassName:Sort
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月9日 下午5:44:12
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class Sort {
	
	private String sortKey;
    
	private SortType sortType;

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public SortType getSortType() {
		return sortType;
	}

	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}
	
}
