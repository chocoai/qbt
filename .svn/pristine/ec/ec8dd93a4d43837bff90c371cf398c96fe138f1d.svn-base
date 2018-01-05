/**
 * Project Name:qbt-persistent
 * File Name:SignCalculator.java
 * Package Name:com.qbt.util
 * Date:2017年2月27日下午5:49:00
 *
*/

package com.qbt.util;

import com.qbt.common.util.Md5;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.persistent.entity.UserProxyAddress;

/**
 * ClassName:SignCalculator
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 下午5:49:00
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SignCalculator {
	
	public static String calUserAddressSign(UserAddress address){
		StringBuffer buffer = new StringBuffer();
		buffer.append(address.getUserId())
				.append(address.getAreaId())
				.append(address.getAddress())
				.append(address.getContact())
				.append(address.getMobile());
		return Md5.MD5Encode(buffer.toString());
	}
	
	public static String calUserProxyAddressSign(UserProxyAddress address){
		StringBuffer buffer = new StringBuffer();
		buffer.append(address.getProxyUserId())
				.append(address.getUserId())
				.append(address.getAreaId())
				.append(address.getAddress())
				.append(address.getContact())
				.append(address.getMobile());
		return Md5.MD5Encode(buffer.toString());
	}
	
}
