
package com.qbt.sf.api.bean.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: OrderReq
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Request") 
@XmlType(propOrder = {})  
public class OrderReq {
    @XmlAttribute
    private String service="OrderService";
    
    @XmlAttribute
    private String lang="zh-CN";
    
    @XmlElement  (name="Head")
    private String head;
    
    @XmlElement(name="Body")
    private OrderReqBody body;
    
    /**
     * getter method 
     * @Title: getService
     * @return the service
     */
    public String getService() {
        return service;
    }
    /**
    * setter method
    * @param service the service to set
    */
    public void setService(String service) {
        this.service = service;
    }
    /**
     * getter method 
     * @Title: getLang
     * @return the lang
     */
    public String getLang() {
        return lang;
    }
    /**
    * setter method
    * @param lang the lang to set
    */
    public void setLang(String lang) {
        this.lang = lang;
    }
    /**
     * getter method 
     * @Title: getHead
     * @return the head
     */
    public String getHead() {
        return head;
    }
    /**
    * setter method
    * @param head the head to set
    */
    public void setHead(String head) {
        this.head = head;
    }
    /**
     * getter method 
     * @Title: getBody
     * @return the body
     */
    public OrderReqBody getBody() {
        return body;
    }
    /**
    * setter method
    * @param body the body to set
    */
    public void setBody(OrderReqBody body) {
        this.body = body;
    }
   
    
   
}
