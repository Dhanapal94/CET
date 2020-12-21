package com.cet.utility.phd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.cet.utility.DBConnection;
import com.cet.utility.ExcelUtility;

public class PHDDBData {

	public static String excelPath = System.getProperty("user.dir") + "\\" + "phdData.xlsx";
	public static int initColc;
	public static int rowc, colc;
	public static int rowSno = 1;
	public static String agentId;
	
	//********* UpdatePhdTeam Records ************
	 public static void updatePHDRecords() throws Exception { 
		 DBConnection.setAssignmentName();
	        String assignPHD = "with cte \r\n" + 
	        		"as (\r\n" + 
	        		"select top 5 concat(u.firstname,', ',u.lastname) as AgentAssigned, c.assignedto from [AppPhd] p\r\n" + 
	        		"join appcampaigntask c on c.appphdref = p.appPHDid\r\n" + 
	        		"join appuser u on u.userid = c.assignedto\r\n" + 
	        		"where taskstatuslkup = 31 and p.isactive = 1 and c.isactive = 1\r\n" + 
	        		")\r\n" + 
	        		"update cte set assignedto = (select  userid from appuser where firstname+' '+lastname = '"+DBConnection.assignName+"') ";
	        
	        String appUserSkillHistory = "update appcampaigntaskhistory set assignedto = (select  userid from appuser where firstname+' '+lastname = 'Dhanapal A')\r\n" + 
	        		"where appcampaigntaskref in (select c.appcampaigntaskid from appcampaigntask c\r\n" + 
	        		"join appuser u on u.userid = c.assignedto \r\n" + 
	        		"where u.firstname+' '+u.lastname = '"+DBConnection.assignName+"' and appphdref is not null)";
	        
	        Connection conn = DBConnection.getConnection();
	        Statement stmt = conn.createStatement(); 
	        stmt.executeUpdate(assignPHD);
	        stmt.executeUpdate(appUserSkillHistory);
	        System.out.println("*** UPDATE PHD RECORDS COMPLETED ***");
	    }
	

	public static void writeSearchData() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdSearch"); 
		System.out.println("Delete search operation completed ::"+flag);
		System.out.println("***PHD_Search_Data***");

		DBConnection.getuserName();
		String searchQuery="select  top 1 t.taskid,AgentId,TaskType,campaignfocus, m.lookupvalue as taskstatus,JobName, DialingMethod,\r\n" + 
				"r.AgentFirstName,r.AgentLastName,r.AgentPrimaryPhoneNumber,r.agentstate,\r\n" + 
				"r.Createdon as CreatedDate,(u.FirstName+' '+u.LastName) as AgentName, m1.lookupvalue as FinalDisposition, t.closeddate as FinalAttemptDate\r\n" + 
				"from [AppPhd] r\r\n" + 
				"join appcampaigntask t on t.AppPHDRef = r.appphdid\r\n" + 
				"left join applookupmaster m on m.lookupmasterid = t.taskstatuslkup\r\n" + 
				"left join applookupmaster m1 on m.lookupmasterid = t.dispositionlkup\r\n" + 
				"left join appuser u on u.userid = t.assignedto\r\n" + 
				"where r.isactive = 1 and t.isactive = 1 and t.taskstatuslkup=31 and u.Msid = '"+DBConnection.userID+"' order by 1 desc";

		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"phdSearch");
		rowc = ExcelUtility.initialGetRowCount();
		initColc=ExcelUtility.getCellCount(0);
		while (rs.next()) { 
			rowc++; 
			for (int i = 1; i <= initColc ; i++)
			{
				colc = ExcelUtility.getCellCount(rowc); 
				String result = rs.getString(i);
				ExcelUtility.setCellData(excelPath, result, rowc, colc);
				if(i==2) {
					agentId=rs.getString(i);
				}

			}

		}
	}

	public static void writeSearchEditData() throws Exception {
		//agentId="141414177";
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdSearchEdit"); 
		System.out.println("Delete search operation completed ::"+flag);
		System.out.println("***PHD_Search_Edit_Data***");

		DBConnection.getuserName();
		String searchQuery="select r.AgentId,r.AgentFirstName,r.AgentLastName ,r.AgentPrimaryPhoneNumber,r.AgentSecondaryPhoneNumber, r.AgencyName,r.Market,r.AgentManagerEmail,r.AgentManagerFirstName,r.AgentManagerLastName,r.AgentManagerPhoneNumber,\r\n" + 
				"r.AgentState,r.Language, concat(u.lastname,', ',u.firstname) as SSRAssigned,concat(u.SupervisorLastName,', ',u.SupervisorFirstName) as SSRSupervisor,r.Other,\r\n" + 
				"c.TaskId,TaskType,r.campaignDescription,r.JobName,r.CreatedOn, m.lookupvalue as TaskStatus, c.ScheduleDate,\r\n" + 
				"Replace(Replace(Stuff((Select Distinct ',<' + m2.lookupvalue + '>'\r\n" + 
				"from string_split(c.PHDLanguageLkups,',')a inner join [AppLookupMaster] m2 on m2.LookupMasterId = a.value for xml path (''),\r\n" + 
				"root('MyString'), type).value('/MyString[1]','varchar(max)'),1,1,''),'<',''),'>','') as PHDTaskLanguages,\r\n" + 
				"m1.lookupvalue as FinalDisposition\r\n" + 
				"from [AppPhd] r\r\n" + 
				"join appcampaigntask c on c.AppPHDRef = r.appphdid\r\n" + 
				"left join applookupmaster m on m.lookupmasterid = c.taskstatuslkup\r\n" + 
				"left join applookupmaster m1 on m1.lookupmasterid = c.dispositionlkup\r\n" + 
				"left join appuser u on u.userid = c.assignedto\r\n" + 
				"where AgentId='"+agentId+"'";

		//System.out.println(searchQuery);

		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"phdSearchEdit");
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

	public static void writeSearchViewData() throws Exception {
		agentId="141414188";
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdSearchView"); 
		System.out.println("Delete search operation completed ::"+flag);
		System.out.println("***PHD_Search_View_Data***");

		DBConnection.getuserName();
		String searchQuery="select r.AgentId,DialingMethod,campaignfocus,r.AgentFirstName,r.AgentLastName ,r.AgentPrimaryPhoneNumber,r.AgentSecondaryPhoneNumber, r.AgencyName,r.Market,r.AgentManagerEmail,r.AgentManagerFirstName,r.AgentManagerLastName,r.AgentManagerPhoneNumber,\r\n" + 
				"r.AgentState,r.Language, concat(u.lastname,', ',u.firstname) as SSRAssigned,concat(u.SupervisorLastName,', ',u.SupervisorFirstName) as SSRSupervisor,r.Other,\r\n" + 
				"c.Notes,c.closeddate as FinalAttemptDate,c.CurrentAttemptCount,\r\n" + 
				"c.TaskId,TaskType,r.campaignDescription,r.JobName,r.CreatedOn, m.lookupvalue as TaskStatus, c.ScheduleDate,c.PHDLanguagelkups,\r\n" + 
				"Replace(Replace(Stuff((Select Distinct ',<' + m2.lookupvalue + '>'\r\n" + 
				"from string_split(c.PHDLanguageLkups,',')a inner join [AppLookupMaster] m2 on m2.LookupMasterId = a.value for xml path (''),\r\n" + 
				"root('MyString'), type).value('/MyString[1]','varchar(max)'),1,1,''),'<',''),'>','') as PHDTaskLanguages,(u.FirstName+' '+u.LastName) as AgentName,\r\n" + 
				"m1.lookupvalue as FinalDisposition\r\n" + 
				"from [AppPhd] r\r\n" + 
				"join appcampaigntask c on c.AppPHDRef = r.appphdid\r\n" + 
				"left join applookupmaster m on m.lookupmasterid = c.taskstatuslkup\r\n" + 
				"left join applookupmaster m1 on m1.lookupmasterid = c.dispositionlkup\r\n" + 
				"left join appuser u on u.userid = c.assignedto\r\n" + 
				"where AgentId='"+agentId+"'";

		//System.out.println(searchQuery);

		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"phdSearchView");
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
	public static HashMap<String, String> getSearchViewData() throws Exception {
		int rownum=1;
		writeSearchViewData();
		HashMap<String, String> map =new HashMap<String , String>();
		ExcelUtility.setExcelFile(excelPath,"phdSearchView");
		int colCount=ExcelUtility.getCellCount(0);
		for (int i = 0; i<colCount; i++) {
			String key=ExcelUtility.getCellData(0, i);
			String value=ExcelUtility.getCellData(rownum, i);
			map.put(key, value);	
		}		
		System.out.println("Data provider completed ::View Data");
		return map;
	}


	// ********** USER ADMIN **************** //

	public static void writeadminSearchData() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdUserAdmin"); 
		System.out.println("Delete Adminsearch operation completed ::"+flag);
		DBConnection.getuserName ();
		System.out.println("write Adminsearch for "+DBConnection.userID);
		String sQuery="select * from dbo.AppUser where MSID='"+DBConnection.userID+"'";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sQuery);
		ExcelUtility.setExcelFile(excelPath,"phdUserAdmin");
		rowc = ExcelUtility.initialGetRowCount();
		initColc=ExcelUtility.getCellCount(0);
		System.out.println("rs.next()"+initColc);
		while (rs.next()) { 
			rowc++; 
			for (int i = 1; i <= initColc ; i++)
			{
				colc = ExcelUtility.getCellCount(rowc); 
				String result = rs.getString(i);
				ExcelUtility.setCellData(excelPath, result, rowc, colc);
			}

		}
		System.out.println("Write operation completed ::Adminsearch  Data");
	}

	public static HashMap<String, String> getUserAdminSearchData() throws Exception {
		int rownum=1;
		writeadminSearchData();
		HashMap<String, String> map =new HashMap<String , String>();
		ExcelUtility.setExcelFile(excelPath,"phdUserAdmin");
		int colCount=ExcelUtility.getCellCount(0);
		for (int i = 0; i<colCount; i++) {
			String key=ExcelUtility.getCellData(0, i);
			String value=ExcelUtility.getCellData(rownum, i);

			if(map.containsKey(key)) {
				String txt=map.get(key);
				String listvalue=value+","+txt;
				map.put(key, listvalue);	
			}
			else {
				map.put(key, value);	
			}	
		}		
		System.out.println("Data provider completed ::Admin Search Data");
		return map;
	}
	
	//ADD New User
	
	public static void writeUserAdminAddNewUserData() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdUserAdminAddNew"); 
		System.out.println("Delete search operation completed ::"+flag);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();

		String searchQuery="select top 1 MsId,FirstName,LastName,EmpId,Email,concat(SupervisorFirstName,' ',SupervisorLastName)as Supervisor, concat(ManagerFirstName,' ',ManagerLastName)as Manager from appsalesuser where msid not in (select msid from appuser)";

		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"phdUserAdminAddNew");
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
	
	//Delete AppUser
    public static void deleteAppUser(String msid) throws Exception { 
        String appUserHistory = "delete from  dbo.AppUserHistory where AppUserIdRef in ( select userid from appuser where msid = '"+msid+"')" ;
        String appUserSkillHistory = "delete from dbo.AppUserSkillHistory where UserRef in ( select userid from appuser where msid = '"+msid+"')";
        String appuserskill = "delete from appuserskill where userref in ( select userid from appuser where msid = '"+msid+"')";
        String appUser = "delete  from dbo.appuser where msid ='"+msid+"'";
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement(); 
        stmt.executeUpdate(appUserHistory);
        stmt.executeUpdate(appUserSkillHistory);
        stmt.executeUpdate(appuserskill);
        stmt.executeUpdate(appUser);
        System.out.println("*** DELETE APP USER COMPLETED ***");
    }

	//******** Assignment ************* //

	public static void writeAssignmentData() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdAssignment"); 
		System.out.println("Delete search operation completed ::"+flag);
		DBConnection.getuserName();
		System.out.println("writeSearchData");
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();

		String searchQuery="select  top 1 t.taskid,AgentId,TaskType,campaignfocus, m.lookupvalue as taskstatus,JobName, DialingMethod,\r\n" + 
				"r.AgentFirstName,r.AgentLastName,r.AgentPrimaryPhoneNumber,r.agentstate,\r\n" + 
				"r.Createdon as CreatedDate,(u.FirstName+' '+u.LastName) as AgentName, m1.lookupvalue as FinalDisposition, t.closeddate as FinalAttemptDate,Agentassigned\r\n" + 
				"from [AppPhd] r\r\n" + 
				"join appcampaigntask t on t.AppPHDRef = r.appphdid\r\n" + 
				"left join applookupmaster m on m.lookupmasterid = t.taskstatuslkup\r\n" + 
				"left join applookupmaster m1 on m.lookupmasterid = t.dispositionlkup\r\n" + 
				"left join appuser u on u.userid = t.assignedto\r\n" + 
				"where r.isactive = 1 and t.isactive = 1 and t.taskstatuslkup=31 and u.Msid not in('"+DBConnection.userID+"') order by 1 desc";

		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"phdAssignment");
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

	public static HashMap<String, String> getAssignmentData() throws Exception {
		int rownum=1;
		writeAssignmentData();
		HashMap<String, String> map =new HashMap<String , String>();
		ExcelUtility.setExcelFile(excelPath,"phdAssignment");
		int colCount=ExcelUtility.getCellCount(0);
		for (int i = 0; i<colCount; i++) {
			String key=ExcelUtility.getCellData(0, i);
			String value=ExcelUtility.getCellData(rownum, i);
			map.put(key, value);	
		}		
		System.out.println("Data provider completed ::Assignment Search  Data");
		return map;
	}
	
	// ******** Home **************** //
	public static void writeHomeData() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdHome"); 
		System.out.println("Delete search operation completed ::"+flag);
		System.out.println("***PHD_Home_Data***");
		DBConnection.setAssignmentName();
		
		String searchQuery="select distinct top 5 CAST (getutcdate() as time) as UTCTime,IndTs.Jobname,tasktype, t.taskid,t.ScheduleUTCStartTime,t.scheduledate, b.Priority ,CAST (t.RecentAtttemptDate as date) as LastAttemptDate, currentattemptcount\r\n" + 
				"from AppCampaignTask t  \r\n" + 
				"inner join appcampaignqueue a \r\n" + 
				"on t.AppCampaignQueueRef=a.AppCampaignQueueID  and a.TeamLkup=4 and a.isactive=t.isactive and (assignedto = "+DBConnection.assignId+"  or assignedto is null)\r\n" + 
				"and t.TaskStatusLkup=31 and t.IsActive = 1\r\n" + 
				"inner join appuserskill c\r\n" + 
				"on  c.IsActive=1 and c.userref="+DBConnection.assignId+" and a.LanguageLkUp=c.skilllkup \r\n" + 
				"inner join appuserskill d\r\n" + 
				"on a.DialingMethodLkUp=d.skilllkup  and d.userref="+DBConnection.assignId+" and d.IsActive=1\r\n" + 
				"inner join appuserskill f\r\n" + 
				"on a.TeamLkUp=f.skilllkup and  f.IsActive=1 and f.userref="+DBConnection.assignId+"\r\n" + 
				"inner join AppCampaignTypes b\r\n" + 
				"on   b.campaignlkup=a.campaignlkup and b.CampaignTypeLkup=a.CampaignTypeLkUp \r\n" + 
				"join Appphd IndTs\r\n" + 
				"on IndTs.Appphdid = t.Appphdref and b.isactive=1 and b.CampaignLkUp=22 and t.isactive = 1\r\n" + 
				"order by b.Priority asc, t.ScheduleUTCStartTime asc, currentattemptcount asc ";

		System.out.println(searchQuery);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"phdHome");
		rowc = ExcelUtility.initialGetRowCount();
		initColc=ExcelUtility.getCellCount(0);
		while (rs.next()) { 
			rowc++; 
			colc = ExcelUtility.getCellCount(rowc);
			ExcelUtility.setCellData(excelPath,Integer.toString(rowSno),rowc, colc);
			for (int i = 1; i <= initColc-1; i++)
			{
				colc = ExcelUtility.getCellCount(rowc); 
				String result = rs.getString(i);
				ExcelUtility.setCellData(excelPath, result, rowc, colc);
			}
			rowSno++;

		}
		System.out.println("Home count:"+rowSno);
	}
	
	// ****************** 	Home Skill ********************************* //
	
	public static void writeHomeSkillData(String Language) throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdHomeSkill"); 
		System.out.println("Delete search operation completed ::"+flag);
		DBConnection.setAssignmentName();
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();

		String searchQuery="select count(*) as Count from appphd r\r\n" + 
				"join appcampaigntask c on c.appphdref = r.appphdid\r\n" + 
				"where Language = '"+Language+"' and r.isactive = 1 and c.isactive =1 and (c.assignedto is null or c.assignedto = "+DBConnection.assignId+")\r\n" + 
				"and taskstatuslkup = 31";

		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"phdHomeSkill");
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
	
	public static void writeHomeNotAssignedSkillData(String Language) throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"phdHomeSkill"); 
		System.out.println("Delete search operation completed ::"+flag);
		DBConnection.setAssignmentName();
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();

		String searchQuery="select count(*) as Count from appphd r\r\n" + 
				"join appcampaigntask c on c.appphdref = r.appphdid\r\n" + 
				"where Language = '"+Language+"' and r.isactive = 1 and c.isactive =1 and (c.assignedto is null)\r\n" + 
				"and taskstatuslkup = 31";

		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"phdHomeSkill");
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
