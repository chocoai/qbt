package com.qbt.web.pojo.userImage;

/**
 * 
 * @author wuwang
 *	指定球包vo
 */
public class UserImageAppointVo {
	
	//会员id
	private int id;
	
	//userImage图片id
	private Integer userImageId;
	
	private String imageUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getUserImageId() {
		return userImageId;
	}

	public void setUserImageId(Integer userImageId) {
		this.userImageId = userImageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
