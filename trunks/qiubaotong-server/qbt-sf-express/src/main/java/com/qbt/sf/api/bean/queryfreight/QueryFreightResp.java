
 /**
 * @Title: QueryFreightResp.java
 * @Package com.qbt.sf.api.bean.queryfreight
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月5日
 * @version V1.0
 **/

package com.qbt.sf.api.bean.queryfreight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.scope.ScopeRespBody;
import com.qbt.sf.api.bean.scope.ScopeRespErr;



 /**
  * @ClassName: QueryFreightResp
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {}) 
public class QueryFreightResp {
	@XmlAttribute
    private String  service="QueryFreightService";

	@XmlElement(name="Head")
    private String  head;
    
    @XmlElement(name="Body")
    private QueryFreightRespBody body;
    
    @XmlElement(name="ERROR")
    private  QueryFreightRespErr error;


}
