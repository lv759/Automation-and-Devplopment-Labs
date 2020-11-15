package com.prj.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.prj.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static String Test_sheet="C:\\Users\\VISH\\eclipse-workspace\\SeleniumProject\\com.prj.qa.TestData\\Dataset.xlsx";
	
	static	Workbook book;
	static Sheet sht;


	public static long  page_load=40;
	public static long implicit_wait=40;
	
	public static void Switchtoframe() {
		driver.switchTo().frame("mainpanel");
	}
	public static Object[][] getdata(String sheetname) {
		FileInputStream fil=null;
		try {
			 fil=new FileInputStream(Test_sheet);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(fil);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sht=book.getSheet(sheetname);
		Object[][] data=new Object[sht.getLastRowNum()][sht.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sht.getLastRowNum();i++) {
			for(int j=0;j<sht.getRow(0).getLastCellNum();j++) {
				data[i][j]=sht.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
