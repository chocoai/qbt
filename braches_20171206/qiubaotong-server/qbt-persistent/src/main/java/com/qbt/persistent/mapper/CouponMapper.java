package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.Coupon;

public interface CouponMapper {
	
    int insert(Coupon record);

    Coupon selectById(Integer id);

    int updateById(Coupon record);
    
    int updateUserIdById(Coupon record);

    //根据暗码更新数据库
    int updateByCode(Coupon record);
    
    //根据用户id查询所有优惠券
    List<UserCouponActivity> selectUserCouponByUserId(@Param("userId")int userId, @Param("status")int status);
    
    //根据子券码查询券码信息
    Coupon selectByChildCode(String childCode);
    
    //根据用户查询有效券码数量
    int selectCouponCountByUserId(int userId);
    
    //根据活动id,查询所有券码
    public List<Coupon> selectCouponByActivityId(int activityId);
    
    //根据父券码，查询所有券码
    public List<Coupon> selectCouponByCode(String code);
    
    //分页查询
    List<UserCouponActivity> findByPageBoss(PageEntity<UserCouponActivity> pageEntity);
    
    // 获取用户有效期个数
	Integer validCount(Integer userId);
    
	//批量生成券
	int insertByBatch(@Param("couponList")List<Coupon> couponList);
    
	int updateStatusById(@Param("id")int id,@Param("status")int status);
	
	//根据还有x天过期的优惠券
	List<UserCouponActivity> findExpireCodesByDay(@Param("day")int day);
	
	/**
	 * 
	 * findAllCouponCode:(查询所有的券码).
	 *
	 * @author huangyihao
	 * 2017年7月10日 上午11:52:12
	 * @return
	 *
	 */
	List<Coupon> findAllCouponCode();
	
	Coupon getCoupon(@Param("activityId")Integer activityId);
	
	void deblockingCoupon(@Param("orderId")Integer orderId);
	
	void bindCoupon(Coupon coupon);
	
	Integer isWinner(@Param("orderId")Integer orderId);
	
	UserCouponActivity findWinnerInfo(@Param("orderId")Integer orderId);

}