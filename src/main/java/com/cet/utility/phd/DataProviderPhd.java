package com.cet.utility.phd;

import java.util.Hashtable;
import com.cet.intit.Base;
import com.cet.utility.ExcelUtility;

import org.testng.annotations.DataProvider;

public class DataProviderPhd extends Base{

	@DataProvider(name = "PHDSearchData")
	public static Object[][] searchPHDDataRepository() throws Exception
	{
		System.out.println("PHD Search Data Provider Started");
		PHDDBData.writeSearchData();
		ExcelUtility.setExcelFile(PHDDBData.excelPath, "phdSearch");
		int rowcount = ExcelUtility.initialGetRowCount();
		int colcount = ExcelUtility.getCellCount(0);
		Object data[][] = new Object[rowcount][1];
		int count=0;
		for (int i = 1; i<=rowcount; i++) {
			Hashtable<String,String> table = new Hashtable<String, String>();
			for (int j = 0; j <= colcount; j++) {
				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
			data[count][0]=table;
			count++;
		}		
		return data;
	}

	@DataProvider(name = "PHDSearchEditData")
	public static Object[][] searchEditPHDDataRepository() throws Exception
	{

		System.out.println("PHD Search Edit Data Provider Started");
		PHDDBData.writeSearchEditData();
		ExcelUtility.setExcelFile(PHDDBData.excelPath, "phdSearchEdit");
		int rowcount = ExcelUtility.initialGetRowCount();
		int colcount = ExcelUtility.getCellCount(0);
		Object data[][] = new Object[rowcount][1];
		int count=0;
		for (int i = 1; i<=rowcount; i++) {
			Hashtable<String,String> table = new Hashtable<String, String>();
			for (int j = 0; j <= colcount; j++) {
				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
			data[count][0]=table;
			count++;
		}		
		return data;
	}
	
	@DataProvider(name = "PHDHome")
	public static Object[][] homePhdDataRepository() throws Exception
	{
		System.out.println("PHD Home Data Provider Started");
		setUp();
		PHD_Helper.setPhdTeam(driver);
		PHDDBData.updatePHDRecords();
		PHDDBData.writeHomeData();
		ExcelUtility.setExcelFile(PHDDBData.excelPath, "phdHome");
		int rowcount = ExcelUtility.initialGetRowCount();
		int colcount = ExcelUtility.getCellCount(0);
		Object data[][] = new Object[rowcount][1];
		int count=0;
		for (int i = 1; i<=rowcount; i++) {
			Hashtable<String,String> table = new Hashtable<String, String>();
			for (int j = 0; j <= colcount; j++) {
				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
			data[count][0]=table;
			count++;
		}		
		return data;
	}
}
