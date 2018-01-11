package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.BillAddress;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.bill.BillAddressVo;
import com.qbt.web.pojo.bill.BillVo;
import com.qbt.web.pojo.order.OrderDetailV2;

public interface BillSupport {
	
   Boolean applyForBill(BillVo vo,	UserWeixin userWeixin);

   List<BillAddress> findBillAddress(Integer id, int orgType);
   
   Boolean insertBillAddress(BillAddressVo vo);
   void updateBillAddress(BillAddressVo vo);
   void deleteBillAddress(Integer id);

   List<BillVo> findBill(Integer id);
   
   public List<OrderDetailV2> findOrderByIds(int[] ids);
   public BillAddressVo findLastUseAddressByUserId(Integer userId);
}
