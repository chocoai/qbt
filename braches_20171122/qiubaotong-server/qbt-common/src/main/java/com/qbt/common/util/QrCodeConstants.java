package com.qbt.common.util;

import java.awt.Color;
import java.awt.Font;

public class QrCodeConstants {
	/**
	 * 空白字符串
	 */
	public static final String BLANK_STRING = "";
	/**
	 * 斜杠
	 */
	public static final String SLASH = "/";
	/**
	 * 双反斜杠
	 */
	public static final String DOUBLE_BACKSLASH = "\\";	

	/**
	 * 二维码图片默认宽度
	 */
	public static final int QR_IMAGE_WIDTH = 300;
	/**
	 * 二维码图片默认长度
	 */
	public static final int QR_IMAGE_HEIGHT = 300;
	
	/** 图片宽度 */
	public static final int IMAGE_WIDTH = 80;

	/** 图片高度 */
	public static final int IMAGE_HEIGHT = 35;

	/** 最小字体大小 */
	public static final int MIN_FONT_SIZE = 18;

	/** 最大字体大小 */
	public static final int MAX_FONT_SIZE = 20;

	/** 最小字符个数 */
	public static final int MIN_WORD_LENGTH = 4;

	/** 最大字符个数 */
	public static final int MAX_WORD_LENGTH = 4;

	/** 随机背景图片路径 */
	public static final String BACKGROUND_IMAGE_PATH = "./config/captcha/";
	
	/*public static final Font[] FONTS = new Font[] { new Font("nyala", Font.BOLD, MAX_FONT_SIZE), new Font("Arial", Font.BOLD, MAX_FONT_SIZE), new Font("nyala", Font.BOLD, MAX_FONT_SIZE), new Font("Bell", Font.BOLD, MAX_FONT_SIZE), new Font("Bell MT", Font.BOLD, MAX_FONT_SIZE), new Font("Credit", Font.BOLD, MAX_FONT_SIZE), new Font("valley", Font.BOLD, MAX_FONT_SIZE),
		new Font("Impact", Font.BOLD, MAX_FONT_SIZE) };*/
	public static final Font[] FONTS = new Font[] { 
		Font.decode("华文细黑") };
	
	
	public static final Color[] COLORS = new Color[] { new Color(255, 255, 255), new Color(255, 220, 220), new Color(220, 255, 255), new Color(220, 220, 255), new Color(255, 255, 220), new Color(220, 255, 220) };
	
}
