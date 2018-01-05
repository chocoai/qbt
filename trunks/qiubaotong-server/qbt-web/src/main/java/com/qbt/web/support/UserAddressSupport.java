package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.web.pojo.user.Address;
import com.qbt.web.pojo.user.AddressDto;

public interface UserAddressSupport {

	public List<Address> list(int userId, int labelType);
	
	public Map<String,String> add(Address address);
	
	public boolean update(Address address);
	
	public boolean updateUpdateTime(AddressDto address);
	
	public boolean delete(int id);
	
}
