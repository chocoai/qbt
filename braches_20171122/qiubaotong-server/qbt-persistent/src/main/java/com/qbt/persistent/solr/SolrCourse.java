/**
 * Project Name:qbt-persistent
 * File Name:SolrCourse.java
 * Package Name:com.qbt.persistent.solr
 * Date:2017年3月30日下午3:59:54
 *
*/

package com.qbt.persistent.solr;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

import com.qbt.common.entity.search.SolrLocation;
import com.qbt.common.util.Checker;
import com.qbt.common.util.CollectionsUtil;

/**
 * ClassName:SolrCourse
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月30日 下午3:59:54
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SolrCourse {
	
	@Field
	private Integer id;
	
	@Field
	private String name;
	
	@Field
    private String shortName;
	
	@Field
    private String englishName;
	
	@Field
    private String initial;
	
	@Field
    private String firstLetter;
	
	@Field
    private String logo;
	
	@Field
    private Integer areaId;
	
	@Field
    private String treePath;
	
	@Field
    private String address;
	
	@Field
    private Integer status;
	
	@Field
    private Boolean isDelete;
    
	@Field
    private Boolean isOutRange;
    
	@Field
    private Double outRangeTime;
    
	@Field
    private Double outRangePrice;
    
	@Field
    private Boolean isTip;
    
	@Field
    private String wechatTip;
    
    @Field
    private Boolean isPractice;
	
    @Field
    private Integer golfHole;
    
    @Field
    private String telephone;
    
    @Field
    private String contact;
    
    @Field
    private String mobile;
    
    @Field
    private Boolean hasAssistant;
    
    @Field
    private String latlng;
    
    private SolrLocation location;
    
    private double dist; // 距离

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsOutRange() {
		return isOutRange;
	}

	public void setIsOutRange(Boolean isOutRange) {
		this.isOutRange = isOutRange;
	}

	public Double getOutRangeTime() {
		return outRangeTime;
	}

	public void setOutRangeTime(Double outRangeTime) {
		this.outRangeTime = outRangeTime;
	}

	public Double getOutRangePrice() {
		return outRangePrice;
	}

	public void setOutRangePrice(Double outRangePrice) {
		this.outRangePrice = outRangePrice;
	}

	public Boolean getIsTip() {
		return isTip;
	}

	public void setIsTip(Boolean isTip) {
		this.isTip = isTip;
	}

	public String getWechatTip() {
		return wechatTip;
	}

	public void setWechatTip(String wechatTip) {
		this.wechatTip = wechatTip;
	}

	public Boolean getIsPractice() {
		return isPractice;
	}

	public void setIsPractice(Boolean isPractice) {
		this.isPractice = isPractice;
	}

	public Integer getGolfHole() {
		return golfHole;
	}

	public void setGolfHole(Integer golfHole) {
		this.golfHole = golfHole;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getHasAssistant() {
		return hasAssistant;
	}

	public void setHasAssistant(Boolean hasAssistant) {
		this.hasAssistant = hasAssistant;
	}

	public double getDist() {
		return dist;
	}

	public void setDist(double dist) {
		this.dist = dist;
	}

	public String getLatlng() {
		return latlng;
	}

	public void setLatlng(String latlng) {
		this.latlng = latlng;
	}

	public SolrLocation getLocation() {
		return location;
	}

	public void setLocation(SolrLocation location) {
		this.location = location;
		if(Checker.isNotEmpty(location)){
			String latlng = location.getLatitude() + "," + location.getLongitude();
			setLatlng(latlng);
		}
	}
    
}
