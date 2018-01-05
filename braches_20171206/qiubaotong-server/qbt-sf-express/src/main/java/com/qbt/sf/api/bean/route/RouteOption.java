package com.qbt.sf.api.bean.route;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @ClassName: OrderFilterPushOption
 * @Description: TODO
 * @author wuwang-win8 2016�?8�?4�?
 * @modify wuwang-win8 2016�?8�?4�?
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class RouteOption {
	@XmlAttribute
	private int weight;
	@XmlAttribute
	private String volume;
	@XmlAttribute
	private String return_tracking;
	@XmlAttribute
	private String express_type;
	@XmlAttribute
	private String children_nos;
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getReturn_tracking() {
		return return_tracking;
	}
	public void setReturn_tracking(String return_tracking) {
		this.return_tracking = return_tracking;
	}
	public String getExpress_type() {
		return express_type;
	}
	public void setExpress_type(String express_type) {
		this.express_type = express_type;
	}
	public String getChildren_nos() {
		return children_nos;
	}
	public void setChildren_nos(String children_nos) {
		this.children_nos = children_nos;
	}
	 
	 
	

	
}
