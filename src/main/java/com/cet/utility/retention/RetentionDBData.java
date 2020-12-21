package com.cet.utility.retention;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.utility.DBConnection;
import com.cet.utility.ExcelUtility;


public class RetentionDBData {
	public static String excelPath = System.getProperty("user.dir") + "\\" + "RetentionData.xlsx";
	public static int initColc;
	public static int rowc, colc;
	public static int rowSno = 1;
	public static String userID="";
	static String MBIID;

	@SuppressWarnings("restriction")
	public static void  getuserName () {
		userID=new com.sun.security.auth.module.NTSystem().getName();
		System.out.println("new com.sun.security.auth.module.NTSystem().getName()"+userID);

	}

	static String appuserQuery="Select * from dbo.AppUser where msid='"+userID+"'";


	/******************************************************Methods********************************************/
	static String searchQuery="select Top 1 MBINum,TaskType,campaignfocus, m.lookupvalue as taskstatus,JobName, DialingMethod, r.FirstName, r.LastName, PrimaryPhone, \r\n" + 
			"(u.FirstName+' '+u.LastName) as AgentName,concat(u.SupervisorFirstName,', ',u.SupervisorLastName) as AgentSupervisor, t.taskid, State,\r\n" + 
			"r.Createdon as CreatedDate, m1.lookupvalue as FinalDisposition, t.closeddate as FinalAttemptDate\r\n" + 
			"from [AppRetention] r\r\n" + 
			"join appcampaigntask t on t.AppRetentionRef = r.AppRetentionid\r\n" + 
			"left join applookupmaster m on m.lookupmasterid = t.taskstatuslkup\r\n" + 
			"left join applookupmaster m1 on m.lookupmasterid = t.dispositionlkup\r\n" + 
			"left join appuser u on u.userid = t.assignedto\r\n" + 
			"where r.isactive = 1 and t.isactive = 1\r\n" + 
			"and t.TaskStatusLkup= 31\r\n" + 
			"and msid='"+userID+"'\r\n" + 
			"order by 1 desc";

	String updateRecord="with cte\r\n" + 
			"as (\r\n" + 
			"select top 5 concat(u.firstname,', ',u.lastname) as AgentAssigned, c.assignedto from [AppRetention] r\r\n" + 
			"join appcampaigntask c on c.appretentionref = r.appretentionid\r\n" + 
			"join appuser u on u.userid = c.assignedto\r\n" + 
			"where taskstatuslkup = 31 and r.isactive = 1 and c.isactive = 1\r\n" + 
			")\r\n" + 
			"update cte set assignedto = (select  userid from appuser where MSId='"+userID+"')";


	@Test
	public static void writeSearchData() throws Exception {
		updateTask();
		Boolean flag=ExcelUtility.deleteRows(excelPath,"search"); 
		System.out.println("Delete search operation completed ::"+flag);
		getuserName ();
		String query=" select Top 1 MBINum,TaskType,campaignfocus, m.lookupvalue as taskstatus,JobName, DialingMethod, r.FirstName, r.LastName, PrimaryPhone, \r\n" + 
				"			(u.FirstName+' '+u.LastName) as AgentName,concat(u.SupervisorFirstName,', ',u.SupervisorLastName) as AgentSupervisor, t.taskid, State,\r\n" + 
				"			r.Createdon as CreatedDate, m1.lookupvalue as FinalDisposition, t.closeddate as FinalAttemptDate \r\n" + 
				"			from [AppRetention] r\r\n" + 
				"			join appcampaigntask t on t.AppRetentionRef = r.AppRetentionid\r\n" + 
				"			left join applookupmaster m on m.lookupmasterid = t.taskstatuslkup\r\n" + 
				"			left join applookupmaster m1 on m.lookupmasterid = t.dispositionlkup\r\n" + 
				"			left join appuser u on u.userid = t.assignedto\r\n" + 
				"			where r.isactive = 1 and t.isactive = 1\r\n" + 
				"			and t.TaskStatusLkup= 31\r\n" + 
				"			and msid='"+userID+"'\r\n" + 
				"			order by 1 desc";
		System.out.println("write SearchData for "+userID);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query);
		ExcelUtility.setExcelFile(excelPath,"search");
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

		System.out.println("Write operation completed ::Search  Data");
	}
	public static void writeadminSearchData() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"adminsearch"); 
		System.out.println("Delete Adminsearch operation completed ::"+flag);
		getuserName ();
		System.out.println("write Adminsearch for "+userID);
		String sQuery="select * from dbo.AppUser where MSID='"+userID+"'";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sQuery);
		ExcelUtility.setExcelFile(excelPath,"adminsearch");
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

	public static void writeadminAddUserSearchData() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"adminAddUsersearch"); 
		System.out.println("Delete admin AddUser search operation completed ::"+flag);
		String sQuery="select Top 1 msid, * from appsalesuser  where msid not in (select msid from appuser)";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sQuery);
		ExcelUtility.setExcelFile(excelPath,"adminAddUsersearch");
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
		System.out.println("Write admin AddUser search operation completed ::writeadminAddUserSearchData  Data");
	}


	public static HashMap<String, String> getSearchData(int rownum) throws Exception {
		//int rownum=1;
		RetentionDBData.writeSearchData();
		HashMap<String, String> map =new HashMap<String , String>();
		ExcelUtility.setExcelFile(excelPath,"search");
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
		System.out.println("map"+map.toString());
		System.out.println("Data provider completed ::Search  Data");
		return map;
	}
	public static HashMap<String, String> getUserAdminSearchData() throws Exception {
		int rownum=1;
		RetentionDBData.writeadminSearchData();
		HashMap<String, String> map =new HashMap<String , String>();
		ExcelUtility.setExcelFile(excelPath,"adminsearch");
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

	public static HashMap<String, String> getAddUserAdminSearchData() throws Exception {
		int rownum=1;
		RetentionDBData.writeadminAddUserSearchData();
		HashMap<String, String> map =new HashMap<String , String>();
		ExcelUtility.setExcelFile(excelPath,"adminAddUsersearch");
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
		System.out.println("Data provider completed ::admin Add User search");
		return map;
	}

	public static void writeViewEditSearchData() throws Exception {
		HashMap<String, String> searchData = getSearchData(1);
		MBIID=searchData.get("MBINum");
		String query="select MBINum,CampaignDescription,Jobname,CurrentPlan,PreviousPlan,r.FirstName as FirstName ,r.LastName as LastName, AgentOfRecord,ApplicationDate,\r\n" + 
				"MemberDateOfBirth, Age, [PrimaryMember'sGender] as Gender,\r\n" + 
				"Address,City,State,\r\n" + 
				"ZipCode,County,PrimaryPhone,PhoneNum2,Language,SalesChannel,ProviderInformation\r\n" + 
				",DialingMethod,CampaignFocus,TimeZone,c.ScheduleDate as Scheduledate,TaskType as TaskType,TaskId as TaskId,c.createdon as CreatedDate,notes,HAIndicator\r\n" + 
				",ProviderInformation, concat(u.lastname,', ',u.firstname) as AgentAssigned, concat(u.SupervisorLastName,', ',u.SupervisorFirstName) as AgentSupervisor,CurrentAttemptCount as Attemptcount,\r\n" + 
				"RecentAtttemptDate as AttemptDate, concat(u1.lastname,', ',u1.firstname) as UserName\r\n" + 
				"from [AppRetention] r\r\n" + 
				"join appcampaigntask c on c.appretentionref = r.appretentionid\r\n" + 
				"left join appuser u on u.userid = c.assignedto\r\n" + 
				"left join appuser u1 on u1.userid = c.LastUpdatedOn\r\n" + 
				"left join applookupmaster m on m.lookupmasterid = c.taskstatuslkup\r\n" + 
				"where taskstatuslkup = 31 "
				+ "and MBINum='"+MBIID+"'";
		Boolean flag=ExcelUtility.deleteRows(excelPath,"searchEdit"); 
		System.out.println("Delete searchEdit operation completed ::"+flag);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ExcelUtility.setExcelFile(excelPath,"searchEdit");
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


	public static HashMap<String, String> getSearchEditData() throws Exception {
		int rownum=1;
		RetentionDBData.writeViewEditSearchData();
		HashMap<String, String> map =new HashMap<String , String>();
		ExcelUtility.setExcelFile(excelPath,"searchEdit");
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
		System.out.println("Data provider completed ::edit  Data");
		return map;
	}

	public static void updateTask() throws Exception, SQLException {
		getuserName ();
		System.out.println("write Adminsearch for "+userID);

		String sql="with cte\r\n" + 
				"as (\r\n" + 
				"select top 5 concat(u.firstname,', ',u.lastname) as AgentAssigned, c.assignedto from [AppRetention] p\r\n" + 
				"join appcampaigntask c on c.appretentionref = p.appretentionid\r\n" + 
				"join appuser u on u.userid = c.assignedto\r\n" + 
				"where taskstatuslkup = 31 and p.isactive = 1 and c.isactive = 1\r\n" + 
				")" + 
				"update cte set assignedto = (select userid from appuser where msid='"+userID+"')\r\n";
		String sql1="update appcampaigntaskhistory set assignedto = (select  userid from appuser where  msid='"+userID+"')\r\n" + 
				"where appcampaigntaskref in (select c.appcampaigntaskid from appcampaigntask c\r\n" + 
				"join appuser u on u.userid = c.assignedto \r\n" + 
				"where u.msid='"+userID+"' and appphdref is not null)";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		int executeUpdate = stmt.executeUpdate(sql);	System.out.println("executeUpdate"+executeUpdate);
		int executeUpdate2 = stmt.executeUpdate(sql1);  System.out.println("executeUpdate"+executeUpdate2);


	}
	public static void deletUser(String smid) throws ClassNotFoundException, SQLException {
		String sql1="delete from dbo.AppUserSkillHistory where userref in ( select userid from appuser where msid = '"+smid+"')"; 
		String sql2="delete from dbo.AppUserHistory where msid = '"+smid+"'";
		String sql3="delete from appuserskill where userref in ( select userid from appuser where msid ='"+smid+"')";
		String sql4="delete  from appuser where msid ='"+smid+"'";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		int executeUpdate = stmt.executeUpdate(sql1);	System.out.println("executeUpdate"+executeUpdate);
		int executeUpdate2 = stmt.executeUpdate(sql2);  System.out.println("executeUpdate"+executeUpdate2);
		int executeUpdate3 = stmt.executeUpdate(sql3);  System.out.println("executeUpdate"+executeUpdate3);
		int executeUpdate4 = stmt.executeUpdate(sql4);  System.out.println("executeUpdate"+executeUpdate4);

	}
	//*************************************User Admin***************************************************************
	public static void viewUserWriteTest() throws Exception {
		getuserName();
		Boolean flag=ExcelUtility.deleteRows(excelPath,"viewAdminUser"); 
		System.out.println("Delet operation for view admin user is ::"+flag);
		String query = "select u.msid,u.firstname,u.lastname,u.EmpId,u.Email,u.SupervisorFirstName,u.SupervisorLastName,u.ManagerName,u.status,u.IsAssignTask,l.LookupDescription,l.lookupvalue from AppUser u join AppUserSkill s on s.userref = u.userid join applookupmaster l on lookupmasterid = SkillLkup where u.isactive = 1 and s.isactive = 1  and u.msid like (Select  u.msid from dbo.AppUser u where msid='"+userID+"') order by u.UpdatedOn desc ";
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		String sheetName = "viewAdminUser";
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


	public static HashMap<String, String> viewAdminUserData() throws Exception
	{
		System.out.println("Get View User Data");
		viewUserWriteTest();
		ExcelUtility.setExcelFile(excelPath, "viewAdminUser");
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
		System.out.println("Data provider viewAdminUser completed");
		return table;
	}
	// ******** Home **************** //
	public static void writeHomeData() throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"home"); 
		System.out.println("Delete search operation completed ::"+flag);
		System.out.println("***Retention_Home_Data***");
		DBConnection.setAssignmentName();

		String searchQuery="select distinct top 5 CAST (getutcdate() as time) as UTCTime,IndTs.Jobname, tasktype, t.taskid,t.ScheduleUTCStartTime,t.scheduledate, b.Priority ,CAST (t.RecentAtttemptDate as date) as LastAttemptDate, currentattemptcount\r\n" + 
				"from AppCampaignTask t \r\n" + 
				"inner join appcampaignqueue a\r\n" + 
				"on t.AppCampaignQueueRef=a.AppCampaignQueueID  and a.TeamLkup=3 and a.isactive=t.isactive and (assignedto = "+DBConnection.assignId+"   or assignedto is null)\r\n" + 
				"and t.TaskStatusLkup=31 and t.IsActive = 1\r\n" + 
				"inner join appuserskill c\r\n" + 
				"on  c.IsActive=1 and c.userref="+DBConnection.assignId+" and a.LanguageLkUp=c.skilllkup\r\n" + 
				"inner join appuserskill d\r\n" + 
				"on a.DialingMethodLkUp=d.skilllkup  and d.userref="+DBConnection.assignId+" and d.IsActive=1\r\n" + 
				"inner join appuserskill f\r\n" + 
				"on a.TeamLkUp=f.skilllkup and  f.IsActive=1 and f.userref="+DBConnection.assignId+"\r\n" + 
				"inner join AppCampaignTypes b\r\n" + 
				"on   b.campaignlkup=a.campaignlkup and b.CampaignTypeLkup=a.CampaignTypeLkUp\r\n" + 
				"join AppRetention IndTs\r\n" + 
				"on IndTs.AppRetentionid = t.AppRetentionref and b.isactive=1 and b.CampaignLkUp=21 and t.isactive = 1\r\n" + 
				"order by b.Priority asc, t.ScheduleUTCStartTime asc, currentattemptcount asc ";


		System.out.println(searchQuery);
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"home");
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
	@DataProvider(name = "RetentionHome")
	public static Object[][] homeDataRepository() throws Exception
	{
		System.out.println("Retention Home Data Provider Started");
		Base.setUp();
		RetentionHelper.setRetentionTeam(Base.driver);
		updateTask();
		writeHomeData();
		ExcelUtility.setExcelFile(excelPath, "home");
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


	public static void writeHomeNotAssignedSkillData(String Language) throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"homeSkill"); 
		System.out.println("Delete search operation completed ::"+flag);
		DBConnection.setAssignmentName();
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();

		String searchQuery="select count(*) from appretention r\r\n" + 
				"join appcampaigntask c on c.appretentionref = r.appretentionid\r\n" + 
				"where Language = '"+Language+"' and r.isactive = 1 and c.isactive =1 and (c.assignedto is null)" + // or c.assignedto = "+DBConnection.assignId+"
				"and taskstatuslkup = 31";
		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"homeSkill");
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

	public static void writeHomeSkillData(String Language) throws Exception {
		Boolean flag=ExcelUtility.deleteRows(excelPath,"homeSkill"); 
		System.out.println("Delete search operation completed ::"+flag);
		DBConnection.setAssignmentName();
		Connection conn = DBConnection.getConnection();
		Statement stmt = conn.createStatement();

		String searchQuery="select count(*) as Count from appphd r\r\n" + 
				"join appcampaigntask c on c.appphdref = r.appphdid\r\n" + 
				"where Language = '"+Language+"' and r.isactive = 1 and c.isactive =1 and (c.assignedto is null or c.assignedto = "+DBConnection.assignId+")\r\n" + 
				"and taskstatuslkup = 31";

		ResultSet rs = stmt.executeQuery(searchQuery);
		ExcelUtility.setExcelFile(excelPath,"homeSkill");
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
}//class end			





















