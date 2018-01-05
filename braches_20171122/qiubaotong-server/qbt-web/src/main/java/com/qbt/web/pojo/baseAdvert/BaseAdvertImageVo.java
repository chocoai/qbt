/**
 * Project Name:qbt-web
 * File Name:BaseAdvertImageVo.java
 * Package Name:com.qbt.web.pojo.baseAdvert
 * Date:2017年10月11日上午10:55:28
 *
*/

package com.qbt.web.pojo.baseAdvert;
/**
 * ClassName:BaseAdvertImageVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月11日 上午10:55:28
 * @author   wuwang
 * @version  
 * @see 	 
 */
public class BaseAdvertImageVo {

	//图片地址
	private String image;

	//图片url
    private String url;
    
    //顺序
    private Integer number;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
    
}
