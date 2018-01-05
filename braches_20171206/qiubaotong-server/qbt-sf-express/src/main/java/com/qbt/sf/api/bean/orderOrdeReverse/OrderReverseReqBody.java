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

package com.qbt.sf.api.bean.orderOrdeReverse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: OrderServiceBody
  * @Description: TODO
  * @author froad-win10 2016�?8�?4�?
  * @modify froad-win10 2016�?8�?4�?
 */

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderReverseReqBody {
    
    @XmlElement(name="Order")
    private OrderReverseReqOrder order;
    
    @XmlElement(name="Extra")
    private OrderReverseExtra extra;

    /**
     * getter method 
     * @Title: getOrder
     * @return the order
     */
    public OrderReverseReqOrder getOrder() {
        return order;
    }

    /**
    * setter method
    * @param order the order to set
    */
    public void setOrder(OrderReverseReqOrder order) {
        this.order = order;
    }

    /**
     * getter method 
     * @Title: getExtra
     * @return the extra
     */
    public OrderReverseExtra getExtra() {
        return extra;
    }

    /**
    * setter method
    * @param extra the extra to set
    */
    public void setExtra(OrderReverseExtra extra) {
        this.extra = extra;
    }
    
}
