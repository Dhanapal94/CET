package com.cet.indts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cet.intit.Base;
import com.cet.pagerepositery.SearchEditPage;
import com.cet.pagerepositery.SearchViewPage;
import com.cet.utility.indts.GetDataFromExcel;

public class SearchViewTest extends Base {

	private static boolean initFlag=true;

	@BeforeClass
	public static void getinit() throws Exception {
		fopenBrowser = true;
		indtsedit = GetDataFromExcel.indtsedit();
		childTest=true;
		parentTest=extent.createTest("Indts-Search View Test");
		team="Indts";
	}


	@BeforeMethod
	public static void getIndtsTaskView() throws Exception {
		softAssert=new SoftAssert();
		if (initFlag) {
			//setUp();
			System.out.println("bconnid is:" + SearchEditPage.launch(driver, grptsedit.get("bConnID")));
			Assert.assertTrue(SearchEditPage.launch(driver, grptsedit.get("bConnID")));
			initFlag=false;
		}		
	}
	// label page title
	@Test(priority=1)
	public void verifyTitle() {
		Assert.assertTrue(SearchViewPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.getTitle(driver), SearchViewPage.expTitle(),
				"Failed : On Search Page tab Title is mismatch.");
		verifyassert(softAssert);
	}

	// label Top section Label
	@Test(priority=2)
	public void verifyPageTitle() {
		Assert.assertTrue(SearchViewPage.launch(driver));
		softAssert.assertEquals(SearchViewPage.labelSearchPage(driver).getText(), SearchViewPage.expTxtTitle(),
				"Failed : On Search Page Title is mismatch");
		verifyassert(softAssert);
	}

	// label Application details
	@Test(priority=3)
	public void verifylabelSearch() {
		Assert.assertTrue(SearchViewPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.labelApplicationDetails(driver).getText(),
				SearchEditPage.expApplicationSecTitle(),
				"Failed : On Task Edit Page Application Details label is mismatch");
		verifyassert(softAssert);
	}

	//Test Windows Handler
	@Test(priority=4)
	public void verifyBconnID() {
		Assert.assertTrue(SearchViewPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getBconnId(driver)),SearchViewPage.expTxtBconnId(), "Failed : On Task View Page bConn ID value is mismatch");
		verifyassert(softAssert);
	}

	//Verify fields in View Page
	@Test(priority=5)
	public void verifyTaskViewFields() {
		Assert.assertTrue(SearchViewPage.launch(driver));
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getBconnId(driver)),SearchViewPage.expTxtBconnId(), "Failed : On Task View Page bConn ID value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCurrentPlan(driver)),SearchViewPage.expCurrentPlan(), "Failed : On Task View Page Current Plan value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPlanToPromote(driver)),SearchViewPage.expPlanToPromote(), "Failed : On Task View Page Plan To Promote value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getFirstName(driver)),SearchViewPage.expFirstName(), "Failed : On Task View Page First Name value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getLastName(driver)),SearchViewPage.expLastName(), "Failed : On Task View Page Last Name value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAdditionalHousehold(driver)),SearchViewPage.expAdditionalHousehold(), "Failed : On Task View Page # of Additional Household value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAddHouseholdFirstName(driver)),SearchViewPage.expAddlHHMemberFirstName(), "Failed : On Task View Page Additional Household First Name  value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAddHouseholdLastName(driver)),SearchViewPage.expAddlHHMemberLastName(), "Failed : On Task View Page Additional Household Last Name is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAddress(driver)),SearchViewPage.expAddress(), "Failed : On Task View Page Address value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCity(driver)),SearchViewPage.expCity(), "Failed : On Task View Page City value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getState(driver)),SearchViewPage.expState(), "Failed : On Task View Page State value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getZipCode(driver)),SearchViewPage.expZipCode(), "Failed : On Task View Page Zip Code value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getCounty(driver)),SearchViewPage.expCounty(), "Failed : On Task View Page County value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPhoneNum1(driver)),SearchViewPage.expPhone1(), "Failed : On Task View Page Phone Number 1 value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPhoneNum2(driver)),SearchViewPage.expPhone2(), "Failed : On Task View Page Phone Number 2 value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getPhoneNum3(driver)),SearchViewPage.expPhone3(), "Failed : On Task View Page Phone Number 3 value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getLanguage(driver)),SearchViewPage.expLanguage(), "Failed : On Task View Page Language value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getMBI(driver)),SearchViewPage.expMBI(), "Failed : On Task View Page MBI value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getMedicaidNumber(driver)),SearchViewPage.expMedicaidNumber(), "Failed : On Task View Page Medicaid Number value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getProviderInformation(driver)),SearchViewPage.expProviderInformation(), "Failed : On Task View Provider Information value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getOther(driver)),SearchViewPage.expOther(), "Failed : On Task View Page Other value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAgentAssigned(driver)),SearchViewPage.expAgentAssigned(), "Failed : On Task View Page Agent Assigned value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getAgentSupervisor(driver)),SearchViewPage.expAgentSupervisor(), "Failed : On Task View Page Agent Supervisor value is mismatch");
		softAssert.assertEquals(SearchEditPage.labelTaskHistory(driver).getText(),SearchViewPage.expTaskHistory(), "Failed : On Task View Page Task History value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colJobName(driver)),SearchViewPage.expColJobName(), "Failed : On Task View Page Job Name value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colAttemptResult(driver)),SearchViewPage.expColAttemptResult(), "Failed : On Task View Page Attempt Result value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colAttemptDate(driver)),SearchViewPage.expColAttemptDate(), "Failed : On Task View Page Attempt Date value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colAttemptCount(driver)),SearchViewPage.expColAttemptCount(), "Failed : On Task View Page Attempt Count value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colUser(driver)),SearchViewPage.expColUser(), "Failed : On Task View Page User value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.colNotes(driver)),SearchViewPage.expColNotes(), "Failed : On Task View Page Notes Value is mismatch");
		softAssert.assertEquals(SearchEditPage.labelTaskDetails(driver),SearchViewPage.expTaskDetailsTitle(), "Failed : On Task View Page Task Details Title is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getTaskId(driver)),SearchViewPage.expTaskID(), "Failed : On Task View Page Task Id value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getTaskType(driver)),SearchViewPage.expTaskType(), "Failed : On Task View Page Task Type value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getTaskStatus(driver)),SearchViewPage.expTaskStatus(), "Failed : On Task View Page Task Status value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getScheduleDate(driver)),SearchViewPage.expScheduledDate(), "Failed : On Task View Page Schedule Date value is mismatch");
		softAssert.assertEquals(SearchEditPage.getInputBoxValue(SearchEditPage.getNotes(driver)),SearchViewPage.expNotes(), "Failed : On Task View Page Notes value is mismatch");		
		SearchViewPage.clickCloseButton(driver).click();
		verifyassert(softAssert);
	}

}
