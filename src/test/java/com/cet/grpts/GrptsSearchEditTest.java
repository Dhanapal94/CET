package com.cet.grpts;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.utility.grpts.*;
import com.cet.intit.Base;
import com.cet.pagerepositery.HomePage;
import com.cet.pagerepositery.SearchEditPage;


public class GrptsSearchEditTest extends Base{
	
	private static boolean initFlag = true;
	
	@BeforeClass
	public static void getinit() throws Exception {
		childTest=true;
		parentTest=extent.createTest("Grpts-Search Edit Test");
		team="Grpts";
		grptsedit = GetDataFromExcelGRPTS.grptsedit();
	}

	@BeforeMethod
	public static void getIndtsTaskEdit() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			//setUp();
			System.out.println("bconnid is:" + SearchEditPage.launch(driver, grptsedit.get("bConnID")));
			Assert.assertTrue(SearchEditPage.launch(driver, grptsedit.get("bConnID")));
			initFlag=false;
			fopenBrowser = true;
		}
		
	}

	// label page title
	@Test(priority = 1)
	public void verifyTitle() throws Exception {
		softAssert.assertEquals(SearchEditPage.getTitle(driver), WriteExcelGRPTS.getgrptstasklabel("TaskDetailsEditTitle"),
				"Failed : On Task Details Page tab Title is mismatch.");
	}

	// label Top section Label
	@Test(priority = 2)
	public void verifyPageTitle() throws Exception {
		softAssert.assertEquals(SearchEditPage.labelSearchPage(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("TaskDetailsPageTitle"),
				"Failed : On Task Details Page Top section lable is mismatch");
	}

	// label Application details
	@Test(priority = 3)
	public void verifylabelSearch() throws Exception {
		softAssert.assertEquals(SearchEditPage.labelApplicationDetails(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("ApplicationDetails"),
				"Failed : On Task Edit Page Application Details label is mismatch");;
	}

	// Verify Mandatory fields labels
	@Test(priority = 4)
	public void verifyallfieldlabels() throws Exception {
		System.out.println(WriteExcelGRPTS.getgrptstasklabel("bconnId"));
		softAssert.assertEquals(SearchEditPage.labelBconnId(driver).getText(), WriteExcelGRPTS.getgrptstasklabel("bconnId"),
				"Failed : On Task Edit Page bConn ID label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelCurrentPlan(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("CurrentPlan"),
				"Failed : On Task Edit Page Current plan label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelPlantoPromote(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("PlantoPromote"),
				"Failed : On Task Edit Page Plan to Promote label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelFirstName(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("FirstName"), "Failed : On Task Edit Page First Name label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelLastName(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("LastName"), "Failed : On Task Edit Page Last Name label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelCity(driver).getText(), WriteExcelGRPTS.getgrptstasklabel("City"),
				"Failed : On Task Edit Page City label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelState(driver).getText(), WriteExcelGRPTS.getgrptstasklabel("State"),
				"Failed : On Task Edit Page City label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelZipCode(driver).getText(), WriteExcelGRPTS.getgrptstasklabel("ZipCode"),
				"Failed : On Task Edit Page Zip Code label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelCounty(driver).getText(), WriteExcelGRPTS.getgrptstasklabel("County"),
				"Failed : On Task Edit Page County label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelPhone1(driver).getText(), WriteExcelGRPTS.getgrptstasklabel("PhoneNo1"),
				"Failed : On Task Edit Page Phone Number 1 label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelLanguage(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("Language"), "Failed : On Task Edit Page Language label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelEmployerGroup(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("EmployerGroup"), "Failed : On Task Edit Page Language label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelAgentAssigned(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("AgentAssigned"),
				"Failed : On Task Edit Page Agent assigned label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelAgentSupervisor(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("AgentSupervisor"),
				"Failed : On Task Edit Page Agent Supervisor label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelTaskId(driver), WriteExcelGRPTS.getgrptstasklabel("TaskId"),
				"Failed : On Task Edit Page Task Id label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelTaskType(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("TaskType"),
				"Failed : On Task Edit Page Agent Supervisor label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelCampaignDescription(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("CampaignDescription"),
				"Failed : On Task Edit Page Agent Supervisor label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelJobName(driver).getText(), WriteExcelGRPTS.getgrptstasklabel("JobName"),
				"Failed : On Task Edit Page Agent Supervisor label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelCreatedDate(driver), WriteExcelGRPTS.getgrptstasklabel("CreatedDate"),
				"Failed : On Task Edit Page Agent Supervisor label is mismatch");
		softAssert.assertEquals(SearchEditPage.getTaskStatus(driver), WriteExcelGRPTS.getgrptstasklabel("TaskStatus"),
				"Failed : On Task Edit Page Agent Supervisor label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelScheduledDate(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("Scheduledate"),
				"Failed : On Task Edit Page Agent Supervisor label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelDisposition(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("Disposition"),
				"Failed : On Task Edit Page Agent Supervisor label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelWrongNumber(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("WrongNumber"),
				"Failed : On Task Edit Page Wrong Number label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelBadNumber(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("BadDisconnectedNumber"),
				"Failed : On Task Edit PageBad Disconnected label is mismatch");
		softAssert.assertEquals(SearchEditPage.labelNotes(driver).getText(),
				WriteExcelGRPTS.getgrptstasklabel("Notes"),
				"Failed : On Task Edit Page Notes label is mismatch");

	}

	// Validate mandatory fields data
	@Test(priority = 5)
	public void validateallmandatoryfieldsvalue() throws Exception {
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getBconnId(driver)),
				indtsedit.get("bConnID"), "Failed : On Task Edit Page bConn ID value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCurrentPlan(driver)),
				indtsedit.get("CurrentPlan"), "Failed : On Task Edit Page Current plan value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPlanToPromote(driver)),
				indtsedit.get("PlanToPromote"), "Failed : On Task Edit Page Plan to Promote value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getFirstName(driver)),
				indtsedit.get("FirstName"), "Failed : On Task Edit Page First Name value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getLastName(driver)),
				indtsedit.get("LastName"), "Failed : On Task Edit Page Last Name value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCity(driver)), indtsedit.get("City"),
				"Failed : On Task Edit Page City value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getState(driver)),
				indtsedit.get("State"), "Failed : On Task Edit Page City value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getZipCode(driver)),
				indtsedit.get("ZipCode"), "Failed : On Task Edit Page Zip Code value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCounty(driver)),
				indtsedit.get("County"), "Failed : On Task Edit Page County value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPhoneNum1(driver)),
				indtsedit.get("PrimaryPhone"), "Failed : On Task Edit Page Phone Number 1 value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getLanguage(driver)),
				indtsedit.get("Language"), "Failed : On Task Edit Page Language value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getEmployerGroup(driver)),
				indtsedit.get("EmployerGroup"), "Failed : On Task Edit Page Employer Group value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAgentAssigned(driver)),
				indtsedit.get("AgentAssigned"), "Failed : On Task Edit Page Agent assigned value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAgentSupervisor(driver)),
				indtsedit.get("AgentSupervisor"), "Failed : On Task Edit Page Agent Supervisor value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getTaskId(driver)),
				indtsedit.get("TaskId"), "Failed : On Task Edit Page Task Id value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getTaskType(driver)),
				indtsedit.get("TaskType"), "Failed : On Task Edit Page tasktype value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCampaignDescription(driver)),
				indtsedit.get("CampaignDescription"),
				"Failed : On Task Edit Page Campaign Description value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getJobName(driver)),
				indtsedit.get("JobName"), "Failed : On Task Edit Page Job Name value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCreatedDate(driver)),
				indtsedit.get("CreatedDate"), "Failed : On Task Edit Page Created Date value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getTaskStatus(driver)),
				indtsedit.get("TaskStatus"), "Failed : On Task Edit Page Task Status value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getScheduleDate(driver)),
				indtsedit.get("Scheduledate"), "Failed : On Task Edit Page Schedule Date value is mismatch");
	}

	// Verify all non mandatory fields

	// Verify Address value
	@Test(priority = 6)
	public void validatevalueaddress() {
		if (indtsedit.get("Address") != null && !indtsedit.get("Address").trim().isEmpty()) {
			softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAddress(driver)),
					indtsedit.get("Address"), "Failed : On Task Edit Page Address value is mismatch");
		} else {
			try {
				softAssert.assertFalse(false);
			} catch (NoSuchElementException e) {
				softAssert.assertTrue(false);
				e.printStackTrace();
			}
		}
	}

	// Verify Current Phone number 2 Value
	@Test(priority = 7)
	public void verifyvaluePhone2() throws Exception {
		if (indtsedit.get("PhoneNum2") != null && !indtsedit.get("PhoneNum2").trim().isEmpty()) {
			softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPhoneNum2(driver)),
					indtsedit.get("PhoneNum2"), "Failed : On Task Edit Page Phone Number 2 value is mismatch");
		} else {
			try {
				softAssert.assertFalse(false);
			} catch (NoSuchElementException e) {
				softAssert.assertTrue(false);
				e.printStackTrace();
			}
		}
	}

	@Test(priority = 8)
	public void verifyvaluephone3() throws Exception {
		if (indtsedit.get("PhoneNum3") != null && !indtsedit.get("PhoneNum3").trim().isEmpty()) {
			softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPhoneNum3(driver)),
					indtsedit.get("PhoneNum3"), "Failed : On Task Edit Page Phone Number 3 value is mismatch");
		} else {
			try {
				softAssert.assertFalse(false);
			} catch (NoSuchElementException e) {
				softAssert.assertTrue(false);
				e.printStackTrace();
			}
		}
	}

	// Verify MBI
	@Test(priority = 9)
	public void verifyvalueMBI() {
		if (indtsedit.get("MBINumber") != null && !indtsedit.get("MBINumber").trim().isEmpty()) {
			softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getMBI(driver)),
					indtsedit.get("MBINumber"), "Failed : On Task Edit Page MBI value is mismatch");
		} else {
			try {
				softAssert.assertFalse(false);
			} catch (NoSuchElementException e) {
				softAssert.assertTrue(false);
				e.printStackTrace();
			}
		}
	}

	// Verify Medicaid Number
	@Test(priority = 10)
	public void verifyvalueMedicaidNum() {
		if (indtsedit.get("MedicaidNumber") != null && !indtsedit.get("MedicaidNumber").trim().isEmpty()) {
			softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getMedicaidNumber(driver)),
					indtsedit.get("MedicaidNumber"), "Failed : On Task Edit Page Medicaid Number value is mismatch");
		} else {
			try {
				softAssert.assertFalse(false);
			} catch (NoSuchElementException e) {
				softAssert.assertTrue(false);
				e.printStackTrace();
			}
		}
	}

	// Verify Provider Information
	@Test(priority = 11)
	public void verifyProviderNumber() {
		if(indtsedit.get("ProviderInformation") != null && !indtsedit.get("ProviderInformation").trim().isEmpty()) {
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getProviderInformation(driver)),
				indtsedit.get("ProviderInformation"),
				"Failed : On Task Edit Page Provider Information value is mismatch");
		} else {
			try {
				softAssert.assertFalse(false);
			} catch (NoSuchElementException e) {
				softAssert.assertTrue(false);
				e.printStackTrace();
			}
		}
	}

	// Verify Other
	@Test(priority = 12)
	public void verifyOther() {
		if(indtsedit.get("Other") != null  && !indtsedit.get("Other").trim().isEmpty()) {
			softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getOther(driver)),
					indtsedit.get("Other"), "Failed : On Task Edit Page Other value is mismatch");
		}
		else {
			try {
				softAssert.assertTrue(false);
			}catch (NoSuchElementException e) {
				softAssert.assertTrue(false);
				e.printStackTrace();
			}
		}
	
	}
	
//	// Verify Task History Label
//	@Test
//	public void verifyTaskHistory() {
//		softAssert.assertEquals(SearchEditPage.labelTaskHistory(driver).getText(), SearchEditPage.expTaskHistory(),
//				"Failed : On Task Edit Page Task History value is mismatch");
//	}
//		
//	// Verify Job Name
//	@Test
//	public void verifyTJobName() {
//		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colJobName(driver)),
//				SearchEditPage.expColJobName(), "Failed : On Task Edit Page Job Name is mismatch");
//	}
//
//	// Verify Attempt Result
//	@Test
//	public void verifyAttemptResult() {
//		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colAttemptResult(driver)),
//				SearchEditPage.expColAttemptResult(), "Failed : On Task Edit Page Attempt Result is mismatch");
//	}
//
//	// Verify Attempt Date
//	@Test
//	public void verifyAttemptDate() {
//		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colAttemptDate(driver)),
//				SearchEditPage.expColAttemptDate(), "Failed : On Task Edit Page Attempt Date is mismatch");
//	}
//
//	// Verify Attempt Count
//	@Test
//	public void verifyAttemptCount() {
//		softAssert.assertTrue(SearchEditPage.tableRowTaskDetails(driver).isEnabled(), "Failed: row not displayed");
//		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colAttemptCount(driver)),
//				SearchEditPage.expColAttemptCount(), "Failed : On Task Edit Page Attempt Count is mismatch");
//	}
//
//	// Verify User
//	@Test
//	public void verifyUser() {
//		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colUser(driver)),
//				SearchEditPage.expColUser(), "Failed : On Task Edit Page User is mismatch");
//	}
//
//	// Verify Notes
//	@Test
//	public void verifyTNotes() {
//		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colNotes(driver)),
//				SearchEditPage.expColNotes(), "Failed : On Task Edit Page Notes is mismatch");
//	}
//
//	// Verify Task Details Label
//	@Test
//	public void verifyTaskDetails() {
//		softAssert.assertEquals(SearchEditPage.labelTaskDetails(driver).getText(), SearchEditPage.expTaskDetailsTitle(),
//				"Failed : On Task Edit Page Task Details value is mismatch");
//	}

	// Verify Notes
	@Test(priority = 13)
	public void verifyNotes() {
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getNotes(driver)),
				indtsedit.get("Notes"), "Failed : On Task Edit Page Notes is mismatch");
	}

	 //Verify Task Save
	 @Test(priority = 14)
	 public void setDisposition() {
	 SearchEditPage.setDropDownValue(SearchEditPage.dropDownDispositionLkup(driver),
	 grptsedit.get("DispositionValue"));
	 SearchEditPage.btnSaveAndClose(driver).click();
	 if (SearchEditPage.wiatForPopUp(driver)) {
	 Alert alert = driver.switchTo().alert();
	 softAssert.assertTrue(alert.getText().contains(SearchEditPage.expMsgSaveAndClose()),
	 "Failed : Failed to save the task details.");
	 alert.accept();
	 }
	 softAssert.assertEquals(HomePage.labelHomePage(driver).getText(),
	 HomePage.expTitle(),
	 "Failed : Text for 'Home Page' is mismatch");
	 }

}
