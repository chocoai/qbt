package com.qbt.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.common.util.Arith;
import com.qbt.persistent.entity.BaseSfPrice;
import com.qbt.persistent.mapper.BaseSfPriceMapper;

@ContextConfiguration(locations = {"classpath*:context/applicationContext*.xml"}) 
public class ExcelParseSfPrice extends AbstractJUnit4SpringContextTests{

	@Resource
	private BaseSfPriceMapper baseSfPriceMapper;
	
//	public static void main(String[] args) throws IOException {
//		readXls();
//	}
	
	//首重价格+（18-1）*续重价格=顺丰价格
	@Test 
	public void readXls() throws IOException{  
	    InputStream is = new FileInputStream( "/Volumes/work/时效产品价格对比表-全网.xlsx");  
	    XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);   
	    
	    // 循环工作表Sheet  
	    XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);  
	    if(hssfSheet == null){  
	    	  return;
	      }  
	   int insertCount = 0;
	   int updateCount = 0;
      // 循环行Row
	  List<String> lines = new ArrayList<String>();
      for(int rowNum = 3; rowNum <= hssfSheet.getLastRowNum(); rowNum++){  
	        XSSFRow hssfRow = hssfSheet.getRow( rowNum);  
	        // 开始省份
        	String srcProv = getValue(hssfRow.getCell(2));  
        	// 开始城市
        	String srcCity = getValue(hssfRow.getCell(1)); 
        	 // 结束省份
        	String destProv = getValue(hssfRow.getCell(7));  
        	// 结束城市
        	String destCity = getValue(hssfRow.getCell(6)); 
        	boolean isOpenJri = getBoolValue(hssfRow.getCell(11)); 
        	boolean isOpenCichen = getBoolValue(hssfRow.getCell(12)); 
        	boolean isOpenCiri = getBoolValue(hssfRow.getCell(13)); 
        	boolean isOpenGeri = getBoolValue(hssfRow.getCell(14)); 
        	double jriFprice = -1;
        	double jriXprice = -1;
        	double jriSfPrice = -1;
        	double jriQbtprice = -1;
        	if(isOpenJri){
        		jriFprice = getDoubleValue(hssfRow.getCell(15));
        		jriXprice = getDoubleValue(hssfRow.getCell(16));
        		jriSfPrice = Arith.add(jriFprice,Arith.mul(17,jriXprice));
        		jriQbtprice = sfprice(jriSfPrice, "0");
        	}
        	double cichenFprice = -1;
        	double cichenXprice = -1;
        	double cichenSfPrice = -1;
        	double cichenQbtprice = -1;
        	if(isOpenCichen){
        		cichenFprice = getDoubleValue(hssfRow.getCell(17));
        		cichenXprice = getDoubleValue(hssfRow.getCell(18));
        		cichenSfPrice = Arith.add(cichenFprice,Arith.mul(17,cichenXprice));
        		cichenQbtprice = sfprice(cichenSfPrice, "5");
        	}
        	double ciriFprice = -1;
        	double ciriXprice = -1;
        	double ciriSfPrice = -1;
        	double ciriQbtprice = -1;
        	if(isOpenCiri){
        		ciriFprice = getDoubleValue(hssfRow.getCell(19));
        		ciriXprice = getDoubleValue(hssfRow.getCell(20));
        		ciriSfPrice = Arith.add(ciriFprice,Arith.mul(17,ciriXprice));
        		ciriQbtprice = sfprice(ciriSfPrice, "1");
        	}
        	double geriFprice = -1;
        	double geriXprice = -1;
        	double geriSfPrice = -1;
        	double geriQbtprice = -1;
        	if(isOpenGeri){
        		geriFprice = getDoubleValue(hssfRow.getCell(21));
        		geriXprice = getDoubleValue(hssfRow.getCell(22));
        		geriSfPrice = Arith.add(geriFprice,Arith.mul(17,geriXprice));
        		geriQbtprice = sfprice(geriSfPrice, "2");
        	}
        	
        	String insertSql = "INSERT INTO `base_sf_price` (`create_time`, `update_time`, `start_province`, `start_city`, `end_province`, `end_city`, `cichen_sf_price`, `cichen_qbt_price`, `cichen_first_price`, `cichen_second_price`, `ciri_sf_price`, `ciri_qbt_price`, `ciri_first_price`, `ciri_second_price`, `jiri_sf_price`, `jiri_qbt_price`, `jiri_first_price`, `jiri_second_price`, `geri_sf_price`, `geri_qbt_price`, `geri_first_price`, `geri_second_price`) "
        			+ "VALUES (now(), now(), '"+srcProv+"', '"+srcCity+"', '"+destProv+"','"+destCity+"', "+cichenSfPrice+", "+cichenQbtprice+","+cichenFprice+","+cichenXprice+","+ciriSfPrice+", "+ciriQbtprice+","+ciriFprice+","+ciriXprice+","+jriSfPrice+", "+jriQbtprice+","+jriFprice+","+jriXprice+","+geriSfPrice+", "+geriQbtprice+","+geriFprice+","+geriXprice+")";
        	
        	String updateSql = "update `base_sf_price` set "
        			+ "`cichen_sf_price`="+cichenSfPrice+","
        			+ "`cichen_qbt_price`="+cichenQbtprice+", "
        			+ "`cichen_first_price`="+cichenFprice+", "
        			+ "`cichen_second_price`="+cichenXprice+", "
        			+ "`ciri_sf_price`="+ciriSfPrice+", "
        			+ "`ciri_qbt_price`="+ciriQbtprice+", "
        			+ "`ciri_first_price`="+ciriFprice+", "
        			+ "`ciri_second_price`="+ciriXprice+", "
        			+ "`jiri_sf_price`="+jriSfPrice+", "
        			+ "`jiri_qbt_price`="+jriQbtprice+", "
        			+ "`jiri_first_price`="+jriFprice+", "
        			+ "`jiri_second_price`="+jriXprice+", "
        			+ "`geri_sf_price`="+geriSfPrice+", "
        			+ "`geri_qbt_price`="+geriQbtprice+", "
        			+ "`geri_first_price`="+geriFprice+", "
        			+ "`geri_second_price`="+geriXprice+" "
        			+ " where start_province='"+srcProv+"' and start_city='"+srcCity+"' and end_province='"+destProv+"' and end_city='"+destCity+"'";
        	
        	String whereSql = "select count(id) from base_sf_price where start_province='"+srcProv+"' and start_city='"+srcCity+"' and end_province='"+destProv+"' and end_city='"+destCity+"'";
        	BaseSfPrice sfPrice = new BaseSfPrice();
        	sfPrice.setStartCity(whereSql);
        	if(baseSfPriceMapper.whereSql(sfPrice)>0){
        		sfPrice.setStartCity(updateSql);
        		baseSfPriceMapper.updateSql(sfPrice);
        		updateCount ++;
        	}else{
        		sfPrice.setStartCity(insertSql);
        		baseSfPriceMapper.insertSql(sfPrice);
        		insertCount ++;
        	}
      	}
      	
      System.out.println(insertCount+","+updateCount);
	      
	}
	
	public static String toUpperWord(String word){
		return word.substring(0,1).toUpperCase()+word.substring(1);
	}
	
	@SuppressWarnings("static-access")  
	private static String getValue(XSSFCell hssfCell){  
	    if(hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN){  
	      return String.valueOf( hssfCell.getBooleanCellValue());  
	    }else if(hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC){  
	      return String.valueOf( hssfCell.getNumericCellValue());  
	    }else{  
	      return String.valueOf( hssfCell.getStringCellValue());  
	    }  
	  } 
	
	private static boolean getBoolValue(XSSFCell hssfCell){  
	    String value = getValue(hssfCell);
	    if("Y".equals(value.toUpperCase())){
	    	return true;
	    }
	    if("N".equals(value.toUpperCase())){
	    	return false;
	    }
	    return false;
	  } 
	
	private static double getDoubleValue(XSSFCell hssfCell){  
	    String value = getValue(hssfCell);
	    return Double.parseDouble(value);
	}
	
	/**
	 *  type 1-次日达 2-隔日达 5-次午达
	  * @Title: sfprice
	  * @Description: TODO
	  * @author: share 2016年10月12日
	  * @modify: share 2016年10月12日
	  * @param price
	  * @param type
	  * @return
	 */
	public static double sfprice(double price,String type){
		double addprice = 0;
		if("1".equalsIgnoreCase(type)){
			addprice = 20;
		}else if("2".equalsIgnoreCase(type)){
			addprice = 20;
		}else if("5".equalsIgnoreCase(type)){
			addprice = 30;
		}else{
			return price;
		}
			
		price = Arith.mul(Arith.add(price, addprice),100);
		String priceStr = String.valueOf((int)price);
		int num = Integer.parseInt(priceStr.substring(priceStr.length()-3, priceStr.length()));
		int fixvalue = 900 - num;
		price = price + fixvalue;
		return Arith.div(price,100,2);
		
	}
}
