package com.cet.phd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.phdpages.PHDSearch_TaskDetails_Page;
import com.cet.pagerepositery.phdpages.PhdSearchPage;
import com.cet.pagerepositery.phdpages.PhdSearchResultPage;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.utility.phd.PHDDBData;
import com.cet.utility.phd.PHD_Helper;

public class PhdSearch_View_Test extends Base {


	static boolean initializationFlag=true;
	static boolean switchToMainWindow=false;
	static String mainWindow;

	static String agentId,agentFirstName,agentLastName,agentPrimaryPhoneNumber,agentSecondaryPhoneNumber,agencyName,market,agentManagerEmail,agentManagerFirstName,
	agentManagerLastName,agentManagerPhoneNumber,agentState,language,ssrAssigned,ssrSupervisor,other,taskId,tasktype,campaignDescription,
	jobName,createdOn,taskStatus,scheduledDate,taskLanguage,finalDisposition,dialingMethod,finalAttemptDate,agentName,notes,campaignFocus;

	static int initCount=0;

	@BeforeClass
	public static void getinit() throws Exception {
		HashMap<String, String> data = PHDDBData.getSearchViewData();
		agentId=data.get("AgentId");
		agentFirstName=data.get("AgentFirstName");
		agentLastName=data.get("AgentLastName");
		agentPrimaryPhoneNumber=data.get("AgentPrimaryPhoneNumber");
		agentSecondaryPhoneNumber=data.get("AgentSecondaryPhoneNumber");
		agencyName=data.get("AgencyName");
		market=data.get("Market");
		agentManagerEmail=data.get("AgentManagerEmail");
		agentManagerFirstName=data.get("AgentManagerFirstName");
		agentManagerLastName=data.get("AgentManagerLastName");
		agentManagerPhoneNumber=data.get("AgentManagerPhoneNumber");
		agentState=data.get("AgentState");
		language=data.get("Language");
		ssrAssigned=data.get("SSRAssigned");
		ssrSupervisor=data.get("SSRSupervisor");
		other=data.get("Other");
		taskId=data.get("TaskId");
		tasktype=data.get("TaskType");
		campaignDescription=data.get("campaignDescription");
		jobName=data.get("JobName");
		createdOn=data.get("CreatedOn");
		taskStatus=data.get("TaskStatus");
		scheduledDate=data.get("ScheduleDate");
		taskLanguage=data.get("TaskLanguage");
		finalDisposition=data.get("FinalDisposition");	
		dialingMethod=data.get("DialingMethod");
		finalAttemptDate=data.get("FinalAttemptDate");
		agentName=data.get("AgentName");
		notes=data.get("Notes");
		campaignFocus=data.get("CampaignFocus");
		childTest=true;
		parentTest=extent.createTest("Phd-Search View Test");
		team="Phd";
	}

	@BeforeMethod
	public void initializationPHD_Search() throws Exception
	{
		if(initializationFlag)
		{
			//setUp();
			LeftPanel.lnkSearch(driver).click();
			PhdSearchPage.launch(driver);
			PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
			PhdSearchPage.buttonSearch(driver).click();		
			initializationFlag=false;
			fopenBrowser=true;
		}
	}
	@AfterMethod()
	public void switchToMainWindow()
	{
		if(switchToMainWindow)
		{
			Point p = new Point(0,3000);
			driver.manage().window().setPosition(p);	
			driver.switchTo().window(mainWindow);
		}
	}

	@Test(priority=1)
	public void editButtonDisabled_Test()
	{	
		String expectedHexa=Color.fromString( PhdSearchResultPage.tableEditLink(driver).getCssValue("color")).asHex();
		Assert.assertEquals( expectedHexa ,"#808080");			
	}

	@Test(priority=2)
	public void agentIdSearch_PHD_View_Test() {
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName, createdOn.substring(0,createdOn.indexOf(' ')), 
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate.substring(0,finalAttemptDate.indexOf(' ')), agentName), "Failed:Search Result Varied!");		
	}

	@Test(priority=3,enabled=true)
	public void agentId_View_Test() throws Exception
	{
		PhdSearchResultPage.jsClick(PhdSearchResultPage.tableViewLink(driver), driver);
		mainWindow=PhdSearchResultPage.handleWindows(driver);
		PHDSearch_TaskDetails_Page.launch(driver);
		//PhdSearchResultPage.waitForPageLoad(driver);
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentId(driver)), 
				agentId,"Failed:Edit Search Page Agent Id Varied!");
	}

	@Test(priority=4)
	public void agentFirstName_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentFirstName(driver)), 
				agentFirstName,"Failed:Edit Search Page Agent First Name Varied!");		
	}

	@Test(priority=5)
	public void agentLastName_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentLastName(driver)), 
				agentLastName,"Failed:Edit Search Page Agent Last Name Varied!");		
	}

	@Test(priority=6)
	public void agentPrimaryPhoneNumber_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputBad_DisconnectedNumber(driver)), 
				agentPrimaryPhoneNumber,"Failed:Edit Search Page agentPrimaryPhoneNumber Varied!");		
	}

	@Test(priority=6)
	public void agentSecondaryPhoneNumber_View__Test()
	{		
		if(agentSecondaryPhoneNumber.length()>0){
			Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputBad_DisconnectedNumber1(driver)), 
					agentSecondaryPhoneNumber,"Failed:Edit Search Page agentSecondaryPhoneNumber Varied!");	
		}
		else {
			try {
				Assert.assertTrue(!PHDSearch_TaskDetails_Page.inputBad_DisconnectedNumber1(driver).isDisplayed(),"Secondary Phone Number Element displayed!");
			}
			catch(NoSuchElementException e) {
				Assert.assertTrue(true);
			}

		}
	}

	@Test(priority=7)
	public void agencyName_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgencyName(driver)), 
				agencyName,"Failed:Edit Search Page AgencyName Varied!");		
	}

	@Test(priority=7)
	public void market_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputMarket(driver)), 
				market,"Failed:Edit Search Page Market Varied!");		
	}

	@Test(priority=8)
	public void agentManagerEmail_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentManagerEmail(driver)), 
				agentManagerEmail,"Failed:Edit Search Page agentManagerEmail Varied!");		
	}

	@Test(priority=9)
	public void agentManagerFirstName_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentManagerFirstName(driver)), 
				agentManagerFirstName,"Failed:Edit Search Page agentManagerFirstName Varied!");		
	}

	@Test(priority=10)
	public void agentManagerLastName_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentManagerLastName(driver)), 
				agentManagerLastName,"Failed:Edit Search Page agentManagerLastName Varied!");		
	}

	@Test(priority=11)
	public void agentManagerPhoneNumber_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentManagerPhoneNumber(driver)), 
				agentManagerPhoneNumber,"Failed:Edit Search Page agentManagerPhoneNumber Varied!");		
	}

	@Test(priority=12)
	public void agentState_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentState(driver)), 
				agentState,"Failed:Edit Search Page agentstate Varied!");		
	}

	@Test(priority=13)
	public void language_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputLanguage(driver)), 
				language,"Failed:Edit Search Page language Varied!");		
	}

	@Test(priority=14)
	public void ssrAssigned_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputSSRAssigned(driver)), 
				ssrAssigned,"Failed:Edit Search Page ssrAssigned Varied!");		
	}

	@Test(priority=15)
	public void ssrSupervisor_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputSSRSupervisor(driver)), 
				ssrSupervisor,"Failed:Edit Search Page ssrSupervisor Varied!");		
	}

	@Test(priority=16)
	public void other_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputOther(driver)), 
				other,"Failed:Edit Search Page other Varied!");		
	}

	@Test(priority=17)
	public void taskHistory_JobName_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getText(PHDSearch_TaskDetails_Page.table_taskHistory_JobName(driver)), 
				jobName,"Failed:View TaskHistory Page jobName Varied!");		
	}

	@Test(priority=18)
	public void taskHistory_Disposition_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getText(PHDSearch_TaskDetails_Page.table_taskHistory_Disposition(driver)), 
				finalDisposition,"Failed:View TaskHistory Page finalDisposition Varied!");		
	}

	@Test(priority=19)
	public void taskHistory_AttemptDate_View__Test()
	{
		String actualFinalAttemptDate = PHDSearch_TaskDetails_Page.getText(PHDSearch_TaskDetails_Page.table_taskHistory_AttemptDate(driver));
		Assert.assertEquals(PHD_Helper.changeDateFormat(actualFinalAttemptDate.substring(0,actualFinalAttemptDate.indexOf(' '))), 
				finalAttemptDate.substring(0,finalAttemptDate.indexOf(' ')),"Failed:View TaskHistory Page finalAttemptDate Varied!");		
	}

	@Test(priority=20)
	public void taskHistory_AttemptCount_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getText(PHDSearch_TaskDetails_Page.table_taskHistory_AttemptCount(driver)), 
				"1","Failed:View TaskHistory Page AttemptCount Varied!");	
	}

	@Test(priority=21)
	public void taskHistory_User_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getText(PHDSearch_TaskDetails_Page.table_taskHistory_User(driver)), 
				ssrAssigned,"Failed:View TaskHistory Page User Varied!");	
	}

	@Test(priority=22)
	public void taskHistory_User_Notes__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getText(PHDSearch_TaskDetails_Page.table_taskHistory_Notes(driver)), 
				notes,"Failed:View TaskHistory Page Notes Varied!");	
	}

	@Test(priority=23)
	public void taskId_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputTaskID(driver)), 
				taskId,"Failed:Edit Search Page taskId Varied!");		
	}

	@Test(priority=24)
	public void taskType_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputTaskType(driver)), 
				tasktype,"Failed:Edit Search Page tasktype Varied!");		
	}

	@Test(priority=25)
	public void campaignDescription_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputCampaignDescription(driver)), 
				campaignDescription,"Failed:Edit Search Page CampaignDescription Varied!");		
	}

	@Test(priority=26)
	public void jobName_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputJobName(driver)), 
				jobName,"Failed:Edit Search Page jobName Varied!");		
	}

	@Test(priority=27)
	public void createdDate_View__Test()
	{
		Assert.assertEquals(PHD_Helper.changeDateFormat(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputCreatedDate(driver))), 
				createdOn.substring(0,createdOn.indexOf(' ')),"Failed:Edit Search Page createdOn Varied!");		
	}

	@Test(priority=28)
	public void taskStatus_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputTaskStatus(driver)), 
				taskStatus,"Failed:Edit Search Page taskStatus Varied!");		
	}

	@Test(priority=29)
	public void scheduledDate_View__Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputScheduledDate(driver)), 
				scheduledDate,"Failed:Edit Search Page scheduledDate Varied!");		
	}


	@Test(priority=30)
	public void taskLanguage_View__Test()
	{
		boolean splitFlag=false;
		for(int i=0;i<taskLanguage.length();i++){
			if(taskLanguage.charAt(i)==','){
				splitFlag=true;
				break;
			}
		}
		if(!splitFlag){
			Assert.assertEquals(PHDSearch_TaskDetails_Page.getTitleText(PHDSearch_TaskDetails_Page.selectMultipleLanguage(driver)), 
					taskLanguage,"Failed:Edit Search Page tasklanguage Varied!");	
		}
		else {
			String[] splitLanguge = PHDSearch_TaskDetails_Page.getTitleText(PHDSearch_TaskDetails_Page.selectMultipleLanguage(driver)).split(","); 
			List<String> expLanguges = Arrays.asList(taskLanguage.split(",")); 
			for(String s: splitLanguge) {
				Assert.assertTrue(PHDSearch_TaskDetails_Page.chekcontains(expLanguges,s.replaceAll("","").trim()),"Failed:Edit Search Page tasklanguage Varied!::"+s);
			}

		}
	}

	@Test(priority=31)
	public void selectDisposition_View__Test() throws Exception
	{
		try {
			PHDSearch_TaskDetails_Page.selectByVisibleText(PHDSearch_TaskDetails_Page.selectDisposition(driver),"Do Not Call",driver);
			Assert.assertTrue(false,"Failed:Able to select a Disposition in view Mode!");
		}
		catch(Exception e) {
			Assert.assertTrue(!PHDSearch_TaskDetails_Page.selectDisposition(driver).isEnabled());
		}	
	}

	@Test(priority=32)
	public void addNotes_View__Test() throws Exception
	{
		System.out.println(PHDSearch_TaskDetails_Page.inputNotes(driver).isEnabled());
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputNotes(driver)),
				notes,"Failed:Edit Search task details Page Notes Varied!");
	}
}
