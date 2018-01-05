package com.qbt.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.lang.StringUtils;

import com.qbt.common.util.ToolsUtil;

public class VipNo {
	
	public static void main(String[] args) throws Exception {
		
		String sql = "insert into vip_create_info (create_time,update_time,vip_create_id,vip_no,vip_random,vip_order_number,sell_status,pay_amount,pay_method,activate_status,activate_date,activate_method,remark,status) "
				+ "VALUES(now(), now(),1, '{0}', '{1}', '{2}', 1, NULL, NULL, 1, NULL, NULL, NULL, 2);";
		BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/work/file/vip_card.txt")));
		String vipOrderNo = "VIP1701091";
		String line = null;
		int i = 1;
		while((line = br.readLine()) != null){
			String[] vipNos = line.split("\t");
			System.out.println(sql.replace("{0}", vipNos[0]).replace("{1}", vipNos[1]).replace("{2}", vipOrderNo+StringUtils.leftPad(String.valueOf(i), 4, '0')));
			i ++;
		}
	}
}
