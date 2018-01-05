package com.qbt.sf.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JaxbDateAdapter extends XmlAdapter<String, Date> {
	
	private static String format = "yyyy-MM-dd HH:mm:ss";
	
	@Override
	public Date unmarshal(String v) throws Exception {
		if (v == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		if (v == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(v);
	}

}
