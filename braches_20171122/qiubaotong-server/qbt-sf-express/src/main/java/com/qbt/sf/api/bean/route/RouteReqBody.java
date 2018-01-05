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

package com.qbt.sf.api.bean.route;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: RouteServiceBody
  * @Description: TODO
  * @author wuwang-win8 2016年8月4日
  * @modify wuwang-win8 2016年8月4日
 */

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class RouteReqBody {
    
    @XmlElement(name="RouteRequest")
    private RouteRepOrder route;
    
     /**
     * getter method 
     * @Title: getOrder
     * @return the order
     */
    public RouteRepOrder getRoute() {
		return route;
	}

	public void setRoute(RouteRepOrder route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "RouteReqBody [route=" + route + "]";
	}
    
    /**
     * getter method 
     * @Title: getExtra
     * @return the extra
     */
  /*  public RouteExtra getExtra() {
        return extra;
    }*/


	/**
    * setter method
    * @param extra the extra to set
    */
   /* public void setExtra(RouteExtra extra) {
        this.extra = extra;
    }*/
    
}
