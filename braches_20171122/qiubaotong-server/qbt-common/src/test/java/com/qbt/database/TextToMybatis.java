package com.qbt.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TextToMybatis {

	
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
		BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/work/生产表名.csv")));
		String line = null;  
		// 获取表名
        while((line = br.readLine()) != null){
        	String tablename = line;
        	String objName = toUpperWord(tablename);
        	String[] tables = tablename.split("_");
        	if(tables.length > 1){
        		objName = "";
        		for(int i = 0;i < tables.length;i++){
        			objName += toUpperWord(tables[i]);
        		}
        	}
        	System.out.println("<table tableName=\""+tablename+"\" domainObjectName=\""+objName+"\" enableCountByExample=\"false\" enableUpdateByExample=\"false\" enableDeleteByPrimaryKey=\"false\" enableDeleteByExample=\"false\" enableSelectByExample=\"false\" selectByExampleQueryId=\"false\"></table>");
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
