/**
 * @Title: OrderServiceAddService.java
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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: OrderServiceAddService
  * @Description: TODO
  * @author froad-win10 2016�?8�?4�?
  * @modify froad-win10 2016�?8�?4�?
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderReverseAddedService {
    @XmlAttribute(name="name")
    private String name;
    
    @XmlAttribute(name="value")
    private String value;
    
    @XmlAttribute(name="value1")
    private String value1;

    /**
     * getter method 
     * @Title: getName
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
    * setter method
    * @param name the name to set
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method 
     * @Title: getValue
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
    * setter method
    * @param value the value to set
    */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * getter method 
     * @Title: getValue1
     * @return the value1
     */
    public String getValue1() {
        return value1;
    }

    /**
    * setter method
    * @param value1 the value1 to set
    */
    public void setValue1(String value1) {
        this.value1 = value1;
    }
    
    
    
    
}
