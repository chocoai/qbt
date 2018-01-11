package com.qbt.web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;

import net.sf.jxls.transformer.XLSTransformer;

public class ExportExcelUtils {
	
    public static void exportStudentExcel(Map<String,Object> beans,String srcPath,OutputStream os) {
        XLSTransformer transformer = new XLSTransformer();
        try {
            //获得模板的输入流
            FileInputStream in = new FileInputStream(srcPath);
            //将beans通过模板输入流写到workbook中
            Workbook workbook = transformer.transformXLS(in, beans);
            //将workbook中的内容用输出流写出去
            workbook.write(os);
        }catch (Exception e) {
            LogCvt.error(e.getMessage(),e);
            throw new BusinessException(e.getMessage());
        }finally{
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}