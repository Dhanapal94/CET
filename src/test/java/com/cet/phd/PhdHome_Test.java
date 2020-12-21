package com.cet.phd;

import java.text.ParseException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.phdpages.PhdHomePage;
import com.cet.pagerepositery.phdpages.PhdSettingPage;
import com.cet.utility.phd.DataProviderPhd;

public class PhdHome_Test extends Base{

	static boolean initializationFlag=true;
	String id,jobName,taskType,scheduledDate,lastAttemptDate,attemptCount;

	static int count=0,parentTestCount=1;

	@BeforeClass
	public void createTest() {
		team="Phd";
		childTest=true;
		parentTest=extent.createTest("Phd-Home Test "+parentTestCount);
		parentTestCount++;
	}

	@Factory(dataProvider="PHDHome", dataProviderClass=DataProviderPhd.class)
	public PhdHome_Test(Hashtable<String,String> data) throws Exception {
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
	public void initializationPHD_Search() throws Exception
	{
		if(initializationFlag)
		{
			setUp();
			PhdHomePage.launch(driver);
			PhdSettingPage.Assigned_NotAssigned_Click(driver);
			initializationFlag=false;
			fopenBrowser=false;
		}
	}

	@AfterMethod
	public void closeBrowser() {
		if(count==5) {
			//fopenBrowser=true;
		}

	}

	@Test(priority=1)
	public void nextScheduledTableHeader_Test() {
		count++;
		Assert.assertEquals(PhdHomePage.tableHeader(driver).getText(),"Next 5 Scheduled Tasks",
				"Failed:Next Scheduled Tasks Header!");		
	}
	@Test(priority=2)
	public void homeJobName_Test() {	
		Assert.assertEquals(PhdHomePage.tableJobName(driver, id).getText(),jobName,
				"Failed:"+count+"Job Name");		
	}
	@Test(priority=3)
	public void homeTaskType_Test() {	
		Assert.assertEquals(PhdHomePage.tableTaskType(driver,id).getText(),taskType,
				"Failed:"+count+"taskType");		
	}
	@Test(priority=4)
	public void homeScheduledDate_Test() {	
		Assert.assertEquals(PhdHomePage.tableScheduledDate(driver, id).getText(),scheduledDate,
				"Failed:"+count+"ScheduledDate");		
	}
	@Test(priority=5) 
	public void homeLastAttempttDate_Test() throws ParseException { 
		String text = PhdHomePage.tableLastAttemptDate(driver,id).getText();
		if(text.length()<=0 || text.equals(null)) {
			Assert.assertEquals(PhdHomePage.tableLastAttemptDate(driver,id).getText(),lastAttemptDate,
					"Failed:"+count+"lastAttemptDate"); 

		}else if(text.length()>0){
			Assert.assertEquals(PhdHomePage.getHomePageDate(text),lastAttemptDate,
					"Failed:"+count+"lastAttemptDate"); 
		}
	}

	@Test(priority=6)
	public void homeAttemptCount_Test() {	
		Assert.assertEquals(PhdHomePage.tableAttemptCount(driver, id).getText(),attemptCount,
				"Failed:"+count+"attemptCount");		
	}
}
