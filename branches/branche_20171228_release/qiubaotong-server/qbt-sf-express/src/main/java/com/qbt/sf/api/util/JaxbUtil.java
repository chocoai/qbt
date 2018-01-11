
package com.qbt.sf.api.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;


/**
  * @ClassName: JaxbUtil
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
public class JaxbUtil {

	
	/**
	  * @Title: convertToXml
	  * @Description: bean To xml
	  * @author: win10 2016年8月4日
	  * @modify: win10 2016年8月4日
	  * @param obj
	  * @return
	 */
	public static String convertToXml(Object obj) {
		return convertToXml(obj, "UTF-8");
	}
	
	public static String convertToXml(Object obj, String encoding) {
		String result = null;
		if(Checker.isEmpty(obj)){
			return result;
		}
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}

		return result;
	}
	

	/**
	  * @Title: converyToJavaBean
	  * @Description: xml to bean
	  * @author: win10 2016年8月4日
	  * @modify: win10 2016年8月4日
	  * @param xml
	  * @param c
	  * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c) {
		T t = null;
		if(Checker.isEmpty(xml)){
			return t;
		}
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}

		return t;
	}
}
