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

public class ExcelToMybatis {

	
	public static void main(String[] args) throws IOException {
		readXls();
	}
	
	
	/**
	 * 
	 * @throws IOException
	 */
	
//	drop table "user_answer" cascade constraints;
//
//	/*==============================================================*/
//	/* Table: "user_answer"                                         */
//	/*==============================================================*/
//	create table "user_answer" 
//	(
//	   "id"                 int(32)              not null,
//	   "user_id"            bigint(64)           default NULL,
//	   "question_id"        bigint(64)           default NULL,
//	   "answer_id"          bigint(64)           default NULL,
//	   constraint PK_USER_ANSWER primary key ("id")
//	)
//	ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
		        	String[] tables = tablename.split("_");
		        	if(tables.length > 1){
		        		objName = "";
		        		for(int i = 0;i < tables.length;i++){
		        			objName += toUpperWord(tables[i]);
		        		}
		        	}
		        	System.out.println("<table tableName=\""+tablename+"\" domainObjectName=\""+objName+"\" enableCountByExample=\"false\" enableUpdateByExample=\"false\" enableDeleteByPrimaryKey=\"false\" enableDeleteByExample=\"false\" enableSelectByExample=\"false\" selectByExampleQueryId=\"false\"></table>");
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
