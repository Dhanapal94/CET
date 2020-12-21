package com.cet.phd;

import java.util.Hashtable;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.phdpages.PHDSearch_TaskDetails_Page;
import com.cet.pagerepositery.phdpages.PhdSearchPage;
import com.cet.pagerepositery.phdpages.PhdSearchResultPage;
import com.cet.utility.phd.DataProviderPhd;
import com.cet.utility.phd.PHD_Helper;

public class PhdSearchEdit_Test extends Base{

	static boolean initializationFlag=true;

	String agentId,agentFirstName,agentLastName,agentPrimaryPhoneNumber,agentSecondaryPhoneNumber,agencyName,market,agentManagerEmail,agentManagerFirstName,
	agentManagerLastName,agentManagerPhoneNumber,agentState,language,ssrAssigned,ssrSupervisor,other,taskId,tasktype,campaignDescription,
	jobName,createdOn,taskStatus,scheduledDate,taskLanguage,finalDisposition;

	static int initCount=0;

	@BeforeClass
	public void createTest() {
		childTest=true;
		parentTest=extent.createTest("Phd-Search Edit Test");
		team="Phd";
	}

	@Factory(dataProvider="PHDSearchEditData", dataProviderClass=DataProviderPhd.class)
	public PhdSearchEdit_Test(Hashtable<String,String> data) throws Exception {
		try {
			this.agentId=data.get("AgentId");
			this.agentFirstName=data.get("AgentFirstName");
			this.agentLastName=data.get("AgentLastName");
			this.agentPrimaryPhoneNumber=data.get("AgentPrimaryPhoneNumber");
			this.agentSecondaryPhoneNumber=data.get("AgentSecondaryPhoneNumber");
			this.agencyName=data.get("AgencyName");
			this.market=data.get("Market");
			this.agentManagerEmail=data.get("AgentManagerEmail");
			this.agentManagerFirstName=data.get("AgentManagerFirstName");
			this.agentManagerLastName=data.get("AgentManagerLastName");
			this.agentManagerPhoneNumber=data.get("AgentManagerPhoneNumber");
			this.agentState=data.get("AgentState");
			this.language=data.get("Language");
			this.ssrAssigned=data.get("SSRAssigned");
			this.ssrSupervisor=data.get("SSRSupervisor");
			this.other=data.get("Other");
			this.taskId=data.get("TaskId");
			this.tasktype=data.get("TaskType");
			this.campaignDescription=data.get("campaignDescription");
			this.jobName=data.get("JobName");
			this.createdOn=data.get("CreatedOn");
			this.taskStatus=data.get("TaskStatus");
			this.scheduledDate=data.get("ScheduleDate");
			this.taskLanguage=data.get("TaskLanguage");
			this.finalDisposition=data.get("FinalDisposition");		
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
			//setUp();
			//LeftPanel.lnkSearch(driver).click();
			PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
			PhdSearchPage.buttonSearch(driver).click();		
			initializationFlag=false;
			fopenBrowser=false;
		}
	}

	@Test(priority=1)
	public void editButtonEnabled_Test()
	{	
		String expectedHexa=Color.fromString( PhdSearchResultPage.tableEditLink(driver).getCssValue("color")).asHex();
		PhdSearchResultPage.tableEditLink(driver).click();
		Assert.assertEquals( expectedHexa ,"#007bff");			
	}

	@Test(priority=2)
	public void agentId_Edit_Test() throws Exception
	{
		//Thread.sleep(10000);
		for(int i=0;i<=2;i++) // Avoid Exception
		{
			PHDSearch_TaskDetails_Page.launch(driver);
			try
			{
				Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentId(driver)), 
						agentId,"Failed:Edit Search Page Agent Id Varied!");
				break;
			}
			catch(Exception e)
			{
				//System.out.println(e.getMessage());
			}
		}
	}

	@Test(priority=3)
	public void agentFirstName_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentFirstName(driver)), 
				agentFirstName,"Failed:Edit Search Page Agent First Name Varied!");		
	}

	@Test(priority=3)
	public void agentLastName_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentLastName(driver)), 
				agentLastName,"Failed:Edit Search Page Agent Last Name Varied!");		
	}

	@Test(priority=4)
	public void agentPrimaryPhoneNumber_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputBad_DisconnectedNumber(driver)), 
				agentPrimaryPhoneNumber,"Failed:Edit Search Page agentPrimaryPhoneNumber Varied!");		
	}

	@Test(priority=5)
	public void agentSecondaryPhoneNumber_Edit_Test()
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

	@Test(priority=6)
	public void agencyName_Edit_Test()
	{
		if(agencyName.length()>0){
			Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgencyName(driver)), 
					agencyName,"Failed:Edit Search Page AgencyName Varied!");	
		}
		else {
			try {
				Assert.assertTrue(!PHDSearch_TaskDetails_Page.inputAgencyName(driver).isDisplayed(),"Failed:Agent name is displayed!");
			}
			catch(NoSuchElementException e) {
				Assert.assertTrue(true);
			}

		}
	}

	@Test(priority=7)
	public void market_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputMarket(driver)), 
				market,"Failed:Edit Search Page Market Varied!");		
	}

	@Test(priority=8)
	public void agentManagerEmail_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentManagerEmail(driver)), 
				agentManagerEmail,"Failed:Edit Search Page agentManagerEmail Varied!");		
	}

	@Test(priority=9)
	public void agentManagerFirstName_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentManagerFirstName(driver)), 
				agentManagerFirstName,"Failed:Edit Search Page agentManagerFirstName Varied!");		
	}

	@Test(priority=10)
	public void agentManagerLastName_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentManagerLastName(driver)), 
				agentManagerLastName,"Failed:Edit Search Page agentManagerLastName Varied!");		
	}

	@Test(priority=11)
	public void agentManagerPhoneNumber_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentManagerPhoneNumber(driver)), 
				agentManagerPhoneNumber,"Failed:Edit Search Page agentManagerPhoneNumber Varied!");		
	}

	@Test(priority=12)
	public void agentState_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputAgentState(driver)), 
				agentState,"Failed:Edit Search Page agentstate Varied!");		
	}

	@Test(priority=13)
	public void language_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputLanguage(driver)), 
				language,"Failed:Edit Search Page language Varied!");		
	}

	@Test(priority=14)
	public void ssrAssigned_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputSSRAssigned(driver)), 
				ssrAssigned,"Failed:Edit Search Page ssrAssigned Varied!");		
	}

	@Test(priority=15)
	public void ssrSupervisor_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputSSRSupervisor(driver)), 
				ssrSupervisor,"Failed:Edit Search Page ssrSupervisor Varied!");		
	}

	@Test(priority=16)
	public void other_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputOther(driver)), 
				other,"Failed:Edit Search Page other Varied!");		
	}

	@Test(priority=17)
	public void taskId_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputTaskID(driver)), 
				taskId,"Failed:Edit Search Page taskId Varied!");		
	}

	@Test(priority=18)
	public void taskType_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputTaskType(driver)), 
				tasktype,"Failed:Edit Search Page tasktype Varied!");		
	}

	@Test(priority=19)
	public void campaignDescription_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputCampaignDescription(driver)), 
				campaignDescription,"Failed:Edit Search Page CampaignDescription Varied!");		
	}

	@Test(priority=20)
	public void jobName_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputJobName(driver)), 
				jobName,"Failed:Edit Search Page jobName Varied!");		
	}

	@Test(priority=21)
	public void createdDate_Edit_Test()
	{
		Assert.assertEquals(PHD_Helper.changeDateFormat(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputCreatedDate(driver))), 
				createdOn.substring(0,createdOn.indexOf(' ')),"Failed:Edit Search Page createdOn Varied!");		
	}

	@Test(priority=22)
	public void taskStatus_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputTaskStatus(driver)), 
				taskStatus,"Failed:Edit Search Page taskStatus Varied!");		
	}

	@Test(priority=23)
	public void scheduledDate_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getInputBoxValue(PHDSearch_TaskDetails_Page.inputScheduledDate(driver)), 
				scheduledDate,"Failed:Edit Search Page scheduledDate Varied!");		
	}


	@Test(priority=24)
	public void taskLanguage_Edit_Test()
	{
		Assert.assertEquals(PHDSearch_TaskDetails_Page.getTitleText(PHDSearch_TaskDetails_Page.selectMultipleLanguage(driver)), 
				taskLanguage,"Failed:Edit Search Page tasklanguage Varied!");		
	}

	@Test(priority=25)
	public void selectDisposition_Edit_Test() throws Exception
	{
		PHDSearch_TaskDetails_Page.selectByVisibleText(PHDSearch_TaskDetails_Page.selectDisposition(driver),"Do Not Call",driver);			
	}

	@Test(priority=26)
	public void addNotes_Edit_Test() throws Exception
	{
		PHDSearch_TaskDetails_Page.inputNotes(driver).sendKeys("Test Notes");
		Assert.assertTrue(PHDSearch_TaskDetails_Page.inputNotes(driver).isEnabled());
	}

	@Test(priority=26,enabled=false)
	public void saveAndClose_Edit_Test() throws Exception
	{
		PHDSearch_TaskDetails_Page.buttonSaveClose(driver).click();
		Assert.assertEquals(PHDSearch_TaskDetails_Page.alertText(driver), "Task details are saved successfully.",
				"Edit and close is not success!");
	}

}
