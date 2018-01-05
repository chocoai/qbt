package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.outRangeAddress.OutRangeAddressPageReqVo;
import com.qbt.web.pojo.outRangeAddress.OutRangeAddressVO;

public interface OutRangeAddressSupport {

	List<OutRangeAddressVO> findByPage(OutRangeAddressPageReqVo reqVo);

	void insert(OutRangeAddressVO vo);

	OutRangeAddressVO findById(Integer id);

	void deleteById(Integer id);

	void updateById(OutRangeAddressVO vo);

}
