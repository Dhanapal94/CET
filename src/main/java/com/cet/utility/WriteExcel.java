package com.cet.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;



@Test
public class WriteExcel {
	public static int initColc;
	public static int rowc, colc;
	public static int rowSno = 0;
	public static String excelPath = System.getProperty("user.dir") + "\\" + "CetTData.xlsx";

	// ********* Additional Household ************ //

	public static int indtsAdditionalHouseHold(String sameHouseHoldRef,String assignedTo , String sheetName) throws Exception {

		Boolean flag=ExcelUtility.deleteRows(excelPath,sheetName); 
		System.out.println("Delete Operation Completed - INDTS -AdditionalsameHousehold ::"+flag);

		String query = "select CMTFileTrackerRef,c.createdon, c.lastupdatedon, appindividualtsid,bconnid,APPSameHouseHoldRef,c.assignedto, taskid, c.taskstatuslkup, \r\n" + 
				"i.firstname,i.lastname, address,city,state,zipcode,county,PrimaryPhone, PhoneNum2, PhoneNum3,Language, dialingteam,dialingmethod,c.appcampaignqueueref, CampaignDescription,campaignfocus from [AppIndividualTS] i\r\n" + 
				"join appcampaigntask c on c.appindividualtsref = i.appindividualtsid\r\n" + 
				"where c.appsamehouseholdref ='"+sameHouseHoldRef+"' and c.isactive = 1  and c.taskstatuslkup=31\r\n" + 
				"order by taskid asc";

		System.out.println(query);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ExcelUtility.setExcelFile(excelPath, sheetName);
		rowc = ExcelUtility.initialGetRowCount();
		initColc=ExcelUtility.getCellCount(0);
		while (rs.next()) { 
			rowc++; 
			colc = ExcelUtility.getCellCount(rowc);
			//System.out.println("Row count is:"+rowc);
			ExcelUtility.setCellData(excelPath,Integer.toString(rowSno),rowc, colc);		
			for (int i = 1; i <= initColc-1 ; i++)
			{
				colc = ExcelUtility.getCellCount(rowc); 
				String result = rs.getString(i);
				ExcelUtility.setCellData(excelPath, result, rowc, colc);
			}
			rowSno++;

		}

		System.out.println("*** INDTS Excel Writting Completed ***");
		System.out.println("Count is: "+rowc);
		rowSno=0;
		return rowc;
	}

	public static int gprtsAdditionalHouseHold(String sameHouseHoldRef,String assignedTo , String sheetName) throws Exception {

		Boolean flag=ExcelUtility.deleteRows(excelPath,sheetName); 
		System.out.println("Delete Operation Completed - gprts -AdditionalsameHousehold ::"+flag);

		String query = "select CMTFileTrackerRef,c.createdon, c.lastupdatedon, appgrouptsid,bconnid,APPSameHouseHoldRef,c.assignedto, taskid, c.taskstatuslkup, \r\n" + 
				"i.firstname,i.lastname, address,city,state,zipcode,county,PrimaryPhone, PhoneNum2, PhoneNum3,Language, dialingteam,dialingmethod,c.appcampaignqueueref, CampaignDescription,campaignfocus from  appgroupts i\r\n" + 
				"join appcampaigntask c on c.appgrouptsref = i.appgrouptsid\r\n" + 
				"where c.appsamehouseholdref ='"+sameHouseHoldRef+"' and c.isactive = 1 and c.taskstatuslkup=31\r\n" +  
				"order by taskid asc";

		System.out.println(query);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ExcelUtility.setExcelFile(excelPath, sheetName);
		rowc = ExcelUtility.initialGetRowCount();
		initColc=ExcelUtility.getCellCount(0);
		while (rs.next()) { 
			rowc++; 
			colc = ExcelUtility.getCellCount(rowc);
			ExcelUtility.setCellData(excelPath,Integer.toString(rowSno),rowc, colc);		
			for (int i = 1; i <= initColc-1 ; i++)
			{
				colc = ExcelUtility.getCellCount(rowc); 
				String result = rs.getString(i);
				ExcelUtility.setCellData(excelPath, result, rowc, colc);
			}
			rowSno++;

		}

		System.out.println("*** GPRTS Excel Writting Completed ***");
		System.out.println("Count is: "+rowc);
		rowSno=0;
		return rowc;
	}

}



