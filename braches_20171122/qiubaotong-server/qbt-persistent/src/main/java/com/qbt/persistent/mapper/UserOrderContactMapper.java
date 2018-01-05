package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.UserOrderContact;

public interface UserOrderContactMapper {
    int insert(UserOrderContact record);

    int updateById(UserOrderContact record);

	List<UserOrderContact> findOldContactsByUserId(int userId);

	void deleteOldContactsById(Integer id);

	UserOrderContact findByUuid(String uuid);

	UserOrderContact findById(Integer id);

	String findMaxDate();

}