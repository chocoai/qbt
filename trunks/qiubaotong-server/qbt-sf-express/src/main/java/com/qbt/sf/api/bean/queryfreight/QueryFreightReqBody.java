package com.qbt.sf.api.bean.queryfreight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.delivertm.DeliverTmReqDeliver;
import com.qbt.sf.api.bean.scope.ScopeReqDeliver;

/**
 * @ClassName: DeliverTmReqBody
 * @Description: TODO
 * @author win8 2016年8月6日
 * @modify win8 2016年8月6日
 */
/**
 * @author wuwang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})  
public class QueryFreightReqBody {
	 
	 @XmlElement(name="QueryFreightReqDeliver")
	  private QueryFreightReqDeliver queryFreightReqDeliver;

	public QueryFreightReqDeliver getQueryFreightReqDeliver() {
		return queryFreightReqDeliver;
	}

	public void setQueryFreightReqDeliver(
			QueryFreightReqDeliver queryFreightReqDeliver) {
		this.queryFreightReqDeliver = queryFreightReqDeliver;
	}

	@Override
	public String toString() {
		return "QueryFreightReqBody [queryFreightReqDeliver="
				+ queryFreightReqDeliver + "]";
	}
	
}




	