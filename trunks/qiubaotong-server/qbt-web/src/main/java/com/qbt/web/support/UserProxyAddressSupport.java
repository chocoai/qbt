/**
 * Project Name:qbt-web
 * File Name:UserProxyAddressSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年2月27日下午4:51:11
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.user.Address;
import com.qbt.web.pojo.user.AddressDto;

/**
 * ClassName:UserProxyAddressSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 下午4:51:11
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface UserProxyAddressSupport {
	
	public List<Address> list(UserWeixin proxyUser, Integer userId, Integer labelType);
	
	public int add(UserWeixin proxyUser, Address address);
	
	public boolean update(UserWeixin proxyUser, Address address);

	public boolean delete(int id);

	public boolean updateUpdateTime(AddressDto address);
	
}
