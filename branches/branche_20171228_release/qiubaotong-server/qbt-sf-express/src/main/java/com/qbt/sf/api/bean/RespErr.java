
package com.qbt.sf.api.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;



@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})  
public class RespErr {

    @XmlAttribute(name="code")
    private String  code;
    
    @XmlValue
    private String value;
    
   
    /**
     * getter method 
     * @Title: getCode
     * @return the code
     */
    public String getCode() {
        return code;
    }

 

    /**
    * setter method
    * @param code the code to set
    */
    public void setCode(String code) {
        this.code = code;
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
      * @Title: toString
      * @Description: TODO
      * @author: win8 2016年8月5日
      * @modify: win82016年8月5日
      * @return
      * @see java.lang.Object#toString()
      */
    
    
    @Override
    public String toString() {
        return "OrderConfirmServiceRespErr [code=" + code + ", value=" + value + "]";
    }


    

}
