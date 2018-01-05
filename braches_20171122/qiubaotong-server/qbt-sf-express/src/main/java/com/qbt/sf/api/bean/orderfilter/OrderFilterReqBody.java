/**
 * @Title: OrderServiceBody.java
 * @Package com.froad.iamp.xml2bean.api
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016�?8�?4�?
 * @version V1.0
**/

package com.qbt.sf.api.bean.orderfilter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.order.OrderReqOrder;

/**
  * @ClassName: OrderConfirmServiceBody
  * @Description: TODO
  * @author wuwang-win8 2016年8月4日
  * @modify wuwang-win8 2016年8月4日
 */

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderFilterReqBody {
    
    @XmlElement(name="OrderFilter")
    private OrderFilterRepOrder orderFilter;
    
    @XmlElement(name="Extra")
    private OrderFilterExtra extra;

    
    public OrderFilterRepOrder getOrderFilter() {
		return orderFilter;
	}


	public void setOrderFilter(OrderFilterRepOrder orderFilter) {
		this.orderFilter = orderFilter;
	}


	/**
     * getter method 
     * @Title: getExtra
     * @return the extra
     */
    public OrderFilterExtra getExtra() {
        return extra;
    }


	/**
    * setter method
    * @param extra the extra to set
    */
    public void setExtra(OrderFilterExtra extra) {
        this.extra = extra;
    }
    
}
