package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.orderChangeBook.OrderChangeBookPageReqVo;
import com.qbt.web.pojo.orderChangeBook.OrderChangeBookVo;

public interface OrderChangeBookSupport {

	List<OrderChangeBookVo> findByPage(OrderChangeBookPageReqVo reqVo);

}
