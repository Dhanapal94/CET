package com.cet.utility;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
	
	public static int totalAdditionalHouseHoldCount=0;
	public static int gprtsTotalAdditionalHouseHoldCount=0;
	
	//INDTS
	@DataProvider(name = "INDTSAdditionalHouseHoldData")
	public static Object[][] indtsdataRepository() throws Exception
	{
		System.out.println("INDTS Test Started");
		DBConnection.setIndtsTaskAssignment(); 
		totalAdditionalHouseHoldCount = WriteExcel.indtsAdditionalHouseHold(DBConnection.appSameHouseHoldRef,DBConnection.assignId,"indtsAdditionalHouseHold");
		ExcelUtility.setExcelFile(WriteExcel.excelPath, "indtsAdditionalHouseHold");
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

	@DataProvider(name = "INDTSNextAdditionalHouseHoldData")
	public static Object[][] nextINDTSDataRepository() throws Exception
	{
		System.out.println("Next Additional INDTS Test Started");
		ExcelUtility.setExcelFile(WriteExcel.excelPath, "indtsAdditionalHouseHold");
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
	
	//GPRTS
	@DataProvider(name = "GPRTSAdditionalHouseHoldData")
	public static Object[][] gprtsdataRepository() throws Exception
	{
		System.out.println("GPRTS Test Started");
		DBConnection.setGrptsTaskAssignment();
		gprtsTotalAdditionalHouseHoldCount = WriteExcel.gprtsAdditionalHouseHold(DBConnection.grptsappSameHouseHoldRef,DBConnection.assignId,"gprtsAdditionalHouseHold");
		ExcelUtility.setExcelFile(WriteExcel.excelPath, "gprtsAdditionalHouseHold");
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

	@DataProvider(name = "GPRTSNextAdditionalHouseHoldData")
	public static Object[][] nextGPRTSDataRepository() throws Exception
	{
		System.out.println("Next Additional GPRTS Test Started");
		ExcelUtility.setExcelFile(WriteExcel.excelPath, "gprtsAdditionalHouseHold");
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
