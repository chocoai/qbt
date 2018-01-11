package com.qbt.common.enums;

import com.qbt.common.util.StringUtil;

public enum LanguagesEnum {


	  CHINA("zh-cn","中文"), 
	  japanese("ja-jp","日语");

	  String value;
	  String desc;

	  private LanguagesEnum(String value,String desc) { this.value = value; this.desc = desc;}

	  public String getValue() {
	    return this.value;
	  }

	  public static boolean checkIsJapanese(String lang){
		  if(StringUtil.isEmpty(lang)){
			  return false;
		  }
		  if(LanguagesEnum.japanese.getValue().equalsIgnoreCase(lang)){
			  return true;
		  }
		  return false;
	  }
	  
		public static String getByCode(String code){
			if(code != null){
				for(LanguagesEnum s : values()){
					if(s.getValue().equals(code)){
						return s.getDesc();
					}
				}
			}
			return "中文";
		}

		public String getDesc() {
			return desc;
		}
}
