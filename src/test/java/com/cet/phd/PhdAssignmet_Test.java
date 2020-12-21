package com.cet.phd;

import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.phdpages.PHDSearch_TaskDetails_Page;
import com.cet.pagerepositery.phdpages.PhdAssignmentPage;
import com.cet.pagerepositery.phdpages.PhdAssignmentResultPage;
import com.cet.pagerepositery.phdpages.PhdSearchPage;
import com.cet.utility.DBConnection;
import com.cet.utility.phd.PHDDBData;
import com.cet.utility.phd.PHD_Helper;

public class PhdAssignmet_Test extends Base  {
	static boolean initializationFlag = true;
	static String  taskId,taskType,campaignFocus,taskStatus,jobName,createdDate,dialingMethod,
	agentName,finalDisposition,finalAttemptDate;

	@BeforeClass
	public static void getinit() throws Exception {
		HashMap<String, String> searchData = PHDDBData.getAssignmentData();
		taskId=searchData.get("TaskId");
		taskType=searchData.get("TaskType");
		campaignFocus=searchData.get("CampaignFocus");
		taskStatus=searchData.get("TaskStatus");
		jobName= searchData.get("JobName");
		createdDate=searchData.get("CreatedDate");
		dialingMethod=searchData.get("DialingMethod");
		agentName=searchData.get("AgentName");
		finalDisposition=searchData.get("FinalDisposition");
		finalAttemptDate=searchData.get("FinalAttemptDate");	
		childTest=true;
		parentTest=extent.createTest("Phd-Assignment Test");
		team="Phd";
	}

	@BeforeMethod
	public static void getInit() throws Exception {
		softAssert=new SoftAssert();
		if (initializationFlag) {
			setUp();
			Assert.assertTrue(PhdAssignmentPage.launch(driver));
			fopenBrowser = true;
			initializationFlag=false;
		}
		
	}

	@Test(priority=1)
	public void taskIDSearch_Assignment_PHD_Test() {
		PhdAssignmentPage.inputTaskId(driver).sendKeys(taskId);
		PhdAssignmentPage.inputAgentName(driver).sendKeys(agentName+Keys.ENTER);
		PhdAssignmentPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation__Assignement_Phd(driver, taskId, taskType, campaignFocus, jobName, createdDate.substring(0,createdDate.indexOf(' ')),
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), 
				"Failed:Search Result Varied!");		
	}

	@Test(priority=2)
	public void actionButtonEnabled_Assignment_PHD_Test() {
		Assert.assertTrue(PhdAssignmentResultPage.tableInputAction(driver).isEnabled(),"Action Input is not Enabled!");
	}

	@Test(priority=3)
	public void actionButtonDefaultNotSelected_Assignment_PHD_Test() {
		Assert.assertTrue(!PhdAssignmentResultPage.tableInputAction(driver).isSelected(),"Action Input is default selected!");
	}

	@Test(priority=4)
	public void campaignFocusSearch_Assignment_PHD_Test() throws Exception{
		PhdAssignmentPage.buttonReset(driver).click();
		PhdAssignmentPage.inputTaskId(driver).sendKeys(taskId);
		PhdAssignmentPage.selectText(PhdSearchPage.dropDownCampaignFocus(driver), campaignFocus, driver);
		PhdAssignmentPage.inputAgentName(driver).sendKeys(agentName+Keys.ENTER);
		PhdAssignmentPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation__Assignement_Phd(driver, taskId, taskType, campaignFocus, jobName, createdDate.substring(0,createdDate.indexOf(' ')), 
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), 
				"Failed:Search Result Varied!");	
	}

	@Test(priority=5)
	public void taskStatusSearch_Assignment_PHD_Test() throws Exception{
		PhdAssignmentPage.buttonReset(driver).click();
		PhdAssignmentPage.inputTaskId(driver).sendKeys(taskId);
		PhdAssignmentPage.selectText(PhdSearchPage.dropDownTaskStatus(driver), taskStatus, driver);
		PhdAssignmentPage.inputAgentName(driver).sendKeys(agentName+Keys.ENTER);
		PhdAssignmentPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation__Assignement_Phd(driver, taskId, taskType, campaignFocus, jobName, createdDate.substring(0,createdDate.indexOf(' ')), 
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), 
				"Failed:Search Result Varied!");	
	}

	@Test(priority=6)
	public void jobNameSearch_Assignment_PHD_Test() throws Exception{
		PhdAssignmentPage.buttonReset(driver).click();
		PhdAssignmentPage.inputTaskId(driver).sendKeys(taskId);
		PhdAssignmentPage.inputJobName(driver).sendKeys(jobName);
		PhdAssignmentPage.inputAgentName(driver).sendKeys(agentName+Keys.ENTER);
		PhdAssignmentPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation__Assignement_Phd(driver, taskId, taskType, campaignFocus, jobName, createdDate.substring(0,createdDate.indexOf(' ')), 
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), 
				"Failed:Search Result Varied!");	
	}

	@Test(priority=7)
	public void fullSearch_Assignment_PHD_Test() throws Exception{
		PhdAssignmentPage.buttonReset(driver).click();
		PhdAssignmentPage.inputTaskId(driver).sendKeys(taskId);
		PhdAssignmentPage.selectText(PhdSearchPage.dropDownCampaignFocus(driver), campaignFocus, driver);
		PhdAssignmentPage.selectText(PhdSearchPage.dropDownTaskStatus(driver), taskStatus, driver);
		PhdAssignmentPage.inputJobName(driver).sendKeys(jobName);
		PhdAssignmentPage.inputAgentName(driver).sendKeys(agentName+Keys.ENTER);
		PhdAssignmentPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation__Assignement_Phd(driver, taskId, taskType, campaignFocus, jobName, createdDate.substring(0,createdDate.indexOf(' ')), 
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, agentName), 
				"Failed:Search Result Varied!");	
	}
	
	@Test(priority=8)
	public void assignButtonEnabled_Assignment_PHD_Test() throws Exception{
		PhdAssignmentResultPage.tableInputAction(driver).click();
		Assert.assertTrue(PhdAssignmentResultPage.buttonAssign(driver).isEnabled(),"Assign Button is not Enabled!");	
	}
	
	@Test(priority=9)
	public void loggedInUser_Assignment_PHD_Test() throws Exception{
		DBConnection.setAssignmentName();
		PhdAssignmentResultPage.buttonAssign(driver).click();
		PhdAssignmentResultPage.selectByVisibleText(PhdAssignmentResultPage.dropDownAssignUserList(driver), DBConnection.assignName, driver);
	}
	
	@Test(priority=10)
	public void alertVerify_Assignment_PHD_Test() throws Exception{
		PhdAssignmentResultPage.buttonAssignUserList(driver).click();
		Assert.assertEquals(PHDSearch_TaskDetails_Page.alertText(driver), "Task assigned successfully",
				"Assignement is not success!");	
	}
	
	@Test(priority=11)
	public void db_Assignmet_PHD_Test() throws Exception{
		PhdAssignmentPage.launch(driver);
		PhdAssignmentPage.inputTaskId(driver).sendKeys(taskId);
		PhdAssignmentPage.inputAgentName(driver).sendKeys(DBConnection.assignName+Keys.ENTER);
		PhdAssignmentPage.buttonSearch(driver).click();
		Assert.assertTrue(PHD_Helper.searchResultValidation__Assignement_Phd(driver, taskId, taskType, campaignFocus, jobName, createdDate.substring(0,createdDate.indexOf(' ')), 
				taskStatus, dialingMethod, finalDisposition, finalAttemptDate, DBConnection.assignName), 
				"Failed:Search Result Varied!");	
	}
	
	@Test(priority=12)
	public void invalidSearch_Assignment_PHD_Test() throws Exception{
		PhdAssignmentPage.buttonReset(driver).click();
		PhdAssignmentPage.inputTaskId(driver).sendKeys("3435898945804");
		PhdAssignmentPage.inputAgentName(driver).sendKeys(agentName+Keys.ENTER);
		PhdAssignmentPage.buttonSearch(driver).click();
		Assert.assertEquals(PhdAssignmentResultPage.tableNoResults(driver).getText(), "No results found for the search criteria",
				"Invalid Result is differed!");
		
	}
}
