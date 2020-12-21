package com.cet.utility.grpts;

import java.util.HashMap;

import com.cet.utility.ExcelUtility;


public class GetDataFromExcelGRPTS {

	public static String excelPath = System.getProperty("user.dir") + "\\" + "GrptsData.xlsx";


	   public static String getEditGrptsUserMsId(int colIndex) throws Exception{
		   ExcelUtility.setExcelFile(excelPath, "grptseditUser");
		   String msid =  ExcelUtility.getCellData(1, colIndex);
		   return msid;
	   }
	   

		public static HashMap<String, String> viewGrptsUserData() throws Exception
		{
			System.out.println("Get View GRPTS User Data");
			WriteExcelGRPTS.viewUserWriteTest();
			ExcelUtility.setExcelFile(excelPath, "grptsviewUser");
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
		
		public static HashMap<String, String> grptsedit() throws Exception
		{
			System.out.println("Get GRPTS task Details");
			WriteExcelGRPTS.grptstaskEdit();
			ExcelUtility.setExcelFile(excelPath, "grptstaskedit");
			int rowcount = ExcelUtility.initialGetRowCount();
			HashMap<String,String> table = new HashMap<String, String>();

			for (int i = 1; i<=1; i++) {
				for (int j = 0; j <= 34; j++) {

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
		
		public static HashMap<String, String> grptstasksearch() throws Exception
		{
			System.out.println("Get INDTS task Details to Search");
			WriteExcelGRPTS.getGrptsTaskToSearch();
			ExcelUtility.setExcelFile(excelPath, "grptstaskSearch");
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

		public static HashMap<String, String> newGrptsCampaign() throws Exception
		{
			System.out.println("Get New Campaign details from Excel");
			ExcelUtility.setExcelFile(excelPath, "grptsNewCampaign");
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
