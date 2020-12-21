package com.cet.utility.grpts;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.cet.utility.DBConnection;
import com.cet.utility.ExcelUtility;

@Test
public class WriteExcelGRPTS {
	public static int initColc;
	public static int rowc, colc;
	public static int rowSno = 1;
	public static String excelPath = System.getProperty("user.dir") + "\\" + "GrptsData.xlsx";
	
	public static void deletViewUser() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"grptsviewUser"); 
		System.out.println("Delete Operation Completed ::"+flag);
	}

	public static void deletetaskdetails() throws Exception {
			Boolean flag=ExcelUtility.deleteRows(excelPath,"grptstaskedit"); 
			System.out.println("Delete Operation Completed ::"+flag);
	}
	
	//*************************************User Admin***************************************************************
	public static void viewUserWriteTest() throws Exception {
		deletViewUser();
		String query = "select u.msid,u.firstname,u.lastname,u.EmpId,u.Email,u.SupervisorFirstName,\r\n" + 
				"u.SupervisorLastName,u.ManagerName,u.status,u.IsAssignTask,l.LookupDescription,\r\n" + 
				"l.lookupvalue from AppUser u join AppUserSkill s \r\n" + 
				"on s.userref = u.userid join applookupmaster l \r\n" + 
				"on lookupmasterid = SkillLkup where u.isactive = 1 and s.isactive = 1 and skilllkup = 2 \r\n" + 
				"order By  u.msid  OFFSET 8 ROWS FETCH NEXT 1 ROWS ONLY";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		String sheetName = "grptsviewUser";
		ExcelUtility.setExcelFile(excelPath, sheetName);
		rowc = ExcelUtility.initialGetRowCount();
		initColc=ExcelUtility.getCellCount(0);
		while (rs.next()) { 
			rowc++; 
			for (int i = 1; i <= initColc ; i++)
			{
				colc = ExcelUtility.getCellCount(rowc); 
				String result = rs.getString(i);
				ExcelUtility.setCellData(excelPath, result, rowc, colc);
			}

		}

	}

	public static void getStatusInActiveMSID() throws Exception {
		String query = "select u.msid \r\n" + 
				"from AppUser u join AppUserSkill s \r\n" + 
				"on s.userref = u.userid join applookupmaster l \r\n" + 
				"on lookupmasterid = SkillLkup where status=0 and skilllkup = 2 \r\n" + 
				"order By  u.msid  OFFSET 8 ROWS FETCH NEXT 1 ROWS ONLY";
		String sheetName = "grptseditUser";
		ExcelUtility.setExcelFile(excelPath, sheetName);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs ; 
		rs = stmt.executeQuery(query);
		colc = ExcelUtility.getCellCount(1); 
		while(rs.next()) {
			String result = rs.getString(1);
			ExcelUtility.setCellData(excelPath, result,1,3);
		}
	}
	public static void getStatusActiveMSID() throws Exception {
		String query = "select u.msid \r\n" + 
				"from AppUser u join AppUserSkill s \r\n" + 
				"on s.userref = u.userid join applookupmaster l \r\n" + 
				"on lookupmasterid = SkillLkup where status=1 and skilllkup = 2 \r\n" + 
				"order By  u.msid  OFFSET 8 ROWS FETCH NEXT 1 ROWS ONLY";
		String sheetName = "grptseditUser";
		ExcelUtility.setExcelFile(excelPath, sheetName);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs ; 
		rs = stmt.executeQuery(query);
		colc = ExcelUtility.getCellCount(1); 
		while(rs.next()) {
			String result = rs.getString(1);
			ExcelUtility.setCellData(excelPath, result, 1, 2);
		}
	}
	public static void getChecekdWorkedMSID() throws Exception {
		String query = "select u.msid \r\n" + 
				"from AppUser u join AppUserSkill s \r\n" + 
				"on s.userref = u.userid join applookupmaster l \r\n" + 
				"on lookupmasterid = SkillLkup where isassigntask = 1 and skilllkup = 2 \r\n" + 
				"order By  u.msid  OFFSET 8 ROWS FETCH NEXT 1 ROWS ONLY";
		String sheetName = "grptseditUser";
		ExcelUtility.setExcelFile(excelPath, sheetName);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs ; 
		rs = stmt.executeQuery(query);
		colc = ExcelUtility.getCellCount(1); 
		while(rs.next()) {
			String result = rs.getString(1);
			ExcelUtility.setCellData(excelPath, result, 1, 1);
		}
	}
	
	public static void getEnglishUnchekedMsID() throws Exception {
		String query = "select u.msid from [dbo].[AppUser] u\r\n" + 
				"left join [dbo].[AppUserSkill] s on s.userref = u.userid\r\n" + 
				"left join applookupmaster l on lookupmasterid = SkillLkup where\r\n" + 
				"u.isactive = 1 and s.isactive = 1 and Status = 1 and skilllkup = 2 and userId not in (select userRef from dbo.AppUserSkill where Skilllkup = 5)\r\n" + 
				"order By  u.msid  OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY";
		String sheetName = "grptseditUser";
		ExcelUtility.setExcelFile(excelPath, sheetName);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs ; 
		rs = stmt.executeQuery(query);
		colc = ExcelUtility.getCellCount(1); 
		while(rs.next()) {
			String result = rs.getString(1);
			ExcelUtility.setCellData(excelPath, result, 1, 4);
		}
	}
	public static void getUnChecekdWorkedMSID() throws Exception {
		String query = "select u.msid \r\n" + 
				"from AppUser u join AppUserSkill s \r\n" + 
				"on s.userref = u.userid join applookupmaster l \r\n" + 
				"on lookupmasterid = SkillLkup where isassigntask = 0 and skilllkup = 2 \r\n" + 
				"order By  u.msid  OFFSET 8 ROWS FETCH NEXT 1 ROWS ONLY";
		String sheetName = "grptseditUser";
		ExcelUtility.setExcelFile(excelPath, sheetName);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs ; 
		rs = stmt.executeQuery(query);
		colc = ExcelUtility.getCellCount(1); 
		while(rs.next()) {
			String result = rs.getString(1);
			ExcelUtility.setCellData(excelPath, result, 1, 0);
		}
	}

	@Test
	public static void editUserWriteTest() throws Exception{
		Boolean flag=ExcelUtility.deleteRows(excelPath,"editUser"); 
		System.out.println("Delete Operation Completed ::"+flag);
		getUnChecekdWorkedMSID();
		getChecekdWorkedMSID();
		getStatusActiveMSID();
		getStatusInActiveMSID();
		getEnglishUnchekedMsID();

	}
	public static String getGrptslabel(String label) throws Exception {
		String value="";
		switch(label) {
		case "editUser": value="Edit User";break;
		case "UseradminEditUserTitle":value="EditUser - CampaignManagement";break;
		case "UseradminviewUserTitle":value="ViewUser - CampaignManagement";break;
		case "homeTitle":value="Home Page - CampaignManagement";break;
		case "UseradminAddUserTitle":value="AddUser - CampaignManagement";break;
		case "UseradminTitle":value="User Administrator - CampaignManagement";break;
		case "UseradminLabel":value="User Administrator";break;
		case "UseradminSearchPanel":value="Search User";break;
		case "searchResult":value="Search Result";break;
		case "userInfo": value="User Info";break;
		case "MSID": value = "MS ID";break;
		case "fname":value ="First Name";break;
		case "lanme":value ="Last Name"; break;
		case "empId":value ="Employee ID"; break;
		case "emailId":value ="Email ID"; break;
		case "supervisor":value ="Supervisor"; break;
		case "manager":value ="Manager"; break;
		case "assignWork":value ="Assign Work"; break;
		case "status":value ="Status"; break;
		case "astatus":value ="Active"; break;
		case "inActivestatus":value ="Inactive"; break;
		case "skills":value ="Skills"; break;
		case "team":value ="Team"; break;
		case "language":value ="Language"; break;
		case "dialingteam":value ="Dialing Team"; break;
		case "dialingMehod":value ="Dialing Method"; break;
		case "cancel":value ="Cancel"; break;
		case "reset":value ="Reset"; break;
		case "save":value ="Save"; break;
		case "AddUser":value ="Add New User"; break;
		case "search":value ="Search"; break;
		case "action":value ="Action"; break;
		case "last":value ="Last"; break;
		case "previous":value ="Previous"; break;
		case "first":value ="First"; break;
		case "next":value ="Next"; break;
		}

		return value;
	}
	
	//*************************************************Task Details Page*****************************************

	@Test
	public static void grptstaskEdit() throws Exception {
		deletetaskdetails();
		String query = "select bConnID,CampaignDescription,Jobname,CurrentPlan,PlanToPromote,i.FirstName as FirstName ,i.LastName as LastName, Address,City,State\r\n" + 
				",ZipCode,County,PrimaryPhone,PhoneNum2,PhoneNum3,Language,MBINum,MedicaidNumber,EmployerGroup,ProviderInformation,\r\n" + 
				"DialingTeam,DialingMethod,CampaignFocus,c.scheduledate,TimeZone,TaskId,i.tasktype, format(c.createdon, 'MM/dd/yyyy') as CreatedDate,m.lookupvalue as TaskStatus,c.notes,\r\n" + 
				"concat(u.lastname,', ',u.firstname) as AgentAssigned, concat(u.SupervisorLastName,', ',u.SupervisorFirstName) as AgentSupervisor, other, c.currentattemptcount\r\n" + 
				"from [AppgroupTS] i\r\n" + 
				"join appcampaigntask c on c.appgrouptsref = i.appgrouptsid \r\n" + 
				"left join appuser u on u.userid = c.assignedto \r\n" + 
				"left join applookupmaster m on m.lookupmasterid = c.taskstatuslkup\r\n" + 
				"where taskstatuslkup = 31 and c.isactive =1 and assignedto = 114 and tasktype = 'GRPTS'\r\n" + 
				"order By  bconnid OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		String sheetName = "grptstaskedit";
		ExcelUtility.setExcelFile(excelPath, sheetName);
		rowc = ExcelUtility.initialGetRowCount();
		initColc=ExcelUtility.getCellCount(0);
		while (rs.next()) { 
			rowc++; 
			for (int i = 1; i <= initColc ; i++)
			{
				colc = ExcelUtility.getCellCount(rowc); 
				String result = rs.getString(i);
				ExcelUtility.setCellData(excelPath, result, rowc, colc);
			}

		}
	}
	
	public static String getgrptstasklabel(String label) throws Exception {
		String value="";
		switch(label) {
		case "TaskDetailsEditTitle":value="Task Details - CampaignManagement";break;
		case "TaskDetailsViewTitle":value="TaskView - CampaignManagement";break;
		case "TaskDetailsPageTitle":value="Task Details";break;
		case "ApplicationDetails":value="Application Details";break;
		case "bconnId":value="bConn ID";break;
		case "CurrentPlan":value="Current Plan";break;
		case "PlantoPromote": value="Plan to Promote";break;
		case "FirstName": value = "First Name";break;
		case "LastName":value ="Last Name";break;
		case "Address":value ="Address"; break;
		case "City":value ="City"; break;
		case "State":value ="State"; break;
		case "ZipCode":value ="Zip Code"; break;
		case "County":value ="County"; break;
		case "PhoneNo1":value ="Phone #1"; break;
		case "PhoneNo2":value ="Phone #2"; break;
		case "PhoneNo3":value ="Phone #3"; break;
		case "Language":value ="Language"; break;
		case "MBI":value ="MBI #"; break;
		case "MedicaidNumber":value ="Medicaid Number"; break;
		case "EmployerGroup":value ="Employer Group"; break;
		case "ProviderInformation":value ="Provider Information"; break;
		case "AgentAssigned":value ="Agent Assigned"; break;
		case "AgentSupervisor":value ="Agent's Supervisor"; break;
		case "TaskId":value ="Task ID"; break;
		case "TaskType":value ="Task Type"; break;
		case "CampaignDescription":value ="Campaign Description"; break;
		case "JobName":value ="Job Name"; break;
		case "CreatedDate":value ="Created Date (UTC)"; break;
		case "TaskStatus":value ="Task Status"; break;
		case "ScheduledDate":value ="Scheduled Date"; break;
		case "Disposition":value ="Disposition"; break;
		case "Notes":value ="Notes"; break;
		case "CampaignScript":value ="Campaign Script"; break;
		case "Close":value ="Close"; break;
		case "Save&GetNext":value ="Save & GetNext"; break;
		case "Save&Close":value ="Save & Close"; break;
		case "WrongNumber":value ="Wrong Number"; break;
		case "BadDisconnectedNumber":value ="Bad/Disconnected Number"; break;
		}
		return value;
	}

             //*****************************GRPTS Task Search***********************************
	
	public static void getGrptsTaskToSearch() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"grptstaskSearch"); 
		System.out.println("Delete Operation Completed ::"+flag);
		String query = "select ait.bconnid, tasktype, campaignfocus, m.lookupvalue as taskstatus, Jobname, dialingmethod, AIT.firstname, AIT.lastname, primaryphone,\r\n" +
				"ait.createdon, u.firstname+' '+u.lastname as AgentName from appcampaigntask ACT\r\n" +
				"Inner Join dbo.AppgroupTS AIT ON ACT.AppgroupTSRef = AIT.AppgroupTSID\r\n" +
				"join appuser u on u.userid = act.assignedto\r\n" +
				"join applookupmaster m on m.lookupmasterid = act.taskstatuslkup where ACT.isactive =1 and AIT.isactive = 1\r\n" +
				"order By ait.bconnid OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY ";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		String sheetName = "grptstaskSearch";
		ExcelUtility.setExcelFile(excelPath, sheetName);
		rowc = ExcelUtility.initialGetRowCount();
		initColc=ExcelUtility.getCellCount(0);
		while (rs.next()) { 
			rowc++; 
			for (int i = 1; i <= initColc ; i++)
			{
				colc = ExcelUtility.getCellCount(rowc); 
				String result = rs.getString(i);
				ExcelUtility.setCellData(excelPath, result, rowc, colc);
			}

		}
	}

}
