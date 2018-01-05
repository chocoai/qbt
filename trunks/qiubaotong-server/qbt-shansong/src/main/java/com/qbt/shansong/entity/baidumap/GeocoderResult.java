/**
 * Project Name:qbt-shansong
 * File Name:GeocoderResult.java
 * Package Name:com.qbt.shansong.entity.baidumap
 * Date:2017年2月23日下午2:04:04
 *
*/

package com.qbt.shansong.entity.baidumap;
/**
 * ClassName:GeocoderResult
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午2:04:04
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class GeocoderResult {
	
	private GeocoderLocation location;
	
	//位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点。
	private Integer precise;
		
	//可信度，描述打点准确度
	private Integer confidence;
		
	//地址类型
	private String level;

	public GeocoderLocation getLocation() {
		return location;
	}

	public void setLocation(GeocoderLocation location) {
		this.location = location;
	}

	public Integer getPrecise() {
		return precise;
	}

	public void setPrecise(Integer precise) {
		this.precise = precise;
	}

	public Integer getConfidence() {
		return confidence;
	}

	public void setConfidence(Integer confidence) {
		this.confidence = confidence;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}
