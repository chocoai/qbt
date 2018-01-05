package com.qbt.web.support.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.Bill;
import com.qbt.persistent.entity.BillAddress;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.BillAddressService;
import com.qbt.service.BillService;
import com.qbt.service.OrderInfoService;
import com.qbt.web.pojo.bill.BillAddressVo;
import com.qbt.web.pojo.bill.BillVo;
import com.qbt.web.pojo.order.OrderDetailV2;
import com.qbt.web.support.BillSupport;
@Service
public class BillSupportImpl implements BillSupport{
	@Resource
	private BillService billService;
	
	@Resource
	private BillAddressService billAddressService;
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Override
	public Boolean applyForBill(BillVo vo, 	UserWeixin userWeixin) {
		//1.查看 地址信息是否存在
		BillAddress billAddress = getBillAddress(vo);
		billAddress.setUserId(userWeixin.getId());
		BillAddress oldAddress = billAddressService.findByProperty(billAddress);	
		if (oldAddress == null) {
			billAddress.setUseTime(new Date());
			billAddressService.insert(billAddress);
		}else{
			oldAddress.setUseTime(new Date());
			billAddressService.updateById(oldAddress);
		}
		//2.校验 金额
		String orderIds = vo.getOrderId();
		String[] idArray=orderIds.split(",");
		int[] ids = new int[idArray.length];
		for(int i = 0;i<idArray.length;i++){
			ids[i]= Integer.parseInt(idArray[i]);
		}
		List<OrderInfo> list =orderInfoService.findByIds(ids);
		double price = 0;
		String orderNumber = "";
		for(OrderInfo orderInfo:list){
			price+=orderInfo.getAmount();
			orderNumber+=orderInfo.getNumber()+",";
		}
		orderNumber = orderNumber.substring(0, orderNumber.length()-1);
		if(price==vo.getPrice()){
			Bill bill = BeanUtil.a2b(vo,Bill.class);
			bill.setStatus(1);
			bill.setOrderNumber(orderNumber);
			bill.setUserId(userWeixin.getId());
			bill.setUserName(userWeixin.getName());
			billService.insert(bill);
			for(int orderId:ids){
				orderInfoService.updateDrawedBillById(orderId);
			}
			return true;
		}else{
			return false;
		}
	}
	private BillAddress getBillAddress(BillVo vo){
		BillAddress billAddress = new BillAddress();
		billAddress.setUserId(vo.getUserId());
		billAddress.setBillType(vo.getBillType());
		billAddress.setOrgType(vo.getOrgType());
		billAddress.setTitle(vo.getTitle());
		
		if(vo.getOrgType()==1){
			if(vo.getBillType()==1){
				billAddress.setEmail(vo.getEmail());
			}else{
				billAddress.setName(vo.getName());
				billAddress.setTelephone(vo.getTelephone());
				billAddress.setAddress(vo.getAddress());
			}
		}else{
			if(vo.getBillType()==1){
				billAddress.setEmail(vo.getEmail());
			}else{
				billAddress.setName(vo.getName());
				billAddress.setTelephone(vo.getTelephone());
				billAddress.setAddress(vo.getAddress());
			}
			billAddress.setTaxFileNumber(vo.getTaxFileNumber());
			billAddress.setBankNumber(vo.getBankNumber());
			billAddress.setBank(vo.getBank());
			billAddress.setCompanyAddress(vo.getCompanyAddress());
			billAddress.setCompanyTelephone(vo.getCompanyTelephone());
		}
		return billAddress;
	}
	@Override
	public List<BillAddress> findBillAddress(Integer id, int orgType) {
		// TODO Auto-generated method stub
		BillAddress billAddress = new BillAddress();
		billAddress.setUserId(id);
		billAddress.setOrgType(orgType);
		return billAddressService.findByUserId(billAddress);
	}
	@Override
	public Boolean insertBillAddress(BillAddressVo vo) {
		BillAddress billAddress = new BillAddress();
		billAddress.setUserId(vo.getUserId());
		billAddress.setBillType(vo.getBillType());
		billAddress.setOrgType(vo.getOrgType());
		billAddress.setTitle(vo.getTitle());
		if(vo.getOrgType()==1){
			if(vo.getBillType()==1){
				billAddress.setEmail(vo.getEmail());
			}else{
				billAddress.setName(vo.getName());
				billAddress.setTelephone(vo.getTelephone());
				billAddress.setAddress(vo.getAddress());
			}
		}else{
			if(vo.getBillType()==1){
				billAddress.setEmail(vo.getEmail());
			}else{
				billAddress.setName(vo.getName());
				billAddress.setTelephone(vo.getTelephone());
				billAddress.setAddress(vo.getAddress());
			}
			billAddress.setTaxFileNumber(vo.getTaxFileNumber());
			billAddress.setBankNumber(vo.getBankNumber());
			billAddress.setBank(vo.getBank());
			billAddress.setCompanyAddress(vo.getCompanyAddress());
			billAddress.setCompanyTelephone(vo.getCompanyTelephone());
		}
		BillAddress ba=billAddressService.findByProperty(billAddress);
		if(ba == null){
			billAddressService.insert(billAddress);
			return true;
		}
		return false;
	}
	@Override
	public void updateBillAddress(BillAddressVo vo) {
		BillAddress billAddress = BeanUtil.a2b(vo,BillAddress.class);
		billAddressService.updateById(billAddress);
	}
	@Override
	public void deleteBillAddress(Integer id) {
		// TODO Auto-generated method stub
		billAddressService.deleteById(id);
	}
	@Override
	public List<BillVo> findBill(Integer id) {
		// TODO Auto-generated method stub
		List<Bill> list= billService.findByUserId(id);
		List<BillVo> voList = BeanUtil.list2list(list, BillVo.class);
		return voList;
	}
	
	public List<OrderDetailV2> findOrderByIds(int[] ids){
		List<OrderInfo> orderInfoList =orderInfoService.findByIds(ids);
		List<OrderDetailV2> list = BeanUtil.list2list(orderInfoList, OrderDetailV2.class);
		return list;
	}
	public BillAddressVo findLastUseAddressByUserId(Integer userId){
		BillAddress billAddress=billAddressService.findLastUseByUserId(userId);
		BillAddressVo vo=BeanUtil.a2b(billAddress,BillAddressVo.class);
		return vo;
	}
	
}
