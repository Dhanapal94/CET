package com.cet.utility;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;


public class DBConnection {
	//DBVET41897
	//cet_test
	//RCTPo@V1
	//  Database credentials
	private static final String USER = "cet_test";
	private static final String PASS = "RCTPo@V1";

	public static String userID="";
	public static String appSameHouseHoldRef,taskid,bconnid,dialingteam,assignName,assignId;
	public static String grptsappSameHouseHoldRef,grptstaskid,grptsbconnid,grptsdialingteam;

	public static void  getuserName () {
		userID=new com.sun.security.auth.module.NTSystem().getName();
		System.out.println("new com.sun.security.auth.module.NTSystem().getName()"+userID);
	}



	public static void appendToPath(){
		String dir=System.getProperty("user.dir")+ File.separatorChar+"sql_resourse"+File.separatorChar;
		String path = System.getProperty("java.library.path");
		path = dir + ";" + path;
		System.setProperty("java.library.path", path);
		try {
			final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
			sysPathsField.setAccessible(true);
			sysPathsField.set(null, null);

		}
		catch (Exception ex){
			throw new RuntimeException(ex);
		}
		System.out.println("**************** Sql dll set ****************");
	}


	public static  Connection getConnection() throws  ClassNotFoundException, SQLException

	{
		//This will fix the dll path of SQL server :: it should be in the java run time path .
		appendToPath();
		String dburl = Readconfig.getValue("cet","dbURL");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(dburl,USER,PASS);
		System.out.println("**************** Connected to Microsfost server **************** ");
		return conn;


	}
	@Test
	public static String getClickCMT() throws ClassNotFoundException, SQLException {
		System.out.println("getClickCMT" );
		String result="" ;
		getuserName();
		String getcheckUserAccessSql= "Select count(MSID) as count from dbo.AppUser WHERE MSID like '"
				+ userID
				+"' and MSID IN (select a.MSID as 'user' from dbo.AppUser a,dbo.AppSalesUser b where a.MSID=b.MSID)";//Readconfig.getValue("cet","checkUserAccessSql");

		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		System.out.println("getcheckUserAccessSql"+getcheckUserAccessSql);
		ResultSet rs= stmt.executeQuery(getcheckUserAccessSql);

		while (rs.next()) {
			result = rs.getString("count");
		}
		System.out.println("result"+result);
		return result;
	}


	@Test 

	public static void getViewUser() throws SQLException, ClassNotFoundException{
		String result="";
		getuserName();
		String query="Select * from dbo.AppUser where MSID  like '"+userID+"'";
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		System.out.println("getcheckUserAccessSql"+query);
		ResultSet rs= stmt.executeQuery(query);


		while (rs.next()) {
			result = rs.getString("IsActive");
		}
		System.out.println("result"+result);
		// return result;

	}

	// ******** Additional HouseHold ********** //

	public static void setAssignmentName() throws SQLException, ClassNotFoundException{
		getuserName();
		String query="select FirstName+' '+LastName as FullName,UserId from dbo.AppUser where MSID='"+userID+"'";
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs= stmt.executeQuery(query);			
		while (rs.next()) {
			assignName = rs.getString(1);
			assignId=rs.getString(2);
		}
		System.out.println("AssignmentName:"+assignName);	
		System.out.println("AssignId:"+assignId);
	}

	// ******** INDTS *************

	public static void setIndtsSameHousehold() throws SQLException, ClassNotFoundException{
		String query="select top 1 APPSameHouseHoldRef,count(APPSameHouseHoldRef) from  [AppIndividualTS] i\r\n" + 
				"join appcampaigntask c on c.appindividualtsref = i.appindividualtsid\r\n" + 
				"where c.appsamehouseholdref is not null and c.isactive = 1  and c.taskstatuslkup=31  group by APPSameHouseHoldRef\r\n" + 
				"having count(APPSameHouseHoldRef)>2 ";
		String count="";
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs= stmt.executeQuery(query);			
		while (rs.next()) {
			appSameHouseHoldRef = rs.getString(1);
			count=rs.getString(2);
		}
		System.out.println("AppSameHouseHold:"+appSameHouseHoldRef);	
		System.out.println("Count same Household:"+count);
	}

	public static void setIndtsTaskAssignment() throws Exception
	{
		setAssignmentName();
		setIndtsSameHousehold();
		String query="select top 1 APPSameHouseHoldRef,taskid,bconnid,dialingteam from  [AppIndividualTS] i\r\n" + 
				"join appcampaigntask c on c.appindividualtsref = i.appindividualtsid\r\n" + 
				"where c.appsamehouseholdref is not null and c.isactive = 1  and c.taskstatuslkup=31 and APPSameHouseHoldRef='"+appSameHouseHoldRef+"'";
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs= stmt.executeQuery(query);			
		while (rs.next()) {
			taskid=rs.getString(2);
			bconnid=rs.getString(3);
			dialingteam=rs.getString(4);

			if(dialingteam.equals("Digital"))
			{
				dialingteam=dialingteam.toUpperCase();
			}
		}
		System.out.println("Taskid:"+taskid);
		System.out.println("Bconnid:"+bconnid);
		System.out.println("DialingTeam:"+dialingteam);
	}

	// ******** GRPTS *************

	public static void setGrptsSameHousehold() throws SQLException, ClassNotFoundException{
		String query="select APPSameHouseHoldRef,count(APPSameHouseHoldRef) from  appgroupts i\r\n" + 
				"join appcampaigntask c on c.appgrouptsref = i.appgrouptsid\r\n" + 
				"where c.appsamehouseholdref is not null and c.isactive = 1  and c.taskstatuslkup=31 and DialingTeam is not Null group by APPSameHouseHoldRef\r\n" + 
				"having count(APPSameHouseHoldRef)>2";
		String count="";
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs= stmt.executeQuery(query);			
		while (rs.next()) {
			grptsappSameHouseHoldRef = rs.getString(1);
			count=rs.getString(2);
		}
		System.out.println("GRPTS AppSameHouseHold:"+grptsappSameHouseHoldRef);	
		System.out.println("GRPTS Count same Household:"+count);
	}

	public static void setGrptsTaskAssignment() throws Exception
	{
		setAssignmentName();
		setGrptsSameHousehold();
		String query="select top 1 APPSameHouseHoldRef,taskid,bconnid,dialingteam,ASSIgnedto  from  appgroupts i\r\n" + 
				"join appcampaigntask c on c.appgrouptsref = i.appgrouptsid\r\n" + 
				"where c.appsamehouseholdref is not null and c.isactive = 1  and c.taskstatuslkup=31 and APPSameHouseHoldRef='"+grptsappSameHouseHoldRef+"'";
		System.out.println(query);
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs= stmt.executeQuery(query);			
		while (rs.next()) {
			grptstaskid=rs.getString(2);
			grptsbconnid=rs.getString(3);
			grptsdialingteam=rs.getString(4);

			if(grptsdialingteam.equals("Digital"))
			{
				grptsdialingteam=grptsdialingteam.toUpperCase();
			}
		}
		System.out.println("GRPTS Taskid:"+grptstaskid);
		System.out.println("GRPTS Bconnid:"+grptsbconnid);
		System.out.println("GRPTS DialingTeam:"+grptsdialingteam);
	}

}
