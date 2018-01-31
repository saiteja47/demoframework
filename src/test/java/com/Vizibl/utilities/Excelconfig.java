package com.Vizibl.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelconfig {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	public Excelconfig() throws IOException {
	
		FileInputStream fis = new FileInputStream(Constants.excelPath);
		workbook = new XSSFWorkbook(fis);
	}

	public int getColumnCount(String sheetName, int rownum) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	public int getRowcount(int SheetIndex) {
		int rowCount = workbook.getSheetAt(SheetIndex).getLastRowNum();
		rowCount = rowCount + 1;
		return rowCount;
	}

	public String GetCellData(int sheetnum, int rownum, int cellnum) {
		DataFormatter df = new DataFormatter();
		sheet = workbook.getSheetAt(sheetnum);
		Cell cell = sheet.getRow(rownum).getCell(cellnum);
		String celldata = df.formatCellValue(cell);
		System.out.println(celldata);
		return celldata;
	}
}
