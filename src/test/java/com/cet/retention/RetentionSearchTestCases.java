package com.cet.retention;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.retentionpages.SearchRetentionPage;
import com.cet.utility.retention.RetentionDBData;


public class RetentionSearchTestCases extends Base {
	static String sMBI,sTaskType,sCampaignFocus,sTaskStatus,sJobName,sDialingMethod,sMemberFirstName,sMemberLastName,
	sPhoneNumber,sAgentName,staskid,sState, sCreatedDate,sFinalDisposition,sFinalAttemptDate;
	
	private static boolean initFlag=true;



	@BeforeClass
	public static void getinit() throws Exception {
		HashMap<String, String> searchData = RetentionDBData.getSearchData(1);
		sMBI=searchData.get("MBINum");
		sTaskType=searchData.get("TaskType");
		sCampaignFocus=searchData.get("campaignfocus");
		sTaskStatus=searchData.get("taskstatus");
		sJobName= searchData.get("JobName");
		sDialingMethod= searchData.get("DialingMethod");
		sMemberFirstName= searchData.get("FirstName");
		sMemberLastName=searchData.get("LastName");
		sPhoneNumber=searchData.get("PrimaryPhone");
		sAgentName=searchData.get("AgentName");
		staskid=searchData.get("taskid");
		sState=searchData.get("State");
		sCreatedDate=searchData.get("CreatedDate");
		sFinalDisposition=searchData.get("FinalDisposition");
		sFinalAttemptDate=searchData.get("FinalAttemptDate");
		childTest=true;
		parentTest=extent.createTest("Retention Search Test");
		team="Retention";
	}

	@BeforeMethod
	public static void getInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			setUp();
			Assert.assertTrue(SearchRetentionPage.launch(driver));
			initFlag=false;
			fopenBrowser = false; // Enable to true when want to run indivaidually
		}	
	}


	@Test(priority=1)
	public static void searchByMBI() {
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colMBI(driver), driver), sMBI);
		verifyassert(softAssert);
	}

	@Test(priority=2)
	public static void searchByCampaignFocus() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.selectText(SearchRetentionPage.selectCampaignFocus(driver), sCampaignFocus, driver);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colCampaignFocus(driver), driver), sCampaignFocus);
		verifyassert(softAssert);
	}

	@Test(priority=3)
	public static void searchByTaskStatus() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.selectText(SearchRetentionPage.selectTaskStatus(driver), sTaskStatus, driver);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colTaskStatus(driver), driver), sTaskStatus);
		verifyassert(softAssert);
	}
	@Test(priority=4)
	public static void searchByJobName() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.inputJobName(driver).sendKeys(sJobName);	
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colJobName(driver), driver), sJobName);
		verifyassert(softAssert);
	}
	@Test(priority=4)
	public static void searchByMemberFirstName() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.inputMemberFirstName(driver).sendKeys(sMemberFirstName);	
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colMemberFirstName(driver), driver), sMemberFirstName);
		verifyassert(softAssert);
	}
	@Test(priority=6)
	public static void searchByMemberLastName() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.inputMemberLastName(driver).sendKeys(sMemberLastName);	
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colMemberLastName(driver), driver), sMemberLastName);
		verifyassert(softAssert);
	}
	@Test(priority=7)
	public static void searchByPhoneNumber() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.inputPhoneNumber(driver).sendKeys(sPhoneNumber);	
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colMBI(driver), driver), sMBI);
		verifyassert(softAssert);
	}
	@Test(priority=8)
	public static void searchByDateFrom() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.sendDate(sCreatedDate, driver, SearchRetentionPage.inputCreatedDateFrom(driver));
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colCreatedDate(driver), driver), SearchRetentionPage.getDate(sCreatedDate));
		verifyassert(softAssert);
	}
	@Test(priority=9)
	public static void searchByDateTo() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.sendDate(sCreatedDate, driver, SearchRetentionPage.inputCreatedDateTo(driver));
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colCreatedDate(driver), driver), SearchRetentionPage.getDate(sCreatedDate));
		verifyassert(softAssert);
	}
	@Test(priority=10)
	public static void searchByAgentName() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.setInputvalue(sAgentName, driver, SearchRetentionPage.inputAgentName(driver));
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colMBI(driver), driver), sMBI);
		verifyassert(softAssert);
	}
	@Test(priority=11)
	public static void searchByAllfield() throws Exception {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.selectText(SearchRetentionPage.selectCampaignFocus(driver), sCampaignFocus, driver);
		SearchRetentionPage.selectText(SearchRetentionPage.selectTaskStatus(driver), sTaskStatus, driver);
		SearchRetentionPage.inputJobName(driver).sendKeys(sJobName);	
		SearchRetentionPage.inputMemberFirstName(driver).sendKeys(sMemberFirstName);	
		SearchRetentionPage.inputMemberLastName(driver).sendKeys(sMemberLastName);	
		SearchRetentionPage.inputPhoneNumber(driver).sendKeys(sPhoneNumber);	
		SearchRetentionPage.sendDate(sCreatedDate, driver, SearchRetentionPage.inputCreatedDateFrom(driver));
		SearchRetentionPage.sendDate(sCreatedDate, driver, SearchRetentionPage.inputCreatedDateTo(driver));
		SearchRetentionPage.setInputvalue(sAgentName, driver, SearchRetentionPage.inputAgentName(driver));
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.tableRow(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colMBI(driver), driver), sMBI);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colTaskId(driver), driver), staskid);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colMemberFirstName(driver), driver), sMemberFirstName);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colMemberLastName(driver), driver), sMemberLastName);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colState(driver), driver), sState);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colTaskType(driver), driver), sTaskType);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colCampaignFocus(driver), driver), sCampaignFocus);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colJobName(driver), driver), sJobName);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colCreatedDate(driver), driver), SearchRetentionPage.getDate(sCreatedDate));
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colTaskStatus(driver), driver), sTaskStatus);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colDialingMethod(driver), driver), sDialingMethod);
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colFinalDisposition(driver), driver), sFinalDisposition);
		verifyassert(softAssert);
	}

	@Test(priority=12)
	public static void invalidSearch() {
		SearchRetentionPage.btnReset(driver).click();
		SearchRetentionPage.inputMBI(driver).sendKeys("11111");
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		softAssert.assertTrue(SearchRetentionPage.txtNoDataFound(driver).isEnabled());
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.txtNoDataFound(driver), driver), "No results found for the search criteria");
		verifyassert(softAssert);
	}

	@Test(priority=0)
	public static void searchPageDefaultValue() {
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelMBI(driver), driver),"#MBI");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelTaskType(driver), driver),"Task Type");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelCampaignFocus(driver), driver),"Campaign Focus");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelTaskStatus(driver), driver),"Task Status");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelJobName(driver), driver),"Job Name");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelDialingMethod(driver), driver),"Dialing Method");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelMemberFName(driver), driver),"Member First Name");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelMemberLName(driver), driver),"Member Last Name");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelPhoneNumber(driver), driver),"Phone Number");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelCreatedDateFrom(driver), driver),"Created Date From");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelCreatedDateTo(driver), driver),"Created Date To");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.labelAgentName(driver), driver),"Agent Name");
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
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerMBI(driver), driver), "#MBI");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerFirstName(driver), driver), "Member First Name");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerLastName(driver), driver), "Member Last Name");
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.headerMState(driver), driver), "Member State");
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
	
}
