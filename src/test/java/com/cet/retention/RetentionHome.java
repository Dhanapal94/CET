package com.cet.retention;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.retentionpages.RetentionHomePage;
import com.cet.utility.retention.RetentionDBData;


public class RetentionHome extends Base{
	String id,jobName,taskType,scheduledDate,lastAttemptDate,attemptCount;
	private static boolean initFlag=true;

	static int count=0,parentTestCount=1;

	@BeforeClass
	public void createTest() {
		childTest=true;
		parentTest=extent.createTest("Retention-Home Test "+parentTestCount);
		team="Retention";
		parentTestCount++;
	}

	@Factory(dataProvider="RetentionHome", dataProviderClass=RetentionDBData.class)
	public RetentionHome(Hashtable<String,String> data) throws Exception {
		try {
			this.id=data.get("Id");
			this.jobName=data.get("JobName");
			this.taskType=data.get("TaskType");
			this.scheduledDate=data.get("ScheduleDate");
			this.lastAttemptDate=data.get("LastAttemptDate");
			this.attemptCount=data.get("CurrentAttemptCount");	
		}
		catch(Exception e)
		{
			System.out.println("Exception is :"+e.getMessage());
		}
	}

	@BeforeMethod
	public void initializationRetention_Search() throws Exception
	{
		if(initFlag)
		{
			setUp();
			initFlag=false;
			fopenBrowser=false; // wanna run this case individually? Then disable this line !
			//fopenBrowser=true; // wanna run this case individually? Then enable this line !
		}
	}


	@Test(priority=1)
	public void nextScheduledTableHeader_Test() {
		count++;
		Assert.assertEquals(RetentionHomePage.tableHeader(driver).getText(),"Next 5 Scheduled Tasks",
				"Failed:Next Scheduled Tasks Header!");		
	}
	@Test(priority=2)
	public void homeJobName_Test() {	
		Assert.assertEquals(RetentionHomePage.tableJobName(driver, id).getText(),jobName,
				"Failed:"+count+"Job Name");		
	}
	@Test(priority=3)
	public void homeTaskType_Test() {	
		Assert.assertEquals(RetentionHomePage.tableTaskType(driver,id).getText(),taskType,
				"Failed:"+count+"taskType");		
	}
	@Test(priority=4)
	public void homeScheduledDate_Test() {	
		Assert.assertEquals(RetentionHomePage.tableScheduledDate(driver, id).getText(),scheduledDate,
				"Failed:"+count+"ScheduledDate");		
	}
	@Test(priority=5)
	public void homeLastAttemptDate_Test() {	
		Assert.assertEquals(RetentionHomePage.tableLastAttemptDate(driver,id).getText(),lastAttemptDate,
				"Failed:"+count+"lastAttemptDate");		
	}
	@Test(priority=6)
	public void homeAttemptCount_Test() {	
		Assert.assertEquals(RetentionHomePage.tableAttemptCount(driver, id).getText(),attemptCount,
				"Failed:"+count+"attemptCount");		
	}
}



