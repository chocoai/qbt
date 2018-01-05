/**
 * Project Name:qbt-persistent
 * File Name:DataColletionSearch.java
 * Package Name:com.qbt.aop
 * Date:2017年7月13日下午3:36:09
 *
*/

package com.qbt.aop;
/**
 * ClassName:DataColletionSearch
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月13日 下午3:36:09
 * @author   huangyihao
 * @version  
 * @see 	 
 */

import java.util.Collection;

public interface DataColletionSearch {
	
	/**
	 * 
	 * searchData:(查询集合数据).
	 *
	 * @author huangyihao
	 * 2017年7月13日 下午3:37:13
	 * @param args
	 * @return
	 *
	 */
	Collection<String> searchData(Object... args);
	
}
