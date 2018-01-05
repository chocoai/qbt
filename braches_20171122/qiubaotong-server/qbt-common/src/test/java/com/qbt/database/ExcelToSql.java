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

public class ExcelToSql {

	
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
	    InputStream is = new FileInputStream( "F:/qiubaotong/qiubaotong-document/data structure/球包通数据库字典V4.3.xlsx");  
	    XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);   
	    
	    List<String> sqlList = new ArrayList<String>();
	    // 循环工作表Sheet  
	    for(int numSheet = 1; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){  
	      XSSFSheet hssfSheet = hssfWorkbook.getSheetAt( numSheet);  
	      if(hssfSheet == null){  
	    	  continue;  
	      }  
	      
	      String tablename = "";
	      StringBuilder sb = new StringBuilder();
	      boolean hasId = false;
	      int maxRow = hssfSheet.getLastRowNum();
	      // 循环行Row   
	      for(int rowNum = 0; rowNum <= maxRow; rowNum++){  
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
		        	tablename = getValue(hssfCell);
		        	sb.append("drop table if exists `"+tablename+"`;\n");
		        	sb.append("/*==============================================================*/\n");
		        	sb.append("/*Table: `"+tablename+"`                                         */\n");
		        	sb.append("/*==============================================================*/\n");
		        	sb.append("create table `"+tablename+"`(\n");
		        	continue;
		        }
		        String field = "";
		        String type = "";
		        String nullname = "";
		        String defaultname = "";
		        String comment = "";
		        // 循环列Cell    
		        for(int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++){  
		          XSSFCell hssfCell = hssfRow.getCell( cellNum);  
		          if(hssfCell == null){  
		            continue;  
		          }
		          if(cellNum == 0){
		        	  field = "";
				      type = "";
				      nullname = "";
				      defaultname = "";
				      field = getValue(hssfCell).trim();
		          }
		          else if(cellNum == 1){
		        	  type = getValue(hssfCell).trim();
		          }else if(cellNum == 3){
		        	  defaultname = getValue(hssfCell).trim();
		        	  if(defaultname!=null && !"".equalsIgnoreCase(defaultname) && !"自增".equalsIgnoreCase(defaultname)){
		        		  defaultname = "default "+defaultname.trim();
		        	  }else{
		        		  defaultname = "";
		        	  }
		          }else if(cellNum == 2){
		        	  nullname = getValue(hssfCell);
		        	  if("no".equalsIgnoreCase(nullname.toLowerCase())){
		        		  nullname = "not null";
		        	  }else{
		        		  nullname = "";
		        	  }
		          }else if(cellNum == 4){
		        	  comment = getValue(hssfCell);
		        	  if(comment != null && !"".equals(comment)){
		        		  comment = "comment '"+comment+"'";
		        	  }
		          }
		          
		        }
		        String auto_increment = "";
		        if(field.toLowerCase().equals("id")){
		        	auto_increment = "auto_increment";
		        	hasId = true;
		        }
		        if(field != null && !field.equals("")){
		        	if(rowNum == maxRow){
		        		if(hasId)
		        			sb.append("`"+field+"` "+type+" "+defaultname+" "+nullname+" "+auto_increment+" "+comment+",\n");
		        		else
		        			sb.append("`"+field+"` "+type+" "+defaultname+" "+nullname+" "+auto_increment+" "+comment+"\n");
		        	}else{
		        		sb.append("`"+field+"` "+type+" "+defaultname+" "+nullname+" "+auto_increment+" "+comment+",\n");
		        	}
		        	
		        }
	      }
	      if(hasId){
	    	  sb.append("primary key (id)\n");
	      }
	      sb.append(")ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");
	      sqlList.add(sb.toString());
	    }
	    File file = new File("qiubaotong.sql");
	    FileUtils.writeLines(file, sqlList);
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
