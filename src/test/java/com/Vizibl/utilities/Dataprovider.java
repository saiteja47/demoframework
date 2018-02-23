package com.Vizibl.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataprovider {
	@DataProvider(name = "forgotPassword")
	public static Object[][] ForgotPassword() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(1);
		int totalcolumns = config.getColumnCount("forgotPassword", 1);
		Object[][] data = new Object[totalrows - 1][totalcolumns - 5];
		for (int i = 1; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 1][j - 5] = config.GetCellData(1, i, j);
			}
		}
		return data;
	}

	@DataProvider(name = "adminLogin")
	public static Object[][] adminLogin() throws Exception {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(0);
		int totalcolumns = config.getColumnCount("Login", 2);
		Object[][] data = new Object[totalrows - 2][totalcolumns - 5];
		for (int i = 2; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 2][j - 5] = config.GetCellData(0, i, j);
			}
		}
		return data;
	}

	@DataProvider(name = "advertiserRegistration")
	public static Object[][] advertiserRegistration() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(3);
		int totalcolumns = config.getColumnCount("advertiserRegistration", 1);
		Object[][] data = new Object[totalrows - 2][totalcolumns - 5];
		for (int i = 1; i < totalrows - 1; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 1][j - 5] = config.GetCellData(3, i, j);
			}
		}
		return data;
	}

	@DataProvider(name = "afterChangingPassword")
	public static Object[][] afterChangingPassword() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(4);
		System.out.println(totalrows);
		int totalcolumns = config.getColumnCount("afterChangingPassword", 2);
		System.out.println(totalcolumns);
		Object[][] data = new Object[totalrows - 2][totalcolumns - 5];
		for (int i = 2; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 2][j - 5] = config.GetCellData(4, i, j);
			}
		}
		return data;
	}

	@DataProvider(name = "ChangePassword")
	public static Object[][] Changepassword() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(2);
		System.out.println(totalrows);
		int totalcolumns = config.getColumnCount("ChangePassword", 1);
		System.out.println(totalcolumns);
		Object[][] data = new Object[totalrows - 2][totalcolumns - 5];
		for (int i = 1; i < totalrows - 1; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 1][j - 5] = config.GetCellData(2, i, j);
			}
		}
		return data;
	}

	@DataProvider(name = "validChangePassword")
	public static Object[][] validChangePassword() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(2);
		System.out.println(totalrows);
		int totalcolumns = config.getColumnCount("ChangePassword", 7);
		System.out.println(totalcolumns);
		Object[][] data = new Object[totalrows - 7][totalcolumns - 6];
		for (int i = 7; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns - 1; j++) {
				data[i - 7][j - 5] = config.GetCellData(2, i, j);
			}
		}
		return data;
	}
	
	public static class Excelldata
	{
		static XSSFWorkbook wb;
		static XSSFSheet sheet1;
		
		public  Excelldata(String excelpath) 
		{
			try {
				File src =new File(excelpath);
				FileInputStream fis =new FileInputStream(src);
				 wb =new XSSFWorkbook(fis);
	    }
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}		
		}
		public static String getData(int sheetnum,int row,int column)
		{  	
			sheet1 = wb.getSheetAt(sheetnum);
		String Data	= sheet1.getRow(row).getCell(column).getStringCellValue();
		
			
			return Data;
		}

}}
