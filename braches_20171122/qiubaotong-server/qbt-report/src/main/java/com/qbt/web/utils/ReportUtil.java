package com.qbt.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportUtil {
	
	public static void initResp(HttpServletRequest request, HttpServletResponse response, String fileName) throws UnsupportedEncodingException{
		response.setContentType("application/x-excel");
        fileName = URLEncoder.encode(fileName, "utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+fileName);
	}
}
