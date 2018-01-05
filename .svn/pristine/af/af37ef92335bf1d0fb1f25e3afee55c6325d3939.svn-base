package com.geling.msg.util;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

public class StringUtil
{
  private static final char[] bcdLookup = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static boolean isNull(Object object)
  {
    if ((object instanceof String)) {
      return isEmpty(object.toString());
    }
    return object == null;
  }
  
  public static boolean isEmpty(String value)
  {
    return (value == null) || (value.trim().length() == 0) || ("null".endsWith(value));
  }
  
  public static String null2String(Object obj)
  {
    return obj == null ? "" : obj.toString();
  }
  
  public static String null2String(String str)
  {
    return str == null ? "" : str;
  }
  
  public static String iso2Gb(String gbString)
  {
    if (gbString == null) {
      return null;
    }
    String outString = "";
    try
    {
      byte[] temp = null;
      temp = gbString.getBytes("ISO8859-1");
      outString = new String(temp, "GB2312");
    }
    catch (UnsupportedEncodingException e) {}
    return outString;
  }
  
  public static String iso2Utf(String isoString)
  {
    if (isoString == null) {
      return null;
    }
    String outString = "";
    try
    {
      byte[] temp = null;
      temp = isoString.getBytes("ISO8859-1");
      outString = new String(temp, "UTF-8");
    }
    catch (UnsupportedEncodingException e) {}
    return outString;
  }
  
  public static String str2Gb(String inString)
  {
    if (inString == null) {
      return null;
    }
    String outString = "";
    try
    {
      byte[] temp = null;
      temp = inString.getBytes();
      outString = new String(temp, "GB2312");
    }
    catch (UnsupportedEncodingException e) {}
    return outString;
  }
  
  public static String fillZero(String dealCode)
  {
    String zero = "";
    if (dealCode.length() < 3) {
      for (int i = 0; i < 3 - dealCode.length(); i++) {
        zero = zero + "0";
      }
    }
    return zero + dealCode;
  }
  
  public static String fillZero(String value, int len)
  {
    if ((isNull(value)) || (len <= 0)) {
      throw new IllegalArgumentException("参数不正确");
    }
    String zero = "";
    int paramLen = value.trim().length();
    if (paramLen < len) {
      for (int i = 0; i < len - paramLen; i++) {
        zero = zero + "0";
      }
    }
    return zero + value;
  }
  
  public static String convertAmount(String amount)
  {
    String str = String.valueOf(Double.parseDouble(amount));
    int pos = str.indexOf(".");
    int len = str.length();
    if (len - pos < 3) {
      return str.substring(0, pos + 2) + "0";
    }
    return str.substring(0, pos + 3);
  }
  
  public static String to10(String opStr)
  {
    String zm = "#123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int lenOfOp = opStr.length();
    long result = 0L;
    for (int i = 0; i < lenOfOp; i++)
    {
      String indexOfOp = opStr.substring(i, i + 1);
      int js = zm.indexOf(indexOfOp);
      result = result * 36L + js;
    }
    String jg = String.valueOf(result);
    int bc = 12 - jg.length();
    String jgq = "";
    for (int j = 0; j < bc; j++) {
      jgq = jgq + "0";
    }
    return jgq + jg;
  }
  
  public static String to36(String originalStr)
  {
    long oVal = Long.parseLong(originalStr);
    

    String result = "";
    String zm = "#123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i = 1; i < 9; i++)
    {
      long shang = oVal / 36L;
      int yushu = (int)(oVal % 36L);
      result = zm.substring(yushu, yushu + 1) + result;
      oVal = shang;
    }
    return result;
  }
  
  public static String to36shortly(String originalStr)
  {
    long oVal = Long.parseLong(originalStr);
    

    String result = "";
    String zm = "123456789ACDEFGHJKLMNPRTUVWXY";
    for (int i = 1; i < 9; i++)
    {
      long shang = oVal / 36L;
      int yushu = (int)(oVal % 29L);
      result = zm.substring(yushu, yushu + 1) + result;
      oVal = shang;
    }
    return result;
  }
  
  public static String encDealId(String dealid)
  {
    if (dealid.length() != 23) {
      return "notval";
    }
    String ny = dealid.substring(5, 7);
    String sq = dealid.substring(11, 21);
    
    return to36(ny + sq);
  }
  
  public static String decDealId(String opStr)
  {
    return to10(opStr);
  }
  
  public static String[] numToWords(String money)
  {
    int j = money.length();
    String[] str = new String[j];
    for (int i = 0; i < j; i++) {
      switch (money.charAt(i))
      {
      case '0': 
        str[i] = "零";
        break;
      case '1': 
        str[i] = "壹";
        break;
      case '2': 
        str[i] = "贰";
        break;
      case '3': 
        str[i] = "叁";
        break;
      case '4': 
        str[i] = "肆";
        break;
      case '5': 
        str[i] = "伍";
        break;
      case '6': 
        str[i] = "陆";
        break;
      case '7': 
        str[i] = "柒";
        break;
      case '8': 
        str[i] = "捌";
        break;
      case '9': 
        str[i] = "玖";
        break;
      case '.': 
        str[i] = "点";
      }
    }
    return str;
  }
  
  public static String money2BigFormat(String money)
  {
    String[] bigNumber = numToWords(money);
    int len = bigNumber.length;
    if (len > 11) {
      return "数额过高";
    }
    StringBuffer sb = new StringBuffer();
    if (len >= 7)
    {
      if (len == 11)
      {
        sb.append(bigNumber[0] + "仟");
        sb.append(bigNumber[1] + "佰" + bigNumber[2] + "拾" + bigNumber[3] + "万");
      }
      if (len == 10) {
        sb.append(bigNumber[0] + "佰" + bigNumber[1] + "拾" + bigNumber[2] + "万");
      }
      if (len == 9) {
        sb.append(bigNumber[0] + "拾" + bigNumber[1] + "万");
      }
      if (len == 8) {
        sb.append(bigNumber[0] + "万");
      }
      sb.append(bigNumber[(len - 7)] + "仟" + bigNumber[(len - 6)] + "佰" + bigNumber[(len - 5)] + "拾");
    }
    if (len == 6) {
      sb.append(bigNumber[0] + "佰" + bigNumber[1] + "拾");
    }
    if (len == 5) {
      sb.append(bigNumber[0] + "拾");
    }
    sb.append(bigNumber[(len - 4)] + "元" + bigNumber[(len - 2)] + "角" + bigNumber[(len - 1)] + "分整");
    
    return sb.toString();
  }
  
  public static String formatCurrecy(String currency)
  {
    if ((null == currency) || ("".equals(currency)) || ("null".equals(currency))) {
      return "";
    }
    NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
    try
    {
      return usFormat.format(Double.parseDouble(currency));
    }
    catch (Exception e) {}
    return "";
  }
  
  public static String formatCurrecy(String currency, String currencyCode)
  {
    try
    {
      if ((null == currency) || ("".equals(currency)) || ("null".equals(currency))) {
        return "";
      }
      if (currencyCode.equalsIgnoreCase("1"))
      {
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        
        return usFormat.format(Double.parseDouble(currency));
      }
      return currency + "点";
    }
    catch (Exception e) {}
    return "";
  }
  
  public static String[] split(String str)
  {
    return split(str, null, -1);
  }
  
  public static String[] split(String text, String separator)
  {
    return split(text, separator, -1);
  }
  
  public static String[] split(String str, String separator, int max)
  {
    StringTokenizer tok = null;
    if (separator == null) {
      tok = new StringTokenizer(str);
    } else {
      tok = new StringTokenizer(str, separator);
    }
    int listSize = tok.countTokens();
    if ((max > 0) && (listSize > max)) {
      listSize = max;
    }
    String[] list = new String[listSize];
    int i = 0;
    int lastTokenBegin = 0;
    int lastTokenEnd = 0;
    while (tok.hasMoreTokens())
    {
      if ((max > 0) && (i == listSize - 1))
      {
        String endToken = tok.nextToken();
        lastTokenBegin = str.indexOf(endToken, lastTokenEnd);
        list[i] = str.substring(lastTokenBegin);
        break;
      }
      list[i] = tok.nextToken();
      lastTokenBegin = str.indexOf(list[i], lastTokenEnd);
      lastTokenEnd = lastTokenBegin + list[i].length();
      i++;
    }
    return list;
  }
  
  public static String replace(String text, String repl, String with)
  {
    return replace(text, repl, with, -1);
  }
  
  private static String replace(String text, String repl, String with, int max)
  {
    if (text == null) {
      return null;
    }
    StringBuffer buf = new StringBuffer(text.length());
    int start = 0;
    int end = text.indexOf(repl, start);
    while (end != -1)
    {
      buf.append(text.substring(start, end)).append(with);
      start = end + repl.length();
      
      max--;
      if (max == 0) {
        break;
      }
      end = text.indexOf(repl, start);
    }
    buf.append(text.substring(start));
    return buf.toString();
  }
  
  @SuppressWarnings("rawtypes")
public static String replaceVariable(String src, Map value)
  {
    int len = src.length();
    StringBuffer buf = new StringBuffer(len);
    for (int i = 0; i < len; i++)
    {
      char c = src.charAt(i);
      if (c == '$')
      {
        i++;
        StringBuffer key = new StringBuffer();
        char temp = src.charAt(i);
        while (temp != '}')
        {
          if (temp != '{') {
            key.append(temp);
          }
          i++;
          temp = src.charAt(i);
        }
        String variable = (String)value.get(key.toString());
        if (null == variable) {
          buf.append("");
        } else {
          buf.append(variable);
        }
      }
      else
      {
        buf.append(c);
      }
    }
    return buf.toString();
  }
  
  public static String utfToGBK(byte[] srcByte)
    throws Exception
  {
    StringBuffer str = new StringBuffer();
    int len = srcByte.length;
    
    int count = 0;
    while (count < len)
    {
      int char1 = srcByte[count] & 0xFF;
      int char2;
      switch (char1 >> 4)
      {
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        count++;
        str.append((char)char1);
        break;
      case 12: 
      case 13: 
        count += 2;
        if (count > len) {
          throw new Exception();
        }
        char2 = srcByte[(count - 1)];
        if ((char2 & 0xC0) != 128) {
          throw new Exception();
        }
        str.append((char)((char1 & 0x1F) << 6 | char2 & 0x3F));
        break;
      case 14: 
        count += 3;
        if (count > len) {
          throw new Exception();
        }
        char2 = srcByte[(count - 2)];
        int char3 = srcByte[(count - 1)];
        if (((char2 & 0xC0) != 128) || ((char3 & 0xC0) != 128)) {
          throw new Exception();
        }
        str.append((char)((char1 & 0xF) << 12 | (char2 & 0x3F) << 6 | (char3 & 0x3F) << 0));
        
        break;
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      default: 
        throw new Exception();
      }
    }
    return str.toString();
  }
  
  public static byte[] getUTFBytes(String s, String charset)
  {
    try
    {
      int pos = 0;
      if (charset != null) {
        s = new String(s.getBytes(), charset);
      }
      char[] cc = s.toCharArray();
      byte[] buf = new byte[cc.length * 3];
      for (int i = 0; i < cc.length; i++)
      {
        char c = cc[i];
        if ((c <= '') && (c != 0))
        {
          buf[(pos++)] = ((byte)c);
        }
        else if (c > '߿')
        {
          buf[(pos + 2)] = ((byte)(0x80 | c >> '\000' & 0x3F));
          buf[(pos + 1)] = ((byte)(0x80 | c >> '\006' & 0x3F));
          buf[(pos + 0)] = ((byte)(0xE0 | c >> '\f' & 0xF));
          pos += 3;
        }
        else
        {
          buf[(pos + 1)] = ((byte)(0x80 | c >> '\000' & 0x3F));
          buf[(pos + 0)] = ((byte)(0xC0 | c >> '\006' & 0x1F));
          pos += 2;
        }
      }
      byte[] tmp = new byte[pos];
      for (int i = 0; i < pos; i++) {
        tmp[i] = buf[i];
      }
      return tmp;
    }
    catch (Exception ex) {}
    return null;
  }
  
  public static int utfLength(String value)
  {
    int utflen = 0;
    char[] val = value.toCharArray();
    for (int i = 0; i < value.length(); i++)
    {
      int c = val[i];
      if ((c >= 1) && (c <= 127)) {
        utflen++;
      } else if (c > 2047) {
        utflen += 3;
      } else {
        utflen += 2;
      }
    }
    return utflen;
  }
  
  public static String couponIdGenerator(String src)
  {
    String srcTemp = null;
    String dst = null;
    int iSrc = 0;
    if (src == null) {
      srcTemp = "        ";
    } else if (src.equals("")) {
      srcTemp = "        ";
    } else {
      srcTemp = src;
    }
    for (int i = 0; i < srcTemp.length(); i++) {
      iSrc += (249 - i) * srcTemp.charAt(i);
    }
    dst = iSrc + "";
    return dst;
  }
  
  public static String getAliasName(String name)
  {
    StringBuilder sb = new StringBuilder("SonicJMSRASubcontext/Sonic_");
    StringTokenizer st = new StringTokenizer(name, ".");
    while (st.hasMoreTokens())
    {
      String token = st.nextToken();
      sb.append(first2Upper(token));
    }
    return sb.toString();
  }
  
  public static String first2Upper(String str)
  {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
  
  public static final String bytesToHexStr(byte[] bcd)
  {
    StringBuffer s = new StringBuffer(bcd.length * 2);
    for (int i = 0; i < bcd.length; i++)
    {
      s.append(bcdLookup[(bcd[i] >>> 4 & 0xF)]);
      s.append(bcdLookup[(bcd[i] & 0xF)]);
    }
    return s.toString();
  }
  
  public static final byte[] hexStrToBytes(String s)
  {
    byte[] bytes = new byte[s.length() / 2];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = ((byte)Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16));
    }
    return bytes;
  }
  
  public static String hexString(byte[] b)
  {
    StringBuffer d = new StringBuffer(b.length * 2);
    for (int i = 0; i < b.length; i++)
    {
      char hi = Character.forDigit(b[i] >> 4 & 0xF, 16);
      char lo = Character.forDigit(b[i] & 0xF, 16);
      d.append(Character.toUpperCase(hi));
      d.append(Character.toUpperCase(lo));
    }
    return d.toString();
  }
  
  public static byte[] hex2byte(byte[] b, int offset, int len)
  {
    byte[] d = new byte[len];
    for (int i = 0; i < len * 2; i++)
    {
      int shift = i % 2 == 1 ? 0 : 4; int 
        tmp35_34 = (i >> 1); byte[] tmp35_30 = d;tmp35_30[tmp35_34] = ((byte)(tmp35_30[tmp35_34] | Character.digit((char)b[(offset + i)], 16) << shift));
    }
    return d;
  }
  
  public static byte[] hex2byte(String s)
  {
    return hex2byte(s.getBytes(), 0, s.length() >> 1);
  }
  
  public static String arrayToDelimitedString(Object[] arr, String delim)
  {
    if ((arr == null) || (arr.length == 0)) {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < arr.length; i++)
    {
      if (i > 0) {
        sb.append(delim);
      }
      sb.append('\'');
      sb.append(arr[i]);
      sb.append('\'');
    }
    return sb.toString();
  }
  
  public static String arrayToStr(Object[] arr, char split)
  {
    if ((arr == null) || (arr.length == 0)) {
      return null;
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < arr.length; i++)
    {
      if (i > 0) {
        sb.append(split);
      }
      sb.append(arr[i]);
    }
    return sb.toString();
  }
  
	public static String convertCharset(String xml, String charset, String to) {
		try {
			return new String(xml.toString().getBytes(charset), to);
		} catch (Exception e) {
			
		}
		return xml;
	}
}
