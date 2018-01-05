package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseLabel.BaseLabelVO;
import com.qbt.web.pojo.baseUserLabel.UserLabelVO;

public interface BaseLabelSupport {

	List<BaseLabelVO> list();

	void addUserLabel(UserLabelVO userVO);

	List<Integer> findByUser(Integer userType, Integer userId);

	List<String> findContentByUser(Integer userType, Integer userId);

}
