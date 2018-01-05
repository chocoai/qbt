/**
 * Project Name:qbt-web
 * File Name:UserImageVo.java
 * Package Name:com.qbt.web.pojo.userImage
 * Date:2017年1月11日上午11:17:11
 *
*/

package com.qbt.web.pojo.userImage;

import javax.validation.constraints.NotNull;

/**
 * ClassName:UserImageVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 上午11:17:11
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class UserImageVo {
	
	private int id;
	
	@NotNull(message = "用户id不能为空")
	private Integer userId;
	
	@NotNull(message = "图片路径不能为空")
	private String imageUrl;
	
	private Integer type = 1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
