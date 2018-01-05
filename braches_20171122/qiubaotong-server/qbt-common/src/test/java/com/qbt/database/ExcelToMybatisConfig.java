package com.qbt.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToMybatisConfig {

	
	public static void main(String[] args) throws IOException {
		readXls();
	}
	
	
	private static void readXls() throws IOException{  
	    InputStream is = new FileInputStream( "/Volumes/work/qiubaotong/球包通数据库字典V1.0.xlsx");  
	    XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);   
	    
	    List<String> sqlList = new ArrayList<String>();
	    // 循环工作表Sheet  
	    for(int numSheet = 1; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){  
	      XSSFSheet hssfSheet = hssfWorkbook.getSheetAt( numSheet);  
	      if(hssfSheet == null){  
	    	  continue;  
	      }  
	      
	      // 循环行Row   
	      for(int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++){  
		        XSSFRow hssfRow = hssfSheet.getRow( rowNum);  
		        if(hssfRow == null || rowNum == 1){  
		          continue;  
		        }
		        // 获取表名
		        if(rowNum == 0){
		        	XSSFCell hssfCell = hssfRow.getCell( 0);  
			        if(hssfCell == null){  
			           continue;  
			        } 
		        	String tablename = getValue(hssfCell);
		        	String objName = toUpperWord(tablename);
		        	String objName1 = tablename;
		        	String[] tables = tablename.split("_");
		        	if(tables.length > 1){
		        		objName = "";
		        		objName1 = "";
		        		for(int i = 0;i < tables.length;i++){
		        			if(i == 0)
		        				objName1 += tables[i];
		        			else
		        				objName1 += toUpperWord(tables[i]);
		        			objName += toUpperWord(tables[i]);
		        		}
		        	}
//		        	System.out.println("<typeAlias alias=\""+objName+"\" type=\"com.qbt.persistent.entity."+objName+"\" />");
//		        	System.out.println("<mapper resource=\"mappers/"+objName+"Mapper.xml\" />");
		        	System.out.println("<bean id=\""+objName1+"Mapper\" class=\"org.mybatis.spring.mapper.MapperFactoryBean\">\n");
		        	System.out.println("	<property name=\"mapperInterface\" value=\"com.qbt.persistent.mapper."+objName+"Mapper\" />\n");
		        	System.out.println("	<property name=\"sqlSessionFactory\" ref=\"persistenceSqlSessionFactory\"/>\n");
		        	System.out.println("</bean>\n");
		        	continue;
		        }
	      }
	    }
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
}
