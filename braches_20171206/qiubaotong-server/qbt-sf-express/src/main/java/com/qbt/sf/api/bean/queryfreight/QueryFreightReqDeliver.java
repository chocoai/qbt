package com.qbt.sf.api.bean.queryfreight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @ClassName: DeliverTmReqDeliver
 * @Description: TODO
 * @author win10 2016年8月6日
 * @modify win10 2016年8月6日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})
public class QueryFreightReqDeliver {
	
	@XmlAttribute(name="source_province")
	private String  source_province;
	
	@XmlAttribute(name="ame_source_city_n")
	private String  ame_source_city_n;
	
	@XmlAttribute(name="source_code")
	private String  source_code ;
	
	@XmlAttribute(name="dest_province ")
	private String  dest_province;
	
	@XmlAttribute(name="e_dest_city_nam")
	private String  e_dest_city_nam;
	
	@XmlAttribute(name="dest_code")
	private String  dest_code;
	
	@XmlAttribute(name="meterage_weightqty")
	private String  meterage_weightqty;
	
	@XmlAttribute(name="express_type")
	private String  express_type;
	
	public String getSource_province() {
		return source_province;
	}
	public void setSource_province(String source_province) {
		this.source_province = source_province;
	}
	public String getAme_source_city_n() {
		return ame_source_city_n;
	}
	public void setAme_source_city_n(String ame_source_city_n) {
		this.ame_source_city_n = ame_source_city_n;
	}
	public String getSource_code() {
		return source_code;
	}
	public void setSource_code(String source_code) {
		this.source_code = source_code;
	}
	public String getDest_province() {
		return dest_province;
	}
	public void setDest_province(String dest_province) {
		this.dest_province = dest_province;
	}
	public String getE_dest_city_nam() {
		return e_dest_city_nam;
	}
	public void setE_dest_city_nam(String e_dest_city_nam) {
		this.e_dest_city_nam = e_dest_city_nam;
	}
	public String getDest_code() {
		return dest_code;
	}
	public void setDest_code(String dest_code) {
		this.dest_code = dest_code;
	}
	public String getMeterage_weightqty() {
		return meterage_weightqty;
	}
	public void setMeterage_weightqty(String meterage_weightqty) {
		this.meterage_weightqty = meterage_weightqty;
	}
	public String getExpress_type() {
		return express_type;
	}
	public void setExpress_type(String express_type) {
		this.express_type = express_type;
	}
	@Override
	public String toString() {
		return "QueryFreightReqDeliver [source_province=" + source_province
				+ ", ame_source_city_n=" + ame_source_city_n + ", source_code="
				+ source_code + ", dest_province=" + dest_province
				+ ", e_dest_city_nam=" + e_dest_city_nam + ", dest_code="
				+ dest_code + ", meterage_weightqty=" + meterage_weightqty
				+ ", express_type=" + express_type + "]";
	}
}
