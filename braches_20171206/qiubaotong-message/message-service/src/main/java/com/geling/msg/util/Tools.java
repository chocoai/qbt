
 /**
 * @Title: Tools.java
 * @Package com.geling.msg.util
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater Administrator 2016年11月1日
 * @version V1.0
 **/

package com.geling.msg.util;

import java.util.Random;

/**
  * @ClassName: Tools
  * @Description: TODO
  * @author Administrator 2016年11月1日
  * @modify Administrator 2016年11月1日
  */

public class Tools {

	public static String getOnlyPK(){
        String timePK = DateUtil.formatDateTime( DateUtil.DATE_TIME_FORMAT6);
        int min = 1000;
        int max = 9999;
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        tmp = tmp % ((max - min) + 1) + min;
        return (new StringBuilder(String.valueOf(timePK))).append(tmp).toString();
    }
	
}
