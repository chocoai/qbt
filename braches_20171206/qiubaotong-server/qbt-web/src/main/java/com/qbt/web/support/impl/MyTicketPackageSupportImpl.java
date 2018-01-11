package com.qbt.web.support.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.ScpConfig;
import com.qbt.common.util.ScpUtil;
import com.qbt.persistent.entity.ActivityTicketPackage;
import com.qbt.persistent.entity.TicketPackageActivity;
import com.qbt.persistent.entity.TicketPackageRule;
import com.qbt.persistent.entity.TicketPackageRuleConfig;
import com.qbt.persistent.entity.UserActivityOrderDetail;
import com.qbt.persistent.entity.UserActivityPackage;
import com.qbt.persistent.entity.UserPackageTicket;
import com.qbt.service.TicketPackageActivityService;
import com.qbt.service.TicketPackageRuleConfigService;
import com.qbt.service.TicketPackageRuleService;
import com.qbt.service.UserActivityOrderDetailService;
import com.qbt.service.UserActivityPackageService;
import com.qbt.service.UserPackageTicketService;
import com.qbt.web.util.ZxingUtil;
import com.qbt.web.pojo.ticket.UserActivityPackageVo;
import com.qbt.web.pojo.ticket.UserPackageTicketVo;
import com.qbt.web.pojo.ticketPackageActivity.TicketPackageActivityPageReqVo;
import com.qbt.web.pojo.ticketPackageActivity.TicketPackageActivityVo;
import com.qbt.web.pojo.ticketPackageRule.TicketPackageRuleConfVo;
import com.qbt.web.pojo.ticketPackageRule.TicketPackageRuleVo;
import com.qbt.web.support.MyTicketPackageSupport;

/**
 *  MyTicketPackage支持
  * @ClassName: MyTicketPackageSupportImpl
  * @Description: TODO
  * @author andy.li
  */
@Service

public class MyTicketPackageSupportImpl implements MyTicketPackageSupport {
	
	@Value("${scp.host}")
    private String ip;
	
	@Value("${scp.port}")
    private String port;
	
	@Value("${scp.username}")
    private String userName;
	
	@Value("${scp.password}")
    private String passWord;
	
	@Value("${nginx.root.dir}")
	private String nginxPath;
	
	@Value("${remote.qrcode.dir}")
	private String remoteQrcodePath;
	
	@Resource
	private UserActivityOrderDetailService userActivityOrderDetailService;
	
	@Resource
	private UserActivityPackageService userActivityPackageService;
	
	@Resource
	private UserPackageTicketService userPackageTicketService;
	
	private TicketPackageActivityService ticketPackageActivityService;
	
	@Resource
	private TicketPackageRuleService ticketPackageRuleService;
	
	@Resource
	private TicketPackageRuleConfigService ticketPackageRuleConfigService;
	

	@Override
	public List<UserActivityPackageVo> findlistNotActive(int userId) {
		
		List<UserActivityPackage> lists=userActivityPackageService.findlistNotActive(userId);
		List<UserActivityPackageVo> result=new ArrayList<UserActivityPackageVo>();
		UserActivityPackageVo userActivityPackageVo=null;
		
		if(lists!=null){
		for(UserActivityPackage u:lists){
			userActivityPackageVo = new UserActivityPackageVo();
			userActivityPackageVo.setId(u.getId());
			userActivityPackageVo.setUserId(u.getUserId());
			userActivityPackageVo.setOrderId(u.getOrderId());
			userActivityPackageVo.setOrderDetailId(u.getOrderDetailId());
			userActivityPackageVo.setStatus(u.getStatus());
			userActivityPackageVo.setCode(u.getCode());
			userActivityPackageVo.setQrCode(u.getQrCode());
			userActivityPackageVo.setOperatorId(u.getOperatorId());
			userActivityPackageVo.setOperatorName(u.getOperatorName());
			userActivityPackageVo.setActivityName(u.getActivityName());
			userActivityPackageVo.setPrice(u.getPrice());
			userActivityPackageVo.setPackageType(u.getPackageType());
			userActivityPackageVo.setCreatTime(u.getCreateTime());
			userActivityPackageVo.setUpdateTime(u.getUpdateTime());
			result.add(userActivityPackageVo);
		   }
		}
	
		return result;
	}

	@Override
	public List<UserActivityPackageVo> findlistUsed(int userId) {
		List<UserActivityPackage> lists=userActivityPackageService.findlistUsed(userId);
		List<UserActivityPackageVo> result=new ArrayList<UserActivityPackageVo>();
		UserActivityPackageVo userActivityPackageVo=null;
		
		if(lists!=null){
		for(UserActivityPackage u:lists){
			userActivityPackageVo = new UserActivityPackageVo();
			userActivityPackageVo.setId(u.getId());
			userActivityPackageVo.setUserId(u.getUserId());
			userActivityPackageVo.setOrderId(u.getOrderId());
			userActivityPackageVo.setOrderDetailId(u.getOrderDetailId());
			userActivityPackageVo.setStatus(u.getStatus());
			userActivityPackageVo.setOperatorId(u.getOperatorId());
			userActivityPackageVo.setOperatorName(u.getOperatorName());
			userActivityPackageVo.setExpirationTime(u.getExpirationTime());
			//判断该券包是否已经过期
			Date date_now=new Date();
			if(date_now.getTime()>u.getExpirationTime().getTime()){
				userActivityPackageVo.setExpirationStatus(1);	
			}else{
				userActivityPackageVo.setExpirationStatus(0);	
			}
			//判断该券包下的券是否已经使用完
			if(userPackageTicketService.checkPackageIsUsed(u.getId())==0){
				userActivityPackageVo.setUsed_status(1);
			}else {
				userActivityPackageVo.setUsed_status(0);
			}
			userActivityPackageVo.setActivateTime(u.getActivateTime());
			userActivityPackageVo.setActivityName(u.getActivityName());
			userActivityPackageVo.setPrice(u.getPrice());
			userActivityPackageVo.setPackageType(u.getPackageType());
			userActivityPackageVo.setEffectiveDay(u.getEffectiveDay());
			userActivityPackageVo.setCreatTime(u.getCreateTime());
			userActivityPackageVo.setUpdateTime(u.getUpdateTime());
			result.add(userActivityPackageVo);
		   }
		}
	
		return result;
	}

	@Override
	public List<UserPackageTicketVo> findlistAvailableTicket(int userId) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<UserPackageTicket> lists=userPackageTicketService.findAvailableTicketByUserId(userId, df.format(new Date()).toString());
		List<UserPackageTicketVo> result=new ArrayList<UserPackageTicketVo>();
		UserPackageTicketVo userPackageTicketVo=null;
		
		if(lists!=null){
			for(UserPackageTicket u:lists){
				userPackageTicketVo=new UserPackageTicketVo();
				userPackageTicketVo.setId(u.getId());
				userPackageTicketVo.setPackageId(u.getPackageId());
				userPackageTicketVo.setOrderDetailId(u.getOrderDetailId());
				userPackageTicketVo.setTicketPrice(u.getTicketPrice());
				userPackageTicketVo.setTicketName(u.getTicketName());
				userPackageTicketVo.setQuantity(u.getQuantity());
				userPackageTicketVo.setUsedQuantity(u.getUsedQuantity());
				userPackageTicketVo.setUseLimit(u.getUseLimit());
				userPackageTicketVo.setUseStatus(u.getUseStatus());
				userPackageTicketVo.setUserId(u.getUserId());
				userPackageTicketVo.setExpirationTime(u.getExpirationTime());
				userPackageTicketVo.setEffectiveDay(u.getEffectiveDay());
				userPackageTicketVo.setActivate_time(u.getActivateTime());
				result.add(userPackageTicketVo);
			}
		}
		return result;
	}

	@Override
	public List<UserPackageTicketVo> findlistDisableTicket(int userId) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<UserPackageTicket> lists=userPackageTicketService.findDisableTicketByUserId(userId, df.format(new Date()).toString());
		List<UserPackageTicketVo> result=new ArrayList<UserPackageTicketVo>();
		UserPackageTicketVo userPackageTicketVo=null;
		
		if(lists!=null){
			for(UserPackageTicket u:lists){
				userPackageTicketVo=new UserPackageTicketVo();
				userPackageTicketVo.setId(u.getId());
				userPackageTicketVo.setPackageId(u.getPackageId());
				userPackageTicketVo.setOrderDetailId(u.getOrderDetailId());
				userPackageTicketVo.setTicketPrice(u.getTicketPrice());
				userPackageTicketVo.setTicketName(u.getTicketName());
				userPackageTicketVo.setQuantity(u.getQuantity());
				userPackageTicketVo.setUsedQuantity(u.getUsedQuantity());
				userPackageTicketVo.setUseLimit(u.getUseLimit());
				userPackageTicketVo.setUseStatus(u.getUseStatus());
				userPackageTicketVo.setUserId(u.getUserId());
				userPackageTicketVo.setExpirationTime(u.getExpirationTime());
				userPackageTicketVo.setEffectiveDay(u.getEffectiveDay());
				userPackageTicketVo.setActivate_time(u.getActivateTime());
				result.add(userPackageTicketVo);
			}
		}
		return result;
	}
	
	@Override
	public String activate(int packageId,String activateUser,String activatePhoneNumber) {
		String result="";
		Object obj=userActivityPackageService.findOrderDetailIdByPackageId(packageId);
		if(obj!=null){
			int orderDetailId=(Integer) obj;
			//判断券包是否已经激活
			UserActivityOrderDetail userActivityOrderDetail=userActivityOrderDetailService.findById(orderDetailId);
			if(userActivityOrderDetail!=null){
				if(userActivityOrderDetail.getActiveStatus()==1||userActivityOrderDetail.getPackageType()==1){
					result="该券包已经激活或已赠送中!";
				}else{
					int effectiveDay=userActivityOrderDetailService.findEffectiveDayByOrderDetailId(orderDetailId);
					UserActivityOrderDetail ticket =new UserActivityOrderDetail();
					ticket.setId(orderDetailId);
					ticket.setActiveStatus(1);
					ticket.setPackageType(0);
					ticket.setActivateTime(new Date());
					Calendar cal = Calendar.getInstance();   
					cal.add(Calendar.DAY_OF_MONTH, effectiveDay);  
					ticket.setExpirationTime(cal.getTime());
					ticket.setActivateUser(activateUser);
					ticket.setActivatePhoneNumber(activatePhoneNumber);
					userActivityOrderDetailService.update(ticket);
					UserActivityPackage ticketPackage = new UserActivityPackage();
					ticketPackage.setId(packageId);
					ticketPackage.setStatus(1);
					userActivityPackageService.update(ticketPackage);
					result="激活成功!";
				}
			}
		}
		return result;
	}

	@Override
	public String cancel(int packageId) {
		String result="";
		Object obj=userActivityPackageService.findOrderDetailIdByPackageId(packageId);
		if(obj!=null){
		int orderDetailId=(Integer) obj;
		UserActivityOrderDetail userActivityOrderDetail=userActivityOrderDetailService.findById(orderDetailId);
		if(userActivityOrderDetail!=null){
			//符合券包可撤销赠送的条件
			if(userActivityOrderDetail.getPackageType()==1&&userActivityOrderDetail.getActiveStatus()==0){
				UserActivityOrderDetail ticket =new UserActivityOrderDetail();
				ticket.setId(orderDetailId);
				ticket.setPackageType(0);
				userActivityOrderDetailService.update(ticket);
				UserActivityPackage ticketPackage = new UserActivityPackage();
				ticketPackage.setId(packageId);
				ticketPackage.setStatus(0);
				userActivityPackageService.update(ticketPackage);
				result="撤销赠送成功!";
			}else{
				result="当前券包状态不可撤销赠送!";
			}
		}
		}
		return result;
	}

	
	@Override
	public String recieve(int userId,String name,int packageId,String qrCode) {
		
		String result="";
		//1.根据packageId获取赠送方的order details info
		Object obj=userActivityPackageService.findOrderDetailIdByPackageId(packageId);
		if(obj!=null){
			int orderDetailId=(Integer) obj;
			UserActivityOrderDetail userActivityOrderDetail=userActivityOrderDetailService.findById(orderDetailId);
			if(userActivityOrderDetail!=null){
				if(userActivityOrderDetail.getPackageType()==2){
					//券包已经被领取过了,不能重复领取
					result="券包已经被领取。";
				}else{
					if(userActivityOrderDetail.getQrCode().equals(qrCode)){
					int orderId=userActivityOrderDetail.getOrderId();
					//2.修改user_activity_order_detail的package_type=2
					UserActivityOrderDetail ticket =new UserActivityOrderDetail();
					ticket.setId(orderDetailId);
					ticket.setPackageType(2);
					userActivityOrderDetailService.update(ticket);
					//3.修改赠送方package的状态为已分享
					UserActivityPackage recordSend=new UserActivityPackage();
					recordSend.setId(packageId);
					recordSend.setStatus(3);
					userActivityPackageService.update(recordSend);
					//4.copy赠送方的相关属性,给接收方创建一个新的package,并设置状态为已接收
					UserActivityPackage recordRevieve=new UserActivityPackage();
					recordRevieve.setOrderId(orderId);
					recordRevieve.setOrderDetailId(orderDetailId);
					recordRevieve.setUserId(userId);
					recordRevieve.setStatus(4);
					recordRevieve.setOperatorId(userId);
					recordRevieve.setOperatorName(name);
					recordRevieve.setCreateTime(new Date());
					recordRevieve.setUpdateTime(new Date());
					userActivityPackageService.insert(recordRevieve);
					//5.查询新生成的package id
					PageEntity<UserActivityPackage> pageEntity=new PageEntity<UserActivityPackage>();
					pageEntity.setCondition(recordRevieve);
					List<UserActivityPackage> lists=userActivityPackageService.findByPage(pageEntity);
					if(lists!=null){
					//6.copy赠送方的package下的tickets到新的package下
					List<UserPackageTicket> tickets=userPackageTicketService.findTicketsByPackageId(packageId);
					UserPackageTicket ticketvo=null;
					for(UserPackageTicket t:tickets){
						ticketvo=new UserPackageTicket();
						ticketvo.setPackageId(lists.get(0).getId());
						ticketvo.setOrderDetailId(t.getOrderDetailId());
						ticketvo.setTicketPrice(t.getTicketPrice());
						ticketvo.setTicketName(t.getTicketName());
						ticketvo.setQuantity(t.getQuantity());
						ticketvo.setUsedQuantity(t.getUsedQuantity());
						ticketvo.setUseLimit(t.getUseLimit());
						ticketvo.setUseStatus(t.getUseStatus());
						ticketvo.setCreateTime(new Date());
						ticketvo.setUpdateTime(new Date());
						userPackageTicketService.insert(ticketvo);
					   }
				     }
					  result="领取成功!";
				  }else{
					  result="领取失败,二维码信息错误!"; 
				  }
			  }
			}
			
		}
		
		return result;
	}
	
	@Override
	public String qrcode(int packageId,String qrCode,String url,String webpath) {
		
		String qrCodeName=packageId+"_qrCode"+".png";
		String qrCodePath=webpath+qrCodeName;
		String qrcode_url = "";
		Object obj=userActivityPackageService.findOrderDetailIdByPackageId(packageId);
		if(obj!=null){
			int orderDetailId=(Integer) obj;
			//判断该package是否已激活和已赠送
			UserActivityOrderDetail userActivityOrderDetail=userActivityOrderDetailService.findById(orderDetailId);
			if(userActivityOrderDetail!=null){
				if(userActivityOrderDetail.getPackageType()!=1&&userActivityOrderDetail.getPackageType()!=2&&userActivityOrderDetail.getActiveStatus()==0){
					if(userActivityOrderDetail.getQrCode().equals(qrCode)){
					//根据url产生一个二维码图片
					try{
						ZxingUtil.createQRCode(url, new File(qrCodePath));
						//qrcode pic upload handle by scp start
						String dateStr = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYYYMMDD);
						String scpPath = remoteQrcodePath + dateStr;
						ScpUtil.uploadFile(qrCodePath, qrCodeName, scpPath, getScpConfig());
						qrcode_url = scpPath.replace(nginxPath, "") + Constants.SLASH + qrCodeName;
						//qrcode pic upload handle by scp end
					}catch(Exception e){
						e.printStackTrace();
					}
					//更改券包状态为赠送中
					UserActivityOrderDetail ticket =new UserActivityOrderDetail();
					ticket.setId(orderDetailId);
					ticket.setPackageType(1);
					userActivityOrderDetailService.update(ticket);
					UserActivityPackage ticketPackage = new UserActivityPackage();
					ticketPackage.setId(packageId);
					ticketPackage.setStatus(2);
					userActivityPackageService.update(ticketPackage);
					}else{
						qrcode_url="获取二维码图片失败,系统二维码错误!";
					}
				}else{
					qrcode_url="获取二维码图片失败,当前不符合赠送条件!";
				}
			
			}
		}
		return qrcode_url;
	}
	

	@Override
	public String useTicket(int ticketId) {
		String result="";
		//通过ticketId获取Ticket,判断该券是否已经全部使用完毕
		UserPackageTicket ticket=userPackageTicketService.findById(ticketId);
		if(ticket==null){
			result="该劵不存在!";
		}else{
			if(ticket.getUseStatus()==1){
			result="该券已经使用完了!";	
			}else{
			UserPackageTicket record=new UserPackageTicket();
			record.setId(ticketId);
			record.setUsedQuantity(ticket.getUsedQuantity()+1);
			record.setQuantity(ticket.getQuantity());
			record.setUseStatus(1);
			userPackageTicketService.update(record);
			}
		}
		return result;
	}
	
	@Override
	public List<UserActivityPackageVo> findPaperPackageList() {
		List<UserActivityPackageVo> result=new ArrayList<UserActivityPackageVo>();
		List<UserActivityPackage> packages=userActivityPackageService.findPaperPackageList();
		UserActivityPackageVo packageVo=null;
		if(packages!=null){
		for(UserActivityPackage u:packages){
			packageVo=new UserActivityPackageVo();
			packageVo.setId(u.getId());
			packageVo.setUserId(u.getUserId());
			packageVo.setOrderId(u.getOrderId());
			packageVo.setOrderDetailId(u.getOrderDetailId());
			packageVo.setStatus(u.getStatus());
			packageVo.setOperatorId(u.getOperatorId());
			packageVo.setOperatorName(u.getOperatorName());
			packageVo.setCreatTime(u.getCreateTime());
			packageVo.setUpdateTime(u.getUpdateTime());
			result.add(packageVo);
		 }
		}
		return result;
	}

	@Override
	public ActivityTicketPackage findPackageById(int packageId) {
		return userPackageTicketService.findByPackageId(packageId);
	}

	@Override
	public List<TicketPackageActivityVo> packageActivityFindByPage(TicketPackageActivityPageReqVo vo) {
		
		PageEntity<TicketPackageActivity> pageEntity = BeanUtil.pageConvert(vo, TicketPackageActivity.class);
		
		List<TicketPackageActivity> activityList = ticketPackageActivityService.findByPage(pageEntity);
		List<TicketPackageActivityVo> voList = BeanUtil.list2list(activityList, TicketPackageActivityVo.class);
		
		vo.setTotalCount(pageEntity.getTotalCount());
		
		return voList;
	}
	
	@Override
	public TicketPackageRuleVo packageActivityFindByRuleId(int id)  throws BusinessException{
		
		TicketPackageRule ticketPackageRule = ticketPackageRuleService.findById(id);
		if(Checker.isEmpty(ticketPackageRule))
		{
			throw new BusinessException("查询不到券包规则");
		}
		
		List<TicketPackageRuleConfig> configs = ticketPackageRuleConfigService.findByRuleId(id);
		
		TicketPackageRuleVo ticketPackageRuleVo  = BeanUtil.a2b(ticketPackageRule, TicketPackageRuleVo.class);
		
		List<TicketPackageRuleConfVo> configVoList = BeanUtil.list2list(configs, TicketPackageRuleConfVo.class);
		
		ticketPackageRuleVo.setTicketPackageRuleConfVolist(configVoList);
		
		return ticketPackageRuleVo;
	}


	private ScpConfig getScpConfig() {
        if (!StringUtils.isEmpty(port)) {
            return new ScpConfig(ip, Integer.parseInt(port), userName, passWord);
        } else {
        	
            return new ScpConfig(ip, 0, userName, passWord);
        }
    }

}
