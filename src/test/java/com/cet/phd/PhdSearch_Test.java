package com.cet.phd;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.cet.intit.Base;
import com.cet.pagerepositery.phdpages.PhdSearchPage;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.manager.PageObject;
import com.cet.utility.phd.DataProviderPhd;
import com.cet.utility.phd.PHD_Helper;

public class PhdSearch_Test extends Base{

	static boolean initializationFlag=true;
	String agentId,tasktype,campaignFocus,taskStatus,jobName,dialingMethod,agentFirstName,agentLastName,phoneNumber,
	createdDateFrom,createdDateTo,agentName,taskId,agentState,finalDisposition,finalAttemptDate;

	static int initCount=0;
	
	@BeforeClass
	public void createTest() {
		childTest=true;
		parentTest=extent.createTest("Phd-Search Test");
		team="Phd";
	}
	
	@Factory(dataProvider="PHDSearchData", dataProviderClass=DataProviderPhd.class)
	public PhdSearch_Test(Hashtable<String,String> data) throws Exception {
		try {
			this.agentId=data.get("AgentId");
			this.tasktype=data.get("TaskType");
			this.campaignFocus=data.get("Campaignfocus");
			this.taskStatus=data.get("Taskstatus");
			this.jobName=data.get("JobName");
			this.dialingMethod=data.get("DialingMethod");
			this.agentFirstName=data.get("AgentFirstName");
			this.agentLastName=data.get("AgentLastName");
			this.phoneNumber=data.get("AgentPrimaryPhoneNumber");
			this.createdDateFrom=data.get("CreatedDate");
			this.agentName=data.get("AgentName");
			this.taskId=data.get("Taskid");
			this.agentState=data.get("Agentstate");
			this.finalDisposition=data.get("FinalDisposition");
			this.finalAttemptDate=data.get("FinalAttemptDate");		
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
			LeftPanel.lnkSearch(driver).click();
			PhdSearchPage.launch(driver);
			initializationFlag=false;
			fopenBrowser=false;
		}
	}
	
	@AfterMethod
	public void resetPHD_Search()
	{
		PhdSearchPage.buttonReset(driver).click();
	}
	
	@Test(priority=1)
	public void agentIdSearch_PHD_Test() {
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName, createdDateFrom.substring(0,createdDateFrom.indexOf(' ')), 
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");		
	}
	
	@Test(priority=2)
	public void campaignFocusSearch_PHD_Test() throws Exception{
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PageObject.selectText(PhdSearchPage.dropDownCampaignFocus(driver), campaignFocus, driver);
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName,createdDateFrom.substring(0,createdDateFrom.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");
	}
	
	@Test(priority=3)
	public void taskStatusSearch_PHD_Test() throws Exception{
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PageObject.selectText(PhdSearchPage.dropDownTaskStatus(driver), taskStatus, driver);
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName,createdDateFrom.substring(0,createdDateFrom.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");
	}
	
	@Test(priority=4)
	public void jobNameSearch_PHD_Test() throws Exception{
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PhdSearchPage.inputJobName(driver).sendKeys(jobName);
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName,createdDateFrom.substring(0,createdDateFrom.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");
	}
	
	@Test(priority=5)
	public void agentFirstNameSearch_PHD_Test() throws Exception{
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PhdSearchPage.inputAgentFirstName(driver).sendKeys(agentFirstName);
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName,createdDateFrom.substring(0,createdDateFrom.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");
	}
	
	@Test(priority=6)
	public void agentLastNameSearch_PHD_Test() throws Exception{
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PhdSearchPage.inputAgentLastName(driver).sendKeys(agentLastName);
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName,createdDateFrom.substring(0,createdDateFrom.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");
	}
	
	@Test(priority=7)
	public void phoneNumberSearch_PHD_Test() throws Exception{
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PhdSearchPage.inputPhoneNumber(driver).sendKeys(phoneNumber);
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName,createdDateFrom.substring(0,createdDateFrom.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");
	}
	
	@Test(priority=8)
	public void agentNameSearch_PHD_Test() throws Exception{
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PhdSearchPage.inputAgentName(driver).sendKeys(agentName);
		PhdSearchPage.inputAgentNameAutoComplete(driver,agentName).click();
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName,createdDateFrom.substring(0,createdDateFrom.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");
	}
	
	@Test(priority=9)
	public void fullSearch_PHD_Test() throws Exception{
		PhdSearchPage.inputAgentId(driver).sendKeys(agentId);
		PageObject.selectText(PhdSearchPage.dropDownCampaignFocus(driver), campaignFocus, driver);
		PageObject.selectText(PhdSearchPage.dropDownTaskStatus(driver), taskStatus, driver);
		PhdSearchPage.inputJobName(driver).sendKeys(jobName);
		PhdSearchPage.inputAgentFirstName(driver).sendKeys(agentFirstName);
		PhdSearchPage.inputAgentLastName(driver).sendKeys(agentLastName);
		PhdSearchPage.inputPhoneNumber(driver).sendKeys(phoneNumber);
		PhdSearchPage.inputAgentName(driver).sendKeys(agentName);
		PhdSearchPage.inputAgentNameAutoComplete(driver,agentName).click();
		PhdSearchPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation(driver, taskId, agentId, agentFirstName, agentLastName, agentState, tasktype, campaignFocus, jobName,createdDateFrom.substring(0,createdDateFrom.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), "Failed:Search Result Varied!");
	}
	
	@Test(priority=10)
	public void tastTypeSearch_PHD_DefaultTest() {
		Assert.assertEquals(PageObject.getSelectedtext(driver, PhdSearchPage.dropDownTaskType(driver)), 
				tasktype,"Failed-Default Task Type value is Varied!");
	}
	
	@Test(priority=11)
	public void dialingMethodSearch_PHD_DefaultTest() {
		Assert.assertEquals(PageObject.getSelectedtext(driver, PhdSearchPage.dropDownDialingMethod(driver)), 
				dialingMethod,"Failed-Default Dialing Method value is Varied!");
	}

}
