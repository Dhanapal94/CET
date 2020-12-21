package com.cet.retention;

import java.text.ParseException;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.HomePage;
import com.cet.pagerepositery.component.LeftPanel;
import com.cet.pagerepositery.retentionpages.SearchRetentionPage;
import com.cet.pagerepositery.retentionpages.SearchTaskDetails;
import com.cet.utility.retention.RetentionDBData;


public class RetentionSearchEditTestCases extends Base {

	static String sMBI,sCurrentPlan,sPreviousPlan,sAgentofRecord,sApplicationDate,sFirstName,sLastName,sMemberDOB,
	sAge,sGender,sAddress,sCity, sState,sCode,sCounty,sPhone,sLanguage,sRetentionName,sRetentionSupervisor,sTaskID,sTaskType,sCDescription,sJobName,scDate
	,sTaskStatus,sSheduleDate,sDespostion,sCampaignFocus,sTimeZone,sNote;

	private static boolean initFlag=true;


	@BeforeClass
	public static void getinit() throws Exception {
		HashMap<String, String> searchData = RetentionDBData.getSearchEditData();
		sMBI= searchData.get("MBINum");
		sCurrentPlan= searchData.get("CurrentPlan");
		sPreviousPlan= searchData.get("PreviousPlan");
		sAgentofRecord= searchData.get("AgentOfRecord");
		sApplicationDate= searchData.get("ApplicationDate");
		sFirstName= searchData.get("FirstName");
		sLastName= searchData.get("LastName");
		sMemberDOB= searchData.get("MemberDateOfBirth");
		sAge= searchData.get("Age");
		sGender= searchData.get("Gender");
		sCity= searchData.get("City");
		sCounty=searchData.get("County");
		sState= searchData.get("State");
		sCode= searchData.get("ZipCode");
		sPhone= searchData.get("PrimaryPhone");
		sLanguage= searchData.get("Language");
		sRetentionName= searchData.get("AgentAssigned");
		sRetentionSupervisor= searchData.get("AgentSupervisor");
		sTaskID= searchData.get("TaskId");
		sTaskType= searchData.get("TaskType");
		sCDescription= searchData.get("CampaignDescription");
		sCampaignFocus= searchData.get("CampaignFocus");
		sJobName= searchData.get("Jobname");
		scDate= searchData.get("CreatedDate");
		sSheduleDate= searchData.get("Scheduledate");
		sAddress= searchData.get("Address");
		sTimeZone= searchData.get("TimeZone");
		sNote= searchData.get("notes");
		childTest=true;
		parentTest=extent.createTest("Retention-Search Edit Test");
		team="Retention";
	}

	@BeforeMethod
	public static void getInit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			//setUp();
			Assert.assertTrue(SearchTaskDetails.editLaunch(driver,sMBI));
			initFlag=false;
			fopenBrowser = false; // Enable to true as well as setup when want to run individually
		}
	}

	@Test(priority=1)
	public static void defaultValues() throws ParseException {
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.txtApplicationDetails(driver),driver), "Application Details");
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelMBI(driver),driver), "MBI #");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputMBI(driver)), sMBI);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelCurrentPlan(driver),driver), "Current Plan");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputCurrentPlan(driver)), sCurrentPlan);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelPreviousPlan(driver),driver), "Previous Plan");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputPreviousPlan(driver)), sPreviousPlan);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelAgentofRecord(driver),driver), "Agent of Record");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputAgentofRecord(driver)), sAgentofRecord);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelApplicationDate(driver),driver), "Application Date");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputApplicationDate(driver)), SearchTaskDetails.getDate(sApplicationDate));
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelFirstName(driver),driver), "First Name");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputFirstName(driver)), sFirstName);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelLastName(driver),driver), "Last Name");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputLastName(driver)), sLastName);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelMemberDOB(driver),driver), "Member Date of Birth");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputMemberDOB(driver)), SearchTaskDetails.getDate(sMemberDOB));
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelAge(driver),driver), "Age");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputAge(driver)), sAge);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelGender(driver),driver), "Primary Member's Gender");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputGender(driver)), sGender);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelAddress(driver),driver), "Address");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputAddress(driver)), sAddress);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelCity(driver),driver), "City");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputCity(driver)), sCity);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelState(driver),driver), "State");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputState(driver)), sState);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelCode(driver),driver), "Zip Code");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputCode(driver)), sCode);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelCounty(driver),driver), "County");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputCounty(driver)), sCounty);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelLanguage(driver),driver), "Language");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputLanguage(driver)), sLanguage);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelRetentionName(driver),driver), "Retention Specialist's Name");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputRetentionName(driver)), sRetentionName);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelRetentionSupervisor(driver),driver), "Retention Specialist's Supervisor");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputRetentionSupervisor(driver)), sRetentionSupervisor);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelTaskID(driver),driver), "Task ID");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputTaskID(driver)), sTaskID);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelTaskType(driver),driver), "Task Type");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputTaskType(driver)), sTaskType);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelCampaignDescription(driver),driver), "Campaign Description");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputCampaignDescription(driver)), sCDescription);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelJobname(driver),driver), "Job name");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputJobname(driver)), sJobName);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelCreatedDate(driver),driver), "Created Date (UTC)");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputCreatedDate(driver)), SearchTaskDetails.getDate(scDate));
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelTaskStatus(driver),driver), "Task Status");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputTaskStatus(driver)),"Open");
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelScheduleDate(driver),driver), "Scheduled Date");
		softAssert.assertEquals(SearchTaskDetails.getInputBoxValue(SearchTaskDetails.inputScheduleDate(driver)),sSheduleDate);
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelDisposition(driver),driver), "Disposition");
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.labelNotes(driver),driver), "Notes");
		softAssert.assertEquals(SearchTaskDetails.getText(SearchTaskDetails.txtApplicationDetails(driver),driver), "Application Details");
		softAssert.assertTrue(SearchTaskDetails.btncampaignScript(driver).isEnabled());
		softAssert.assertTrue(SearchTaskDetails.btnClose(driver).isEnabled());
		softAssert.assertTrue(SearchTaskDetails.btnSave(driver).isEnabled());
		softAssert.assertTrue(SearchTaskDetails.btnSavenClose(driver).isEnabled());
		verifyassert(softAssert);
	}
	@Test(priority=2)
	public static void verifyFieldStatus() {
		softAssert.assertFalse(SearchTaskDetails.inputMBI(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputCurrentPlan(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputPreviousPlan(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputAgentofRecord(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputApplicationDate(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputFirstName(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputLastName(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputMemberDOB(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputAge(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputGender(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputAddress(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputCity(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputState(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputCode(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputCounty(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputLanguage(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputRetentionName(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputRetentionSupervisor(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputTaskID(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputTaskType(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputCampaignDescription(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputJobname(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputCreatedDate(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputTaskStatus(driver).isEnabled());
		softAssert.assertFalse(SearchTaskDetails.inputScheduleDate(driver).isEnabled());
		softAssert.assertTrue(SearchTaskDetails.txtAreaNotes(driver).isEnabled());
		softAssert.assertTrue(SearchTaskDetails.btncampaignScript(driver).isEnabled());
		softAssert.assertTrue(SearchTaskDetails.btnClose(driver).isEnabled());
		softAssert.assertTrue(SearchTaskDetails.btnSave(driver).isEnabled());
		softAssert.assertTrue(SearchTaskDetails.btnSavenClose(driver).isEnabled());
		verifyassert(softAssert);
	}

	@Test(priority=3)
	public static void selectDispostion() throws Exception {
		SearchTaskDetails.selectTextByIndex(driver, SearchTaskDetails.selectDisposition(driver), 1);
		String selectedtext = SearchTaskDetails.getSelectedtext(driver, SearchTaskDetails.selectDisposition(driver));
		SearchTaskDetails.jsClick(SearchTaskDetails.btnSavenClose(driver), driver);
		SearchTaskDetails.waitForPageLoad(driver);
		if (SearchTaskDetails.wiatForPopUp(driver)) {
			Alert alert = driver.switchTo().alert();
			softAssert.assertTrue(alert.getText().contains("Task details are saved successfully."),
					"Failed : Edit User reset msg mismatch.");
			alert.accept();
		}
		softAssert.assertEquals(HomePage.labelHomePage(driver).getText(), HomePage.expTitle(),
				"Failed : Text for 'Home Page' is mismatch");
		LeftPanel.lnkSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		SearchRetentionPage.inputMBI(driver).sendKeys(sMBI);
		SearchRetentionPage.btnSearch(driver).click();
		SearchRetentionPage.waitForPageLoad(driver);
		System.out.println("SearchRetentionPage.lnkEdit(driver).isEnabled()"+SearchRetentionPage.lnkEdit(driver).isEnabled());
		softAssert.assertTrue(SearchRetentionPage.lnkEdit(driver).getAttribute("class").equals("disabled"));
		softAssert.assertEquals(SearchRetentionPage.getText(SearchRetentionPage.colFinalDisposition(driver), driver), selectedtext);
		verifyassert(softAssert);
	}
}
