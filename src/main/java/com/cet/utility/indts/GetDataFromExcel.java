package com.cet.utility.indts;

import java.util.HashMap;

import com.cet.utility.ExcelUtility;


public class GetDataFromExcel {
	public static String excelPath = System.getProperty("user.dir") + "\\" + "IndtsData.xlsx";


   public static String getEditUserMsId(int colIndex) throws Exception{
	   ExcelUtility.setExcelFile(excelPath, "EditUser");
	   String msid =  ExcelUtility.getCellData(1, colIndex);
	   return msid;
   }
   

	public static HashMap<String, String> viewUserData() throws Exception
	{
		System.out.println("Get View User Data");
		WriteExcel.viewUserWriteTest();
		ExcelUtility.setExcelFile(excelPath, "viewUser");
		int rowcount = ExcelUtility.initialGetRowCount();
		HashMap<String,String> table = new HashMap<String, String>();

		for (int i = 1; i<=1; i++) {
			for (int j = 0; j <= 9; j++) {

				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
		}		

		for (int i = 1; i<=rowcount; i++) {
			String tableHeader =  ExcelUtility.getCellData(i, 10);
			String tableValue = ExcelUtility.getCellData(i, 11);

			if(table.containsKey(tableHeader)) {
				String value=table.get(tableHeader);
				String listvalue=value+","+tableValue;
				table.put(tableHeader, listvalue);	
			}
			else {
				table.put(tableHeader, tableValue);	
			}

		}

		System.out.println("Data"+table);
		System.out.println("Data provider completed");
		return table;
	}
	
	public static HashMap<String, String> indtsedit() throws Exception
	{
		System.out.println("Get INDTS task Details");
		WriteExcel.indtstaskEdit();
		ExcelUtility.setExcelFile(excelPath, "indtstaskedit");
		int rowcount = ExcelUtility.initialGetRowCount();
		HashMap<String,String> table = new HashMap<String, String>();

		for (int i = 1; i<=1; i++) {
			for (int j = 0; j <= 36; j++) {

				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
		}		

		for (int i = 1; i<=rowcount; i++) {
			String tableHeader =  ExcelUtility.getCellData(i, 10);
			String tableValue = ExcelUtility.getCellData(i, 11);

			if(table.containsKey(tableHeader)) {
				String value=table.get(tableHeader);
				String listvalue=value+","+tableValue;
				table.put(tableHeader, listvalue);	
			}
			else {
				table.put(tableHeader, tableValue);	
			}

		}

		System.out.println("Data"+table);
		System.out.println("Data provider completed");
		return table;
	}
	
	public static HashMap<String, String> indtstasksearch() throws Exception
	{
		System.out.println("Get INDTS task Details to Search");
		WriteExcel.getIndtsTaskToSearch();
		ExcelUtility.setExcelFile(excelPath, "indtstaskSearch");
		int rowcount = ExcelUtility.initialGetRowCount();
		HashMap<String,String> table = new HashMap<String, String>();

		for (int i = 1; i<=1; i++) {
			for (int j = 0; j <= 11; j++) {

				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
		}		

		for (int i = 1; i<=rowcount; i++) {
			String tableHeader =  ExcelUtility.getCellData(i, 10);
			String tableValue = ExcelUtility.getCellData(i, 11);

			if(table.containsKey(tableHeader)) {
				String value=table.get(tableHeader);
				String listvalue=value+","+tableValue;
				table.put(tableHeader, listvalue);	
			}
			else {
				table.put(tableHeader, tableValue);	
			}

		}

		System.out.println("Data"+table);
		System.out.println("Data provider completed");
		return table;
	}

	public static HashMap<String, String> newCampaign() throws Exception
	{
		System.out.println("Get New Campaign details from Excel");
		ExcelUtility.setExcelFile(excelPath, "NewCampaign");
		int rowcount = ExcelUtility.initialGetRowCount();
		HashMap<String,String> table = new HashMap<String, String>();

		for (int i = 1; i<=1; i++) {
			for (int j = 0; j <= 5; j++) {

				String tableHeader =  ExcelUtility.getCellData(0, j);
				String tableValue = ExcelUtility.getCellData(i, j);
				table.put(tableHeader, tableValue);	
			}	
		}		

		for (int i = 1; i<=rowcount; i++) {
			String tableHeader =  ExcelUtility.getCellData(i, 10);
			String tableValue = ExcelUtility.getCellData(i, 11);

			if(table.containsKey(tableHeader)) {
				String value=table.get(tableHeader);
				String listvalue=value+","+tableValue;
				table.put(tableHeader, listvalue);	
			}
			else {
				table.put(tableHeader, tableValue);	
			}

		}

		System.out.println("Data"+table);
		System.out.println("Data provider completed");
		return table;
	}

	

}
