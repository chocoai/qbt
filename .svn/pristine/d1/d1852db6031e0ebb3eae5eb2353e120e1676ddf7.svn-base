package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.ActivityTicketPackage;
import com.qbt.web.pojo.ticket.UserActivityPackageVo;
import com.qbt.web.pojo.ticket.UserPackageTicketVo;


public interface MyTicketPackageSupport {

	/**
	  * @Title: listNotActive
	  * @Description: Search (active_status=0 and package_type=0))
	  * @author: andy.li
	  * @return List<UserActivityPackageVo>
	  */
	public List<UserActivityPackageVo> findlistNotActive(int userId);
	
	/**
	  * @Title: listUsed
	  * @Description: Search (active_status=1 or package_type in(1,2) or(active_status=1 and today>expiration_time))
	  * @author: andy.li
	  * @return List<UserActivityPackageVo>
	 */
	public List<UserActivityPackageVo> findlistUsed(int userId);
	
	/**
	 * @Title: listAvailableTicket
	 * @author: andy.li
	 * @return List<UserPackageTicketVo>
	 */
	public List<UserPackageTicketVo> findlistAvailableTicket(int userId);
	
	/**
	 * @Title: listDisableTicket
	 * @author: andy.li
	 * @return List<UserPackageTicketVo>
	 */
	public List<UserPackageTicketVo> findlistDisableTicket(int userId);
	
	/**
	 * @Title: activate
	 * @Description:update active_status  = 1
	 * @param packageId
	 * @param activateUser
	 * @param activatePhoneNumber
	 * @param code
	 * @param codeStatus
	 * @author: andy.li
	 * @return
	 */
	public String activate(int packageId,String activateUser,String activatePhoneNumber,String code,int codeStatus);
	
	/**
	 * @Title: cancel
	 * @Description:update package_type = 0
	 * @author: andy.li
	 * @param packageId
	 * @return
	 */
	public String cancel(int packageId);
	
	/**
	 * @Title: recieve
	 * @Description:
	 *  update package_type = 2
		copy a new package to current user
	 * @param 接受方的userId
	 * @param 赠送方的packageId
	 * @param qrCode
	 * @return
	 */
	public String recieve(int userId,int packageId);
	
	/**
	 * @Title: qrcode
	 * @Description: post :package_id (update qrcode to user_activity_package, update package_type = 1)
	 * @author: andy.li
	 * @param packageId
	 * @return UserPackageTicketVo
	 */
	public byte[] qrcode(int packageId,String url,String webpath);
	
	/**
	 * @Title: useTicket
	 * @Description update table user_package_ticket,set used_quantity+1
	 * @author: andy.li
	 * @param ticketId
	 * @return
	 */
	public String useTicket(int ticketId);
	
	/**
	 * @Title: findPackageById
	 * @Description find details Package info by packageId
	 * @author: andy.li
	 * @param packageId
	 * @return ActivityTicketPackage
	 */
	public ActivityTicketPackage findPackageById(int packageId);
}
