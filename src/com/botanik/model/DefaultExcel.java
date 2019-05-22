package com.botanik.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author teyyub , 9:14:15 PM
 */
public class DefaultExcel {

    private String sheetName;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    Row row;
    FileOutputStream fileOut;

    public DefaultExcel(String sheetName) {
        this.sheetName = sheetName;
    }

    public void ready() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);

    }

    public void write() throws FileNotFoundException, IOException {
        fileOut = new FileOutputStream(fileName());
        workbook.write(fileOut);
        fileOut.close();
    }
//    public void row(){
//       return sheet.getRow;
//    }

    public void addRow(int index) {
        row = sheet.createRow(index);
    }

    public void merge() {
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
    }

    public void createStyle() {
        CellStyle style = workbook.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.BIG_SPOTS);
        cell(0).setCellStyle(style);
    }

    public void addToCell(int index, String text) {
        row.createCell(index).setCellValue(text);
    }
    public int getRows(){
        return row.getRowNum();
    }
    public Cell cell(int index) {
        return row.getCell(index);
    }

    private long genId() {
        return System.currentTimeMillis();
    }

    private String fileName() {
        return "c:/test/" + genId() + ".xlsx";
    }
}
