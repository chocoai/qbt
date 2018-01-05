package com.qbt.web.pojo.message;

import javax.validation.constraints.NotNull;

public class MessageVo {

	@NotNull(message="短信模板不能为空")
	private String template_id;
	@NotNull(message="短信内容为空")
	private String[] contents;
	@NotNull(message="手机号不能为空")
	private String[] mobiles;

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	
	
	public String[] getMobiles() {
		return mobiles;
	}

	public void setMobiles(String[] mobiles) {
		this.mobiles = mobiles;
	}

	public String[] getContents() {
		return contents;
	}

	public void setContents(String[] contents) {
		this.contents = contents;
	}
	
	
	
}
