package com.qbt.sf.api.bean.queryfreight;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import com.qbt.sf.api.bean.scope.ScopeRespDeliver;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})
public class QueryFreightResqBody {
	@XmlElementWrapper(name="QueryFreightResponse")
	@XmlElement(name="QueryFreight")
	private List<QueryFreightRespDeliver> deliverQueryFreight;
	
	@Override
	public String toString() {
		return "QueryFreightResqBody [deliverQueryFreight="
				+ deliverQueryFreight + "]";
	}

	public List<QueryFreightRespDeliver> getDeliverQueryFreight() {
		return deliverQueryFreight;
	}

	public void setDeliverQueryFreight(
			List<QueryFreightRespDeliver> deliverQueryFreight) {
		this.deliverQueryFreight = deliverQueryFreight;
	}
}


	