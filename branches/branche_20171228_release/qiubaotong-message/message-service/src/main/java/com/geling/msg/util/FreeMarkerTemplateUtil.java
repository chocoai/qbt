package com.geling.msg.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import com.geling.msg.logback.LogCvt;

import freemarker.template.Template;

public class FreeMarkerTemplateUtil {


	public static String templateParser(String templateContent,
			Map<String, String> content) {
		try {
			StringReader reader = new StringReader(templateContent);
			Template template;
			template = new Template("", reader, null);
			StringWriter out = new StringWriter();
			
			//如果传入的content 为空，则直接返回模板内容
			if (content != null) {
				template.process(content, out);

				String result = out.toString();
				LogCvt.debug("template content is:[" + result + "]");
				return result;
			}else{
				return templateContent;
			}
		} catch (Exception e) {
			LogCvt.error("templateContent = " + templateContent + "\ncontent = "
					+ content,e);
			e.printStackTrace();
		}
		return null;
	}
}
