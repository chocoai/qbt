/**
 * @Title: OrderServiceExtra.java
 * @Package com.froad.iamp.xml2bean.api
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016�?8�?4�?
 * @version V1.0
**/

package com.qbt.sf.api.bean.orderconfirm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: OrderConfirmExtra
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
public class OrderConfirmExtra {

    @XmlAttribute
    private String e1;
    
    @XmlAttribute
    private String e2;

    /**
     * getter method 
     * @Title: getE1
     * @return the e1
     */
    public String getE1() {
        return e1;
    }

    /**
    * setter method
    * @param e1 the e1 to set
    */
    public void setE1(String e1) {
        this.e1 = e1;
    }

    /**
     * getter method 
     * @Title: getE2
     * @return the e2
     */
    public String getE2() {
        return e2;
    }

    /**
    * setter method
    * @param e2 the e2 to set
    */
    public void setE2(String e2) {
        this.e2 = e2;
    }
    
    

}
