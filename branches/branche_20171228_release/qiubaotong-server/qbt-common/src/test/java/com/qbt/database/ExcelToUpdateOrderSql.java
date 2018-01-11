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

public class ExcelToUpdateOrderSql {

	
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
	    InputStream is = new FileInputStream( "/Volumes/work/order_addrid.xlsx");  
	    XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);   
	    
	    List<String> sqlList = new ArrayList<String>();
	    // 循环工作表Sheet  
	      XSSFSheet hssfSheet = hssfWorkbook.getSheetAt( 0);  
	      
	      String tablename = "";
	      boolean hasId = false;
	      int maxRow = hssfSheet.getLastRowNum();
	      // 循环行Row   
	      for(int rowNum = 1; rowNum <= maxRow; rowNum++){  
		        XSSFRow hssfRow = hssfSheet.getRow(rowNum);  
		        String name = getValue(hssfRow.getCell(0));  
		        String addrId = getValue(hssfRow.getCell(1));  
		        sqlList.add("update order_info set j_addr_id="+(int)Double.parseDouble(addrId)+" where j_addr_name='"+name+"' and j_addr_id=0;\n");
		        sqlList.add("update order_info set d_addr_id="+(int)Double.parseDouble(addrId)+" where d_addr_name='"+name+"' and d_addr_id=0;\n");
	      }
	      
	      File file = new File("order_ifno.sql");
	      FileUtils.writeLines(file, sqlList);
	}
	
	@SuppressWarnings("static-access")  
	private static String getValue(XSSFCell hssfCell){  
	    if(hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN){  
	      return String.valueOf( hssfCell.getBooleanCellValue());  
	    }else if(hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC){  
	      return String.valueOf(hssfCell.getNumericCellValue());  
	    }else{  
	      return String.valueOf( hssfCell.getStringCellValue());  
	    }  
	  } 
}
