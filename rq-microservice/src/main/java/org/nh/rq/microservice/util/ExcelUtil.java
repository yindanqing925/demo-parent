package org.nh.rq.microservice.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: ExcelUtil.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/29 14:15
 */
public class ExcelUtil {

    private static final String NOTFOUND = "暂无该房间隔离信息";
    private static final String NOTFOUND2 = "查询信息有误, 请重新输入";

    /**
     * 根据
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String getRoomRqInfo(InputStream inputStream, String roomNo) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++){
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            String stringCellValue = String.valueOf((int)cell.getNumericCellValue());
            if(roomNo.equals(stringCellValue)){
                return row.getCell(1).getStringCellValue();
            }
        }
        return NOTFOUND;
    }

    /**
     * 根据
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String getCheckInfo(InputStream inputStream, String idNo) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++){
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            String stringCellValue = cell.getStringCellValue();
            if(idNo.equals(stringCellValue)){
                return row.getCell(1).getStringCellValue();
            }
        }
        return NOTFOUND2;
    }

}
