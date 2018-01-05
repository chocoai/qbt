package com.qbt.common.util;

import com.qbt.common.logback.LogCvt;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XmlUtils {

	/**
	 *  xml to object
	  * @Title: xmlToObj
	  * @Description: TODO
	  * @author: share 2017年2月21日
	  * @modify: share 2017年2月21日
	  * @param xml
	  * @param destClasz
	  * @return
	 */
	public static  <T> T xmlToObj(String xml,Class<T> destClasz) {
		try {
			XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
			xStream.ignoreUnknownElements();
			xStream.processAnnotations(new Class[]{destClasz});
			LogCvt.info("转换xml:"+xml);
			xml = StringUtil.convertCharset(xml, "UTF-8", "ISO-8859-1");
			T resp = (T)xStream.fromXML(xml);
			return resp;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return null;
	}

	/**
	 *  Object to Xml
	  * @Title: objToOXml
	  * @Description: TODO
	  * @author: share 2017年2月21日
	  * @modify: share 2017年2月21日
	  * @param xml
	  * @param destClasz
	  * @return
	 */
	public static String objToXml(Object xml, Class[] destClasz) {
		// TODO Auto-generated method stub
		try {
			XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
			xStream.ignoreUnknownElements();
			if(destClasz != null && destClasz.length > 0){
				xStream.processAnnotations(destClasz);
			}
			LogCvt.info("转换xml:"+xml);
			String resp = xStream.toXML(xml);
			return resp;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		return null;
	}
}
