package com.cet.retention;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.retentionpages.SearchRetentionPage;
import com.cet.utility.retention.RetentionDBData;

/****Checking ***/


public class RetentionAssignmentTestCases extends Base {

	private static boolean initFlag=true;

	static String sAgentName,sAgentSupervisor,sTaskID,sCampaignFocus,sTaskStatus,sJobName,sDialingMethod,sCreatedDate;


	@BeforeClass
	public static void getinit() throws Exception {
		HashMap<String, String> searchData = RetentionDBData.getSearchData(1);
		sAgentName=searchData.get("AgentName").replaceAll(",", "");;
		sAgentSupervisor=searchData.get("AgentSupervisor").replaceAll(",", "");;
		sTaskID=searchData.get("taskid");
		sCampaignFocus=searchData.get("campaignfocus");
		sTaskStatus=searchData.get("taskstatus");
		sJobName= searchData.get("JobName");
		sDialingMethod= searchData.get("DialingMethod");
		sCreatedDate=searchData.get("CreatedDate");
		childTest=true;
		parentTest=extent.createTest("Retention-Assignment Test");
		team="Retention";
	}
	@BeforeMethod
	public static void getInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			Assert.assertTrue(SearchRetentionPage.Assignmentlaunch(driver));
			initFlag=false;
			fopenBrowser = true;
		}
	}

	@Test(priority=0)
	public static void retentionPageDefaultValue() {
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelTaskID(driver), driver),"Task ID");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelTaskType(driver), driver),"Task Type");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelCampaignFocus(driver), driver),"Campaign Focus");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelTaskStatus(driver), driver),"Task Status");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelJobName(driver), driver),"Job Name");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelDialingMethod(driver), driver),"Dialing Method");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelCreatedDateFrom(driver), driver),"Created Date From");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelCreatedDateTo(driver), driver),"Created Date To");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelAgentName(driver), driver),"Agent Name");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelSupervisor(driver), driver),"Supervisor");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelManager(driver), driver),"Manager");
		softAssert.assertEquals(SearchRetentionPage.getSelectedtext(driver,SearchRetentionPage.selectSupervisor(driver)),"Select");
		softAssert.assertEquals(SearchRetentionPage.getSelectedtext(driver,SearchRetentionPage.selectManager(driver)),"Select");
		softAssert.assertEquals(SearchRetentionPage.getInputBoxPlaceHolder(SearchRetentionPage.inputCreatedDateFrom(driver)),"MM/DD/YYYY");
		softAssert.assertEquals(SearchRetentionPage.getInputBoxPlaceHolder(SearchRetentionPage.inputCreatedDateTo(driver)),"MM/DD/YYYY");
		softAssert.assertEquals(SearchRetentionPage.getSelectedtext(driver,SearchRetentionPage.selectTaskType(driver)),"Retention");
		softAssert.assertEquals(SearchRetentionPage.getSelectedtext(driver,SearchRetentionPage.selectCampaignFocus(driver)),"Select");
		softAssert.assertEquals(SearchRetentionPage.getSelectedtext(driver,SearchRetentionPage.selectTaskStatus(driver)),"Select");
		softAssert.assertEquals(SearchRetentionPage.getSelectedtext(driver,SearchRetentionPage.selectDialingMethod(driver)),"Manual");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.btnCancel(driver), driver),"Cancel");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.btnReset(driver), driver),"Reset");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.btnSearch(driver), driver),"Search");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerActions(driver), driver), "Action");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerTaskId(driver), driver), "Task ID");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerTasktype(driver), driver), "Task Type");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerCampaignFocus(driver), driver), "Campaign Focus");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerJobName(driver), driver), "Job Name");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerCreatedDate(driver), driver), "Created Date");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerTaskStatus(driver), driver), "Task Status");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerDialingMethod(driver), driver), "Dialing Method");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerFinalDisposition(driver), driver), "Final Disposition");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerFinalAttemptDate(driver), driver), "Final Attempt Date");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerFinalAssignedTo(driver), driver), "Assigned To");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.txtNoDataFound(driver), driver), "No records to display /Change the search criteria");
		verifyassert(softAssert);
	}
	@Test(priority=1)
	public static void searchbyTaskID() {
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
	}

	@Test(priority=2)
	public static void searchByCampaignFocus() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		//SearchRetentionPage.setInputvalue(sAgentName, driver, SearchRetentionPage.inputAgentName(driver));
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.selectText(SearchRetentionPage.selectCampaignFocus(driver), sCampaignFocus, driver);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=3)
	public static void searchByTaskStatus() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.selectText(SearchRetentionPage.selectTaskStatus(driver), sTaskStatus, driver);
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=4)
	public static void searchByJobName() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.inputJobName(driver).sendKeys(sJobName);	
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=5)
	public static void searchByDialingMethod() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.selectText(SearchRetentionPage.selectDialingMethod(driver), sDialingMethod, driver);
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=6)
	public static void searchByDateFrom() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.sendDate(sCreatedDate, driver, SearchRetentionPage.inputCreatedDateFrom(driver));
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=7)
	public static void searchByDateTo() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.sendDate(sCreatedDate, driver, SearchRetentionPage.inputCreatedDateTo(driver));
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=8)
	public static void searchByAgentName() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=9)
	public static void searchBySupervisor() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID+Keys.TAB);
		SearchRetentionPage.selectText(SearchRetentionPage.selectSupervisor(driver), sAgentSupervisor, driver);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=10)
	public static void verifyErrorMsgFromlessthanTo() {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		//SearchRetentionPage.setInputvalue(sAgentName, driver, SearchRetentionPage.inputAgentName(driver));
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName);
		String sDate =SearchRetentionPage.gatDate(0);
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+sDate+"'", SearchRetentionPage.inputCreatedDateFrom(driver));  
		SearchRetentionPage.inputCreatedDateFrom(driver).sendKeys(Keys.ENTER);
		sDate =SearchRetentionPage.gatDate(-2);
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+sDate+"'", SearchRetentionPage.inputCreatedDateTo(driver));  
		SearchRetentionPage.inputCreatedDateTo(driver).sendKeys(Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertEquals(SearchRetentionPage.txtPleaseCorrect(driver),"The Created Date From should be less than the Created Date To");
		verifyassert(softAssert);
	}
	@Test(priority=11)
	public static void verifyRequiredFieldErrorText() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertEquals(SearchRetentionPage.txtPleaseCorrect(driver),"Please select either of the following mandatory fields" + 
				"Agent Name" + 
				"Supervisor" + 
				"Manager");
		verifyassert(softAssert);
	}
	@Test(priority=12)
	public static void assignOneTask() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		SearchRetentionPage.firstrowcheckBox(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.btnAssign(driver).click();
		//	SearchRetentionPage.waitForPageLoad(driver);
		//softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.modelAssignText(driver),driver), "Assign"); 
		SearchRetentionPage.selectTextByIndex(driver,SearchRetentionPage.modelSelectUserList(driver),1);
		String selectedtext = SearchRetentionPage.getSelectedtext(driver,SearchRetentionPage.modelSelectUserList(driver));
		SearchRetentionPage.jsClick(SearchRetentionPage.nodelbtnAssign(driver), driver);
		if (SearchRetentionPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains("Task assigned successfully"),
					"Failed : Assign Message mismatch");
			alert.accept();
		}
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.inputTaskID(driver).sendKeys(sTaskID);
		SearchRetentionPage.inputAgentName(driver).sendKeys(selectedtext+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=13)
	public static void assignMultipleTask() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputAgentName(driver).sendKeys(sAgentName+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		SearchRetentionPage.firstrowcheckBox(driver).click();
		SearchRetentionPage.secondrowcheckBox(driver).click();
		String text1 = SearchRetentionPage.firstRowtaskID(driver).getText();
		String text2 = SearchRetentionPage.secondRowtaskID(driver).getText();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.btnAssign(driver).click();
		//	SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.modelAssignText(driver),driver), "Assign"); 
		SearchRetentionPage.selectTextByIndex(driver,SearchRetentionPage.modelSelectUserList(driver),1);
		String selectedtext = SearchRetentionPage.getSelectedtext(driver,SearchRetentionPage.modelSelectUserList(driver));
		SearchRetentionPage.jsClick(SearchRetentionPage.nodelbtnAssign(driver), driver);
		if (SearchRetentionPage.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains("Task assigned successfully"),
					"Failed : Assign Message mismatch");
			alert.accept();
		}
		SearchRetentionPage.waitforElement(driver,SearchRetentionPage.btnReset(driver));
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputTaskID(driver).sendKeys(text1);
		SearchRetentionPage.inputAgentName(driver).sendKeys(selectedtext+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.inputTaskID(driver).sendKeys(text2);
		SearchRetentionPage.inputAgentName(driver).sendKeys(selectedtext+Keys.ENTER);
		SearchRetentionPage.btnSearch(driver).click();
		softAssert.assertTrue(SearchRetentionPage.retentiontableRow(driver).isEnabled());
		verifyassert(softAssert);
	}

}