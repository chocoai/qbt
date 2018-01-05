package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.UserOrderContact;

public interface UserOrderContactService {

	List<UserOrderContact> findOldContactsByUserId(int userId);

	void deleteOldContactsById(Integer id);

	UserOrderContact findByUuid(String uuid);

	int insert(UserOrderContact userOrderContact);
	
	String findMaxDate();

	UserOrderContact findById(Integer id);

}
